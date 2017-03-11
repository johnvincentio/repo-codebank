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
 * This example program is redistributable provided it carries the above
 * copy right and warning information.
 */
package demo.activetree.print;

import com.activetree.print.PageHeaderFooterListener;
import com.activetree.print.PageHeaderFooterRenderer;
import com.activetree.print.AtPrintConstants;
import com.activetree.print.AtPrintUtil;

import java.awt.*;
import java.awt.print.PageFormat;

public class DemoHeaderFooterRenderer implements PageHeaderFooterListener {
	protected String header = "Header Text (Smart JPrint, http://www.activetree.com)";
	protected Font headerFont = new Font("Times New Roman", Font.BOLD, 20);
	protected Color headerColor = AtPrintConstants.GENERAL_HEADER_FG1;
	protected Font footerFont = new Font("Arial", Font.PLAIN, 12);
	protected Color footerColor = Color.decode("#000033");

	public DemoHeaderFooterRenderer(String headerText) {
		this.header = headerText;
	}

	public void setPageHeaderAndFooter(PageHeaderFooterRenderer r) {
//				//System.out.println("setPageHeaderAndFooter()...totalPages=" + r.getTotalPageCount());
//				AtHeaderFooterElement header
//				  = new AtHeaderFooterElement(null,
//				                              new Font("Times New Roman", Font.BOLD, 20),
//				                              Color.decode("#333366"),
//				                              SystemColor.white,
//				                              false,
//				                              AtHeaderFooterElement.LEFT);
//				AtHeaderFooterElement footer
//				  = new AtHeaderFooterElement("Page " + r.getPageNumber() +"/" + r.getTotalPageCount(),
//				                              new Font("Arial", Font.PLAIN, 10),
//				                              Color.decode("#000033"),
//				                              SystemColor.white,
//				                              false,
//				                              AtHeaderFooterElement.CENTER);
//				if (r.getPageNumber() == 1) {
//					header.setStr("Employee Information - Manufacturing Division");
//				}
//				r.setHeader(header);
//				r.setFooter(footer);
	}

	public void drawHeader(Graphics g, Rectangle headerBbox, int pageNumber, int totalPageCount,
	                       int pageNumberLocation, PageFormat pf, double zoom) {
		Font zoomedFont = AtPrintUtil.getFont(headerFont, zoom);
		FontMetrics fm = AtPrintUtil.getFontMetrics(zoomedFont);
		int hx = (int) pf.getImageableX();
		int hy = headerBbox.y + headerBbox.height - (fm.getHeight()/4);
		g.setColor(headerColor);
		g.setFont(zoomedFont);
		g.drawString(header, hx, hy);

		String message = "(This is header area for writing your own custom header)";
		g.drawString(message, hx, hy - fm.getHeight());
		((Graphics2D)g).draw(headerBbox);
	}

	public void drawFooter(Graphics g, Rectangle footerBbox, int pageNumber, int totalPageCount,
	                       int pageNumberLocation, PageFormat pf, double zoom) {
		Font zoomedFont = AtPrintUtil.getFont(footerFont, zoom);
		String footer = "(Page " + pageNumber + " of " + totalPageCount +")";
		FontMetrics fm = AtPrintUtil.getFontMetrics(zoomedFont);
		//draw color renderers first and then the footer page number text next.
		int fx = (int) (pf.getWidth() - fm.stringWidth(footer))/2;
		int fy = footerBbox.y + fm.getHeight();
		g.setColor(footerColor);
		g.setFont(zoomedFont);
		g.drawString(footer, fx, fy);

		String message = "(This is footer area for writing your own custom footer)";
		int msgx = (int) footerBbox.getCenterX() - (fm.stringWidth(message)/2);
		g.drawString(message, msgx, fy + fm.getHeight());
		((Graphics2D)g).draw(footerBbox);
	}
}
