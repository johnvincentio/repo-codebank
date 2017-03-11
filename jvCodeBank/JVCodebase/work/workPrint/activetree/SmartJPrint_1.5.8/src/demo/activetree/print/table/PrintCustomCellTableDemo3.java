/**
 * Source: PrintCustomCellTableDemo3.java
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

import com.activetree.print.*;
import com.activetree.resource.AtConstants;
import com.activetree.utils.AtComponentUtil;
import com.activetree.common.SmartJPrint;

import javax.swing.table.TableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.image.BufferedImage;

import demo.activetree.print.PrintFrame;

public class PrintCustomCellTableDemo3 extends PrintFrame {
	public static final BufferedImage EMPTY_IMAGE_CELL
	  = new BufferedImage(85, 60, BufferedImage.TYPE_INT_RGB);

	private JTable table = null;

	public PrintCustomCellTableDemo3() {
		super();
		frame.setTitle("SmartJPrint - Printing JTable");
		table = getTable();
		table.setDefaultRenderer(Cityname.class, new CitynameCellRenderer());
		table.setDefaultRenderer(Temperature.class, new TemperatureCellRenderer());
		table.setDefaultRenderer(Rainfall.class, new RainfallCellRenderer());
		table.setDefaultRenderer(Windflow.class, new WindflowCellRenderer());
		table.setDefaultRenderer(Forecast.class, new ForecastCellRenderer());
		table.setRowHeight(EMPTY_IMAGE_CELL.getHeight());
		setPrintableComponent(table);
		frame.setSize(700, 400);
	}

	public JTable getJTable() {
		return this.table;
	}

	public void actionPerformed(ActionEvent evt) {
		if (evt.getActionCommand().equals("Print")) {
			tablePrinter.print(table, PageNoPainter.PAGE_NONE);
		}else if (evt.getActionCommand().equals("Generate PDF")) {
			pdfPrinter.setPageNumberLocation(PageNoPainter.PAGE_NONE);
			super.printAsPdf(table, pdfPrinter);
		}else if (evt.getActionCommand().equals("Preview")) {
			tablePrinter.preview(table, PageNoPainter.PAGE_NONE, true, frame);
		}
	}

	private JTable getTable() {
		String[] cols = {"City", "Temperature", "Rainfall", "Windflow", "Forecast"};
		String[] cities = {"San Jose", "Fremont", "SFO", "Mt. View", "Oakland",
		                   "Milpitas", "Loveland", "Ft Collins", "Denver", "Cupertino", "Hayward",
		                   "S Ramon", "Livermoor", "New York", "N Jersy", "Boston", "L Angeles",
		                   "Fairfield", "Union City", "Sunnyvale", "Palo Alto"};
		String[][] temperatures = { {"78", "75"}, {"70", "67"}, {"70", "69"}, {"78", "73"},
		                            {"56", "50"}, {"80", "70"}, {"54", "52"}, {"60", "57"}, {"65", "60"}, {"65", "60"},
		                            {"56", "50"}, {"67", "65"}, {"75", "70"}, {"78", "76"}, {"65", "64"}, {"76", "74"},
		                            {"67", "65"}, {"76", "67"}, {"67", "65"}, {"56", "53"}, {"67", "65"}};
		String[][] rainfalls = { {"05 mm", "10 mm"}, {"23 mm", "24 mm"}, {"34 mm", "24 mm"},
		                         {"12 mm", "20 mm"}, {"11 mm", "15 mm"}, {"34 mm", "56 mm"},
		                         {"23 mm", "34 mm"}, {"12 mm", "13 mm"}, {"34 mm", "56 mm"}, {"12 mm", "23 mm"},
		                         {"34 mm", "27 mm"}, {"32 mm", "23 mm"}, {"45 mm", "50 mm"},
		                         {"26 mm", "34 mm"}, {"14 mm", "13 mm"}, {"47 mm", "56 mm"}, {"23 mm", "23 mm"},
		                         {"34 mm", "23 mm"}, {"29 mm", "23 mm"}, {"43 mm", "50 mm"}, {"23 mm", "24 mm"}};
		String[] windflows = {"20", "45", "56", "24", "67", "13", "67", "34", "57",
		                      "56", "78", "23", "56", "25", "56", "67", "25", "46", "25", "43", "18"};
		String[][] forecasts = {{"65", "10 mm"}, {"55", "13 mm"}, {"56", "20 mm"},
		                        {"78", "13 mm"}, {"56", "34 mm"},
		                        {"78", "23 mm"}, {"73", "19 mm"}, {"80", "33 mm"},
		                        {"49", "40 mm"}, {"76", "27 mm"},
		                        {"56", "24 mm"}, {"67", "45 mm"}, {"73", "27 mm"},
		                        {"78", "35 mm"}, {"80", "57 mm"},
		                        {"57", "56 mm"}, {"78", "56 mm"}, {"84", "25 mm"},
		                        {"57", "56 mm"}, {"73", "25 mm"}, {"73", "36 mm"}};

		Object[][] data = new Object[21][cols.length];

		for (int i=0; i< data.length; i++) {
			data[i][0] = new Cityname(cities[i]);
			data[i][1] = new Temperature(temperatures[i][0], temperatures[i][1]);
			data[i][2] = new Rainfall(rainfalls[i][0], rainfalls[i][1]);
			data[i][3] = new Windflow(windflows[i]);
			data[i][4] = new Forecast(forecasts[i][0], forecasts[i][1]);
		}

		DefaultTableModel tableModel = new DefaultTableModel(data, cols) {
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return false;
			}

			public Class getColumnClass(int colIndex) {
				if (colIndex == 0) {
					return Cityname.class;
				}else if (colIndex == 1) {
					return Temperature.class;
				}else if (colIndex == 2) {
					return Rainfall.class;
				}else if (colIndex == 3) {
					return Windflow.class;
				}else if (colIndex == 4) {
					return Forecast.class;
				}
				return String.class;
			}
		};
		JTable table = new JTable(tableModel);
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.getColumnModel().getColumn(0).setPreferredWidth(EMPTY_IMAGE_CELL.getWidth());
		tableHeader.getColumnModel().getColumn(1).setPreferredWidth(EMPTY_IMAGE_CELL.getWidth());
		tableHeader.getColumnModel().getColumn(2).setPreferredWidth(EMPTY_IMAGE_CELL.getWidth());
		tableHeader.getColumnModel().getColumn(3).setPreferredWidth(EMPTY_IMAGE_CELL.getWidth());
		tableHeader.getColumnModel().getColumn(4).setPreferredWidth(EMPTY_IMAGE_CELL.getWidth());
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableHeader.setResizingAllowed(false);
		return table;
	}

	public static void main(String[] args) {
		if (args != null && args.length >= 1) {
			SmartJPrint.setLicenseKey(args[0]);
		}
		else {
			System.out.println("Usage: java " + PrintCustomCellTableDemo3.class.getName() + " licenseKey");
			System.exit(0);
		}

		PrintFrame demo = new PrintCustomCellTableDemo3();
		demo.postInit();
		demo.setVisible(true);
	}

}

class Cityname {
	public String city;
	public Cityname(String city) {
		this.city = city;
	}
}

class Temperature {
	public String max;
	public String avg;
	public Temperature(String max, String avg) {
		this.max = max;
		this.avg = avg;
	}
}

class Rainfall {
	public String rainfall;
	public String average;
	public Rainfall(String rainfall, String average) {
		this.rainfall = rainfall;
		this.average = average;
	}
}

class Windflow {
	public String windflow;
	public Windflow(String windflow) {
		this.windflow = windflow;
	}
}

class Forecast {
	public String temperature;
	public String rainfall;
	public Forecast(String temperature, String rainfall) {
		this.temperature = temperature;
		this.rainfall = rainfall;
	}
}

abstract class BaseCellRenderer extends JPanel
     implements TableCellRenderer, PrintableCell {
	ImageIcon TEMPERATURE_ICON = new ImageIcon(getClass().getResource("/demo/activetree/image/redmeter.gif"));
	ImageIcon RAINFALL_ICON = new ImageIcon(getClass().getResource("/demo/activetree/image/yellowmeter.gif"));
	ImageIcon SNOWFALL_ICON = new ImageIcon(getClass().getResource("/demo/activetree/image/greenmeter.gif"));
	ImageIcon FORECAST_ICON = new ImageIcon(getClass().getResource("/demo/activetree/image/chart.gif"));
	Color CELL_BG_COLOR = new Color(204, 204, 255, 100);
	Color CELL_FG_COLOR = Color.decode("#000033"); //SystemColor.blue.darker().darker();
	Font CELL_TEXT_FONT = new Font("Arial", Font.PLAIN, 10);
	Dimension prefSize = new Dimension(PrintCustomCellTableDemo3.EMPTY_IMAGE_CELL.getWidth(),
	                                   PrintCustomCellTableDemo3.EMPTY_IMAGE_CELL.getHeight());
	boolean selected;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

	public abstract void draw(Graphics g);

	public void drawBasic(Graphics g) {
		AtComponentUtil.applyAntiAlias(g);
		g.setColor(getBgColor());
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setFont(CELL_TEXT_FONT);
//		g.setColor(SystemColor.control);
//		g.fillRect(0, 0, getWidth(), getHeight());
//		g.setColor(getBgColor());
//		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(CELL_FG_COLOR);
	}

	public Dimension getPreferredSize() {
		return prefSize;
	}

	public Color getBgColor() {
		if (selected) {
			return AtConstants.SELECTION_BACKGROUND;
		}else{
			return SystemColor.white;
		}
	}

	public int getCellWidth() {
		return PrintCustomCellTableDemo3.EMPTY_IMAGE_CELL.getWidth();
	}

	public int getCellHeight() {
		return PrintCustomCellTableDemo3.EMPTY_IMAGE_CELL.getHeight();
	}

	public AtElement getContent() {
		return null;
	}
}

class CitynameCellRenderer extends BaseCellRenderer {
	Cityname cityname;
	Font font = new Font("Times New Roman", Font.BOLD, 16);
	public Component getTableCellRendererComponent(JTable table,
	                                               Object value,
	                                               boolean isSelected,
	                                               boolean hasFocus,
	                                               int row, int column) {
		cityname = (Cityname) value;
		selected = isSelected;
		repaint();
		return this;
	}

	public void draw(Graphics g) {
		drawBasic(g);
		g.setColor(SystemColor.blue.darker().darker());
		FontMetrics fm = getFontMetrics(font);
		g.setFont(font);
		int y = (getHeight()/2) + (fm.getHeight()/4);
		g.drawString(cityname.city, 5, y);
	}

	public void draw(Graphics graphics, JTable table, Object cellValue,
	                 int row, int col, boolean isHeaderCell,
	                 Rectangle cellBbox, double zoom) {
		Graphics2D g = (Graphics2D)graphics;
		Font orgFont = g.getFont();
		Color orgColor = g.getColor();

		g.setColor(getBgColor());
		g.fill(cellBbox);

		g.setColor(SystemColor.blue.darker().darker());

		Font zoomedFont = AtPrintUtil.getFont(font, zoom);
		FontMetrics fm = getFontMetrics(zoomedFont);

		g.setFont(zoomedFont);
		int y = cellBbox.y + (cellBbox.height/2) + (fm.getHeight()/4);
		g.drawString(cityname.city, cellBbox.x + 5, y);

		g.setFont(orgFont);
		g.setColor(orgColor);
	}
}

class TemperatureCellRenderer extends BaseCellRenderer {
	Temperature temperature;
	public Component getTableCellRendererComponent(JTable table,
	                                               Object value,
	                                               boolean isSelected,
	                                               boolean hasFocus,
	                                               int row, int column) {
		temperature = (Temperature) value;
		selected = isSelected;
		repaint();
		return this;
	}

	public void draw(Graphics g) {
		drawBasic(g);
		int x = (getWidth() - TEMPERATURE_ICON.getIconWidth())/2;
		int y = (getHeight() - TEMPERATURE_ICON.getIconHeight())/2;
		g.drawImage(TEMPERATURE_ICON.getImage(), x, y, this);

		FontMetrics fm = getFontMetrics(CELL_TEXT_FONT);
		int sy = y - (fm.getHeight()/2);
		g.drawString("avg: " + temperature.avg, x, sy);

		sy = y + TEMPERATURE_ICON.getIconHeight() + fm.getHeight();
		g.drawString("max: " + temperature.max, x, sy);
	}

	public void draw(Graphics graphics, JTable table, Object cellValue,
	                 int row, int col, boolean isHeaderCell,
	                 Rectangle cellBbox, double zoom) {
		Graphics2D g = (Graphics2D)graphics;
		Font orgFont = g.getFont();
		Color orgColor = g.getColor();

		g.setColor(getBgColor());
		g.fill(cellBbox);

		Font zoomedFont = AtPrintUtil.getFont(CELL_TEXT_FONT, zoom);
		FontMetrics fm = getFontMetrics(zoomedFont);

		int x = cellBbox.x + (cellBbox.width - TEMPERATURE_ICON.getIconWidth())/2;
		int y = cellBbox.y + (cellBbox.height - TEMPERATURE_ICON.getIconHeight())/2;
		//todo - need to also resize the image using zoom
		g.drawImage(TEMPERATURE_ICON.getImage(), x, y, this);

		g.setFont(zoomedFont);
		g.setColor(SystemColor.blue.darker().darker());
		int sy = y - (fm.getHeight()/2);
		g.drawString("avg: " + temperature.avg, x, sy);

		sy = y + TEMPERATURE_ICON.getIconHeight() + fm.getHeight();
		g.drawString("max: " + temperature.max, x, sy);

		g.setColor(orgColor);
		g.setFont(orgFont);
	}
}

class RainfallCellRenderer extends BaseCellRenderer {
	Rainfall rainfall;
	public Component getTableCellRendererComponent(JTable table,
	                                               Object value,
	                                               boolean isSelected,
	                                               boolean hasFocus,
	                                               int row, int column) {
		rainfall = (Rainfall) value;
		selected = isSelected;
		repaint();
		return this;
	}

	public void draw(Graphics g) {
		drawBasic(g);
		int x = (getWidth() - RAINFALL_ICON.getIconWidth())/2;
		int y = (getHeight() - RAINFALL_ICON.getIconHeight())/2;
		g.drawImage(RAINFALL_ICON.getImage(), x, y, this);

		FontMetrics fm = getFontMetrics(CELL_TEXT_FONT);
		int sy = y - (fm.getHeight()/2);
		g.drawString("avg: " + rainfall.average, x, sy);

		sy = y + RAINFALL_ICON.getIconHeight() + fm.getHeight();
		g.drawString("max: " + rainfall.rainfall, x, sy);
	}

	public void draw(Graphics graphics, JTable table, Object cellValue,
	                 int row, int col, boolean isHeaderCell,
	                 Rectangle cellBbox, double zoom) {
		Graphics2D g = (Graphics2D)graphics;
		Font orgFont = g.getFont();
		Color orgColor = g.getColor();

		g.setColor(getBgColor());
		g.fill(cellBbox);

		Font zoomedFont = AtPrintUtil.getFont(CELL_TEXT_FONT, zoom);
		FontMetrics fm = getFontMetrics(zoomedFont);

		int x = cellBbox.x + (cellBbox.width - RAINFALL_ICON.getIconWidth())/2;
		int y = cellBbox.y + (cellBbox.height - RAINFALL_ICON.getIconHeight())/2;
		//todo - need to also resize the image using zoom
		g.drawImage(RAINFALL_ICON.getImage(), x, y, this);

		g.setColor(CELL_FG_COLOR);
		g.setFont(zoomedFont);
		int sy = y - (fm.getHeight()/2);
		g.drawString("avg: " + rainfall.average, x, sy);

		sy = y + RAINFALL_ICON.getIconHeight() + fm.getHeight();
		g.drawString("max: " + rainfall.rainfall, x, sy);

		g.setFont(orgFont);
		g.setColor(orgColor);
	}
}

class WindflowCellRenderer extends BaseCellRenderer {
	Windflow windoflow;
	public Component getTableCellRendererComponent(JTable table,
	                                               Object value,
	                                               boolean isSelected,
	                                               boolean hasFocus,
	                                               int row, int column) {
		windoflow = (Windflow) value;
		selected = isSelected;
		repaint();
		return this;
	}

	public void draw(Graphics g) {
		drawBasic(g);
		int x = (getWidth() - SNOWFALL_ICON.getIconWidth())/2;
		int y = (getHeight() - SNOWFALL_ICON.getIconHeight())/2;
		g.drawImage(SNOWFALL_ICON.getImage(), x, y, this);

		FontMetrics fm = getFontMetrics(CELL_TEXT_FONT);
		int sy = y - (fm.getHeight()/2);
		g.drawString(windoflow.windflow + " miles/hr", x, sy);
	}

	public void draw(Graphics graphics, JTable table, Object cellValue,
	                 int row, int col, boolean isHeaderCell,
	                 Rectangle cellBbox, double zoom) {
		Graphics2D g = (Graphics2D)graphics;
		Font orgFont = g.getFont();
		Color orgColor = g.getColor();

		g.setColor(getBgColor());
		g.fill(cellBbox);

		int x = cellBbox.x + (cellBbox.width - SNOWFALL_ICON.getIconWidth())/2;
		int y = cellBbox.y + (cellBbox.height - SNOWFALL_ICON.getIconHeight())/2;
		//todo - need to also resize the image using zoom
		g.drawImage(SNOWFALL_ICON.getImage(), x, y, this);

		Font zoomedFont = AtPrintUtil.getFont(CELL_TEXT_FONT, zoom);
		FontMetrics fm = getFontMetrics(zoomedFont);

		g.setColor(CELL_FG_COLOR);
		g.setFont(zoomedFont);
		int sy = y - (fm.getHeight()/2);
		g.drawString(windoflow.windflow + " miles/hr", x, sy);

		g.setFont(orgFont);
		g.setColor(orgColor);
	}
}

class ForecastCellRenderer extends BaseCellRenderer {
	Forecast forecast;

	public Component getTableCellRendererComponent(JTable table,
	                                               Object value,
	                                               boolean isSelected,
	                                               boolean hasFocus,
	                                               int row, int column) {
		forecast = (Forecast) value;
		selected = isSelected;
		repaint(); //causes the paintComponent(g) to be called.
		return this;
	}

	public void draw(Graphics g) {
		drawBasic(g);
		int x = (getWidth() - FORECAST_ICON.getIconWidth())/2;
		int y = (getHeight() - FORECAST_ICON.getIconHeight())/2;
		g.drawImage(FORECAST_ICON.getImage(), x, y, this);

		FontMetrics fm = getFontMetrics(CELL_TEXT_FONT);
		int sy = y - (fm.getHeight()/4);
		g.drawString("temperature: " + forecast.temperature, 5, sy);

		sy = y + FORECAST_ICON.getIconHeight() + (fm.getHeight()/4)*3;
		g.drawString("rainfall: " + forecast.rainfall, 5, sy);
	}

	public void draw(Graphics graphics, JTable table, Object cellValue,
	                 int row, int col, boolean isHeaderCell,
	                 Rectangle cellBbox, double zoom) {
		Graphics2D g = (Graphics2D)graphics;
		Font orgFont = g.getFont();
		Color orgColor = g.getColor();

		g.setColor(getBgColor());
		g.fill(cellBbox);

		int x = cellBbox.x + (cellBbox.width - FORECAST_ICON.getIconWidth())/2;
		int y = cellBbox.y + (cellBbox.height - FORECAST_ICON.getIconHeight())/2;
		//todo - need to also resize the image using zoom
		g.drawImage(FORECAST_ICON.getImage(), x, y, this);

		Font zoomedFont = AtPrintUtil.getFont(CELL_TEXT_FONT, zoom);
		FontMetrics fm = getFontMetrics(zoomedFont);

		g.setColor(CELL_FG_COLOR);
		g.setFont(zoomedFont);
		int sy = y - (fm.getHeight()/4);
		g.drawString("temperature: " + forecast.temperature, cellBbox.x + 5, sy);

		sy = y + FORECAST_ICON.getIconHeight() + (fm.getHeight()/4)*3;
		g.drawString("rainfall: " + forecast.rainfall, cellBbox.x + 5, sy);

		g.setFont(orgFont);
		g.setColor(orgColor);
	}
}
