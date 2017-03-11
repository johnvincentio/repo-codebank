
package webclient1.saaj;

import java.util.*;
import java.io.*;

public class JVBarcodes implements Serializable {

	private ArrayList m_list = new ArrayList();

	public JVBarcodes() {}

	public void addBarcode(JVBarcode i) {
		System.out.println("--- addBarcode");
		m_list.add(i);
	}
	public Iterator getBarcodes() {return m_list.iterator();}
}
