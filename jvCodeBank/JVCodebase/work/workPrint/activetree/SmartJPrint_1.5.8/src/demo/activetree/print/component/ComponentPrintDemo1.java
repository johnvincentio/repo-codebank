/**
 * Source: ComponentPrintDemo1.java
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
package demo.activetree.print.component;

import demo.activetree.print.PrintFrame;
import com.activetree.print.PageNoPainter;
import com.activetree.print.AtComponentPrinter;
import com.activetree.common.SmartJPrint;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.*;

public class ComponentPrintDemo1 extends PrintFrame {
	private Component canvas = null;

	public ComponentPrintDemo1() {
		super();
		frame.setTitle("Smart JPrint - Printing any Component");
		setPrintableComponent(sampleComponent());
	}

	public void actionPerformed(ActionEvent evt) {
		AtComponentPrinter printer = new AtComponentPrinter();

		if (evt.getActionCommand().equals("Print")) {
			printer.print(canvas); //, PageNoPainter.LOWER_CENTER);
		}else if (evt.getActionCommand().equals("Generate PDF")) {
			//pdfPrinter.setCopies(3);
			super.printAsPdf(canvas, pdfPrinter);
		}else if (evt.getActionCommand().equals("Preview")) {
			printer.preview(canvas, PageNoPainter.LOWER_CENTER, true, frame);
		}
	}

	private Component sampleComponent() {
		canvas = new Canvas() {
			public void paint(Graphics g) {
				super.paint(g);
				Graphics2D g2d = (Graphics2D)g;

				g2d.setColor(SystemColor.white);
				g2d.fill(new Rectangle(0, 0, getWidth(), getHeight()));

				int y = 10;
				g2d.setColor(SystemColor.blue.darker().darker());
				for (int row=0; row < 5; row++) {
					int x = 10;
					for (int col=0; col < 5; col++) {
            if (row == 0) {
	            g2d.draw(new Rectangle(x, y, 150, 150));
            }
						if (row == 1) {
							g2d.drawArc(x, y, 150, 150, 0, 360);
						}
						if (row == 2) {
							g2d.drawOval(x, y, 150, 150);
						}
						if (row == 3) {
							g2d.drawArc(x, y, 150, 150, 0, 360);
							g2d.drawString("Smart JPrint", x+40, y+70);
						}
						if (row == 4) {
							g2d.drawRoundRect(x, y, 150, 150, 20, 20);
						}
						x += 150;
						x += 50;
					}

					y += 150;
					y+= 50;
				}
			}
		};

    canvas.setSize(new Dimension(1100, 1100));
		JPanel top = new JPanel(new BorderLayout());
		ScrollPane scroll = new ScrollPane();
    scroll.add(canvas);
		top.add(scroll, BorderLayout.CENTER);
		return top;
	}

	public static void main(String[] args) {
		if (args != null && args.length >= 1) {
			SmartJPrint.setLicenseKey(args[0]);
		}
		else {
			System.out.println("Usage: java "
                         + ComponentPrintDemo1.class.getName()
                         + " licenseKey");
			System.exit(0);
		}

		PrintFrame demo = new ComponentPrintDemo1();
		demo.postInit();
		demo.setVisible(true);
	}
}
