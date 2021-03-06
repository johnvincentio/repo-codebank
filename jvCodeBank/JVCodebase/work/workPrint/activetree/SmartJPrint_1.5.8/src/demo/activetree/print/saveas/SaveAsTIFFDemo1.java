/**
 * Source: SaveAsTIFFDemo1.java
 * Version: ${VERSION}$
 * Copyright � ${2003-2004}$ by ActiveTree Inc.
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
import java.awt.print.Pageable;

public class SaveAsTIFFDemo1 {
  public static void main(String [] args) {
	  if (args.length <= 0) {
		  System.out.println("Usage: " + SaveAsTIFFDemo1.class.getName() + " licenseKey");
		  System.exit(1);
	  }

	  String licenseKey = args[0];
	  SmartJPrint.setLicenseKey(licenseKey);

    AtImagePrinter tiffReader = new AtImagePrinter();
    JTable table = new SampleDataProvider().getJTable();

    //Create Pages
    AtTablePrinter tablePrinter = new AtTablePrinter();
    tablePrinter.setDrawCellBorder(true);
    tablePrinter.setHeaderBold(true);
    tablePrinter.setRepeatHeader(true);
    Pageable pages = tablePrinter.getPageable(table, PageNoPainter.LOWER_CENTER);
    int pageCount = pages.getNumberOfPages();
    AtAbstractPage[] allPages = new AtAbstractPage[pageCount];
    for (int i=0; pages != null && i < pageCount; i++) {
      AtAbstractPage page = (AtAbstractPage) pages.getPrintable(i);
      allPages[i] = page;
    }

	  //Save As
    try {
      String uncompressedTIFFfile = "./smartjprint_tiffdemo1.tif";
      String compressedTIFFfile = "./smartjprint_tiffdemo1_compressed.tif";
      tiffReader.saveAsTIFF(allPages, uncompressedTIFFfile, false);
      System.out.println("All pages saved as a TIFF document in: " + uncompressedTIFFfile);
      tiffReader.saveAsTIFF(allPages, compressedTIFFfile, true);
      System.out.println("All pages saved as a compressed TIFF document in: " + compressedTIFFfile);
    }catch(Throwable t) {
      t.printStackTrace();
    }
    System.out.println("Done");
  }
}