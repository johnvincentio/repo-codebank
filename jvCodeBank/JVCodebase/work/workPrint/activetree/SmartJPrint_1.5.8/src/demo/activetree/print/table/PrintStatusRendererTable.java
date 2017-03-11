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
 * Part of this example source and icons are taken from the J2SE demo swing set
 * examples and is copyright protected by:
 * Copyright (c) 2003 Sun Microsystems, Inc. All  Rights Reserved.
 *
 * This example program is redistributable provided it carries the above
 * copy right and warning information.
 *
 */
package demo.activetree.print.table;

import demo.activetree.print.PrintFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.io.OutputStream;

import com.activetree.print.*;
import com.activetree.common.SmartJPrint;

public class PrintStatusRendererTable extends PrintFrame {
	private JTable table = null;
	protected MyTableCellBorderRenderer borderRenderer = new MyTableCellBorderRenderer();
	protected MyPageHeaderFooterListener pageHeaderFooterListener = new MyPageHeaderFooterListener();

	public PrintStatusRendererTable() {
		super();
		frame.setTitle("Print/PDF JTable using PrintableCell Interface");
		table = getTable();
		setPrintableComponent(table);
	}

	public JTable getJTable() {
		return table;
	}

	public void actionPerformed(ActionEvent evt) {
		tablePrinter.setPageHeaderFooterListener(pageHeaderFooterListener);
    tablePrinter.setCellBorderRenderer(borderRenderer);
		if (evt.getActionCommand().equals("Print")) {
			tablePrinter.print(table, PageNoPainter.PAGE_NONE, false, false, getMyPageFormat(), null);
		}else if (evt.getActionCommand().equals("Generate PDF")) {
			pdfPrinter.setPageNumberLocation(PageNoPainter.PAGE_NONE);
		  pdfPrinter.setPageHeaderFooterListener(pageHeaderFooterListener);
      pdfPrinter.setTableCellBorderRenderer(borderRenderer);
      OutputStream outputStream = AtPrintUtil.getOutputStream(table, "pdf", "PDF Files");
      if (outputStream == null) {
        return;
      }
      try {
        pdfPrinter.print(table, outputStream, PageNoPainter.PAGE_NONE,
                         getMyPageFormat(), null, false, false, true, true, true);
      }catch(Throwable ex) {
        ex.printStackTrace();
      }
      System.out.println("PDF document is produced for viewing.");
		}else if (evt.getActionCommand().equals("Preview")) {
			tablePrinter.preview(table, PageNoPainter.PAGE_NONE, false, getMyPageFormat(), frame);
		}
	}

	JTable getTable() {
		String[] cols = {" Application ", " DB Connection  ", " Web Services "," RMI Registry ", " Performance "};
		Object[][] data = new Object[50][cols.length];

		//Create same data for the table.
		String applName = "Application ";
		String dbConnection = "Connection ";
		String rmiStatus = "RMI Status ";
		for (int row=0; row < data.length; row++) {
			data[row][0] = applName + row;
			data[row][1] = dbConnection + row;
			data[row][2] = new Integer(getColorCode());
			data[row][3] = rmiStatus + row;
			data[row][4] = new Integer(getColorCode());
		}

		DefaultTableModel tableModel = new DefaultTableModel(data, cols) {
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return false;
			}
		};
		JTable table = new JTable(tableModel);
		table.getColumnModel().getColumn(0).setCellRenderer(new StatusRenderer());
		table.getColumnModel().getColumn(2).setCellRenderer(new StatusRenderer());
		table.getColumnModel().getColumn(4).setCellRenderer(new StatusRenderer());
		return table;
	}

	public int getColorCode() {
		int colorCode = 0;
		double randNo = Math.random();
		if (randNo >= 0 && randNo <= 0.25) {
			colorCode = 0;
		}else if (randNo > 0.25 && randNo <= 0.50) {
			colorCode = 1;
		}else if (randNo > 0.50 && randNo <= 0.75) {
			colorCode = 2;
		}else {
			colorCode = 3;
		}
		return colorCode;
	}

	/**
	 * We need this custom page format in order to have a bigger header and footer area.
	 * Therefore, we have reduced the imageable area and increased the imageable Y value.
	 */
	public PageFormat getMyPageFormat() {
		PageFormat pf = new PageFormat();
		Paper paper = pf.getPaper();
		double currX = paper.getImageableX();
		double currY = paper.getImageableY();
		double currImgW = paper.getImageableWidth();
		double currImgH = paper.getImageableHeight();
		double DELTA = 50;
		double newY = currY + DELTA;
		double newImgH = currImgH - (2 * DELTA);
		Paper customPaper = new Paper();
		customPaper.setImageableArea(currX, newY, currImgW, newImgH);
    pf.setPaper(customPaper);
		pf.setOrientation(PageFormat.PORTRAIT);
		AtPrintUtil.debugPageFormat(pf);

		return pf;
	}

	public static void main(String[] args) {
		if (args != null && args.length >= 1) {
			SmartJPrint.setLicenseKey(args[0]);
		}	else {
			System.out.println("Usage: java " + PrintStatusRendererTable.class.getName() + " licenseKey");
			System.exit(0);
		}
		PrintFrame demo = new PrintStatusRendererTable();
		demo.postInit();
		demo.setVisible(true);
	}
}

