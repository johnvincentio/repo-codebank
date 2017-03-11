/**
 * Source: JTextAreaPrintDemo.java
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

import com.activetree.print.PageNoPainter;
import com.activetree.common.SmartJPrint;

import javax.swing.*;
import java.awt.event.ActionEvent;

import demo.activetree.print.PrintFrame;

public class JTextAreaPrintDemo extends PrintFrame {
	private JTextArea ta = new JTextArea();

	public JTextAreaPrintDemo() {
		super();
		frame.setTitle("Smart JPrint - Printing JTextArea");
		ta.setText(simpleText());
		ta.setLineWrap(true);
		ta.setWrapStyleWord(true);
		setPrintableComponent(ta);
	}

	public void actionPerformed(ActionEvent evt) {
		if (evt.getActionCommand().equals("Print")) {
			printer.print(ta, PageNoPainter.LOWER_CENTER);
		}else if (evt.getActionCommand().equals("Generate PDF")) {
			//pdfPrinter.setCopies(3);
			super.printAsPdf(ta, pdfPrinter);
		}else if (evt.getActionCommand().equals("Preview")) {
			printer.preview(ta, PageNoPainter.LOWER_CENTER, true, frame);

//			AtAbstractPrinter printerClass = printer;
//			printer.setPreviewPaneSize(new Dimension(780,500));
//			AtPreviewFrame previewFrame = printerClass.getPreviewWindow();
//			//previewFrame.setSize(780,500);
//			previewFrame.setPreviewButtonVisible(AtPreviewFrame.PDF_BUTTON, false);
//			previewFrame.setPreviewButtonTooltipText(AtPreviewFrame.PRINT_BUTTON, "Print the pages");
//			previewFrame.setPreviewButtonImage(AtPreviewFrame.PRINT_BUTTON, AtImageList.IMAGE_LIST.FULLSCREEN);
//			previewFrame.setPreviewButtonEnabled(AtPreviewFrame.GO_BUTTON, false);
		}
	}

	private String simpleText() {
		String msg = "State changes in objects\n\n";

		msg += "Just to give you an example, let us take water (H2O) as a type. In ";
		msg += "summer, mother nature heats up everything and the water in lakes, ";
		msg += "rivers, sea evaporates to become clouds in the sky. In winter, ";
		msg += "nature extracts heat from the water and it becomes ice to spread ";
		msg += "across fields, rivers, and mountains. Ice again becomes water and ";
		msg += "flows over mountains, plains to streams, and finally to sea, when ";
		msg += "mother nature completes the cycle by bringing the summer back.\n\n";

		msg += "What we have noticed from the above example?\n\n";

		msg += "We have definitely learned couple of things from it. A type, changes ";
		msg += "its state (in this case, the state is ice, water, or vapor). ";
		msg += "Something external that (in this case nature extracts or puts heat ";
		msg += "back to the water) acts to the object so that it moves from one ";
		msg += "state to another state.\n\n";

		msg += "Let us take the BankAccount class as an example. Assume that you ";
		msg += "have just opened a new bank account with $100 as the opening ";
		msg += "deposit amount. We can call the state of your account is in create ";
		msg += "state. Once created an account might take some times before it can be ";
		msg += "operational, as the bank has to deliver an ATM or Credit card, and ";
		msg += "bunch of check to you before it becomes operational. Therefore, when ";
		msg += "creation state is over, you are ready to operate your account by depositing, ";
		msg += "withdrawing, check issuing against the account, called operational state.\n\n";

		msg += "Similarly, when you do not operate your account for a very long ";
		msg += "time and do not have enough balance in the account, bank ";
		msg += "might move the account to closed state and you'll not be able to operate ";
		msg += "your account. To operate the same account, you perhaps have to ";
		msg += "request the bank to re-open it to operational state. In terms ";
		msg += "of object definition, the state can be defined using just an ";
		msg += "integer flag to hold the three different values. Let us say 1 ";
		msg += "is for ‘open state’, 2 for ‘operational state’ and 3 is to indicate ";
		msg += "‘closed state’.\n";
		return msg;
	}

	public static void main(String[] args) {
		if (args != null && args.length >= 1) {
			SmartJPrint.setLicenseKey(args[0]);
		}
		else {
			System.out.println("Usage: java " + JTextAreaPrintDemo.class.getName() + " licenseKey");
			System.exit(0);
		}

		JTextAreaPrintDemo demo = new JTextAreaPrintDemo();
		demo.postInit();
		demo.setVisible(true);
	}
}
