/**
 * Source: MultiSourceDemo2.java
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
package demo.activetree.print.multisource;

import demo.activetree.print.PrintFrame;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.Document;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.print.Pageable;
import java.awt.print.PageFormat;
import java.awt.event.ActionEvent;
import java.io.OutputStream;

import com.activetree.print.*;
import com.activetree.resource.AtImageList;
import com.activetree.common.SmartJPrint;

public class MultiSourceDemo2 extends PrintFrame {
	public static void main(String[] args) {
		if (args != null && args.length >= 1) {
			SmartJPrint.setLicenseKey(args[0]);
		}
		else {
			System.out.println("Usage: java " + MultiSourceDemo1.class.getName() + " licenseKey");
			System.exit(0);
		}

		MultiSourceDemo2 demo = new MultiSourceDemo2();
		demo.postInit();
		demo.setVisible(true);
	}

	private JTextPane textPane;
	//JTables
	String tableNames[] = {"Favorite Foods", "Employee Information"};
	JTable[] tables = new JTable[2];

	public MultiSourceDemo2() {
		frame.setTitle("Smart JPrint - Print/PDF from multiple sources");
		frame.setSize(700, 500);
		textPane = new JTextPane();
		initStyle(textPane);

		//add JTextArea
		insertText(textPane.getDocument(), "\n");
		textPane.setCaretPosition(textPane.getDocument().getLength());

		//init and add JTable 1 & 2.
		tables[0] = new IconTable().getTable();
    tables[1] = new StringTable().getTable();

		//add tables
		for (int i=0; i < tables.length; i++) {
			String tableName = tableNames[i];
			JTable table = tables[i];
			addTable(tableName, table);
		}

		//put into a scroll pane.
		JScrollPane scrollPane = new JScrollPane(textPane);
		setPrintableComponent(scrollPane);
		textPane.setEditable(false);
	}

	public void addTable(String tableName, JTable table) {
		textPane.setCaretPosition(textPane.getDocument().getLength());
		insertText(textPane.getDocument(), tableName + "\n");
		textPane.setCaretPosition(textPane.getDocument().getLength());
		table.getTableHeader().setBorder(BorderFactory.createLineBorder(SystemColor.control.darker(), 1));
		textPane.insertComponent(table.getTableHeader());
    insertText(textPane.getDocument(), "\n");
		textPane.setCaretPosition(textPane.getDocument().getLength());
		table.setBorder(BorderFactory.createLineBorder(AtPrintConstants.GENERAL_HEADER_FG1, 1));
		textPane.insertComponent(table);
		insertText(textPane.getDocument(), "\n\n");
		textPane.setCaretPosition(textPane.getDocument().getLength());
	}

	void initStyle(JTextPane textPane) {
		Style style = textPane.getLogicalStyle();
		StyleConstants.setFontFamily(style, "Arial");
		StyleConstants.setLeftIndent(style, 20);
		StyleConstants.setRightIndent(style, 20);
		StyleConstants.setFontSize(style, 12);
		StyleConstants.setBold(style, true);
		StyleConstants.setForeground(style, AtPrintConstants.GENERAL_HEADER_FG1);
		int start = textPane.getCaretPosition();
		int end = textPane.getDocument().getLength();
		textPane.select(start, end);
		textPane.setParagraphAttributes(style, true);
		textPane.setMaximumSize(new Dimension(700, 500));
	}

	private void insertText(Document doc, String string) {
		try {
			doc.insertString(doc.getLength(), string, null);
		}catch(Throwable t) {
			t.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent evt) {
		//Create Pageables first.
		AtBook book = new AtBook();
		Font headerFont = new Font("Arial", Font.BOLD, 14);

		//Add all JTables
		for (int i=0; i < tables.length; i++) {
			String tableName = tableNames[i];
			JTable table = tables[i];
			AtStringElement tableHeader = new AtStringElement(tableName, headerFont, AtPrintConstants.GENERAL_HEADER_FG1);
			tableHeader.setLineSpacing(5.0f);
			book.append(tableHeader);
			book.append(table, true, true, true);
			if (i < (tables.length-1)) {
				book.append("\n");
			}
		}

		if (evt.getActionCommand().equals("Print")) {
			AtGenericPrinter genericPrinter = new AtGenericPrinter();
			genericPrinter.print(book, PageNoPainter.LOWER_CENTER, true);
		}else if (evt.getActionCommand().equals("Generate PDF")) {
			OutputStream pdfStream = AtPrintUtil.getOutputStream(frame, "pdf", "PDF Files");
			if (pdfStream == null) {
				return;
			}
			AtGenericPrinter genericPrinter = new AtGenericPrinter();
      Pageable pages = genericPrinter.getPageable(book, PageNoPainter.LOWER_CENTER);
			AtAbstractPage page1 = (AtAbstractPage) pages.getPrintable(0);
			PageFormat pageFormat = page1.getPageFormat();
			AtPdfPrinter pdfPrinter = new AtPdfPrinter();
			try {
				pdfPrinter.printPageable(pdfStream, pages, pageFormat);
			}catch(Throwable t) {
				t.printStackTrace();
			}
		}else if (evt.getActionCommand().equals("Preview")) {
			AtGenericPrinter genericPrinter = new AtGenericPrinter();
			genericPrinter.preview(book, PageNoPainter.LOWER_CENTER, frame);
		}
	}
}

class StringTable {
	public JTable getTable() {
		String[] cols = {"Employee Name", "SS No.", "Date Of Birth",
		                 "Position", "Salary", "Home Phone", "Cell Phone"};
		String[][] data = new String[40][cols.length];

		//Create same data for the table.
		String name = "Employee Name - ";
		String ssn = "SS No - ";
		String dob = "Birth Date - ";
		String position = "Position - ";
		String annualSalary = "Employee Salary - ";
		String homePhone = "Home Phone - ";
		String cellPhone = "Cell Phone - ";
		for (int row=0; row < data.length; row++) {
			data[row][0] = name + row;
			data[row][1] = ssn + row;
			data[row][2] = dob + row;
			data[row][3] = position + row;
			data[row][4] = annualSalary + row;
			data[row][5] = homePhone + row;
			data[row][6] = cellPhone + row;
		}

		DefaultTableModel tableModel = new DefaultTableModel(data, cols);
		JTable table = new JTable(tableModel);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.getTableHeader().setFont(new Font("Arial", Font.PLAIN, 12));
		return table;
	}
}

class IconTable {
	public JTable getTable() {
    final int INITIAL_ROWHEIGHT = 33;
		// final
		final String[] names = {"No.", "First Name", "Last Name", "Favorite Food",
		                        "Hobby", "Favorite Color", "Favorite Country", "Phone"};

		ImageIcon asparagus    = createImageIcon("/demo/activetree/image/asparagus.jpg");
		ImageIcon broccoli     = createImageIcon("/demo/activetree/image/broccoli.jpg");
		ImageIcon grapes       = createImageIcon("/demo/activetree/image/grapes.jpg");
		ImageIcon kiwi         = createImageIcon("/demo/activetree/image/kiwi.jpg");
		ImageIcon peach        = createImageIcon("/demo/activetree/image/peach.jpg");
		ImageIcon pickle       = createImageIcon("/demo/activetree/image/pickle.jpg");
		ImageIcon raspberry    = createImageIcon("/demo/activetree/image/raspberry.jpg");
		ImageIcon strawberry   = createImageIcon("/demo/activetree/image/strawberry.jpg");
		ImageIcon watermelon   = createImageIcon("/demo/activetree/image/watermelon.jpg");

		NamedColor aqua        = new NamedColor(new Color(127, 255, 212), "Aqua");
		NamedColor beige       = new NamedColor(new Color(245, 245, 220), "Beige");
		NamedColor black       = new NamedColor(Color.black, "Black");
		NamedColor blue        = new NamedColor(new Color(0, 0, 222), "Light Blue");
		NamedColor eblue       = new NamedColor(Color.blue, "Blue");
		NamedColor jfcblue     = new NamedColor(new Color(204, 204, 255), "JFC Blue");
		NamedColor jfcblue2    = new NamedColor(new Color(153, 153, 204), "JFC Blue 2");
		NamedColor cybergreen  = new NamedColor(Color.green.darker().brighter(), "Cyber Green");
		NamedColor darkgreen   = new NamedColor(new Color(0, 100, 75), "Dark Green");
		NamedColor forestgreen = new NamedColor(Color.green.darker(), "Forest Green");
		NamedColor gray        = new NamedColor(Color.gray, "Gray");
		NamedColor green       = new NamedColor(Color.green, "Green");
		NamedColor orange      = new NamedColor(new Color(255, 165, 0), "Orange");
		NamedColor purple      = new NamedColor(new Color(160, 32, 240),  "Purple");
		NamedColor red         = new NamedColor(Color.red, "Red");
		NamedColor rustred     = new NamedColor(Color.red.darker(), "Rust Red");
		NamedColor sunpurple   = new NamedColor(new Color(100, 100, 255), "Sun Purple");
		NamedColor suspectpink = new NamedColor(new Color(255, 105, 180), "Suspect Pink");
		NamedColor turquoise   = new NamedColor(new Color(0, 255, 255), "Turquoise");
		NamedColor violet      = new NamedColor(new Color(238, 130, 238), "Violet");
		NamedColor yellow      = new NamedColor(Color.yellow, "Yellow");

		// Create the dummy data (a few rows of names)
		final Object[][] data = {
			{"1", "Mike",    "Albers",       strawberry,  "Basket Ball",  green,      "US",        "408-123-2345" },
			{"2", "Mark",    "Andrews",      grapes,      "Volley Ball",  blue,       "Canada",    "408-123-2345" },
			{"3", "Brian",   "Beck",         raspberry,   "Foot Ball",    black,      "China",     "510-123-2345" },
			{"4", "Lara",    "Bunni",        strawberry,  "Tennis",       red,        "Japan",     "408-123-2345" },
			{"5", "Reena",   "Nair",         strawberry,  "Chess",        purple,     "India",     "408-347-2345" },
			{"6", "Roger",   "Brinkley",     peach,       "Badminton",    blue,       "Australia", "408-123-2345" },
			{"7", "Brent",   "Christian",    broccoli,    "Cricket",      black,      "India",     "510-123-2345" },
			{"8", "Mark",    "Davidson",     asparagus,   "Chess",        darkgreen,  "Nepal",     "408-123-2345" },
			{"9", "Jeff",    "Dinkins",      kiwi,        "Table Tennis", blue,       "France",    "209-123-2345" },
			{"10","Ewan",    "Dinkins",      strawberry,  "Volley Ball",  yellow,     "US",        "456-123-2345" },
			{"11","Amy",     "Fowler",       raspberry,   "Foot Ball",    violet,     "UK",        "408-123-2345" },
			{"12","Hania",   "Gajewska",     raspberry,   "Foot Ball",    purple,     "Norway",    "123-123-2345" },
			{"13","David",   "Geary",        watermelon,  "Basket Ball",  blue,       "Egypt",     "678-123-2345" },
			{"14","Eric",    "Hawkes",       pickle,      "Cricket",      blue,       "India",     "245-123-2345" },
			{"15","Kathleen","Zelony",       grapes,      "Foot Ball",    gray,       "India",     "234-123-2345" }
		};

		// Create a model of the data.
		TableModel dataModel = new AbstractTableModel() {
			public int getColumnCount() { return names.length; }
			public int getRowCount() { return data.length;}
			public Object getValueAt(int row, int col) {
				return data[row][col];
			}
			public String getColumnName(int column) {
				return names[column];
			}
			public Class getColumnClass(int c) {
				return getValueAt(0, c).getClass();
			}
			public boolean isCellEditable(int row, int col) {return col ==5;}
			public void setValueAt(Object aValue, int row, int column) { data[row][column] = aValue; }
		};


		// Create the table
		final JTable tableView = new JTable(dataModel);

		// Show colors by rendering them in their own color.
		DefaultTableCellRenderer colorRenderer = new DefaultTableCellRenderer() {
			public void setValue(Object value) {
				if (value instanceof NamedColor) {
					NamedColor c = (NamedColor) value;
					setBackground(c);
					setForeground(c.getTextColor());
					setText(c.toString());
					setIcon(AtImageList.IMAGE_LIST.INSERT_ICON);
				} else {
					super.setValue(value);
				}
			}
		};

		// Create a combo box to show that you can use one in a table.
		JComboBox comboBox = new JComboBox();
		comboBox.addItem(aqua);
		comboBox.addItem(beige);
		comboBox.addItem(black);
		comboBox.addItem(blue);
		comboBox.addItem(eblue);
		comboBox.addItem(jfcblue);
		comboBox.addItem(jfcblue2);
		comboBox.addItem(cybergreen);
		comboBox.addItem(darkgreen);
		comboBox.addItem(forestgreen);
		comboBox.addItem(gray);
		comboBox.addItem(green);
		comboBox.addItem(orange);
		comboBox.addItem(purple);
		comboBox.addItem(red);
		comboBox.addItem(rustred);
		comboBox.addItem(sunpurple);
		comboBox.addItem(suspectpink);
		comboBox.addItem(turquoise);
		comboBox.addItem(violet);
		comboBox.addItem(yellow);

		TableColumn colorColumn = tableView.getColumnModel().getColumn(5);
		// Use the combo box as the editor in the "Favorite Color" column.
		colorColumn.setCellEditor(new DefaultCellEditor(comboBox));

		colorRenderer.setHorizontalAlignment(JLabel.CENTER);
		colorColumn.setCellRenderer(colorRenderer);

		tableView.setRowHeight(INITIAL_ROWHEIGHT);

		return tableView;
	}

	private ImageIcon createImageIcon(String iconFile) {
		ImageIcon icon = new ImageIcon(getClass().getResource(iconFile));
		return icon;
	}

	class NamedColor extends Color {
		String name;
		public NamedColor(Color color, String name) {
			super(color.getRGB());
			this.name = name;
		}

		public Color getTextColor() {
			int r = getRed();
			int g = getGreen();
			int b = getBlue();
			if(r > 240 || g > 240) {
				return Color.black;
			} else {
				return Color.white;
			}
		}

		public String toString() {
			return name;
		}
	}
}