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
 * This example programs are redistributable provided it carries the above
 * copy right and warning information.
 */

package demo.activetree.pdfprint;

import com.activetree.pdfprint.AtPdfStreamPrinter;
import com.activetree.common.SmartJPrint;

import javax.print.PrintService;
import java.awt.print.PrinterJob;
import java.awt.print.Pageable;
import java.io.File;
import java.net.URL;

public class SilentPrintingPDFUrl {
  public static void main(String[] args) {
    String pdfFile = null;
		if (args != null && args.length >= 2) {
			SmartJPrint.setLicenseKey(args[0]);
      pdfFile = args[1];
		}
		else {
			System.out.println("Usage: java " + SilentPrintingPDFUrl.class.getName() + " <licenseKey>  <pdfUrl>");
			System.exit(0);
      //System.out.println("using default url: http://www.activetree.com/demo/SmartJPrint_ToPDFDemo1.pdf");
      //pdfFile = "http://www.activetree.com/demo/SmartJPrint_ToPDFDemo1.pdf";
		}
    AtPdfStreamPrinter pdfStreamPrinter = new AtPdfStreamPrinter();
    PrintService ps = PrinterJob.getPrinterJob().getPrintService(); //default printer
    PrinterJob pj = PrinterJob.getPrinterJob();
    try {
      URL pdfDoc = new URL(pdfFile);
      pj.setPrintService(ps);
      Pageable pages = pdfStreamPrinter.getPageable(pdfDoc);
      pj.setPageable(pages);
      pj.print();
    }catch(Throwable t) {
      t.printStackTrace();
    }
  }
}

