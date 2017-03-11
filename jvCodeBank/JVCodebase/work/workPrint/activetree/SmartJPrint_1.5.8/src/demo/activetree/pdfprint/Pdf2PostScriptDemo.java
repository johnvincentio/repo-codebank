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

import com.activetree.common.SmartJPrint;
import com.activetree.pdfprint.AtPdfStreamPrinter;
import com.activetree.pdfprint.AtPdfAbstractPage;
import com.activetree.pdfprint.AtPDF2PostScriptPrinter;

import java.awt.print.Pageable;
import java.io.File;
import java.io.FileOutputStream;

public class Pdf2PostScriptDemo {
  public static void main(String[] args) {
    String pdfFile = null;
		if (args != null && args.length >= 2) {
			SmartJPrint.setLicenseKey(args[0]);
      pdfFile = args[1];
		}
		else {
			System.out.println("Usage: java " + SilentPrintPDFFile.class.getName() + " <licenseKey>  <pdfFile>");
			System.exit(0);
		}
    try {
      File pdfDoc = new File(pdfFile);

      AtPdfStreamPrinter pdfStreamPrinter = new AtPdfStreamPrinter();
      Pageable allPages = pdfStreamPrinter.getPageable(pdfDoc);

      AtPdfAbstractPage[] pages = new AtPdfAbstractPage[allPages.getNumberOfPages()];
      for (int i=0; i < allPages.getNumberOfPages(); i++) {
        AtPdfAbstractPage aPage = (AtPdfAbstractPage) allPages.getPrintable(i);
        pages[i] = aPage;
      }

      //Print to a file
      String psOutFile = "./pdf_2_postscript1.ps";
      try {
        FileOutputStream psOutStream = new FileOutputStream(psOutFile);
        AtPDF2PostScriptPrinter psPrinter = new AtPDF2PostScriptPrinter();
        psPrinter.saveAsPostScriptOutput(pages, psOutStream);
      }catch(Throwable t) {
        t.printStackTrace();
      }
    }catch(Throwable t) {
      t.printStackTrace();
    }
  }
}
