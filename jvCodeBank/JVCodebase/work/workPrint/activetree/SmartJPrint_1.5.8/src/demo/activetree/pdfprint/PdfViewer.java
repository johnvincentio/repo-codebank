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

public class PdfViewer {
  public static void main(String[] args) {
		if (args != null && args.length >= 1) {
			SmartJPrint.setLicenseKey(args[0]);
		}
		else {
			System.out.println("Usage: java " + PdfViewer.class.getName() + " <licenseKey>");
			System.exit(0);
		}
//    AtLAFUtil.setDefaultLookAndFeel();
    AtPdfPreviewFrame previewFrame = new AtPdfPreviewFrame();
    previewFrame.setVisible(true);
  }
}
