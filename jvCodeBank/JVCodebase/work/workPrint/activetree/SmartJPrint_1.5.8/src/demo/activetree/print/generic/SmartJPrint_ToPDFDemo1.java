/**
 * Source: SmartJPrint_ToPDFDemo1.java
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
import com.activetree.resource.AtImageList;
import com.activetree.common.SmartJPrint;

import javax.swing.*;
import java.awt.*;
import java.io.OutputStream;

public class SmartJPrint_ToPDFDemo1 extends JApplet {
	private AtPdfPrinter pdfPrinter;
	private AtBook book;

	public SmartJPrint_ToPDFDemo1() {
	}

	public void init() {
		SmartJPrint.setLicenseKey(getParameter("key"));
		postInit();
	}

	public void postInit() {
		pdfPrinter = new AtPdfPrinter();
		createBook();

		//Produce PDF by uncommenting this line.
		//producePDF();

		//This is going to print the output to a printer.
		AtGenericPrinter genericPrinter = new AtGenericPrinter();
		genericPrinter.applyAntialiasing(true); //optional

		//if you want user intervention and GUI preview.
		genericPrinter.preview(book, null);
	}

	private void createBook() {
		book = new AtBook();
		Font titleFont = new Font("Helvitica", Font.BOLD, 20);
		Font subTitleFont = new Font("Helvitica", Font.PLAIN, 15);
		Color titleColor = SystemColor.blue.darker().darker();
		Color subTitleColor = SystemColor.blue.darker().darker();
		ImageIcon bullet = AtImageList.IMAGE_LIST.RIGHT_ARROW_16;

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

		book.write(bullet);
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

		book.write(bullet);
		elm = new AtStringElement("Generate PDF from your Java GUI Swing components\n\n");
		elm.setFont(subTitleFont);
		elm.setForeground(subTitleColor);
		book.write(elm);
		book.write("Java GUI application can generate the output as a PDF document from a " +
		           "GUI component such as tables (using JTable), text data (from JTextArea, " +
		           "JTextPane, JEditorPane, or any kind of JTextComponent) and images. The " +
		           "SmartJ printing APIs automatically prints these components by breaking " +
		           "them into rows and columns and pages as appropriate.\n\n");

		book.write(bullet);
		elm = new AtStringElement("Print and/or Preview\n\n");
		elm.setFont(subTitleFont);
		elm.setForeground(subTitleColor);
		book.write(elm);
		book.write("Smart JPrint APIs are very flexable and allows you to either print " +
		           "the output to a printer, preview the output using a GUI preview window, " +
		           "and/or send the output to write as a PDF document. " +
		           "Therefore, you can generate PDF files or create hard copies of " +
		           "the output by printing it to a " +
		           "printer. For a GUI based program, you can preview the output and then " +
		           "you can select page(s) to print or generate PDF documents.\n\n");

		book.write(bullet);
		elm = new AtStringElement("Downloads and details?\n\n");
		elm.setFont(subTitleFont);
		elm.setForeground(subTitleColor);
		book.write(elm);

		book.write(new AtStringElement("You might check at our website"));

		elm = new AtStringElement("http://www.activetree.com");
		elm.setFont(new Font("Helvetica", Font.ITALIC, 12));
		elm.setUnderslined(true);
		book.write(elm);

		elm = new AtStringElement(" for the details of the products, features, and downloads.\n");
		book.write(elm);

		book.write(new AtLineElement(200, 1, AtLineElement.BOTTOM, true));
		AtStringElement note = new AtStringElement("Note: ", new Font("Helvitica", 3, 12)); //3 == BOLD + ITALIC
		book.write(note);
		book.write(new AtStringElement("This PDF document is generated using Smart JPrint (AtGenericPrinter class).", new Font("Helvetica", Font.ITALIC, 12)));
	}

	protected void producePDF() {
		//now Generate a Pageable and pass to the pdf printer.
		OutputStream outStream = null;
		try {
			outStream = AtPrintUtil.getOutputStream(null, "pdf", "PDF Files");
			if (outStream == null) {
				System.out.println("You did not select a file for output.");
				return;
			}

			//Print with default page format.
			//pdfPrinter.print(book, outStream, PageNoPainter.LOWER_CENTER, false);

			//For printing with custom page format.
			pdfPrinter.print(book, outStream, PageNoPainter.LOWER_CENTER, true);
			System.out.println("A PDF document is generated.");
			outStream.close();
		}catch(Throwable t) {
			t.printStackTrace();
		}
	}

	public static void main(String[] args) {
		if (args != null && args.length >= 1) {
			SmartJPrint.setLicenseKey(args[0]);
		}
		else {
			System.out.println("Usage: java " + SmartJPrint_ToPDFDemo1.class.getName() + " licenseKey");
			System.exit(0);
		}

		SmartJPrint_ToPDFDemo1 demo = new SmartJPrint_ToPDFDemo1();
		demo.postInit();
	}
}
