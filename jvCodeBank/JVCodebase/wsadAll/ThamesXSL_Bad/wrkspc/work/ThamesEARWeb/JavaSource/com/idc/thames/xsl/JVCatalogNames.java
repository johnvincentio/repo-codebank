
package com.idc.thames.xsl;

import java.util.*;

public class JVCatalogNames {

	private ArrayList list = new ArrayList();

	public JVCatalogNames() {}

	public void addItem(JVCatalogName name) {list.add(name);}
	public Iterator getItems() {return list.iterator();}
	public StringBuffer toXML() {
		JVCatalogName name;
		StringBuffer sb = new StringBuffer();

//		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		sb.append("<?xml version='1.0' encoding='UTF-8'?>\n");	
		sb.append("<Data>\n");
		sb.append("\t<Title>Catalogs</Title>\n");
		sb.append("\t<Header>Please choose from the following catalogs</Header>\n");
		sb.append("\t<Catalogs>\n");

		Iterator iterator = getItems();
		while (iterator.hasNext()) {
			name = (JVCatalogName) iterator.next();						
			sb.append("\t\t<Catalog>\n");
			sb.append("\t\t\t<Id>").append(name.getCatalogid()).append("</Id>\n");
			sb.append("\t\t\t<Description>").append(name.getDs()).append("</Description>\n");
			sb.append("\t\t</Catalog>\n");
		}
		sb.append("\t</Catalogs>\n");
		sb.append("</Data>\n");
		return sb;
	}
}


