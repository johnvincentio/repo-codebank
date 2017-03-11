/**
 * Source: UsingAtBookDemo.java
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
import java.io.OutputStream;
import java.awt.*;

public class UsingAtBookDemo extends JApplet {
	private AtPdfPrinter pdfPrinter;
	private AtBook book = new AtBook();

	public UsingAtBookDemo() {
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
			//Align an AtElement by wrapping it into a AtLineContent object shown next.
			AtStringElement leftAlignedElm = new AtStringElement("Example of Left Aligned Text", new Font("Times New Roman", Font.PLAIN, 28));
			AtStringElement centerAlignedElm = new AtStringElement("Example of Center Aligned Text", new Font("Times New Roman", Font.PLAIN, 22));
			AtStringElement rightAlignedElm = new AtStringElement("Example of Right Aligned Text", new Font("Times New Roman", Font.PLAIN, 16));
			AtLineContent leftAlignedLine = new AtLineContent(leftAlignedElm, AtElement.LEADING);
			AtLineContent centerAlignedLine = new AtLineContent(centerAlignedElm, AtElement.CENTER);
			AtLineContent rightAlignedLine = new AtLineContent(rightAlignedElm, AtElement.TRAILING);
			book.append(new AtStringElement("Aligning Text Horizontally\n\n",
			                                new Font("Helvetica", Font.PLAIN, 30),
			                                AtPrintConstants.GENERAL_HEADER_FG1));
			book.append("Align an AtElement such as AtStringElement, AtIconElement " +
			            "etc. within a line in the page using the AtLineContent Object.\n\n" +
			            "Following are examples of LEADING, CENTER, and TRAILING " +
			            "alignment of text elements (AtStringElement objects) each added " +
			            "into a AtLineContent.\n\n");
			book.append(leftAlignedLine);
			book.append(centerAlignedLine);
			book.append(rightAlignedLine);

			ImageIcon icon = new ImageIcon(getClass().getResource("/demo/activetree/image/tree_faces.png"));
			AtIconElement leftAlignedIcon = new AtIconElement(icon.getImage());
			AtIconElement centerAlignedIcon = new AtIconElement(icon.getImage());
			AtIconElement rightAlignedIcon = new AtIconElement(icon.getImage());
			AtLineContent left = new AtLineContent(leftAlignedIcon, AtElement.LEADING);
			AtLineContent centered = new AtLineContent(centerAlignedIcon, AtElement.CENTER);
			AtLineContent right = new AtLineContent(rightAlignedIcon, AtElement.TRAILING);
			book.append(new AtStringElement("Aligning an Icon Horizontally\n\n",
			                                new Font("Helvetica", Font.PLAIN, 30),
			                                AtPrintConstants.GENERAL_HEADER_FG1));
			book.append(left);
			book.append(centered);
			book.append(right);

			//Example of Underlined text
			book.append(new AtStringElement("\n\nUnderlined Text\n",
			                                new Font("Helvetica", Font.PLAIN, 30),
			                                AtPrintConstants.GENERAL_HEADER_FG1));
			AtStringElement underlinedText = new AtStringElement("This line of text is an example of " +
			                                                     "underlined text.",
			                                                     new Font("Helvetica", Font.PLAIN, 22));
			underlinedText.setUnderslined(true);
			book.append(underlinedText);

			//Strikethrough text examples
			book.append(new AtStringElement("\n\nStrike through Text\n",
			                                new Font("Helvetica", Font.PLAIN, 30),
			                                AtPrintConstants.GENERAL_HEADER_FG1));
			AtStringElement strikeThroughText = new AtStringElement("This line of text is an example " +
			                                                        "of strike through Text.",
			                                                        new Font("Helvetica", Font.PLAIN, 22));
			strikeThroughText.setStrikeThrough(true);
			book.append(strikeThroughText);

			//Changing line spacing between lines next to each other.
			book.append(new AtStringElement("\n\nChanging Vertical Space Between Lines\n",
			                                new Font("Helvetica", Font.PLAIN, 30),
			                                AtPrintConstants.GENERAL_HEADER_FG1));
			AtStringElement line1 = new AtStringElement("(1) Wider vertical space between this line and next line (vertical gap of 6 pixels).\n");
			AtStringElement line2 = new AtStringElement("(2) Smallest vertical gap between this line and next line (vertical gap of 0 pixels).\n");
			AtStringElement line3 = new AtStringElement("(3) Example of changing vertical space between lines of text\n");
			line1.setLineSpacing(6.0f); //increasing line spacing between line 1 & 2
			line2.setLineSpacing(0.0f); //reducing the line spacing between line 2 & 3.
			book.append(line1);
			book.append(line2);
			book.append(line3);

      //Adding a TAB
			book.append(new AtStringElement("\n\nAdding TAB & New Line Characters\n",
			                                new Font("Helvetica", Font.PLAIN, 30),
			                                AtPrintConstants.GENERAL_HEADER_FG1));
			AtStringElement tabStrElm
			  = new AtStringElement("This line of text has a tab character. Next is the TAB " +
			                        "character.\tThis sentence is after the TAB character. A TAB " +
			                        "character is represented by \\t and a new line is represented " +
			                        "by \\n characters respectively. When you add a long string, you " +
			                        "can add TAB and new line characters at any place within the string.");
			book.append(tabStrElm);

      //Adding Page Break
			book.append(new AtStringElement("\n\nAdding Page Break\n",
			                                new Font("Helvetica", Font.PLAIN, 30),
			                                AtPrintConstants.GENERAL_HEADER_FG1));
			AtStringElement pageBreakElm
			  = new AtStringElement("Adding PAGE BREAK is very easy. There is already a " +
			                        "AtPageBreak class defined for this purpose. You can " +
			                        "add a \"new AtPageBreak()\" using the append() methods " +
			                        "defined in the AtBook. Alternatively, make use of the constant " +
			                        "PAGE_BREAK defined in the AtElement. Anywhere in the program " +
			                        "you feel free to add a page break. Once you add a page break, e.g. " +
			                        "AtElement.PAGE_BREAK, all contents appended after this will be " +
			                        "rendered in the next page of the document leaving rest of the space " +
			                        "in the page empty.");
			book.append(pageBreakElm);

			//Align an element in a new page both horizontally and vertically
			//using a AtPageContent object.
			//Vertical alignment is at CENTER & horizontal alignment too is centered.
			AtStringElement newPageContent = new AtStringElement("Center Aligned Text Of a AtPageContent",
			                                                     new Font("Arial", Font.PLAIN, 22),
			                                                     AtPrintConstants.GENERAL_HEADER_FG1);
			AtLineContent aStringLine = new AtLineContent(newPageContent, AtElement.CENTER); //center withing the line horizontally
			AtPageContent aPageContent = new AtPageContent(aStringLine, 0.5f);  //center vertically withint the page.
			book.append(aPageContent);

			//vertical alignment at TOP and horizontal alignment TRAILING
			AtStringElement northAlignedPageContent = new AtStringElement("North-East Aligned Text of a AtPageContent",
			                                                     new Font("Arial", Font.PLAIN, 22),
			                                                     AtPrintConstants.GENERAL_HEADER_FG1);
			AtLineContent northAlignedPage = new AtLineContent(northAlignedPageContent, AtElement.TRAILING); //center withing the line horizontally
			AtPageContent pageContent2 = new AtPageContent(northAlignedPage, 0.0f);  //center vertically withint the page.
			book.append(pageContent2);

			//Vertical alignment is at BOTTOM & horizontal alignment is LEADING
			AtStringElement southAlignedPageContent = new AtStringElement("South-West Aligned Text of a AtPageContent",
			                                                     new Font("Arial", Font.PLAIN, 22),
			                                                     AtPrintConstants.GENERAL_HEADER_FG1);
			AtLineContent sourthAlignedPage = new AtLineContent(southAlignedPageContent, AtElement.LEADING); //center withing the line horizontally
			AtPageContent pageContent3 = new AtPageContent(sourthAlignedPage, 1.0f);  //center vertically withint the page.
			book.append(pageContent3);
		}

	private void printPDF() {
		OutputStream outStream = null;
		try {
			outStream = AtPrintUtil.getOutputStream(null, "pdf", "PDF Files");
			if (outStream == null) {
				System.out.println("You did not select a file for output.");
				return;
			}
			pdfPrinter.print(book, outStream, PageNoPainter.LOWER_CENTER, false);
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
			System.out.println("Usage: java " + UsingAtBookDemo.class.getName() + " licenseKey");
			System.exit(0);
		}

		UsingAtBookDemo demo = new UsingAtBookDemo();
		demo.postInit();
	}
}
