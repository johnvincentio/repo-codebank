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

import com.activetree.pdfprint.AtPdfPreviewFrame;
import com.activetree.common.SmartJPrint;

import java.net.URL;

public class UrlPDFdemo {
  public static void main(String[] args) {
		if (args != null && args.length >= 2) {
			SmartJPrint.setLicenseKey(args[0]);
		}
		else {
			System.out.println("Usage: java " + UrlPDFdemo.class.getName() + " <licenseKey> <PDF URL>");
			System.exit(0);
		}
    String pdfUrl = args[1];
    URL url = null;
    AtPdfPreviewFrame previewFrame = null;
    try {
      url = new URL(pdfUrl);
      previewFrame = new AtPdfPreviewFrame();
      previewFrame.setVisible(true);
      previewFrame.showPdf(url);
    }catch(Throwable t) {
      t.printStackTrace();
    }
  }
}
