/**
 * Source: PrintFrame.java
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
package demo.activetree.print;

import com.activetree.resource.AtImageList;
import com.activetree.print.*;
import com.activetree.utils.AtDebug;
import com.activetree.common.SmartJPrint;

import javax.swing.*;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.Size2DSyntax;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.MediaPrintableArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.io.OutputStream;

public class PrintFrame extends JApplet implements ActionListener {
	protected JFrame frame = new JFrame();
	protected JScrollPane scrollPane = null;
	protected AtDocumentPrinter printer;
	protected AtPdfPrinter pdfPrinter;
	protected AtTablePrinter tablePrinter;
	protected AtGenericPrinter genericPrinter;

	protected JPanel printToolBar;
  protected JButton printPdf;
  protected JButton preview;
  protected JButton print;

	public PrintFrame() {
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
		printer = new AtDocumentPrinter();
		pdfPrinter = new AtPdfPrinter();
		genericPrinter = new AtGenericPrinter();
		tablePrinter = new AtTablePrinter();
		tablePrinter.setDrawCellBorder(true);
		tablePrinter.setRepeatHeader(true);
		tablePrinter.setHeaderBold(true);
	}

	protected void setupContentPane() {
		Container c = frame.getContentPane();
		c.setLayout(new BorderLayout());
		scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(SystemColor.white);
		c.add(scrollPane, BorderLayout.CENTER);

		//toolbar
		printToolBar = new JPanel(new FlowLayout(FlowLayout.LEADING));
		print = new JButton(AtImageList.IMAGE_LIST.PRINT);
		print.setActionCommand("Print");
		print.setToolTipText("Print");
		print.addActionListener(this);
		printToolBar.add(print);

		printPdf = new JButton(AtImageList.IMAGE_LIST.PDF);
		printPdf.setActionCommand("Generate PDF");
		printPdf.setToolTipText("Generate output as a PDF document");
		printPdf.addActionListener(this);
		printToolBar.add(printPdf);

		preview = new JButton(AtImageList.IMAGE_LIST.PREVIEW);
		preview.setActionCommand("Preview");
		preview.setToolTipText("Preview");
		preview.addActionListener(this);
		printToolBar.add(preview);

		c.add(printToolBar, BorderLayout.NORTH);

		//Close operation.
		frame.setSize(new Dimension(650, 400));
	}

	public void setPrintableComponent(Component compToPrint) {
    scrollPane.setViewportView(compToPrint);
		scrollPane.updateUI();
	}

  /** Override it in the derived classes */
	public void actionPerformed(ActionEvent evt) {
	}

	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}

	public void printAsPdf(Component compToPrint, AtPdfPrinter pdfPrinter) {
		AtDebug.debug("Save As PDF file...");
		OutputStream outputStream = AtPrintUtil.getOutputStream(compToPrint, "pdf", "PDF Files");
		if (outputStream == null) {
		  return;
		}

		try {
//      pdfPrinter.print(compToPrint, outputStream, pdfPrinter.getPageNumberLocation(),
//                       null, getPrintRequestProperties(), true);
      pdfPrinter.print(compToPrint, outputStream, pdfPrinter.getPageNumberLocation(), null, null, true);
    }catch(Throwable ex) {
		  ex.printStackTrace();
		}
		System.out.println("PDF document is produced for viewing.");
	}

	public PrintRequestAttributeSet getPrintRequestProperties() {
		HashPrintRequestAttributeSet attrs = new HashPrintRequestAttributeSet();
		attrs.add(MediaSizeName.ISO_A4);

		MediaSize mediaSize = MediaSize.ISO.A4;
		//set the image area within the paper total area
    float mediaWidth = mediaSize.getX(Size2DSyntax.MM);
		float mediaHeight = mediaSize.getY(Size2DSyntax.MM);
//		System.out.println("paper width=" + mediaWidth + ", mediaHeight=" + mediaHeight);

		float imageableX = 20; //mm
		float imageableY = 30; //mm
		float imageableWidth = (mediaWidth - (2*imageableX));
		float imageableHeight = (mediaHeight - (2*imageableY));
//		System.out.println("imageableW=" + imageableWidth + ", imageablelHeight=" + imageableHeight);
		MediaPrintableArea imageableArea = new MediaPrintableArea(imageableX, imageableY, imageableWidth, imageableHeight, Size2DSyntax.MM);
		attrs.add(imageableArea);
		return attrs;
	}

	public static final PageFormat getCustomPageFormat() {
		PageFormat pf = new PageFormat();
		Paper paper = pf.getPaper();
		double currX = paper.getImageableX();
		double currY = paper.getImageableY();
		double currImgW = paper.getImageableWidth();
		double currImgH = paper.getImageableHeight();
		double DELTA = 50;
		double newX = currX - DELTA;
		double newY = currY - DELTA;
		double newImgW = currImgW + (2 * DELTA);
		double newImgH = currImgH + (2 * DELTA);

//		System.out.println("newX=" + newX + ", newY=" + newY
//		                   + ", newImgW=" + newImgW
//		                   + ", newImgH=" + newImgH);

		Paper customPaper = new Paper();
		customPaper.setImageableArea(newX, newY, newImgW, newImgH);
    pf.setPaper(customPaper);
		pf.setOrientation(PageFormat.LANDSCAPE);
		AtPrintUtil.debugPageFormat(pf);

		return pf;
	}

	public static final PageFormat getPortraitCustomPageFormat() {
		PageFormat pf = new PageFormat();
		Paper paper = pf.getPaper();
		double currX = paper.getImageableX();
		double currY = paper.getImageableY();
		double currImgW = paper.getImageableWidth();
		double currImgH = paper.getImageableHeight();
		double DELTA = 50;
		double newX = currX - DELTA;
		double newY = currY - DELTA;
		double newImgW = currImgW + (2 * DELTA);
		double newImgH = currImgH + (2 * DELTA);

//		System.out.println("newX=" + newX + ", newY=" + newY
//		                   + ", newImgW=" + newImgW
//		                   + ", newImgH=" + newImgH);

		Paper customPaper = new Paper();
		customPaper.setImageableArea(newX, newY, newImgW, newImgH);
    pf.setPaper(customPaper);
		pf.setOrientation(PageFormat.PORTRAIT);
		AtPrintUtil.debugPageFormat(pf);

		return pf;
	}


}
