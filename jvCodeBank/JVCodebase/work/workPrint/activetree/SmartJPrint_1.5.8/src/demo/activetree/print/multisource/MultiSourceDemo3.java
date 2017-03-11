/**
 * Source: MultiSourceDemo3.java
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

import com.activetree.print.*;
import com.activetree.resource.AtImageList;
import com.activetree.common.SmartJPrint;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionListener;
import java.awt.print.*;
import java.awt.*;
import java.io.OutputStream;

public class MultiSourceDemo3 extends MyFrame {
	public static void main(String[] args) {
		if (args != null && args.length >= 1) {
			SmartJPrint.setLicenseKey(args[0]);
		}
		else {
			System.out.println("Usage: java " + MultiSourceDemo3.class.getName() + " licenseKey");
			System.exit(0);
		}
		MyFrame demo = new MultiSourceDemo3();
		demo.setVisible(true);
	}

	public MultiSourceDemo3() {
		super();
		frame.setTitle("Smart JPrint - Print pages from multiple sources");
	}

  public void actionPerformed(ActionEvent evt) {
    PageFormat pf = new PageFormat();
		AtTablePrinter tablePrinter = new AtTablePrinter();
		tablePrinter.setDrawCellBorder(true);
		tablePrinter.setRepeatHeader(true);
		tablePrinter.setHeaderBold(true);
    tablePrinter.setPageFormat(pf);
    Pageable tablePages = tablePrinter.getPageable(getTable(), PageNoPainter.PAGE_NONE);
    AtDocumentPrinter docPrinter = new AtDocumentPrinter();
    docPrinter.setPageFormat(pf);
    Pageable textPages = docPrinter.getPageable(getTextComponent(), PageNoPainter.PAGE_NONE);
    Book allPages = new Book();

    //Add table pages.
    for (int page=0; tablePages != null && page < tablePages.getNumberOfPages(); page++) {
      allPages.append(tablePages.getPrintable(page), tablePages.getPageFormat(page));
    }
    //Add your custom pages anywhere.
    Pageable myCustomPages = getMyCustomPages();
    for (int page=0; myCustomPages != null && page < myCustomPages.getNumberOfPages(); page++) {
      allPages.append(myCustomPages.getPrintable(page), myCustomPages.getPageFormat(page));
    }

    //Add TextComponent pages.
    for (int page=0; textPages != null && page < textPages.getNumberOfPages(); page++) {
      allPages.append(textPages.getPrintable(page), textPages.getPageFormat(page));
    }

    //For PDF generation
    if (evt.getActionCommand().equals("PDF")) {
      AtPdfPrinter pdfPrinter = new AtPdfPrinter();
      pdfPrinter.setPageNumberLocation(PageNoPainter.PAGE_NONE);
      try {
        OutputStream pdfFile = AtPrintUtil.getOutputStream(frame, "pdf", "PDF Files");
	      if (pdfFile == null) {
		      return;
	      }
        pdfPrinter.printPageable(pdfFile, allPages, pf);
      }catch(Throwable t) {
        t.printStackTrace();
      }
      System.out.println("A PDF file is generated.");
    }
    //For PRINTING
    else if (evt.getActionCommand().equals("Print")) {
	    PrinterJob printerJob = PrinterJob.getPrinterJob();
	    try {
		    printerJob.setPageable(allPages);
		    printerJob.print();
	    }catch(Throwable t) {
		    t.printStackTrace();
	    }
	    System.out.println("Document is printed.");
    }
  }

  Pageable getMyCustomPages() {
    Printable myCustomPage = new Printable() {
      public int print(Graphics g, PageFormat pageFormat, int pageIndex)
          throws PrinterException {
        //double paperWidth = pageFormat.getWidth();
        double imgX = pageFormat.getImageableX();
        double imgY = pageFormat.getImageableY();
	      Font font = new Font("Arial", Font.PLAIN, 11);
        FontMetrics fm = frame.getFontMetrics(font);
        int textHeight = fm.getHeight();
        int sy = (int) imgY + textHeight;
	      g.setFont(font);
        g.drawString("Smart JPrint allows to print or PDF generate pages from multiple sources.", (int)imgX, sy);
        sy += textHeight;
        sy += fm.getDescent();
        g.drawString("o This is a custom page from your Java GUI or J2EE program.", (int)imgX, sy);
        sy += textHeight;
        sy += fm.getDescent();
        g.drawString("o Pages prior to this page is generated from a JTable using Smart JPrint APIs.", (int)imgX, sy);
        sy += textHeight;
        sy += fm.getDescent();
        g.drawString("o Paqges next to this page too generated using Smart JPrint from a TextComponent.", (int)imgX, sy);
        return PAGE_EXISTS;
      }
    };
    Book pageable = new Book();
    pageable.append(myCustomPage, new PageFormat());
    return pageable;
  }

  JTextComponent getTextComponent() {
    StringBuffer msg = new StringBuffer("State changes in objects\n\n");

    msg.append("Just to give you an example, let us take water (H2O) as a type. In ");
    msg.append("summer, mother nature heats up everything and the water in lakes, ");
    msg.append("rivers, sea evaporates to become clouds in the sky. In winter, ");
    msg.append("nature extracts heat from the water and it becomes ice to spread ");
    msg.append("across fields, rivers, and mountains. Ice again becomes water and ");
    msg.append("flows over mountains, plains to streams, and finally to sea, when ");
    msg.append("mother nature completes the cycle by bringing the summer back.\n\n");

    msg.append("What we have noticed from the above example?\n\n");

    msg.append("We have definitely learned couple of things from it. A type, changes ");
    msg.append("its state (in this case, the state is ice, water, or vapor). ");
    msg.append("Something external that (in this case nature extracts or puts heat ");
    msg.append("back to the water) acts to the object so that it moves from one ");
    msg.append("state to another state.\n\n");

    msg.append("Let us take the BankAccount class as an example. Assume that you ");
    msg.append("have just opened a new bank account with $100 as the opening ");
    msg.append("deposit amount. We can call the state of your account is in create ");
    msg.append("state. Once created an account might take some times before it can be ");
    msg.append("operational, as the bank has to deliver an ATM or Credit card, and ");
    msg.append("bunch of check to you before it becomes operational. Therefore, when ");
    msg.append("creation state is over, you are ready to operate your account by depositing, ");
    msg.append("withdrawing, check issuing against the account, called operational state.\n\n");

    msg.append("Similarly, when you do not operate your account for a very long ");
    msg.append("time and do not have enough balance in the account, bank ");
    msg.append("might move the account to closed state and you'll not be able to operate ");
    msg.append("your account. To operate the same account, you perhaps have to ");
    msg.append("request the bank to re-open it to operational state. In terms ");
    msg.append("of object definition, the state can be defined using just an ");
    msg.append("integer flag to hold the three different values. Let us say 1 ");
    msg.append("is for ‘open state’, 2 for ‘operational state’ and 3 is to indicate ");
    msg.append("‘closed state’.\n");

    JTextComponent textComponent = new JTextArea();
    textComponent.setText(msg.toString());
    return textComponent;
  }

  JTable getTable() {
    String[] cols =
            {"EmpNo", "Employee Name", "SSN", "Date Of Birth",
             "Home Phone"};
    String[][] data = new String[60][cols.length];

    //Create same data for the table.
    int empNo = 1000;
    String name = "Employee Name - ";
    String ssn = "SSN - ";
    String dob = "Date - ";
    String homePhone = "Home Phone - ";
    for (int row=0; row < data.length; row++) {
      data[row][0] = String.valueOf(empNo+row);
      data[row][1] = name + row;
      data[row][2] = ssn + row;
      data[row][3] = dob + row;
      data[row][4] = homePhone + row;

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
    table.getTableHeader().setReorderingAllowed(false);
    return table;
  }

}

class MyFrame extends JApplet implements ActionListener {
	protected JFrame frame = new JFrame();
	public MyFrame() {
		setupContentPane();
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				frame.setVisible(false);
				frame.dispose();
			}
		});
	}

	public void init() {
		SmartJPrint.setLicenseKey(getParameter("key"));
		frame.setVisible(true);
		postInit();
	}

	public void postInit() {
	}

	protected void setupContentPane() {
		Container c = frame.getContentPane();
		c.setLayout(new BorderLayout());
		//toolbar
		JPanel printToolBar = new JPanel(new FlowLayout(FlowLayout.LEADING));
		JButton print = new JButton(AtImageList.IMAGE_LIST.PRINT);
		print.setActionCommand("Print");
		print.setToolTipText("Print output pages");
		print.addActionListener(this);
		printToolBar.add(print);

		JButton pdf = new JButton(AtImageList.IMAGE_LIST.PDF);
		pdf.setActionCommand("PDF");
		pdf.setToolTipText("Generate output as a PDF document");
		pdf.addActionListener(this);
		printToolBar.add(pdf);

		c.add(printToolBar, BorderLayout.NORTH);

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setText("Press the button above to Print, PDF, Preview pages from the following:\n\n" +
		                 "1. Pages received from a sample JTable (using Smart JPrint API).\n" +
		                 "2. A custom page created from the Java program (not using SmartJPrint API).\n" +
		                 "3. Pages created from a JTextArea Swing component (using Smart JPrint API).");
    c.add(textArea, BorderLayout.CENTER);
		frame.setSize(new Dimension(600, 180));
	}

  /** Override it in the derived classes */
	public void actionPerformed(ActionEvent evt) {
	}

	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}
}

