/**
 * Source: HTMLBrowser.java
 * Version: ${VERSION}$
 * Copyright © ${2003-2004}$ by ActiveTree Inc.
 * All rights reserved.
 *
 * Warning:
 * This source code provided to help you understand how the smart jprint APIs
 * can work for your program. It carries no liability for any kind of damage
 * non-functioning and any other as specified in the license terms and consitions
 * for any product.
 *
 * This example program is redistributable provided it carries the above
 * copy right and warning information.
 */
package demo.activetree.print.html;

import com.activetree.print.AtDocumentPrinter;
import com.activetree.print.PageNoPainter;
import com.activetree.print.AtPdfPrinter;
import com.activetree.swing.AtStatusPanel;
import com.activetree.swing.AtFileChooser;
import com.activetree.resource.AtImageList;
import com.activetree.resource.AtConstants;
import com.activetree.common.SmartJPrint;

import java.util.*;
import java.net.*;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.event.*;
import java.io.OutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.html.*;
import javax.print.attribute.HashPrintRequestAttributeSet;

import demo.activetree.print.PrintFrame;

public class HTMLBrowser extends BaseHTMLViewer {
	protected JEditorPane editorPane = null;
	protected AtStatusPanel statusPanel = null;
	protected String title = null;
	protected LocationPanel locationPanel = null;
	protected DocumentTracker tracker = null;
	protected String menus[] = {"Back", "Forward"};
	protected Vector links = new Vector();
	protected HTMLMenuAction actionList[] = new HTMLMenuAction[2];
	protected HTMLPopupMenu popup = new HTMLPopupMenu();
	private JScrollPane scroll = null;
	public static final String[] printMenus
	  = {"Print", "Generate PDF", "Preview"};
	public static final String tooltip[] =
	  {"Print", "Generate output as a PDF document", "Preview and print"};
	private AtPdfPrinter pdfPrinter;
  private AtFileChooser fileChooser;

	public static final ImageIcon[] icons = {
		AtImageList.IMAGE_LIST.PRINT,
		AtImageList.IMAGE_LIST.PDF,
		AtImageList.IMAGE_LIST.PREVIEW
	};

	private static final ImageIcon[] viewIcons = {
		AtImageList.IMAGE_LIST.PREVIOUS,
		AtImageList.IMAGE_LIST.NEXT
	};
	private AtDocumentPrinter docPrinter;

	public HTMLBrowser() {
		super();
		frame.setTitle("Smart JPrint - HTML Printing");
		this.title = frame.getTitle();
		initialize();
	}

	public void postInit() {
		pdfPrinter = new AtPdfPrinter();
		docPrinter = new AtDocumentPrinter();
		//docPrinter.setPreviewPaneSize(new Dimension(800, 700));
		docPrinter.setPreviewPaneTitle("Print preview");
	}


	protected void setupContentPane() {
	}

