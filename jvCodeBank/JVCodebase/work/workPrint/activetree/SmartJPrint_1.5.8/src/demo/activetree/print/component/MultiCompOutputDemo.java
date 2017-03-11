/**
 * Source: MultiCompOutputDemo.java
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
 * This example programs are redistributable provided it carries the above
 * copy right and warning information.
 */
package demo.activetree.print.component;

import com.activetree.print.*;
import com.activetree.common.SmartJPrint;

import javax.swing.*;
import java.awt.print.Paper;
import java.awt.print.PageFormat;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.OutputStream;

import demo.activetree.print.PrintFrame;

public class MultiCompOutputDemo extends PrintFrame implements ActionListener {
  public static void main(String[] args) {
		if (args != null && args.length >= 1) {
			SmartJPrint.setLicenseKey(args[0]);
		}
		else {
			System.out.println("Usage: java " + MultiCompOutputDemo.class.getName() + " licenseKey");
			System.exit(0);
		}

		PrintFrame demo = new MultiCompOutputDemo();
		demo.postInit();
		demo.setVisible(true);
  }

  JPanel pdfPanel = new JPanel(new GridLayout(0, 1));
	Font labelFont = new Font("Arial", Font.PLAIN, 12);
  int compCount = 3;
  JButton pdfButton;
  JButton pdfTopButton;
  JComponent[] pages;
  PageFormat pf;
	int pageNumber = 1;

  public MultiCompOutputDemo() {
	  super();
		setPrintableComponent(sampleMultpageComponent());
	  frame.setResizable(false);
	  frame.setTitle("PDF mutliple swing components together - Smart JPrint");
  }

	private Component sampleMultpageComponent() {
    pf = new PageFormat();
    Paper p = new Paper();
    p.setImageableArea(72, 72, 468, 648);    //Letter size paper.
    pf.setPaper(p);

    pages = new JComponent[compCount];
    for(int i=0; i < compCount; ++i) {
      JPanel aContainer = new JPanel(new BorderLayout());
      aContainer.setBackground(SystemColor.white);
      HeaderPane header = new HeaderPane();
      FooterPane footer = new FooterPane();
      int headerHeight = header.getPreferredSize().height;
      int footerHeight = footer.getPreferredSize().height;
      int contentHeight = 648 - headerHeight- footerHeight;
      aContainer.add(header, BorderLayout.NORTH);
      aContainer.add(new ContentPane(i+1, new Dimension(460, contentHeight)), BorderLayout.CENTER);
      aContainer.add(footer, BorderLayout.SOUTH);
      aContainer.setSize(new Dimension(465, 645));  //Letter size.
      aContainer.setMaximumSize(new Dimension(465, 645));  //Letter size.
      pages[i] = aContainer;
      pdfPanel.add(aContainer);
    }
    JScrollPane pdfPanelScroller = new JScrollPane(pdfPanel);

    //button pane
    pdfButton = new JButton("PDF Invidividual components");
    pdfButton.addActionListener(this);
    pdfTopButton = new JButton("PDF Top Container");
    pdfTopButton.addActionListener(this);

    JPanel buttonPane = new JPanel(new FlowLayout(FlowLayout.TRAILING));
    buttonPane.add(pdfButton);
    buttonPane.add(pdfTopButton);

    Container c = new JPanel(new BorderLayout());
    c.setLayout(new BorderLayout());
    c.add(pdfPanelScroller, BorderLayout.CENTER);
    c.add(buttonPane, BorderLayout.NORTH);
    frame.setSize(new Dimension(490, 300));
		return c;
  }

	protected void setupContentPane() {
		Container c = frame.getContentPane();
		c.setLayout(new BorderLayout());
		scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(SystemColor.white);
		c.add(scrollPane, BorderLayout.CENTER);
	}

