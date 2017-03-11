/**
 * Source: ColoredTextAreaPrintDemo.java
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
 * This example programs are redistributable provided it carries the above
 * copy right and warning information.
 */
package demo.activetree.print.textarea;

import demo.activetree.print.PrintFrame;

import javax.swing.*;

import com.activetree.print.PageNoPainter;
import com.activetree.common.SmartJPrint;

import java.awt.event.ActionEvent;
import java.awt.*;

public class ColoredTextAreaPrintDemo extends PrintFrame {
	private JTextArea ta = new JTextArea();

	public ColoredTextAreaPrintDemo() {
		super();
		frame.setTitle("Smart JPrint - Printing Colored JTextArea");
		ta.setText(simpleText());
		ta.setLineWrap(true);
		ta.setWrapStyleWord(true);
		ta.setForeground(SystemColor.blue.darker());
		setPrintableComponent(ta);
	}

	public void actionPerformed(ActionEvent evt) {
		if (evt.getActionCommand().equals("Print")) {
			printer.print(ta, PageNoPainter.LOWER_CENTER);
		}else if (evt.getActionCommand().equals("Generate PDF")) {
			super.printAsPdf(ta, pdfPrinter);
		}else if (evt.getActionCommand().equals("Preview")) {
			printer.preview(ta, PageNoPainter.LOWER_CENTER, true, frame);
		}
	}

	private String simpleText() {
		String msg = "This is a colored text in this JTextArea\n\n" +
		  "Type some text of your choice and then print to a printer, " +
		  "preview the pages, and/or generate a PDF document.";
		return msg;
	}

	public static void main(String[] args) {
		if (args != null && args.length >= 1) {
			SmartJPrint.setLicenseKey(args[0]);
		}
		else {
			System.out.println("Usage: java " + ColoredTextAreaPrintDemo.class.getName() + " licenseKey");
			System.exit(0);
		}

		ColoredTextAreaPrintDemo demo = new ColoredTextAreaPrintDemo();
		demo.postInit();
		demo.setVisible(true);
	}
}
