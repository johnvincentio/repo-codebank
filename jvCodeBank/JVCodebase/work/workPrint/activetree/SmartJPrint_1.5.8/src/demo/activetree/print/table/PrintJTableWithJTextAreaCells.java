/**
 * Source: PrintJTableWithJTextAreaCells.java
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
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Pageable;
import java.awt.print.Printable;

import demo.activetree.print.PrintFrame;
import demo.activetree.print.DemoHeaderFooterRenderer;

public class PrintJTableWithJTextAreaCells extends PrintFrame {
	private JTable table = null;

	public PrintJTableWithJTextAreaCells() {
		super();
		frame.setTitle("Print/PDF JTable with JTextArea cells");
		table = getTable();
		setPrintableComponent(table);
	}

	public JTable getJTable() {
		return table;
	}

	public void actionPerformed(ActionEvent evt) {
		PageHeaderFooterListener l = new DemoHeaderFooterRenderer("Print/PDF JTable with JTextArea cells");
		tablePrinter.setPageHeaderFooterListener(l);
		if (evt.getActionCommand().equals("Print")) {
			tablePrinter.print(table, PageNoPainter.PAGE_NONE, false, false, getMyPageFormat(), null);
		}else if (evt.getActionCommand().equals("Generate PDF")) {
			pdfPrinter.setPageNumberLocation(PageNoPainter.PAGE_NONE);
			pdfPrinter.setPageHeaderFooterListener(l);
      pdfPrinter.setHeaderBold(true);
			printAsPdf(table, pdfPrinter);
		}else if (evt.getActionCommand().equals("Preview")) {
			tablePrinter.preview(table, PageNoPainter.PAGE_NONE, false, getMyPageFormat(), frame);
		}
	}

	JTable getTable() {
		String[] cols = {"EmpNo", "Employee Name", "SSN", "Description",
		                 "Home Phone", "Work Phone", "Street Address"};
		Object[][] data = new Object[11][cols.length];

		//Create same data for the table.
		int empNo = 1000;
		String description = "Description of the Individual is displayed in a " +
		  "JTextArea and printed using Smart JPrint PrintableCell Interface. Cell # ";
		String name = "Employee Name - ";
		String ssn = "SSN - ";
		String homePhone = "Home Phone - ";
		String workPhone = "His/Her Work Phone - 000";
		String stAddr = "His/Her Street Address - ";
		for (int row=0; row < data.length; row++) {
			data[row][0] = String.valueOf(empNo+row);
			data[row][1] = name + row;
			data[row][2] = ssn + row;
			data[row][3] = description + row;
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
		TextRenderer textRenderer = new TextRenderer();
		table.getColumnModel().getColumn(3).setCellRenderer(textRenderer);
		table.setRowHeight(20);
		return table;
	}

  //TODO - We are increasing the header and footer area by reducing the imageableY
  //and imageableHeight value of the page in the page format.
	public PageFormat getMyPageFormat() {
		PageFormat pf = new PageFormat();
		Paper paper = pf.getPaper();
		double currX = paper.getImageableX();
		double currY = paper.getImageableY();
		double currImgW = paper.getImageableWidth();
		double currImgH = paper.getImageableHeight();
		double DELTA = 25;
		double newY = currY + DELTA;
		double newImgH = currImgH - (2 * DELTA);
		Paper customPaper = new Paper();
		customPaper.setImageableArea(currX, newY, currImgW, newImgH);
    pf.setPaper(customPaper);
		pf.setOrientation(PageFormat.PORTRAIT);
		return pf;
	}

//	class TextRenderer extends JTextArea implements TableCellRenderer, PrintableCell {
//OR
	class TextRenderer extends JTextPane implements TableCellRenderer, PrintableCell {
	  boolean bold = false;
	  int cellWidth = 230;

	  public TextRenderer() {
	    super();
	    setEditable(false);
	  }

	  public void draw(java.awt.Graphics graphics, javax.swing.JTable table,
	                   java.lang.Object cellValue, int row, int col,
	                   boolean isHeaderCell, java.awt.Rectangle cellBbox,
	                   double zoom) {

	    TextRenderer compAtCell = (TextRenderer)getTableCellRendererComponent(table, cellValue, false, false, row, col);
		  int margin = 3;
		  //AtDocumentPrinter can help you printing at JTextComponent content
		  AtDocumentPrinter docPrinter = new AtDocumentPrinter();
		  PageFormat pf = new PageFormat();
		  Paper customPaper = new Paper();
		  customPaper.setImageableArea(cellBbox.x+margin, cellBbox.y,
		                               cellBbox.width-(2*margin), cellBbox.height);
		  pf.setPaper(customPaper);
		  docPrinter.setPageFormat(pf);
      docPrinter.setZoom(zoom*100);

		  //get pages
		  Pageable pages = docPrinter.getPageable(compAtCell, PageNoPainter.PAGE_NONE);
      if (pages.getNumberOfPages() > 1) {   //this means we got 2 pages, so compress further to make it 1 page.
        docPrinter.zoomOut();
        pages = docPrinter.getPageable(compAtCell, PageNoPainter.PAGE_NONE);
      }

      try {
        Printable page = pages.getPrintable(0);
        PageFormat aPf = pages.getPageFormat(0);
        page.print(graphics, aPf, 0);
      }catch(Throwable t) {
      }
	  }

	  public int getCellHeight() {
		  String text = super.getText();
		  int cellHeight = AtPrintUtil.getCellHeight(
		    getCellWidth(), text, getFont(), getFontMetrics(getFont()), tablePrinter.getZoom());
			return cellHeight;
	  }

	  public int getCellWidth() {
	    return cellWidth;
	  }

	  public AtElement getContent() {
	    return null;
	  }

	  public Component getTableCellRendererComponent(JTable table, Object value,
	                                                 boolean isSelected, boolean hasFocus,
	                                                 int row, int column) {
	    super.setText( (value == null) ? "" : value.toString());
		  setSize(getCellWidth(), getCellHeight());

	    super.setForeground(Color.BLACK);
	    super.setBackground(Color.WHITE);

	    if (isSelected) {
	      super.setBackground(Color.GRAY);
	    }
	    if (bold) {
	      Font font = this.getFont();
	      super.setFont(new Font(font.getFontName(), Font.BOLD, font.getSize()));
	    }

	    return this;
	  }
	}

	public static void main(String[] args) {
		if (args != null && args.length >= 1) {
			SmartJPrint.setLicenseKey(args[0]);
		}
		else {
			System.out.println("Usage: java " + PrintJTableWithJTextAreaCells.class.getName() + " licenseKey");
			System.exit(0);
		}
		PrintFrame demo = new PrintJTableWithJTextAreaCells();
		demo.postInit();
		demo.setVisible(true);
	}
}





