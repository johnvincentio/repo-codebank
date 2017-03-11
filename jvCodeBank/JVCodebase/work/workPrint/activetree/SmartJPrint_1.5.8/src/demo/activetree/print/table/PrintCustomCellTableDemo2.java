/**
 * Source: PrintCustomCellTableDemo2.java
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

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import com.activetree.print.PageNoPainter;
import com.activetree.resource.AtImageList;
import com.activetree.common.SmartJPrint;
import demo.activetree.print.PrintFrame;

public class PrintCustomCellTableDemo2 extends PrintFrame {
	private JTable table = null;

	public PrintCustomCellTableDemo2() {
		super();
		frame.setTitle("Smart JPrint - Printing complex JTable");
		table = getTable();
		table.setRowHeight(IMAGE.getIconHeight());
		setPrintableComponent(table);
	}

	public JTable getJTable() {
		return this.table;
	}

	public void actionPerformed(ActionEvent evt) {
		if (evt.getActionCommand().equals("Print")) {
			tablePrinter.print(table, PageNoPainter.LOWER_CENTER);
		}else if (evt.getActionCommand().equals("Generate PDF")) {
			super.printAsPdf(table, pdfPrinter);
			//table.updateUI();
		}else if (evt.getActionCommand().equals("Preview")) {
			tablePrinter.setFitToPageWidth(true);
			tablePrinter.preview(table, PageNoPainter.LOWER_CENTER, true, frame);
		}
	}

  ///////////////////////////////////////////table////////////////
	///////////////////////////////////////////////////////////////
  ImageIcon IMAGE = createImageIcon("/demo/activetree/image/apple.jpg");

	public JTable getTable() {
    final int INITIAL_ROWHEIGHT = 33;
		// final
		final String[] names = {"No.", "First Name", "Last Name", "Favorite Food",
		                        "Hobby", "Favorite Color", "Favorite Country", "Phone"};

		ImageIcon apple        = createImageIcon("/demo/activetree/image/apple.jpg");
		ImageIcon asparagus    = createImageIcon("/demo/activetree/image/asparagus.jpg");
		ImageIcon banana       = createImageIcon("/demo/activetree/image/banana.jpg");
		ImageIcon broccoli     = createImageIcon("/demo/activetree/image/broccoli.jpg");
		ImageIcon cantaloupe   = createImageIcon("/demo/activetree/image/cantaloupe.jpg");
		ImageIcon carrot       = createImageIcon("/demo/activetree/image/carrot.jpg");
		ImageIcon corn         = createImageIcon("/demo/activetree/image/corn.jpg");
		ImageIcon grapes       = createImageIcon("/demo/activetree/image/grapes.jpg");
		ImageIcon grapefruit   = createImageIcon("/demo/activetree/image/grapefruit.jpg");
		ImageIcon kiwi         = createImageIcon("/demo/activetree/image/kiwi.jpg");
		ImageIcon onion        = createImageIcon("/demo/activetree/image/onion.jpg");
		ImageIcon pear         = createImageIcon("/demo/activetree/image/pear.jpg");
		ImageIcon peach        = createImageIcon("/demo/activetree/image/peach.jpg");
		ImageIcon pepper       = createImageIcon("/demo/activetree/image/pepper.jpg");
		ImageIcon pickle       = createImageIcon("/demo/activetree/image/pickle.jpg");
		ImageIcon pineapple    = createImageIcon("/demo/activetree/image/pineapple.jpg");
		ImageIcon raspberry    = createImageIcon("/demo/activetree/image/raspberry.jpg");
		ImageIcon sparegrass   = createImageIcon("/demo/activetree/image/asparagus.jpg");
		ImageIcon strawberry   = createImageIcon("/demo/activetree/image/strawberry.jpg");
		ImageIcon tomato       = createImageIcon("/demo/activetree/image/tomato.jpg");
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
			{"15","Earl",    "Johnson",      carrot,      "Foot Ball",    green,      "China",     "408-123-2345" },
			{"16","Robi",    "Kahn",         apple,       "Cricket",      green,      "US",        "408-123-2345" },
			{"17","Robert",  "Kim",          strawberry,  "Basket Ball",  blue,       "US",        "563-123-2345" },
			{"18","Janet",   "Koenig",       peach,       "Foot Ball",    turquoise,  "Hong Kong", "142-123-2345" },
			{"19","Jeff",    "Kesselman",    pineapple,   "Cricket",      blue,       "Maxico",    "356-123-2345" },
			{"20","Onno",    "Kluyt",        broccoli,    "Foot Ball",    orange,     "Italy",     "650-123-2345" },
			{"21","Peter",   "Korn",         sparegrass,  "Basket Ball",  sunpurple,  "Russia",    "456-123-2345" },
			{"22","Rick",    "Levenson",     raspberry,   "Volley Ball",  black,      "Fiji",      "390-123-2345" },
			{"23","Brian",   "Lichtenwalter",pear,        "Foot Ball",    jfcblue,    "Japan",     "560-123-2345" },
			{"24","Malini",  "Minasandram",  corn,        "Cricket",      beige,      "India",     "408-123-2345" },
			{"25","Michael", "Martak",       strawberry,  "Foot Ball",    green,      "Nepal",     "768-123-2345" },
			{"26","David",   "Mendenhall",   peach,       "Volley Ball",  forestgreen,"Vietnam",   "345-123-2345" },
			{"27","Phil",    "Milne",        banana,      "Foot Ball",    suspectpink,"Canada",    "527-123-2345" },
			{"28","Lynn",    "Monsanto",     peach,       "Basket Ball",  cybergreen, "UK",        "678-123-2345" },
			{"29","Hans",    "Muller",       pineapple,   "Cricket",      rustred,    "Germany",   "980-123-2345" },
			{"30","Tim",     "Prinzing",     pepper,      "Volley Ball",  blue,       "Fiji",      "324-123-2345" },
			{"31","Raj",     "Premkumar",    broccoli,    "Chess",        jfcblue2,   "Sri Lanka", "514-123-2345" },
			{"32","Howard",  "Rosen",        strawberry,  "Foot Ball",    green,      "US",        "408-123-2345" },
			{"33","Ray",     "Ryan",         banana,      "Volley Ball",  black,      "Australia", "456-123-2345" },
			{"34","Georges", "Saab",         cantaloupe,  "Chess",        aqua,       "Peru",      "408-123-2345" },
			{"35","Tom",     "Santos",       pepper,      "Foot Ball",    blue,       "Argentina", "408-123-2345" },
			{"36","Rich",    "Schiavi",      pepper,      "Foot Ball",    blue,       "Russia",    "408-123-2345" },
			{"37","Nancy",   "Schorr",       watermelon,  "Volley Ball",  green,      "UK",        "514-123-2345" },
			{"38","Keith",   "Sprochi",      watermelon,  "Basket Ball",  darkgreen,  "US",        "408-123-2345" },
			{"39","Matt",    "Tucker",       broccoli,    "Foot Ball",    eblue,      "India",     "408-123-2345" },
			{"40","Dimitri", "Trembovetsky", tomato,      "Volley Ball",  red,        "Malayasia", "408-123-2345" },
			{"41","Scott",   "Violet",       banana,      "Cricket",      violet,     "Singapore", "538-123-2345" },
			{"42","Kathy",   "Walrath",      pear,        "Foot Ball",    blue,       "Norway",    "879-123-2345" },
			{"43","Nathan",  "Walrath",      grapefruit,  "Basket Ball",  black,      "Nepal",     "917-123-2345" },
			{"44","Steve",   "Wilson",       onion,       "Volley Ball",  green,      "Australia", "678-123-2345" },
			{"45","Kathleen","Zelony",       grapes,      "Foot Ball",    gray,       "India",     "234-123-2345" }
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

	public static void main(String[] args) {
		if (args != null && args.length >= 1) {
			SmartJPrint.setLicenseKey(args[0]);
		}
		else {
			System.out.println("Usage: java " + PrintCustomCellTableDemo2.class.getName() + " licenseKey");
			System.exit(0);
		}

		PrintFrame demo = new PrintCustomCellTableDemo2();
		demo.postInit();
		demo.setVisible(true);
	}
}