	protected void initialize() {
		Container top = frame.getContentPane();

		Container c = new JPanel(new BorderLayout());
		editorPane = createEditorPane();
		editorPane.addHyperlinkListener(new HyperlinkHandler());
		tracker = new DocumentTracker(null,  editorPane.getPage());
		scroll = new JScrollPane(editorPane);
		c.add(scroll, BorderLayout.CENTER);

		statusPanel = new AtStatusPanel("Ready");
		statusPanel.setMinimumSize(new Dimension(480, 22));
		statusPanel.setForeground(Color.blue);
		c.add(statusPanel, BorderLayout.SOUTH);

		JPanel northPanel = new JPanel(new BorderLayout());
		JPanel toolbarPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 5));
		toolbarPanel.add(new NavigationToolBar());
		toolbarPanel.add(new BrowserPrintTool());
		northPanel.add(toolbarPanel, BorderLayout.NORTH);

		locationPanel = new LocationPanel();
		locationPanel.setURL(tracker.getURL());
		northPanel.add(locationPanel, BorderLayout.CENTER);

		c.add(northPanel, BorderLayout.NORTH);

		frame.setJMenuBar(new BrowserMenuBar());
		frame.getJMenuBar().add(new BrowserPrintMenu());

		editorPane.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int id = e.getModifiers();
				if ((id & InputEvent.BUTTON2_MASK) != 0 ||
				  (id & InputEvent.BUTTON3_MASK) != 0) {
					popup.show(e.getComponent(),e.getX(),e.getY());
				}
			}
		});

		top.setLayout(new BorderLayout());
		top.add(c, BorderLayout.CENTER);
	}

	public void showDocument(URL url) {
		if (url == null)
			return;

		System.out.println("adding URL: " + url.toString());

		DocumentTracker t = new DocumentTracker(tracker, url);
		tracker.setChild(t);
		tracker = t;
		try {
			editorPane.setPage(tracker.getURL());
			frame.setTitle(title + " - " + tracker.getURL().toString());
			statusPanel.setMessage("Ready");
			statusPanel.repaint();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	class HyperlinkHandler implements HyperlinkListener {
		public void hyperlinkUpdate(HyperlinkEvent e) {
			if (e.getURL() != null) {
				statusPanel.setMessage(e.getURL().toString());
				statusPanel.repaint();
			}
			HyperlinkEvent.EventType type = e.getEventType();
			if (type == HyperlinkEvent.EventType.ACTIVATED) {
				JEditorPane pane = (JEditorPane) e.getSource();
				if (e instanceof HTMLFrameHyperlinkEvent) {
					HTMLFrameHyperlinkEvent  ce = (HTMLFrameHyperlinkEvent)e;
					HTMLDocument doc = (HTMLDocument)pane.getDocument();
					doc.processHTMLFrameHyperlinkEvent(ce);
				}else {
					showDocument(e.getURL());
					locationPanel.setURL(e.getURL());
				}
			}
		}
	}

	protected class BrowserMenuBar extends JMenuBar {
		public BrowserMenuBar() {
			JMenu view = add(new JMenu("View"));
			for (int i=0; i<actionList.length; i++) {
				view.add(actionList[i]);
			}
		}
	}

	protected class BrowserPrintTool extends JToolBar {
		public BrowserPrintTool() {
			setBorderPainted(true);
			for (int i=0; i<printMenus.length; i++) {
				BrowserPrintMenuAction action = new BrowserPrintMenuAction(printMenus[i], icons[i]);
				JButton button = add(action);
				button.setBorderPainted(true);
			}
		}
	}

	protected class NavigationToolBar extends JToolBar {
		public NavigationToolBar() {
			setBorderPainted(true);
			for (int i=0; i<menus.length; i++) {
				if (actionList[i] == null) {
					actionList[i] = new HTMLMenuAction(menus[i], viewIcons[i]);
				}
				JButton button = add(actionList[i]);
				button.setBorderPainted(true);
			}
		}
	}

	protected class LocationPanel extends JPanel implements ActionListener {
		JButton goButton = new JButton("Go");
		JTextField inputField = new JTextField();
		public LocationPanel() {
			setLayout(new BorderLayout());
			setBorder(BorderFactory.createEmptyBorder(3,6,4,3));
			goButton.setIcon(new ImageIcon("go.gif"));
			goButton.addActionListener(this);
			add(new JLabel("Address"), BorderLayout.WEST);
			add(inputField, BorderLayout.CENTER);
			add(goButton, BorderLayout.EAST);
			//Add key listener to respond
			//when user press "ENTER".
			inputField.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent ke) {
					if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
						showDocument(getURL());
					}
				}
			});
		}

		public URL getURL() {
			String location = inputField.getText();
			URL url = null;
			try {
				url = new URL(location);
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(this, "Malformed URL: " + location,
				                              "Error", JOptionPane.ERROR_MESSAGE);
				return null;
			}
			return url;
		}
		public void setURL(URL url) {
			if (url == null) return;

			inputField.setText(url.toString());
			inputField.setCaretPosition(0);
		}
		public void actionPerformed(ActionEvent e) {
			showDocument(getURL());
		}
	}


	protected class BrowserPrintMenu  extends JMenu {
		public BrowserPrintMenu() {
			super("Print");
			for (int i=0; i<printMenus.length; i++) {
				BrowserPrintMenuAction action = new BrowserPrintMenuAction(printMenus[i], icons[i]);
				add(action);
			}
		}
	}

	protected class BrowserPrintMenuAction extends AbstractAction {
		public BrowserPrintMenuAction(String name, Icon icon) {
			if (icon != null) {
				putValue(Action.SMALL_ICON, icon);
			}
			putValue(Action.NAME, name);
			putValue(Action.ACTION_COMMAND_KEY, name);
		}
		public void actionPerformed(ActionEvent e) {
			PageFormat customPf = PrintFrame.getPortraitCustomPageFormat();
			String source = (String)getValue(Action.ACTION_COMMAND_KEY);
			System.out.println("action cmd: " + source);

			if (source.equals("Print")) {
				docPrinter.print(editorPane, PageNoPainter.LOWER_RIGHT, true,
				                 false, customPf, new HashPrintRequestAttributeSet());
			}else if (source.equals("Generate PDF")) {
				printAsPdf();
				//editorPane.updateUI();
			}else if (source.equals("Preview")) {
				docPrinter.preview(editorPane, PageNoPainter.LOWER_RIGHT, true, customPf, frame);
			}
		}
	}

	private void printAsPdf() {
		System.out.println("Save As PDF file...");
		OutputStream outputStream = getOutputStream();
		if (outputStream == null) {
		  return;
		}

		try {
			PageFormat customPf = PrintFrame.getPortraitCustomPageFormat();
		  pdfPrinter.print(editorPane, outputStream, PageNoPainter.LOWER_CENTER, customPf, true);
		}catch(Throwable ex) {
		  ex.printStackTrace();
		}

		System.out.println("PDF document is produced for viewing.");
	}

	OutputStream getOutputStream() {
		if (fileChooser == null) {
	    String filters[] = {"pdf"};
			String userHome = ".";
			try {
				userHome = System.getProperty("user.home");
			}catch(Throwable t) {
				//TODO - for applet this is done becs. it may b e security exception.
			}

	    File defaultFile = new File(userHome);
	    fileChooser = new AtFileChooser(defaultFile, "Choose a PDF file name",
	                                                "Select", 'S', "Select a PDF file",
	                                                filters, "PDF Files", false);
		}

	  File file = fileChooser.showDialog(AtConstants.OPEN, editorPane);

	  if (file == null) {
	    return null;
	  }

	  //File file = fileChooser.getSelectedFile();
	  String fileNameStr = file.toString();

	  //System.out.println("abs path name: " + file.getAbsolutePath());
	  //System.out.println("filename before adding .pdf: " + fileNameStr);

	  if ( (fileNameStr != null) && (fileNameStr.lastIndexOf(".pdf") < 0) ) {
	    fileNameStr += ".pdf";
	    //System.out.println("filename after adding .pdf: " + fileNameStr);
	  }

	  file = new File(fileNameStr);

	  if (file.exists()) {
	    int reply = JOptionPane.showConfirmDialog(editorPane,
	                                              "A file named \"" + file.getAbsolutePath() + "\" is already existing.\n\n" +
	                                              "Do you want to overwrite it?",
	                                              "Confirm",
	                                              JOptionPane.YES_NO_OPTION,
	                                              JOptionPane.INFORMATION_MESSAGE);
	    if (reply != JOptionPane.YES_OPTION) {
	      return null;
	    }
	  }

	  FileOutputStream fos = null;
	  try {
	    fos = new FileOutputStream(file);
	  }catch(Throwable t) {
	    String errorMessage = t.getMessage();
	    JOptionPane.showMessageDialog(editorPane,
	                                  "Could not save into file \"" + file.getAbsoluteFile() + "\".\n\n" +
	                                  errorMessage + "\n\n" +
	                                  "Enter a valid file name without special characters in it.\n\n",
	                                  "File creation error",
	                                  JOptionPane.ERROR_MESSAGE);
	    return null;
	  }

	  PrintStream ps = new PrintStream(fos);
	  return ps;
	}


	class HTMLPopupMenu extends JPopupMenu {
		public HTMLPopupMenu() {
			for (int i=0; i<menus.length; i++) {
				if (actionList[i] == null) {
					actionList[i] = new HTMLMenuAction(menus[i], viewIcons[i]);
				}
				add(new JMenuItem(actionList[i]));
			}
		}
	}

	class HTMLMenuAction extends AbstractAction {
		public HTMLMenuAction(String name, Icon icon) {
			if (icon != null) {
				putValue(Action.SMALL_ICON, icon);
			}
			putValue(Action.NAME, name);
		}
		public void actionPerformed(ActionEvent e) {
			String name = (String) getValue(Action.NAME);
			System.out.println("ActionEvent on - " + name);
			URL docToShow = null;
			if (name.equals("Back")) {
				if (tracker.getParent() != null) {
					DocumentTracker t = tracker.getParent();
					tracker = t;
					docToShow = tracker.getURL();
				}
			}else if (name.equals("Forward")) {
				if (tracker.getChild() != null) {
					DocumentTracker t = tracker.getChild();
					tracker = t;
					docToShow = tracker.getURL();
				}
			}
			if (docToShow != null) {
				try {
					System.out.println("showing URL: "  + docToShow.toString());
					editorPane.setPage(docToShow);
					locationPanel.setURL(docToShow);
					frame.setTitle(title + " - " + docToShow.toString());
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	class DocumentTracker {
		private URL url = null;
		private DocumentTracker parent = null;
		private DocumentTracker child = null;
		public DocumentTracker(
		  DocumentTracker parent, URL url) {
			this.parent = parent;
			this.url = url;
		}
		public URL getURL() {
			return url;
		}
		public DocumentTracker getParent() {
			return parent;
		}
		public DocumentTracker getChild() {
			return child;
		}
		public void setChild(DocumentTracker child) {
			this.child = child;
		}
	}


	public static void main(String[] args) {
		if (args != null && args.length >= 1) {
			SmartJPrint.setLicenseKey(args[0]);
		}
		else {
			System.out.println("Usage: " + HTMLBrowser.class.getName() + " licenseKey");
			System.exit(0);
		}

		HTMLBrowser demo = new HTMLBrowser();
		demo.postInit();
		demo.setVisible(true);
	}
}

