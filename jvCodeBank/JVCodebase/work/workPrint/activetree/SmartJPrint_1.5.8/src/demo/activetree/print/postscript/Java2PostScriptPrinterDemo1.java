/**
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
package demo.activetree.print.postscript;

import demo.activetree.print.PrintFrame;
import demo.activetree.print.DemoHeaderFooterRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.print.Pageable;
import java.io.InputStream;
import java.io.File;
import java.io.FileOutputStream;

import com.activetree.print.PageHeaderFooterListener;
import com.activetree.print.PageNoPainter;
import com.activetree.print.AtAbstractPage;
import com.activetree.print.postscript.AtJava2PostScriptPrinter;
import com.activetree.common.SmartJPrint;

public class Java2PostScriptPrinterDemo1 extends PrintFrame {
	private JTable table = null;

	public Java2PostScriptPrinterDemo1() {
		super();
		frame.setTitle("Smart JPrint - Print JTable");
		table = getTable();
		setPrintableComponent(table);
    //change the text for the print button
    print.setText("Generate PostScript");
    preview.setVisible(false);
    printPdf.setVisible(false);
	}

	public JTable getJTable() {
		return table;
	}

	public void actionPerformed(ActionEvent evt) {
		PageHeaderFooterListener l = new DemoHeaderFooterRenderer("Employee Information - Manufacturing Division");
		tablePrinter.setPageHeaderFooterListener(l);
		if (evt.getActionCommand().equals("Print")) {
			//tablePrinter.print(table, PageNoPainter.PAGE_NONE, false);
      Pageable allPages = tablePrinter.getPageable(table, PageNoPainter.LOWER_CENTER);
      AtAbstractPage[] pages = new AtAbstractPage[allPages.getNumberOfPages()];
      for (int i=0; i < allPages.getNumberOfPages(); i++) {
        AtAbstractPage aPage = (AtAbstractPage) allPages.getPrintable(i);
        pages[i] = aPage;
      }

      //Print to a file
      String psOutFile = "./smartjprint_2_postscript2.ps";
      try {
        FileOutputStream psOutStream = new FileOutputStream(psOutFile);
        AtJava2PostScriptPrinter psPrinter = new AtJava2PostScriptPrinter();
        psPrinter.saveAsPostScriptOutput(pages, psOutStream);
      }catch(Throwable t) {
        t.printStackTrace();
      }

      //todo:
      //OR Do this for either saving to a file or to send to a PS printer.

//      AtJava2PostScriptPrinter psPrinter = new AtJava2PostScriptPrinter();
//      InputStream psStream = null;
//      try {
//        psStream = psPrinter.getPostScriptOutput(pages);
//      }catch(Throwable t) {
//        t.printStackTrace();
//      }
//      //Save to a file OR send it to a PS printer such as HP LeserJet
//      //save as a file.
//      saveAsPostScript(psStream, "./smartjprint_2_postscript1.ps");
//      //print to a PS printer
//      //System.exec(...);
		}
	}

  public void saveAsPostScript(InputStream psStream, String fileName) {
      File psFile = new File(fileName);
      FileOutputStream out = null;
      try {
        out = new FileOutputStream(psFile);
        byte buf[] = new byte[5120];
        for (int bytesCount=0; (bytesCount = psStream.read(buf)) != -1; ) {
          out.write(buf, 0, bytesCount);
        }
        psStream.close();
        out.close();
      }catch(Throwable t) {
        t.printStackTrace();
      }
  }

  //////////////////////////////////////////////////////////////////////

	JTable getTable() {
		String[] cols = {"EmpNo", "Employee Name", "SSN", "Date Of Birth",
		                 "Home Phone", "Work Phone", "Street Address",
		                 "Apt/House No", "City", "State", "Zip Code"};
		Object[][] data = new Object[100][cols.length];

		//Create same data for the table.
		int empNo = 1000;
		String name = "Employee Name - ";
		String ssn = "SSN - ";
		String dob = "Date - ";
		String homePhone = "Home Phone - ";
		String workPhone = "Work Phone - 000";
		String stAddr = "Street Address - ";
		String houseNo = "Apt/House No # ";
		String city = "City Name - ";
		String state = "State Name - ";
		String zipcode = "Zip Code - ";
		for (int row=0; row < data.length; row++) {
			data[row][0] = String.valueOf(empNo+row);
			data[row][1] = name + row;
			data[row][2] = ssn + row;
			data[row][3] = dob + row;
			data[row][4] = homePhone + row;
			data[row][5] = workPhone + row;
			data[row][6] = stAddr + row;
			data[row][7] = houseNo + row;
			data[row][8] = city + row;
			data[row][9] = state + row;
			data[row][10] = zipcode + row;

			if (row == 2) {
				data[row][1] = null;
				data[row][2] = null;
				data[row][3] = null;
			}
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
			System.out.println("Usage: java " + Java2PostScriptPrinterDemo1.class.getName() + " licenseKey");
			System.exit(0);
		}
		PrintFrame demo = new Java2PostScriptPrinterDemo1();
		demo.postInit();
		demo.setVisible(true);
	}
}
