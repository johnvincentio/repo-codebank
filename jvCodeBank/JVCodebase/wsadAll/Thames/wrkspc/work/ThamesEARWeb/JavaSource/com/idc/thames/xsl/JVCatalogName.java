
package com.idc.thames.xsl;

public class JVCatalogName {
	int catalogid;
	String ds;

	public JVCatalogName(int i, String c){
		Debug.println(" i "+i+" c "+c+":");
		catalogid = i;
		ds = c;
	}
	public int getCatalogid() {return catalogid;}
	public String getDs() {return ds;}
}

