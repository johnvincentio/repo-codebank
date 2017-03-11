/**
 * Source: SaveAsTIFFDemo2.java
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
package demo.activetree.print.saveas;

import com.activetree.print.*;
import com.activetree.common.SmartJPrint;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.Document;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.print.Pageable;
import java.awt.print.PageFormat;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.OutputStream;
import java.io.File;
import java.io.FileOutputStream;

import demo.activetree.print.PrintFrame;
import demo.activetree.print.rtf.WordProcessor;

public class SaveAsTIFFDemo2 extends PrintFrame {
	private JTextPane textPane;

	//JTables
	String tableNames[] = {"Hubs and Nodes", "Gateways", "Boards", "Spans", "Channels"};
	JTable[] tables = new JTable[5];
	//TextArea
	String taLabel = "Gateway configuration guide (User editable)";
	String taText = "\n" +
	  "1. Gateway must be identified with an IP address.\n" +
		"2. Number of Boards can varry. You can add more Board if necessary.\n" +
		"3. A Board can have maximum 4 Spans. You can keep one or more Span active or inactive.\n" +
		"4. A Span can have 27 channels.\n";
	JTextArea ta = new JTextArea(taText);
	//JTextPane
	String smartjprint = "Smart JPrint - What is it? (User editable)";
	WordProcessor rtfComponent = new WordProcessor();
	String rtfResourceFile = "/demo/activetree/documents/SmartJPrint1.rtf";

	public SaveAsTIFFDemo2() {
		frame.setTitle("Smart JPrint - Print/PDF from multiple sources");
		frame.setSize(700, 500);
		textPane = new JTextPane();
		initStyle(textPane);

		//add JTextArea
		insertText(textPane.getDocument(), "\n");
		textPane.setCaretPosition(textPane.getDocument().getLength());
		ta.setBorder(BorderFactory.createLineBorder(SystemColor.blue.darker().darker(), 1));
		insertText(textPane.getDocument(), taLabel + "\n");
		textPane.setCaretPosition(textPane.getDocument().getLength());
		textPane.insertComponent(ta);
		insertText(textPane.getDocument(), "\n\n");
		textPane.setCaretPosition(textPane.getDocument().getLength());

		//init and add JTable 1 & 2.
		for (int i=0; i < 2; i++) {
			tables[i] = createSampleTable();
		}
		//add tables
		for (int i=0; i < 2; i++) {
			String tableName = tableNames[i];
			JTable table = tables[i];
			addTable(tableName, table);
		}

		//add rtf editor
		rtfComponent.openDocument(rtfResourceFile);
		JTextPane rtfPane = rtfComponent.getPane();
		rtfPane.setBorder(BorderFactory.createLineBorder(SystemColor.blue.darker().darker(), 1));
		insertText(textPane.getDocument(), smartjprint + "\n");
		textPane.setCaretPosition(textPane.getDocument().getLength());
		textPane.insertComponent(rtfPane);
		textPane.setCaretPosition(textPane.getDocument().getLength());
		insertText(textPane.getDocument(), "\n");
		textPane.setCaretPosition(textPane.getDocument().getLength());

		//add rest of the JTables
		for (int i=2; i < tables.length; i++) {
			tables[i] = createSampleTable();
		}
		insertText(textPane.getDocument(), "\n");
		textPane.setCaretPosition(textPane.getDocument().getLength());
		//add tables
		for (int i=2; i < tables.length; i++) {
			String tableName = tableNames[i];
			JTable table = tables[i];
			addTable(tableName, table);
		}

		//put into a scroll pane.
		JScrollPane scrollPane = new JScrollPane(textPane);
		setPrintableComponent(scrollPane);
		textPane.setEditable(false);

		//Add few more buttons for TIFF, JPG, and PNG
		JButton tiffButton = new JButton("TIFF");
		tiffButton.setActionCommand("TIFF");
		tiffButton.setToolTipText("Produce a TIFF image document");
		tiffButton.addActionListener(this);
		printToolBar.add(tiffButton);

		JButton pngButton = new JButton("PNG");
		pngButton.setActionCommand("PNG");
		pngButton.setToolTipText("Produce PNG image file for each page");
		pngButton.addActionListener(this);
		printToolBar.add(pngButton);

		JButton jpgButton = new JButton("JPG");
		jpgButton.setActionCommand("JPG");
		jpgButton.setToolTipText("Produce JPG image file for each page");
		jpgButton.addActionListener(this);
		printToolBar.add(jpgButton);
	}

	public void addTable(String tableName, JTable table) {
		textPane.setCaretPosition(textPane.getDocument().getLength());
		insertText(textPane.getDocument(), tableName + "\n");
		textPane.setCaretPosition(textPane.getDocument().getLength());
		textPane.insertComponent(table.getTableHeader());
    insertText(textPane.getDocument(), "\n");
		textPane.setCaretPosition(textPane.getDocument().getLength());
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
		StyleConstants.setForeground(style, SystemColor.blue.darker().darker());
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
		Font headerFont = new Font("Arial", Font.BOLD, 14);

		//Add - JTextArea
		AtBook book = new AtBook();
		book.append(new AtStringElement(taLabel, headerFont,
		                                AtPrintConstants.GENERAL_HEADER_COLOR));
		book.append("\n");
		book.append(ta);

		//Add 2 JTables
		for (int i=0; i < 2; i++) {
			String tableName = tableNames[i];
			JTable table = tables[i];
			book.append(new AtStringElement(tableName, headerFont,
			                                AtPrintConstants.GENERAL_HEADER_COLOR));
			book.append("\n");
			book.append(table, true, true, true);
			if (i < (tables.length-1)) {
				book.append("\n");
			}
		}
		AtStringElement jprintLabel = new AtStringElement(smartjprint, headerFont,
		                                AtPrintConstants.GENERAL_HEADER_COLOR);
		book.append(jprintLabel);
		book.append("\n");
		book.append(rtfComponent.getPane());

		//Add rest of the JTables
		for (int i=2; i < tables.length; i++) {
			String tableName = tableNames[i];
			JTable table = tables[i];
			book.append(new AtStringElement(tableName, headerFont,
			                                AtPrintConstants.GENERAL_HEADER_COLOR));
			book.append("\n");
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
		}else if (evt.getActionCommand().equals("TIFF")) {
			System.out.println("Saving As...TIFF");
			AtAbstractPage[] outputPages = getOutputPages(book);
			AtImagePrinter imgPrinter = new AtImagePrinter();
			OutputStream outputStream = AtPrintUtil.getOutputStream(frame, "tif", "TIF Files");
			if (outputStream == null) {
				return;
			}
			try {
        System.out.println("Save as TIFF...pages=" + outputPages.length);
				imgPrinter.saveAsTIFF(outputPages, outputStream, true);
			}catch(Throwable t) {
				t.printStackTrace();
			}
			System.out.println("TIFF...Done");
		}else if (evt.getActionCommand().equals("PNG")) {
			System.out.println("Saving As...PNG");
			AtAbstractPage[] outputPages = getOutputPages(book);
			try {
				for (int i=0; outputPages != null && i < outputPages.length; i++) {
					String fileName = "smartjprint_pngdemo2_page_" + (i+1) + ".png";
					File file = new File(fileName);
					FileOutputStream outputStream = new FileOutputStream(file);
					AtImageFactory.saveAsPNG(outputPages[i], outputStream);
					System.out.println(file.getAbsoluteFile().toString() + " saved.");
				}
			}catch(Throwable t) {
				t.printStackTrace();
			}
			System.out.println("PNG...Done");
		}else if (evt.getActionCommand().equals("JPG")) {
			System.out.println("Saving As...JPG");
			AtAbstractPage[] outputPages = getOutputPages(book);
			try {
				for (int i=0; outputPages != null && i < outputPages.length; i++) {
					String fileName = "smartjprint_jpgdemo2_page_" + (i+1) + ".jpg";
          File file = new File(fileName);
          FileImageOutputStream output = new FileImageOutputStream(file);
					AtImageFactory.saveAsJPEG(outputPages[i], output, 1.0f);
					System.out.println(file.getAbsoluteFile().toString() + " saved.");
				}
			}catch(Throwable t) {
				t.printStackTrace();
			}
			System.out.println("JPG...Done");
		}else if (evt.getActionCommand().equals("Preview")) {
			AtGenericPrinter genericPrinter = new AtGenericPrinter();
			genericPrinter.preview(book, PageNoPainter.LOWER_CENTER, frame);
		}
	}

	public AtAbstractPage[] getOutputPages(AtBook book) {
		AtGenericPrinter genericPrinter = new AtGenericPrinter();
		Pageable pages = genericPrinter.getPageable(book, PageNoPainter.LOWER_CENTER);
    int pageCount = pages.getNumberOfPages();
    AtAbstractPage[] allPages = new AtAbstractPage[pageCount];
    for (int i=0; pages != null && i < pageCount; i++) {
      AtAbstractPage page = (AtAbstractPage) pages.getPrintable(i);
      allPages[i] = page;
      System.out.println("page " + i);
    }
		return allPages;
	}

	private JTable createSampleTable() {
		String[] cols = {"Employee Name", "SS No.", "Date Of Birth",
		                 "Position", "Salary"};
		String[][] data = new String[5][cols.length];

		//Create same data for the table.
		String name = "Employee Name - ";
		String ssn = "SS No - ";
		String dob = "Birth Date - ";
		String position = "Position - ";
		String annualSalary = "Employee Salary - ";
		for (int row=0; row < data.length; row++) {
			data[row][0] = name + row;
			data[row][1] = ssn + row;
			data[row][2] = dob + row;
			data[row][3] = position + row;
			data[row][4] = annualSalary + row;
		}

		DefaultTableModel tableModel = new DefaultTableModel(data, cols);
		JTable table = new JTable(tableModel);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setFont(new Font("Arial", Font.PLAIN, 12));
		return table;
	}

	public static void main(String[] args) {
		if (args != null && args.length >= 1) {
			SmartJPrint.setLicenseKey(args[0]);
		}
		else {
			System.out.println("Usage: java " + SaveAsTIFFDemo2.class.getName() + " licenseKey");
			System.exit(0);
		}

		SaveAsTIFFDemo2 demo = new SaveAsTIFFDemo2();
		demo.postInit();
		demo.setVisible(true);
	}
}
