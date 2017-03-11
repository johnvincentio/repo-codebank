/**
 * Source: PrintFromJ2EEdemo1.java
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

public class PrintFromJ2EEdemo1 extends JApplet {
	private AtGenericPrinter genericPrinter;
	private AtBook book = new AtBook();

	public PrintFromJ2EEdemo1() {
	}

	public void init() {
		SmartJPrint.setLicenseKey(getParameter("key"));
		postInit();
	}

	public void postInit() {
//		int result = JOptionPane.showConfirmDialog(null,
//		                              "This program will try to print the Java \nprogram " +
//		                              "output to a printer.\n\nDo you want to continue?", "Confirm",
//		                              JOptionPane.INFORMATION_MESSAGE);
//		if (result != JOptionPane.YES_OPTION) {
//			super.destroy();
//			return;
//		}

		genericPrinter = new AtGenericPrinter();
		genericPrinter.applyAntialiasing(true);
		createBook();

		//Preview
		genericPrinter.preview(book, null);

		//Print
		//genericPrinter.print(book);
	}

	private void createBook() {
		Font titleFont = new Font("Times New Roman", Font.BOLD, 20);
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


		book.write(new AtStringElement("\n\nAdding special characters to the strings",
		                               titleFont, titleColor));
		book.write("\n\nIt is very simple to use the AtBook class to add lines of text. You " +
		           "can add line break using the \\n character as you do for standard output " +
		           "generation from Java System.out.println() methods. You can add a TAB " +
		           "character \\t that will put 8 white spaces when rendering the output.\n\n");


		book.write(AtElement.PAGE_BREAK);
		book.write(new AtStringElement("How to page break?", titleFont, titleColor));
		book.write("\n\n\tBefore this paragraph, there is a page break added. So don't get surprized if " +
		           "this heading is always shown at the beginning of a new page leaving empty " +
		           "spaces in the previous page. Typically in a J2EE program, you can add lines " +
		           "of text and put a page break at any position.");
		book.write("\n\n\tA page break can be added using the AtPageBreak object or by " +
		           "using the PAGE_BREAK constant defined in the AtElement class.");
		book.write("\n\nAs an example, both of the above two paragraphs has a \"\\t\" (TAB) at the beginning " +
		           "to indent the paragraphs. You can insert a tab character at any position " +
		           "in your string.");
	}

	public static void main(String[] args) {
		if (args != null && args.length >= 1) {
			SmartJPrint.setLicenseKey(args[0]);
		}
		else {
			System.out.println("Usage: java " + SmartJPrint_ToPDFDemo1.class.getName() + " licenseKey");
			System.exit(0);
		}

		PrintFromJ2EEdemo1 demo = new PrintFromJ2EEdemo1();
		demo.postInit();
	}
}
