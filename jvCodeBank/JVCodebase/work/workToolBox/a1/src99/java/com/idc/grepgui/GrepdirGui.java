package com.idc.grepgui;

/*
	To DO:
	1. pull down box for file types.
	2. put info to properties files.
	3. get info from properties file.
	4. choose default (last selected).
	5. pass info as parameters
	6. tab through the fields properly
*/

import com.idc.trace.Debug;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;

public class GrepdirGui extends JFrame implements ActionListener {
//	private static final String GUI_EDITOR="C:\\Program Files\\EditPlus 2\\editplus.exe";
	private static final String GUI_EDITOR="gvim";
	private JTextArea m_messagesArea;	
	private JTextField m_stringField;
	private JTextField m_typeField;
	private JTextField m_dirField;
	private JTextField m_editField;	
	private JButton m_btnApp;
	private JButton m_btnDir;
	private JButton m_btnEdit;
	private JButton m_btnClear;			
	private JLabel m_txtStatus;
	private JProgressBar m_progress;
	private JFileChooser m_fileChooser;	

	private AppThread m_appThread;
	private Grepdir m_grepdir;
	private boolean m_bAppOver = false;

	public GrepdirGui (String msg) {
		super(msg);
//		Debug.setFile("/tmp/grepdirgui.log",false);
		m_grepdir = new Grepdir(this);
		m_appThread = new AppThread(this, m_grepdir);
		m_appThread.start();
		makeFileChooser();
		setContentPane(makeContentPane());
		this.addWindowListener	(new WindowAdapter() {
			public void windowClosing (WindowEvent e) {
				doStopClient();
			}
		});
		setSize(700,900);
		pack();
		setVisible(true);	
	}
	public AppThread getAppThread() {return m_appThread;}
	public boolean isAppOver() {return m_bAppOver;}	
	public static void main(String[] args) {
		GrepdirGui app = new GrepdirGui("GrepdirGUI");
	}
	public void makeFileChooser() {
		m_fileChooser = new JFileChooser();
//		m_fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		m_fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		String strCwd = System.getProperty("user.dir");
		m_fileChooser.setCurrentDirectory(new File(strCwd));
	}
	public void doStopClient() {
		m_bAppOver = true;
		m_appThread.setStop();
		try {
			while (m_appThread.isAlive()) {
				Debug.println("thread is alive");
				Thread.sleep(10);
				Debug.println("Sleeping");
			}
			Debug.println("thread is not alive");
		}
		catch (InterruptedException e) {
			Debug.println("no sleep");
		}
		Debug.println("exiting app...");
		System.exit(0);
	}	
	
