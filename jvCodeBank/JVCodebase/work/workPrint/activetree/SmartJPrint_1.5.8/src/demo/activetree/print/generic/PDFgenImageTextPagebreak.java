/**
 * Source: PDFgenImageTextPagebreak.java
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

public class PDFgenImageTextPagebreak extends JApplet {
	private AtPdfPrinter pdfPrinter;
	private AtBook book = new AtBook();

	public PDFgenImageTextPagebreak() {
	}

	public void init() {
		SmartJPrint.setLicenseKey(getParameter("key"));
		postInit();
	}

	public void postInit() {
		pdfPrinter = new AtPdfPrinter();
		createBook();

		//Generate PDF
		//printPDF();

		//This is going to print the output to a printer.
		AtGenericPrinter genericPrinter = new AtGenericPrinter();
		genericPrinter.applyAntialiasing(true); //optional

		//if you want user intervention and GUI preview.
		genericPrinter.preview(book, null);
	}

	private void createBook() {
		Font titleFont = new Font("Arial", Font.BOLD, 16);
		Color titleColor = SystemColor.blue.darker().darker();

		AtStringElement elm = new AtStringElement("Print & Generate PDF using \"Smart JPrint\"\n\n",
		                                          titleFont);
		elm.setForeground(titleColor);
		book.write(elm);
		book.write("Add styled text, icons, simple 2D Graphics to print all of them together. ");
		book.write("Make use of the write() methods from the AtBook class to add all of " +
		           "these and then pass the AtBook to an AtGenericPrinter for printing it " +
		           "or to an AtPdfPrinter to generate PDF document.\n\n");


		book.write(new AtStringElement("Next is an image.\n\n", titleFont, titleColor));
		ImageIcon waterLillies = new ImageIcon(
		  getClass().getResource("/demo/activetree/image/water_lillies.jpg"));
		book.write(waterLillies);

		elm = new AtStringElement("\n\nHow to produce strike through text?", titleFont, titleColor);
		book.append(elm);
		elm = new AtStringElement("\n\nThis line in an example of how to produce strike through " +
		                          "text for printing, PDF generation, TIFF, JPG, and PNG output.\n");
		elm.setStrikeThrough(true);
		elm.setStrikeThroughColor(SystemColor.MAGENTA);
		book.append(elm);
		book.append(AtElement.PAGE_BREAK);

		book.write(new AtStringElement("\n\nAdding special characters to the strings",
		                               titleFont, titleColor));
		book.write("\n\nIt is very simple to use the AtBook class to add lines of text. You " +
		           "can add line break using the \\n character as you do for standard output " +
		           "generation from Java System.out.println() methods. You can add a TAB " +
		           "character \\t that will put 8 white spaces when rendering the output.\n\n");


		book.write(new AtStringElement("How to page break?", titleFont, titleColor));
		book.write("\n\nA page break can be added using the AtPageBreak object or by " +
		           "using the PAGE_BREAK constant defined in the AtElement class.");
	}

	private void printPDF() {
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
			pdfPrinter.print(book, outStream, PageNoPainter.LOWER_CENTER, false);
			//System.out.println("A PDF document is generated.");
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

		PDFgenImageTextPagebreak demo = new PDFgenImageTextPagebreak();
		demo.postInit();
	}
}
