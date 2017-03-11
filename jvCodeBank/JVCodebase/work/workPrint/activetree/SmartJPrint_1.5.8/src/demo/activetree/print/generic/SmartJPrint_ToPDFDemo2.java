/**
 * Source: SmartJPrint_ToPDFDemo2.java
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
import java.awt.print.PageFormat;
import java.io.OutputStream;

import demo.activetree.print.PrintFrame;

public class SmartJPrint_ToPDFDemo2 extends JApplet {
	private AtPdfPrinter pdfPrinter;
	private AtBook book;


	public SmartJPrint_ToPDFDemo2() {
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
		ImageIcon rightArrow = AtImageList.IMAGE_LIST.RIGHT_ARROW_16;
		ImageIcon leftArrow = AtImageList.IMAGE_LIST.LEFT_ARROW_16;

		AtStringElement elm = new AtStringElement("SmartJPrint_ToPDFDemo2\n\n", titleFont);
		elm.setForeground(titleColor);
		book.write(elm);

		book.write(rightArrow);
		book.write(new AtStringElement("Generate PDF from your J2EE Server Applications  ",
		                               subTitleFont, titleColor));
		book.write(leftArrow);
		book.write("\n\n");
		book.write(rightArrow);
		elm = new AtStringElement("Few numbers:\n");
		elm.setFont(subTitleFont);
		elm.setForeground(subTitleColor);
		book.write(elm);
		book.write("(1)0123456789 (2)0123456789 (3)0123456789 (4)0123456789" +
		           "  (5)0123456789 (6)0123456789 (7)0123456789 (8)0123456789(9)" +
		           "0123456789  (10)0123456789  (11)0123456789  (12)0123456789  (13)" +
		           "0123456789  (14)0123456789  (15)0123456789  (16)0123456789  (17)0123456789" +
		           "  (18)0123456789  (19)0123456789\n\n");

		book.write(rightArrow);
		elm = new AtStringElement("Some random", new Font("Helvetica", Font.PLAIN, 15));
		elm.setForeground(subTitleColor);
		book.write(elm);
		elm = new AtStringElement(" text output:\n", new Font("Helvetica", Font.PLAIN, 15));
		elm.setForeground(subTitleColor);
		book.write(elm);
		for (int i=0; i < 100; i++) {
			book.write("Your J2EE program output line no " + i + "\n");
		}
	}

	protected void producePDF() {
		//now Generate a Pageable and pass to the pdf printer.
		OutputStream outStream = null;
		try {
      outStream = AtPrintUtil.getOutputStream(null, "pdf", "PDF Files");
			if (outStream == null) {
				System.out.println("You did not select a filename.");
			}

			PageFormat customPf = PrintFrame.getPortraitCustomPageFormat();
			pdfPrinter.print(book, outStream, PageNoPainter.LOWER_CENTER, customPf, false);
			//pdfPrinter.print(book, outStream, PageNoPainter.LOWER_CENTER, true);
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
			System.out.println("Usage: java " + SmartJPrint_ToPDFDemo2.class.getName() + " licenseKey");
			System.exit(0);
		}

		SmartJPrint_ToPDFDemo2 demo = new SmartJPrint_ToPDFDemo2();
		demo.postInit();
	}
}

