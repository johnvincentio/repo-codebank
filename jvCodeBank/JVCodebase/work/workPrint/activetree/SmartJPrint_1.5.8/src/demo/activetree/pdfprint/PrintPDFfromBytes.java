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
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class PrintPDFfromBytes {
  public static void main(String[] args) {
    String pdfFile = null;
		if (args != null && args.length >= 2) {
			SmartJPrint.setLicenseKey(args[0]);
      pdfFile = args[1];
		}	else {
			System.out.println("Usage: java " + PrintPDFfromBytes.class.getName() + " <licenseKey> <PDF File>");
			System.exit(0);
		}
    URL url = null;

    byte pdfBytes[] = null;
    try {
      url = new URL(pdfFile);
      InputStream in = url.openStream();
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      byte buf[] = new byte[5120];
      for (int bytesCount=0; (bytesCount = in.read(buf)) != -1; ) {
        out.write(buf, 0, bytesCount);
      }
      in.close();
      out.close();
      pdfBytes = out.toByteArray();
      System.out.println("Reading...PdfBytes from URL = [" + pdfBytes.length + "]");
    }catch(Throwable t) {
      //t.printStackTrace();
      //try as a File
      File file = new File(pdfFile);
      try {
        url = file.toURL();
      }catch(Throwable tx) {
        //
      }
    }

    //show the preview window.
    AtPdfPreviewFrame previewFrame = new AtPdfPreviewFrame();
    previewFrame.setVisible(true);
    previewFrame.showPdf(pdfBytes);
  }
}
