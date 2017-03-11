
package com.idc.thames.xsl;

import com.idc.trace.Debug;
import java.util.*;

public class JVCart {

	private ArrayList list = new ArrayList();

	public JVCart() {}

	public void addItem(JVItem i) {
		Debug.println("--- addItem");
		list.add(i);
	}
	public Iterator getItems() {return list.iterator();}

	public int computeTotal() {
		Iterator iterator = list.iterator();
		int total = 0;
		while(iterator.hasNext()) {
			JVItem item = (JVItem)iterator.next();
			total = total + item.getQuantity() * item.getPrice();
		}
		return total;
	}
}