/////////////////Support classes///////////////////////////////////////////////
class StatusRenderer extends DefaultTableCellRenderer  implements ListCellRenderer, PrintableCell {
	private static int MARGIN = 2;
	private static int CELL_WIDTH = 70;
	private static int CELL_HEIGHT = 16;
	String[] statusNames = {"Normal", "Minor Warning", "Major Warning", "Critical", "Overall"};
	Color[] statusColors = {new Color(255, 255, 255), new Color(255, 255, 0),
	                        new Color(255, 204, 204), new Color(255, 0, 51),
													new Color(102, 204, 0)};
	Font customFont = new Font("Helvetica", Font.PLAIN, 12);

	public StatusRenderer() {
		super();
		FontMetrics fm = getFontMetrics(customFont);
		CELL_WIDTH = fm.stringWidth("Application XX") + (2 * MARGIN);
		CELL_HEIGHT = fm.getHeight(); // + (2 * MARGIN);
	}

	public Color[] getStatusColors() {
		return this.statusColors;
	}

	public String[] getStatusNames() {
		return this.statusNames;
	}

	private static int intValue = Integer.MAX_VALUE;
	public Component getTableCellRendererComponent(JTable table,
	                                               Object value,
	                                               boolean selected,
	                                               boolean hasFocus,
	                                               int row, int column) {
		//value for the cell
		super.setFont(customFont);
		if (value instanceof Integer) {
			setText(String.valueOf(intValue--));
			setHorizontalAlignment(JLabel.TRAILING);
		} else {
			setText((String)value);
			setHorizontalAlignment(JLabel.LEADING);
		}

		//selection
		if (selected) {
			setForeground(table.getSelectionForeground());
			setBackground(table.getSelectionBackground());
		} else {
			setForeground(table.getForeground());
			if (value instanceof Integer) {
				Integer intCellValue = (Integer) value;
				int colorIndex = intCellValue.intValue();
				setBackground(statusColors[colorIndex]);
			}else {
				if (column == 0) {
					//if rest of the columns are status "white", then this is green
					int col_status = ((Integer)table.getValueAt(row, column+2)).intValue();
					if (col_status == 0) {
						setBackground(statusColors[4]);
					}else {
						setBackground(table.getBackground());
					}
				}else {
					setBackground(table.getBackground());
				}
			}
		}

		//focus
		if (hasFocus) {
			setBorder( UIManager.getBorder("Table.focusCellHighlightBorder") );
			if (table.isCellEditable(row, column)) {
				super.setForeground( UIManager.getColor("Table.focusCellForeground") );
				super.setBackground( UIManager.getColor("Table.focusCellBackground") );
			}
		} else {
			setBorder(noFocusBorder);
		}

		return this;
	}


	public Component getListCellRendererComponent(JList
	  list, Object
	  value, int index, boolean isSelected, boolean cellHasFocus) {
		Component comp = this.getTableCellRendererComponent(null, value,
		                                                    false, false, 0, 0);
		if (isSelected) {
			if (index == 0)
				comp.setBackground(UIManager.getColor("ComboBox.selectionBackground"));
			else
				comp.setBackground(comp.getBackground().darker());
		}
		return comp;
	}

