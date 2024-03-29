package com.idc.pdf;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class HelloWorldLandscape1 {
	/** Path to the resulting PDF file. */
	public static final String RESULT = "hello_landscape1.pdf";

	/**
	 * Creates a PDF file: hello_landscape1.pdf
	 * 
	 * @param args
	 *            no arguments needed
	 */
	public static void main(String[] args) throws DocumentException,
			IOException {
		// step 1
		// landscape format using the rotate() method
		Document document = new Document(PageSize.LETTER.rotate());
		// step 2
		PdfWriter.getInstance(document, new FileOutputStream(RESULT));
		// step 3
		document.open();
		// step 4
		document.add(new Paragraph("Hello World"));
		// step 5
		document.close();
	}
}
