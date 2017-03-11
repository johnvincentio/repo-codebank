/**
 * Source: CustomStringTableCellRendererDemo.java
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

import com.activetree.print.*;
import com.activetree.common.SmartJPrint;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.text.SimpleDateFormat;

import demo.activetree.print.PrintFrame;
import demo.activetree.print.DemoHeaderFooterRenderer;

public class CustomStringTableCellRendererDemo extends PrintFrame {
	private JTable table = null;

	public CustomStringTableCellRendererDemo() {
		super();
		frame.setTitle("Print JTable with Styled String Cells");
		table = getTable();
		setPrintableComponent(table);
	}

	public JTable getJTable() {
		return table;
	}

	public void actionPerformed(ActionEvent evt) {
		PageHeaderFooterListener l = new DemoHeaderFooterRenderer("Employee Information - Manufacturing Division");
		tablePrinter.setPageHeaderFooterListener(l);
		if (evt.getActionCommand().equals("Print")) {
			tablePrinter.print(table, PageNoPainter.PAGE_NONE, false);
		}else if (evt.getActionCommand().equals("Generate PDF")) {
			pdfPrinter.setPageNumberLocation(PageNoPainter.PAGE_NONE);
			pdfPrinter.setPageHeaderFooterListener(l);
			printAsPdf(table, pdfPrinter);
		}else if (evt.getActionCommand().equals("Preview")) {
			tablePrinter.preview(table, PageNoPainter.PAGE_NONE, true, frame);
		}
	}

	JTable getTable() {
		String[] cols = {"EmpNo", "Employee Name", "SSN", "Date Of Birth",
		                 "Home Phone", "Work Phone", "Street Address"};
		Object[][] data = new Object[100][cols.length];

		//Create same data for the table.
		int empNo = 1000;
		String name = "Employee Name - ";
		String ssn = "SSN - ";
		//String dob = "Date - ";
		String homePhone = "Home Phone - ";
		String workPhone = "Work Phone - 000";
		String stAddr = "Street Address - ";
		for (int row=0; row < data.length; row++) {
			data[row][0] = String.valueOf(empNo+row);
			data[row][1] = name + row;
			data[row][2] = ssn + row;
			data[row][3] = new java.util.Date();
			data[row][4] = homePhone + row;
			data[row][5] = workPhone + row;
			data[row][6] = stAddr + row;
			if (row == 2) {
				data[row][1] = "";
				data[row][2] = "";
				data[row][3] = null;
			}
		}

		DefaultTableModel tableModel = new DefaultTableModel(data, cols) {
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return false;
			}
		};
		JTable table = new JTable(tableModel);
		DateTableCellRenderer dateRenderer = new DateTableCellRenderer();
		table.getColumnModel().getColumn(3).setCellRenderer(dateRenderer);
		table.setRowHeight(dateRenderer.getCellHeight());
		return table;
	}

	class DateTableCellRenderer extends JLabel implements TableCellRenderer, PrintableCell {
		SimpleDateFormat format = (SimpleDateFormat)SimpleDateFormat.getDateInstance();
		private String pattern = "hh:mm a MM/dd/yy (E)";
		Font font = new Font("Helvetica", Font.BOLD, 20);
		FontMetrics fm = super.getFontMetrics(font);
		Color fg = Color.decode("#3366cc");
		Color bg = SystemColor.white;
		String value;

	  public Component getTableCellRendererComponent(JTable table, Object value,
	                        boolean isSelected, boolean hasFocus, int row, int column) {
	    format.applyPattern(pattern);
	    String text = (value==null)? "" : format.format(value);
	    this.value = text;
	    super.setFont(font);
	    super.setText(text);
	    if (isSelected) {
		    super.setForeground(fg);
		    super.setBackground(table.getSelectionBackground());
	    } else {
	      super.setForeground((fg != null) ? fg : table.getForeground());
	      super.setBackground((bg != null) ? bg : table.getBackground());
	    }
	    return this;
	  }

		/////PrintableCell interface APIs/////////////////////////////////////
		public AtElement getContent() {
			AtStringElement elm = new AtStringElement(value, font, fg, bg, false);
			//elm.setStrikeThrough(true);
			elm.setAlignment(AtElement.CENTER);
			return elm;
		}

		public int getCellWidth() {
			return fm.stringWidth(value);
		}

		public int getCellHeight() {
			return fm.getHeight();
		}

		public void draw(Graphics g, JTable table, Object cellValue, int row,
		                 int col, boolean isHeaderCell, Rectangle cellBbox, double zoom) {}
	}

	public static void main(String[] args) {
		if (args != null && args.length >= 1) {
			SmartJPrint.setLicenseKey(args[0]);
		}
		else {
			System.out.println("Usage: java " + CustomStringTableCellRendererDemo.class.getName() + " licenseKey");
			System.exit(0);
		}
		PrintFrame demo = new CustomStringTableCellRendererDemo();
		demo.postInit();
		demo.setVisible(true);
	}
}