	public void postInit() {}

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == pdfButton) {
      //PDF's individual components and combines them as one output.
      saveAsPdfIndividualComponents();
    }else if (e.getSource() == pdfTopButton) {
      //Also pass the pdfPanel to print whole thing by breaking into pages.
      saveAsPdfTop();
    }
  }

  public void saveAsPdfIndividualComponents() {
    //Accumulate all pages into a Pageable object
    java.awt.print.Book allPages = new java.awt.print.Book();
    for(int i=0; i < compCount; ++i) {
      AtComponentPrinter compPrinter = new AtComponentPrinter();
      compPrinter.setPageFormat(pf);
      JComponent compToOutput = pages[i];
      java.awt.print.Pageable pages = compPrinter.getPageable(compToOutput, PageNoPainter.PAGE_NONE);

      for (int j=0; pages != null && j < pages.getNumberOfPages(); j++) {
        AtAbstractPage page = (AtAbstractPage) pages.getPrintable(j);
	      page.setPageNumbeLocation(PageNoPainter.LOWER_CENTER);
	      page.setPageNumber(pageNumber++);
        PageFormat aPf = pages.getPageFormat(j);
        allPages.append(page, aPf);
      }
    }
    System.out.println("total pages=" + allPages.getNumberOfPages());

    //produce PDF output.
    AtPdfPrinter pdfPrinter = new AtPdfPrinter();
    pdfPrinter.setPageFormat(pf);
    try {
	    OutputStream pdfOutputStream = AtPrintUtil.getOutputStream(frame, "pdf", "PDF Files");
      pdfPrinter.setPageNumberLocation(PageNoPainter.LOWER_CENTER);
      pdfPrinter.printPageable(pdfOutputStream, allPages, pf);
    }catch(Throwable t) {
      t.printStackTrace();
    }
  }

  public void saveAsPdfTop() {
    AtPdfPrinter pdfPrinter = new AtPdfPrinter();
    pdfPrinter.setPageFormat(pf);
    try {
	    OutputStream pdfOutputStream = AtPrintUtil.getOutputStream(frame, "pdf", "PDF Files");
      pdfPrinter.setPageNumberLocation(PageNoPainter.LOWER_CENTER);
      pdfPrinter.print(pdfPanel, pdfOutputStream);
    }catch(Throwable t) {
      t.printStackTrace();
    }
  }

  class HeaderPane extends JPanel {
    public HeaderPane() {
      setBackground(SystemColor.white);
      setForeground(AtPrintConstants.GENERAL_HEADER_COLOR);
      setLayout(new BorderLayout());
	    JLabel label1 = new JLabel("Header (Left part)", JLabel.LEADING);
	    JLabel label2 = new JLabel("Header (center part)", JLabel.CENTER);
	    JLabel label3 = new JLabel("Header (right part)", JLabel.LEADING);
	    label1.setFont(labelFont);
	    label2.setFont(labelFont);
	    label3.setFont(labelFont);
	    label1.setForeground(AtPrintConstants.GENERAL_HEADER_COLOR);
	    label2.setForeground(AtPrintConstants.GENERAL_HEADER_COLOR);
	    label3.setForeground(AtPrintConstants.GENERAL_HEADER_COLOR);
      add(label1, BorderLayout.WEST);
      add(label2, BorderLayout.CENTER);
      add(label3, BorderLayout.EAST);
    }
  }

  class ContentPane extends JPanel {
    BufferedImage testImg;
    public ContentPane(int idx, Dimension imgArea) {
      setPreferredSize(imgArea);
      testImg = new BufferedImage(imgArea.width, imgArea.height, BufferedImage.TYPE_INT_ARGB);
      Graphics g = testImg.getGraphics();
      g.setColor(SystemColor.white);
      g.fillRect(0, 0, imgArea.width, imgArea.height);
      g.setColor(SystemColor.LIGHT_GRAY);
      g.fillRect(0, 0, imgArea.width, imgArea.height);

      String sampleString = "Smart JPrint" + " (Page " + idx + ")";
      Font font = new Font("Arial", Font.BOLD, 40);
      FontMetrics fm = AtPrintUtil.getFontMetrics(font);
      int strWidth = fm.stringWidth(sampleString);
      int x = (imgArea.width - strWidth)/2;
      int y = (imgArea.height - fm.getHeight())/2;
      y += (fm.getHeight()/4)*3;
      g.setColor(AtPrintConstants.GENERAL_HEADER_FG1);
      g.setFont(font);
      g.drawString(sampleString, x, y);
    }

    public void paintComponent(Graphics g) {
      g.setColor(SystemColor.white);
      g.fillRect(0, 0, getWidth(), getHeight());
      if (testImg != null) {
        g.drawImage(testImg, 0, 0, this);
      }
    }
  }

  class FooterPane extends JPanel {
    public FooterPane() {
      setBackground(SystemColor.white);
      setForeground(AtPrintConstants.GENERAL_HEADER_COLOR);
      setLayout(new BorderLayout());
	    JLabel label1 = new JLabel("Footer (Left part)", JLabel.LEADING);
	    JLabel label2 = new JLabel("Footer (center part)", JLabel.CENTER);
	    JLabel label3 = new JLabel("Footer (right part)", JLabel.LEADING);
	    label1.setFont(labelFont);
	    label2.setFont(labelFont);
	    label3.setFont(labelFont);
	    label1.setForeground(AtPrintConstants.GENERAL_HEADER_COLOR);
	    label2.setForeground(AtPrintConstants.GENERAL_HEADER_COLOR);
	    label3.setForeground(AtPrintConstants.GENERAL_HEADER_COLOR);
      add(label1, BorderLayout.WEST);
      add(label2, BorderLayout.CENTER);
      add(label3, BorderLayout.EAST);
    }
  }
}

