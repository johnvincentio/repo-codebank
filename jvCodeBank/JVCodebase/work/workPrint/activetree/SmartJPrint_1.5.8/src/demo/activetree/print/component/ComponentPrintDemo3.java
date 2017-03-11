/**
 * Source: ComponentPrintDemo3.java
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
package demo.activetree.print.component;

import demo.activetree.print.PrintFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.*;

import com.activetree.print.AtComponentPrinter;
import com.activetree.print.PageNoPainter;
import com.activetree.utils.AtLAFUtil;
import com.activetree.common.SmartJPrint;

public class ComponentPrintDemo3 extends PrintFrame {
	private Component canvas = null;

	public ComponentPrintDemo3() {
		super();
		frame.setTitle("Smart JPrint - Printing any Component");
		canvas = sampleComponent();
		setPrintableComponent(canvas);
		frame.setSize(new Dimension(460, 450));
	}

	public void actionPerformed(ActionEvent evt) {
		AtComponentPrinter printer = new AtComponentPrinter();

		if (evt.getActionCommand().equals("Print")) {
			printer.print(canvas, PageNoPainter.LOWER_CENTER);
		}else if (evt.getActionCommand().equals("Generate PDF")) {
			//pdfPrinter.setCopies(3);
			super.printAsPdf(canvas, pdfPrinter);
		}else if (evt.getActionCommand().equals("Preview")) {
			printer.preview(canvas, PageNoPainter.LOWER_CENTER, true, frame);
		}
	}

	private Component sampleComponent() {
		JPanel top = new JPanel(new BorderLayout());

		JPanel employeeDetails = new JPanel(new GridBagLayout());
		employeeDetails.add(new JLabel("Emp Number", JLabel.TRAILING),
		                    new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.EAST,
		                                           GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		employeeDetails.add(new JTextField("1002995000"),
		                    new GridBagConstraints(1, 0, 1, 1, 1, 0, GridBagConstraints.WEST,
		                                           GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		employeeDetails.add(new JLabel("Last Name", JLabel.TRAILING),
		                    new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.EAST,
		                                           GridBagConstraints.NONE, new Insets(0, 5, 5, 5), 0, 0));

		employeeDetails.add(new JTextField("Roy"),
		                    new GridBagConstraints(1, 1, 1, 1, 1, 0, GridBagConstraints.WEST,
		                                           GridBagConstraints.BOTH, new Insets(0, 5, 5, 5), 0, 0));

		employeeDetails.add(new JLabel("First Name", JLabel.TRAILING),
		                    new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.EAST,
		                                           GridBagConstraints.NONE, new Insets(0, 5, 5, 5), 0, 0));

		employeeDetails.add(new JTextField("Renuka"),
		                    new GridBagConstraints(1, 2, 1, 1, 1, 0, GridBagConstraints.WEST,
		                                           GridBagConstraints.BOTH, new Insets(0, 5, 5, 5), 0, 0));

		employeeDetails.add(new JLabel("Home Phone", JLabel.TRAILING),
		                    new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.EAST,
		                                           GridBagConstraints.NONE, new Insets(0, 5, 5, 5), 0, 0));

		employeeDetails.add(new JLabel("408-967-4586", JLabel.LEADING),
		                    new GridBagConstraints(1, 3, 1, 1, 1, 0, GridBagConstraints.WEST,
		                                           GridBagConstraints.BOTH, new Insets(0, 5, 5, 5), 0, 0));

		employeeDetails.add(new JLabel("Cell Phone", JLabel.TRAILING),
		                    new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.EAST,
		                                           GridBagConstraints.NONE, new Insets(0, 5, 5, 5), 0, 0));

		employeeDetails.add(new JLabel("650-678-3598", JLabel.LEADING),
		                    new GridBagConstraints(1, 4, 1, 1, 1, 0, GridBagConstraints.WEST,
		                                           GridBagConstraints.BOTH, new Insets(0, 5, 5, 5), 0, 0));

		employeeDetails.add(new JLabel("Address", JLabel.TRAILING),
		                    new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 5, 5, 5), 0, 0));

		employeeDetails.add(new JTextArea("Old Addesss:\n2451 California Ave\nApartment-256" +
		                                  "\nSunnyvale\nCA 95105-4523" +
		                                  "\n\nNew address:\n2541 Alvin Ave\nSan Jose\nCA 95135-5622"),
		                    new GridBagConstraints(1, 5, 1, 1, 1, 0, GridBagConstraints.WEST,
		                                           GridBagConstraints.BOTH, new Insets(0, 5, 5, 5), 0, 0));

		employeeDetails.add(new JLabel("Education", JLabel.TRAILING),
		                    new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.EAST,
		                                           GridBagConstraints.NONE, new Insets(0, 5, 5, 5), 0, 0));

		employeeDetails.add(new JTextField("Masters in Science"),
		                    new GridBagConstraints(1, 6, 1, 1, 1, 0, GridBagConstraints.WEST,
		                                           GridBagConstraints.BOTH, new Insets(0, 5, 5, 5), 0, 0));

		top.add(employeeDetails, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
		buttonPanel.add(new JButton("Next"));
		buttonPanel.add(new JButton("Previous"));
		buttonPanel.add(new JButton("Ok"));
		buttonPanel.add(new JButton("Cancel"));
		buttonPanel.add(new JButton("Help"));
    top.add(buttonPanel, BorderLayout.SOUTH);

		return top;
	}

	public static void main(String[] args) {
		if (args != null && args.length >= 1) {
			SmartJPrint.setLicenseKey(args[0]);
		}
		else {
			System.out.println("Usage: java " + ComponentPrintDemo1.class.getName() + " licenseKey");
			System.exit(0);
		}
    AtLAFUtil.setWindowsLookAndFeel();
		PrintFrame demo = new ComponentPrintDemo3();
		demo.postInit();
		demo.setVisible(true);
	}
}