	private Container makeContentPane() {
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		
		JPanel topPane = new JPanel();
		JLabel label1 = new JLabel("Search String");
		JLabel label2 = new JLabel("File Type");
		m_stringField = new JTextField(20);
		m_stringField.addActionListener(this);		
		m_typeField = new JTextField(10);
		m_typeField.addActionListener(this);
		
		m_dirField = new JTextField(20);
		m_dirField.addActionListener(this);	
		m_btnDir = new JButton("Directory");
		m_btnDir.addActionListener(this);
	
		topPane.add(label1);				
		topPane.add(m_stringField);
		topPane.add(label2);
		topPane.add(m_typeField);		
		topPane.add(m_btnDir);
		topPane.add(m_dirField);		

		JPanel midPane = new JPanel();
		m_messagesArea = new JTextArea(40,90);
		m_messagesArea.setEditable(false);		
		m_messagesArea.setDragEnabled(true);	
		midPane.add(new JScrollPane(m_messagesArea));

		JPanel lowPane = new JPanel();
		m_btnApp = new JButton("Search");
		m_btnApp.addActionListener(this);
		lowPane.add(m_btnApp);
						
		m_txtStatus = new JLabel();
		lowPane.add (m_txtStatus);
		m_progress = new JProgressBar();
		lowPane.add(m_progress);
	
		m_editField = new JTextField(35);
		m_editField.addActionListener(this);
		m_btnEdit = new JButton("Edit");
		m_btnEdit.addActionListener(this);
		m_btnClear = new JButton("Clear");
		m_btnClear.addActionListener(this);		
		lowPane.add(m_editField);		
		lowPane.add(m_btnEdit);
		lowPane.add(m_btnClear);								
				
		pane.add(topPane,BorderLayout.NORTH);
		pane.add(midPane,BorderLayout.CENTER);
		pane.add(lowPane,BorderLayout.SOUTH);			
		return pane;
	}	
	public void setButtonText (boolean bBtn) {
		final String msg;
		if (bBtn) msg = "Search";
		else msg = "Stop";
		SwingUtilities.invokeLater (
			new Runnable() {
				public void run() {
					m_btnApp.setText(msg);
				}
			}
		);
	}
	public void setEditButtonActive (final boolean bBtn) {
		SwingUtilities.invokeLater (
			new Runnable() {
				public void run() {
					m_btnEdit.setEnabled(bBtn);
				}
			}
		);
	}
	public void setDirButtonActive (final boolean bBtn) {
		SwingUtilities.invokeLater (
			new Runnable() {
				public void run() {
					m_btnDir.setEnabled(bBtn);
				}
			}
		);
	}
	public void setClearButtonActive (final boolean bBtn) {
		SwingUtilities.invokeLater (
			new Runnable() {
				public void run() {
					m_btnClear.setEnabled(bBtn);
				}
			}
		);
	}		
	public void setMessagesArea (final String msg) {
		SwingUtilities.invokeLater (
			new Runnable() {
				public void run() {
					m_messagesArea.append(msg);
					m_messagesArea.append("\n");
					m_messagesArea.setCaretPosition(
						m_messagesArea.getText().length());										
				}
			}
		);
	}
	public void setStatusMessage (final String msg) {
		SwingUtilities.invokeLater (
			new Runnable() {
				public void run() {
					m_txtStatus.setText(msg);
					validate();
				}
			}
		);		
	}
	public void initProgressBar (final int iMin, final int iMax) {
		SwingUtilities.invokeLater (
			new Runnable() {
				public void run() {
					m_progress.setMinimum(iMin);
					m_progress.setMaximum(iMax);
					m_progress.setValue(iMin);
					m_progress.setStringPainted(true);
//					m_progress.setIndeterminate(false);
				}
			}
		);		
	}
	public void setProgressBar (final int value) {
		SwingUtilities.invokeLater (
			new Runnable() {
				public void run() {
					m_progress.setValue(value);
				}
			}
		);
	}
	private void setStringField (final String msg) {
		SwingUtilities.invokeLater (
			new Runnable() {
				public void run() {
					m_stringField.setText(msg);
					validate();
				}
			}
		);		
	}
	private void setTypeField (final String msg) {
		SwingUtilities.invokeLater (
			new Runnable() {
				public void run() {
					m_typeField.setText(msg);
					validate();
				}
			}
		);		
	}
	private void setDirField (final String msg) {
		SwingUtilities.invokeLater (
			new Runnable() {
				public void run() {
					m_dirField.setText(msg);
					validate();
				}
			}
		);		
	}
	private void setEditField (final String msg) {
		SwingUtilities.invokeLater (
			new Runnable() {
				public void run() {
					m_editField.setText(msg);
					validate();
				}
			}
		);		
	}	
	private void searchSelected() {
		Debug.println(">>> searchSelected");
		boolean bError = false;
		if (getStringField() == null || getStringField().length() < 1)
				bError = true;
		if (getTypeField() == null || getTypeField().length() < 1)
				bError = true;
		if (getDirField() == null || getDirField().length() < 1)
				bError = true;
		if (! bError) {
			File file = new File (getDirField());
			if (! file.isDirectory()) bError = true;
		}
		if (bError) {
			setStatusMessage("Enter all the fields and press Search");
			setProgressBar(0);			
		}
		else {
			m_appThread.setStart();
			setStarted();
		}
		Debug.println("<<< searchSelected");		
	}
	public void setStarted() {
		setButtonText(false);
		setEditButtonActive(false);
		setDirButtonActive(false);
		setClearButtonActive(false);		
	}
	public void setStopped() {
		setButtonText(true);
		setEditButtonActive(true);
		setDirButtonActive(true);
		setClearButtonActive(true);				
	}		
	public void actionPerformed (ActionEvent e) {
		Object source = e.getSource();
		if (source instanceof JTextField) {
			Debug.println("textfield");
			searchSelected();
		}
		else if (source instanceof JButton) {
			Debug.println("jbutton");
			if (source == m_btnApp) {
				Debug.println("btnApp");
				JButton jb = (JButton) e.getSource();
				String strBtn = jb.getText();
				if (strBtn.equals("Search"))
					searchSelected();
				else if (strBtn.equals("Stop")) {
					m_appThread.setStop();
					setStopped();
				}							
			}
			else if (source == m_btnDir) {
				Debug.println("btnDir");
				int retval = m_fileChooser.showOpenDialog(GrepdirGui.this);
				if (retval == JFileChooser.APPROVE_OPTION) {
					File file = m_fileChooser.getSelectedFile();
					setDirField (file.getPath());
				}
			}
			else if (source == m_btnEdit) {
				Debug.println("btnEdit");
				String strFile = getEditField().trim();
				if (strFile.length() > 0) {
					File file = new File(strFile);
					if (file.isFile())
						doEditor(strFile);
				}
			}
			else if (source == m_btnClear) {
				Debug.println("btnClear");
				setEditField("");
			}						
		}
		else
			Debug.println("else type");
	}
	public String getStringField() {return m_stringField.getText();}
	public String getTypeField() {return m_typeField.getText();}
	public String getDirField() {return m_dirField.getText();}
	public String getEditField() {return m_editField.getText();}
	private String getEditor() {return GUI_EDITOR;}
	public void addWord(String word) {setMessagesArea(word);}		
	public void setSize (int width, int height) {
		super.setSize (width, height);
		validate();
		repaint();
	}
	public void doEditor(String strFile) {
		String strCmd = GUI_EDITOR + " " + strFile;
		Debug.println("strCmd :"+strCmd+":");
		try {
			Runtime.getRuntime().exec(strCmd);
		}
		catch (IOException e) {
			Debug.println("cannot run command "+strCmd);
		}
	}
}
