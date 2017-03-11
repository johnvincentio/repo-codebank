/**
 * Source: PrintWithHeaderFooterDemo.java
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
package demo.activetree.print.table;

import demo.activetree.print.PrintFrame;
import demo.activetree.print.DemoHeaderFooterRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;

import com.activetree.print.*;
import com.activetree.common.SmartJPrint;

public class PrintWithHeaderFooterDemo extends PrintFrame {
	private JTable table = null;

	public PrintWithHeaderFooterDemo() {
		super();
		frame.setTitle("Smart JPrint - Print JTable with header and footer");
		table = getTable();
		setPrintableComponent(table);
	}

	public void actionPerformed(ActionEvent evt) {
		PageHeaderFooterListener l = new DemoHeaderFooterRenderer("New hire contact details");
		tablePrinter.setPageHeaderFooterListener(l);
		if (evt.getActionCommand().equals("Print")) {
			tablePrinter.print(table, PageNoPainter.PAGE_NONE, true, true, null, null);
		}else if (evt.getActionCommand().equals("Generate PDF")) {
			pdfPrinter.setPageNumberLocation(PageNoPainter.PAGE_NONE);
			pdfPrinter.setPageHeaderFooterListener(l);
			printAsPdf(table, pdfPrinter);
		}else if (evt.getActionCommand().equals("Preview")) {
			tablePrinter.preview(table, PageNoPainter.PAGE_NONE, true, frame);
		}
	}

	JTable getTable() {
		String[] cols = {"Last Name", "First Name", "Phone Number", "Company Name"};
		String[][] data = new String[100][cols.length];

		//Create same data for the table.
		String lName = "Last name - ";
		String fName = "First name - ";
		String phone = "Phone number - ";
		String company = "Company name - ";
		for (int row=0; row < data.length; row++) {
			data[row][0] = lName + row;
			data[row][1] = fName + row;
			data[row][2] = phone + row;
			data[row][3] = company + row;
		}

		DefaultTableModel tableModel = new DefaultTableModel(data, cols) {
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return false;
			}
		};
		JTable table = new JTable(tableModel);
		return table;
	}

	public static void main(String[] args) {
		if (args != null && args.length >= 1) {
			SmartJPrint.setLicenseKey(args[0]);
		}
		else {
			System.out.println("Usage: java " + PrintWithHeaderFooterDemo.class.getName() + " licenseKey");
			System.exit(0);
		}

		PrintFrame demo = new PrintWithHeaderFooterDemo();
		demo.postInit();
		demo.setVisible(true);
	}
}