	/**
	 * Return null from this interface method so that the Smart JPrint will call
	 * the draw() method next for you to render the cell as you wish.
	 * @return
	 */
	public AtElement getContent() {
//		System.out.println("getContent: "+this.getText());
//    AtStringElement elm = new AtStringElement(this.getText(),
//		this.getFont(), this.getForeground(),
//		this.getBackground(), false);
		return null;
	}


	public int getCellWidth() {
		return CELL_WIDTH;
	}

	public int getCellHeight() {
		return CELL_HEIGHT;
	}

	public void draw(java.awt.Graphics graphics,
	                 javax.swing.JTable table,
	                 java.lang.Object cellValue,
	                 int row,
	                 int col,
	                 boolean isHeaderCell,
	                 java.awt.Rectangle cellBbox,
	                 double zoom) {
		Graphics2D g = (Graphics2D)graphics;
		Color orgColor = g.getColor();
		Font orgFont = g.getFont();

		TableCellRenderer r = table.getCellRenderer(row, col);
		Component compAtCell = null;
		if (r != null) {
			compAtCell = r.getTableCellRendererComponent(table, cellValue, false, false, row, col);
		}

		Color cellBg = SystemColor.white;
		Color cellFg = SystemColor.black;
		Font cellFont = getFont();
		if (compAtCell != null) {
			cellBg = compAtCell.getBackground();
			cellFg = compAtCell.getForeground();
			if (compAtCell.getFont() != null) {
				cellFont = compAtCell.getFont();
			}
		}
		Font zoomedFont = AtPrintUtil.getFont(cellFont, zoom);
		FontMetrics cellFm = getFontMetrics(zoomedFont);

		//text?  //because it is a JLabel renderer, let us do this.
		String text = ((JLabel)compAtCell).getText();

		//draw the content
		g.setFont(zoomedFont);
		g.setColor(cellBg);
		Rectangle refinedCellBbox = new Rectangle(cellBbox.x+1, cellBbox.y+1, cellBbox.width-1, cellBbox.height-1);
		g.fill(refinedCellBbox);  //background
		g.setColor(cellFg);

		int y = cellBbox.y + ((cellBbox.height/4)*3);
		int x = cellBbox.x + MARGIN;        //left aligned
		int strWidth = cellFm.stringWidth(text);
		if (cellValue instanceof Number) {  //right aligned
			x = (cellBbox.x + cellBbox.width) - strWidth - MARGIN;
		}
		g.drawString(text, x, y);

		g.setColor(orgColor);
		g.setFont(orgFont);
	}
}

class MyTableCellBorderRenderer implements AtBorderRenderer {
	public void drawBorder(JTable table, Object cellValue, int row, int col,
	                       boolean isHeaderCell, Graphics g, Rectangle bbox) {
		Graphics2D g2d = (Graphics2D)g;
		if (!isHeaderCell) {
			g2d.setColor(table.getGridColor());
			g2d.draw(bbox);
		}	else {
			if (col == table.getColumnCount()-1) {
				g2d.setColor(table.getGridColor());
				g2d.drawRect(bbox.x, bbox.y, bbox.width, bbox.height-1);
				g2d.setColor(table.getGridColor().darker().darker());
				g2d.drawRect(bbox.x+1, bbox.y, bbox.width-1, bbox.height-2);
			}else {
				if (col == 0) {
					g2d.setColor(table.getGridColor());
					g2d.drawRect(bbox.x, bbox.y, bbox.width-1, bbox.height-1);
					g2d.setColor(table.getGridColor().darker().darker());
					g2d.drawRect(bbox.x, bbox.y, bbox.width-2, bbox.height-2);
				}else {
					g2d.setColor(table.getGridColor());
					g2d.drawRect(bbox.x, bbox.y, bbox.width-1, bbox.height-1);
					g2d.setColor(table.getGridColor().darker().darker());
					g2d.drawRect(bbox.x+1, bbox.y, bbox.width-3, bbox.height-2);
				}
			}
		}
	}
}

