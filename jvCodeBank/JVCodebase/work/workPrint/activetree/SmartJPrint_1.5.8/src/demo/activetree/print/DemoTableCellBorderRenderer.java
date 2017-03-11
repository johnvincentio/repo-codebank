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

import com.activetree.print.AtBorderRenderer;

import javax.swing.*;
import java.awt.*;

public class DemoTableCellBorderRenderer implements AtBorderRenderer {
	public void drawBorder(JTable table, Object cellValue, int row, int col,
	                       boolean isHeaderCell, Graphics g, Rectangle bbox) {
		Graphics2D g2d = (Graphics2D)g;
		if (!isHeaderCell) {
			g2d.setColor(table.getGridColor());
			g2d.draw(bbox);
		}	else {
			if (col == table.getColumnCount()-1) {
				g2d.setColor(table.getGridColor());
				g2d.drawRect(bbox.x, bbox.y, bbox.width, bbox.height-1);
				g2d.setColor(table.getGridColor().darker().darker());
				g2d.drawRect(bbox.x+1, bbox.y, bbox.width-1, bbox.height-2);
			}else {
				if (col == 0) {
					g2d.setColor(table.getGridColor());
					g2d.drawRect(bbox.x, bbox.y, bbox.width-1, bbox.height-1);
					g2d.setColor(table.getGridColor().darker().darker());
					g2d.drawRect(bbox.x, bbox.y, bbox.width-2, bbox.height-2);
				}else {
					g2d.setColor(table.getGridColor());
					g2d.drawRect(bbox.x, bbox.y, bbox.width-1, bbox.height-1);
					g2d.setColor(table.getGridColor().darker().darker());
					g2d.drawRect(bbox.x+1, bbox.y, bbox.width-3, bbox.height-2);
				}
			}
		}
	}
}
