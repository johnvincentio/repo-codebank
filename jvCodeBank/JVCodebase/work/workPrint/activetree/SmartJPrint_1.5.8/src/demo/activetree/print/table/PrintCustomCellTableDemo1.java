/**
 * Source: PrintCustomCellTableDemo1.java
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

import java.awt.event.ActionEvent;
import java.awt.*;
import java.io.OutputStream;

import com.activetree.print.*;
import com.activetree.utils.AtDebug;
import com.activetree.common.SmartJPrint;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class PrintCustomCellTableDemo1 extends PrintFrame {
	private JTable table = null;

	public PrintCustomCellTableDemo1() {
		super();
		frame.setTitle("Smart JPrint - Print JTable");
		table = getTable();
		setPrintableComponent(table);
	}

	public void actionPerformed(ActionEvent evt) {
		if (evt.getActionCommand().equals("Print")) {
			tablePrinter.print(table, PageNoPainter.PAGE_NONE, true, true, null, null);
		}else if (evt.getActionCommand().equals("Generate PDF")) {
			printAsPdf(table, pdfPrinter);
		}else if (evt.getActionCommand().equals("Preview")) {
			tablePrinter.preview(table, PageNoPainter.LOWER_CENTER, true, frame);
		}
	}

	public void printAsPdf(JComponent compToPrint, AtPdfPrinter pdfPrinter) {
		AtDebug.debug("Save As PDF file...");
		OutputStream outputStream = AtPrintUtil.getOutputStream(compToPrint, "pdf", "PDF Files");
		if (outputStream == null) {
		  return;
		}

		try {
			pdfPrinter.print(compToPrint, outputStream, pdfPrinter.getPageNumberLocation(), true);
		}catch(Throwable ex) {
		  ex.printStackTrace();
		}

		System.out.println("PDF document is produced for viewing.");
	}

	private JTable getTable() {
		JTable table = new JTable(new EmployeeModel());
		table.setPreferredScrollableViewportSize(new Dimension(600, 200));

		//set renderer in the table.
		table.setDefaultRenderer(String.class, new ColorRenderer());
		JComboBox educationList = new JComboBox();
		educationList.addItem("Graduate");
		educationList.addItem("P.G.Diploma");
		educationList.addItem("Masters");
		educationList.addItem("Phd");
		educationList.addItem("High School");
		educationList.addItem("Junior School");
		TableColumn eduColumn = table.getColumnModel().getColumn(3);
		eduColumn.setCellEditor(new DefaultCellEditor(educationList));

		return table;
	}

	class EmployeeModel extends AbstractTableModel {
		Object[] columns =
		  {"Emp No", "Last Name", "First Name", "Education", "Department", "Gender"};

		Object[][] employees = {
			{"4444", "Beech", "Jonathan","Graduate", "Software",new Boolean(false)},
			{"5555","Lee","Aaron","P.G.Diploma", "Software",new Boolean(false)},
			{"1111","Nair","Reena","Masters", "Marketing",new Boolean(true)},
			{"2222","Kundu","Biswajit","High School", "Software",new Boolean(false)},
			{"3333","Roy","Renuka","Phd", "Accounting",new Boolean(true)} };

		public String getColumnName(int col) {
			return columns[col].toString();
		}

		public Class getColumnClass(int col) {
			return employees[0][col].getClass();
		}

		public int getColumnCount() {
			return columns.length;
		}

		public int getRowCount() {
			return employees.length;
		}

		public Object getValueAt(int row, int col) {
			return employees[row][col];
		}

		public boolean isCellEditable(int row, int col) {
			return true;
		}

		public void setValueAt(
		  Object value, int row, int col) {
			employees[row][col] = value;
			fireTableCellUpdated(row, col);
		}
	}

	class ColorRenderer extends DefaultTableCellRenderer {
		public ColorRenderer() {
			setBackground(SystemColor.controlShadow);
		}

		public Component getTableCellRendererComponent(
		  JTable table, Object value,
		  boolean isSelected, boolean hasFocus,
		  int row, int column) {

			JLabel renderer = (JLabel) super.getTableCellRendererComponent(table,
			    value, isSelected, hasFocus, row, column);

			renderer.setBackground(SystemColor.control);
			if (isSelected) {
				renderer.setBackground(SystemColor.controlShadow);
				renderer.setForeground(SystemColor.blue.darker());
			}
			return renderer;
		}
	}

	public static void main(String[] args) {
		if (args != null && args.length >= 1) {
			SmartJPrint.setLicenseKey(args[0]);
		}
		else {
			System.out.println("Usage: java " + PrintCustomCellTableDemo1.class.getName() + " licenseKey");
			System.exit(0);
		}

		PrintFrame demo = new PrintCustomCellTableDemo1();
		demo.postInit();
		demo.setVisible(true);
	}
}

