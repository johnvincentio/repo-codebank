/**
 * Source: BaseHTMLViewer.java
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

import javax.swing.*;
import java.net.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class BaseHTMLViewer extends JApplet {
	protected JFrame frame = new JFrame();

	public BaseHTMLViewer() {
		frame.setSize(500, 650);
		setupContentPane();
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				frame.setVisible(false);
				frame.dispose();
			}
		});
	}

	public void init() {
		com.activetree.common.SmartJPrint.setLicenseKey(getParameter("key"));
		setVisible(true);
		postInit();
	}

	public void postInit() {}

	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}

	protected void setupContentPane() {
		Container c = frame.getContentPane();
		c.setLayout(new BorderLayout());
		JEditorPane editorPane = createEditorPane();
		JScrollPane scroll = new JScrollPane(editorPane);
		c.add(scroll, BorderLayout.CENTER);
	}

	protected JEditorPane createEditorPane() {
		JEditorPane editorPane = new JEditorPane();
		editorPane.setContentType("text/html");
		editorPane.setEditable(false);
		String doc = null;
		try {
			try {
				doc = "http://www.activetree.com/demo/oo_concepts.html";
				URL docUrl = new URL(doc);
				editorPane.setPage(docUrl);
			}catch(Throwable t) {
				doc = "file:" + System.getProperty("user.dir")
			    + System.getProperty("file.separator") + "oo_concepts.html";
				URL docUrl = new URL(doc);
				editorPane.setPage(docUrl);
			}
		}catch (Exception e) {
			Toolkit.getDefaultToolkit().beep();
			System.err.println("Couldn't read URL: " + doc);
			System.err.println("Trying to load remote URL http://www.google.com");
			try {
				URL remoteUrl = new URL("http://www.google.com");
				editorPane.setPage(remoteUrl);
			}catch(Exception e1) {}
		}
		return editorPane;
	}
}
