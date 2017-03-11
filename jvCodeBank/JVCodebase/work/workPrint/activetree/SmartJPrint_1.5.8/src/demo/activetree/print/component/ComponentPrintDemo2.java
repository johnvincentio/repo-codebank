/**
 * Source: ComponentPrintDemo2.java
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

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.*;

import com.activetree.print.AtComponentPrinter;
import com.activetree.print.PageNoPainter;

public class ComponentPrintDemo2 extends PrintFrame {
	private JPanel canvas = null;

	public ComponentPrintDemo2() {
		super();
		frame.setTitle("Smart JPrint - Printing any Component");
		setPrintableComponent(sampleComponent());
	}

	public void actionPerformed(ActionEvent evt) {
		AtComponentPrinter printer = new AtComponentPrinter();

		if (evt.getActionCommand().equals("Print")) {
			printer.print(canvas, PageNoPainter.LOWER_CENTER);
		}else if (evt.getActionCommand().equals("Generate PDF")) {
			//pdfPrinter.setCopies(3);
			super.printAsPdf(canvas, pdfPrinter);
		}else if (evt.getActionCommand().equals("Preview")) {
			printer.preview(canvas, PageNoPainter.LOWER_CENTER, true, frame);
		}
	}

	private Component sampleComponent() {
		ImageIcon icon = new ImageIcon(getClass().getResource("/demo/activetree/image/winter.jpg"));
		final Image image = icon.getImage();
		canvas = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(SystemColor.white);
				g.fillRect(0, 0, getWidth(), getHeight());
				g.drawImage(image, 10, 10, image.getWidth(null), image.getHeight(null), null);
			}
		};

		JPanel top = new JPanel(new BorderLayout());
		JScrollPane scroll = new JScrollPane(canvas);
		top.add(scroll, BorderLayout.CENTER);
		canvas.setPreferredSize(new Dimension(image.getWidth(null),
		                                      image.getHeight(null)-10));
		return top;
	}

	public static void main(String[] args) {
		if (args != null && args.length >= 1) {
			com.activetree.common.SmartJPrint.setLicenseKey(args[0]);
		}
		else {
			System.out.println("Usage: java " + ComponentPrintDemo2.class.getName() + " licenseKey");
			System.exit(0);
		}

		PrintFrame demo = new ComponentPrintDemo2();
		demo.postInit();
		demo.setVisible(true);
	}
}

