/**
 * Source: PrintAndPDFFromJ2EEdemo2.java
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
package demo.activetree.print.generic;

import com.activetree.print.*;
import com.activetree.common.SmartJPrint;

import javax.swing.*;
import java.awt.*;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.FileOutputStream;

public class PrintAndPDFFromJ2EEdemo2 extends JApplet {
	private AtBook book;

	public PrintAndPDFFromJ2EEdemo2() {
		book = new AtBook();
	}

	public void init() {
		SmartJPrint.setLicenseKey(getParameter("key"));
		postInit();
	}

	public void postInit() {
		int result = JOptionPane.showConfirmDialog(null,
		                              "This program will try to print the Java \nprogram " +
		                              "output to a printer.\n\nDo you want to continue?", "Confirm",
		                              JOptionPane.INFORMATION_MESSAGE);
		if (result != JOptionPane.YES_OPTION) {
			super.destroy();
			return;
		}

		//Accumulate the output into thr AtBook instance.
		createBook();

		//To generate PDF pass a OutputStream and the AtBook into the pdfPrinter.print method.
		//You can continue to PDF generate using the same AtBook instance if necessary before printing.
		//Uncommenting the next few lines that will PDF generate.
//		pdfPrinter = new AtPdfPrinter();
//		try {
//			OutputStream pdfOutputStream = new PrintStream(new FileOutputStream("./smartjprint.pdf"));
//			pdfPrinter.print(book, pdfOutputStream, PageNoPainter.LOWER_CENTER, false);
//		} catch (Throwable throwable_ex) {
//			throwable_ex.printStackTrace();
//		}

		//This is going to print the output to a printer.
		AtGenericPrinter genericPrinter = new AtGenericPrinter();
		genericPrinter.applyAntialiasing(true); //optional

		//if you want user intervention and GUI preview.
//		genericPrinter.preview(book, null);

		//No user intervention. output sents to a default printer attached to the computer.
		//Use other print(...) methods if necessary to pass a custom page format and more.
		genericPrinter.print(book);
	}

	private void createBook() {
		Font titleFont = new Font("Helvitica", 1, 20);
		Font subTitleFont = new Font("Helvitica", 0, 15);
		Color titleColor = SystemColor.blue.darker().darker();
		Color subTitleColor = SystemColor.blue.darker().darker();

		AtStringElement elm = new AtStringElement("Generate PDF Documents using \"Smart JPrint\"\n\n", titleFont);
		elm.setForeground(titleColor);
		book.write(elm);
		book.write("Smart JPrint APIs are 100% pure Java APIs and takes care of any kind of PDF " +
		           "generation and printing needs. SmartJ printing APIs lets you ");
		elm = new AtStringElement("automaticaly format texts, icons, 2D Graphics as output from " +
		                          "your J2EE and Swing programs to generate PDF, print, and preview " +
		                          "the output pages in a wanderful preview UI.");
		elm.setFont(new Font("Helvetica", Font.ITALIC, 12));
		book.write(elm);
		book.write("\n\n");

		book.write(new AtNewlineElement());
		elm = new AtStringElement("Generate PDF from your J2EE Server Applications\n\n");
		elm.setFont(subTitleFont);
		elm.setForeground(subTitleColor);
		book.write(elm);

		book.write(new AtStringElement("Deploy the SmartJPrint APIs to generate PDF files from your J2EE server. " +
		                               "Let your J2EE program write styled text, icons, and 2D graphics " +
		                               "using the SmartJ printing APIs. " +
		                               "You can then have options to generate a \"Adobe Acrobat\" readable " +
		                               "PDF document as a file, or print the output to a printer. " +
		                               "Design your PDF forms using the text, icons, and 2D graphics. " +
		                               "Look at the examples to find out how simple it is to do all of these from " +
		                               "your Java program.\n\n"));

	}

	public static void main(String args[]) {
		if (args != null && args.length >= 1) {
			SmartJPrint.setLicenseKey(args[0]);
		}
		else {
			System.out.println("Usage: java " + SmartJPrint_ToPDFDemo1.class.getName() + " licenseKey");
			System.exit(0);
		}

		PrintAndPDFFromJ2EEdemo2 print = new PrintAndPDFFromJ2EEdemo2();
		print.postInit();
	}

}

