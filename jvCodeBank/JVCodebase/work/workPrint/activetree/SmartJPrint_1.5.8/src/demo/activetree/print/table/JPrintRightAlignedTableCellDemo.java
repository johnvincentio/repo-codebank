/**
 * Source: JPrintRightAlignedTableCellDemo.java
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

import com.activetree.print.PageNoPainter;
import com.activetree.print.AtPdfPrinter;
import com.activetree.print.AtPrintUtil;
import com.activetree.utils.AtDebug;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.OutputStream;
import javax.swing.*;
import javax.swing.table.*;

import demo.activetree.print.PrintFrame;

public class JPrintRightAlignedTableCellDemo extends PrintFrame {
	private JTable table = null;

  public JPrintRightAlignedTableCellDemo() {
		super();
		frame.setTitle("Smart JPrint - Print JTable with different cell alignment.");
		table = getTable();
		setPrintableComponent(table);
	  frame.setSize(new Dimension(500, 350));
  }

	public void actionPerformed(ActionEvent evt) {
		if (evt.getActionCommand().equals("Print")) {
			tablePrinter.print(table, PageNoPainter.PAGE_NONE, true, true, null, null);
		}else if (evt.getActionCommand().equals("Generate PDF")) {
			printAsPdf(table, pdfPrinter);
		}else if (evt.getActionCommand().equals("Preview")) {
			tablePrinter.preview(table, PageNoPainter.LOWER_CENTER, true, frame);
			tablePrinter.getPreviewWindow().setSize(800, 500);
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

	protected JTable getTable() {
    JTable table = new JTable(new CustomTableModel());
		table.setPreferredScrollableViewportSize(new Dimension(500, 200));
		return table;
	}


  protected class CustomTableModel extends AbstractTableModel {
    protected final Object[][] dataSource =
    { {"0001", "Rice Bag", "Basmati", new Double(10.00),
       new Integer(5500), new Integer(10)},
      {"0002", "Rice Bag", "Jasmine", new Double(4.00),
       new Integer(6000), new Integer(10)},
      {"0003", "Rice Bag", "Basmati", new Double(30.00),
       new Integer(7000), new Integer(40)},
      {"0004", "Wheat Bag", "N/A", new Double(4.00),
       new Integer(5000), new Integer(10)},
      {"0005", "Potato Bag", "Farm fresh",
        new Double(2.25),
       new Integer(4000), new Integer(10)},
      {"0006", "Eggs Bag", "Farm fresh", new Double(2.20),
       new Integer(4000), new Integer(10)},
    };

    protected final String[] colNames = {
      "Item No.", "Name", "Quality", "Unit Price ($)",
      "Stock Level (lb)", "Quantity (lb)"
    };
    public String getColumnName(int col) {
      return colNames[col].toString();
    }
    public Class getColumnClass(int col) {
      switch (col) {
        case 0:
          return String.class;
        case 1:
          return String.class;
        case 2:
          return String.class;
        case 3:
          return Integer.class;
        case 4:
          return Integer.class;
        case 5:
          return Double.class;
      }
      return null;
    }
    public int getRowCount() {
      return dataSource.length;
    }
    public int getColumnCount() {
      return colNames.length;
    }
    public Object getValueAt(int row, int col) {
      return dataSource[row][col];
    }
    public boolean isCellEditable(int row, int col) {
      return false;
    }
    public void setValueAt(
         Object value, int row, int col) {
      dataSource[row][col] = value;
      fireTableCellUpdated(row, col);
    }
  }

	public static void main(String[] args) {
		if (args != null && args.length >= 1) {
			com.activetree.common.SmartJPrint.setLicenseKey(args[0]);
		}
		else {
			System.out.println("Usage: java " + JPrintRightAlignedTableCellDemo.class.getName() + " licenseKey");
			System.exit(0);
		}

		PrintFrame demo = new JPrintRightAlignedTableCellDemo();
		demo.postInit();
		demo.setVisible(true);
	}
}