class MyPageHeaderFooterListener implements PageHeaderFooterListener {
	int pageCount = 0;
	public void setPageHeaderAndFooter(PageHeaderFooterRenderer r) {
//				//System.out.println("setPageHeaderAndFooter()...totalPages=" + r.getTotalPageCount());
//				AtHeaderFooterElement header
//				  = new AtHeaderFooterElement(null,
//				                              new Font("Times New Roman", Font.BOLD, 20),
//				                              Color.decode("#333366"),
//				                              SystemColor.white,
//				                              false,
//				                              AtHeaderFooterElement.LEFT);
//				AtHeaderFooterElement footer
//				  = new AtHeaderFooterElement("Page " + r.getPageNumber() +"/" + r.getTotalPageCount(),
//				                              new Font("Arial", Font.PLAIN, 10),
//				                              Color.decode("#000033"),
//				                              SystemColor.white,
//				                              false,
//				                              AtHeaderFooterElement.CENTER);
//				if (r.getPageNumber() == 1) {
//					header.setStr("Employee Information - Manufacturing Division");
//				}
//				r.setHeader(header);
//				r.setFooter(footer);
	}

	String header = "Application Monitoring - Network Element Status";
	Font headerFont = new Font("Times New Roman", Font.BOLD, 20);
	Color headerColor = AtPrintConstants.GENERAL_HEADER_FG1;
	Font footerFont = new Font("Arial", Font.PLAIN, 12);
	Color footerColor = Color.decode("#000033");
	public void drawHeader(Graphics g, Rectangle headerBbox, int pageNumber, int totalPageCount,
	                       int pageNumberLocation, PageFormat pf, double zoom) {
		Font zoomedFont = AtPrintUtil.getFont(headerFont, zoom);
		FontMetrics fm = AtPrintUtil.getFontMetrics(zoomedFont);
		int hx = (int) pf.getImageableX();
		int hy = headerBbox.y + headerBbox.height - (fm.getHeight()/4);
		g.setColor(headerColor);
		g.setFont(zoomedFont);
		g.drawString(header, hx, hy);

		String message = "(This is header area for writing custom header in this area)";
		int msgx = (int) headerBbox.getCenterX() - (fm.stringWidth(message)/2);
		g.drawString(message, msgx, hy - fm.getHeight());
		((Graphics2D)g).draw(headerBbox);
	}

	public void drawFooter(Graphics g, Rectangle footerBbox, int pageNumber, int totalPageCount,
	                       int pageNumberLocation, PageFormat pf, double zoom) {
		Font zoomedFont = AtPrintUtil.getFont(footerFont, zoom);
		String footer = "(Page " + pageNumber + " of " + totalPageCount +")";
		FontMetrics fm = AtPrintUtil.getFontMetrics(zoomedFont);

		//draw color renderers first and then the footer page number text next.
		StatusRenderer status = new StatusRenderer();
		String[] statusNames = status.getStatusNames();
		Color[] statusColors = status.getStatusColors();
		int colorboxWidth = 10;
		int colorboxHeight = 10;
		int x = (int) pf.getImageableX();
		int labely = footerBbox.y + fm.getHeight();
		int icony = labely - colorboxHeight;
		for (int i=0; i < statusNames.length; i++) {
			Color color = statusColors[i];
			String label = statusNames[i];
			//draw icon
			g.setColor(color);
			g.fillRect(x, icony, colorboxWidth, colorboxHeight);
			g.setColor(footerColor);
			g.drawRect(x, icony, colorboxWidth, colorboxHeight);

			//draw label
			x += colorboxWidth;
			x += 5; //gap
			g.setFont(zoomedFont);
			g.drawString(label, x, labely);

			x += fm.stringWidth(label);
			x += 20; // gap between two renderers.
		}

		int fx = (int) (pf.getWidth() - fm.stringWidth(footer))/2;
		int fy = labely + fm.getHeight();
		g.setColor(footerColor);
		g.setFont(zoomedFont);
		g.drawString(footer, fx, fy);

		//
		String message = "(This is footer area for writing custom footer in this area)";
		int msgx = (int) footerBbox.getCenterX() - (fm.stringWidth(message)/2);
		g.drawString(message, msgx, fy + fm.getHeight());
		((Graphics2D)g).draw(footerBbox);
	}
}