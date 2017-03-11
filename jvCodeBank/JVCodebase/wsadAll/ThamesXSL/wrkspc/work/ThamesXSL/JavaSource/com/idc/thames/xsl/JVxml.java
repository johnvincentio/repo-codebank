
package com.idc.thames.xsl;

import com.idc.trace.Debug;
import java.util.Iterator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

public class JVxml {
	public JVxml() {}

	public Document makeCart(JVCart cart) {
		JVItem item;
		Element topElem, secondElem, elem;
		DocumentBuilderFactory docBuilderFactory;
		DocumentBuilder docBuilder;
		Document doc = null;

		Debug.println (">>> makeCart");
		try {
			docBuilderFactory = DocumentBuilderFactory.newInstance();
			docBuilderFactory.setNamespaceAware(false);
			docBuilder = docBuilderFactory.newDocumentBuilder();
			doc = docBuilder.newDocument();	  

			topElem = doc.createElement("Data");
			doc.appendChild(topElem);

			elem = doc.createElement("Title");
			elem.appendChild(doc.createTextNode("Thames Books"));
			topElem.appendChild(elem);

			elem = doc.createElement("Header");
			elem.appendChild(doc.createTextNode("Contents of Cart"));
			topElem.appendChild(elem);

			secondElem = doc.createElement("Message");
			topElem.appendChild(secondElem);

			elem = doc.createElement("Header");
			elem.appendChild(doc.createTextNode("Message_Header"));
			secondElem.appendChild(elem);

			elem = doc.createElement("Text");
			elem.appendChild(doc.createTextNode("Message_Text"));
			secondElem.appendChild(elem);

			Iterator iter = cart.getItems();
			while (iter.hasNext()) {
				item = (JVItem) iter.next();
				Debug.println("Itemid "+item.getItemid());

				secondElem = doc.createElement("Item");
				topElem.appendChild(secondElem);

				elem = doc.createElement("Cartid");
				elem.appendChild(doc.createTextNode(
						Integer.toString(item.getCartid())));
				secondElem.appendChild(elem);

				elem = doc.createElement("Itemid");
				elem.appendChild(doc.createTextNode(
						Integer.toString(item.getItemid())));
				secondElem.appendChild(elem);

				elem = doc.createElement("Catalog");
				elem.appendChild(doc.createTextNode(item.getCatalog()));
				secondElem.appendChild(elem);

				elem = doc.createElement("Sds");
				elem.appendChild(doc.createTextNode(item.getSds()));
				secondElem.appendChild(elem);

				elem = doc.createElement("Lds");
				elem.appendChild(doc.createTextNode(item.getLds()));
				secondElem.appendChild(elem);

				elem = doc.createElement("Quantity");
				elem.appendChild(doc.createTextNode(
						Integer.toString(item.getQuantity())));
				secondElem.appendChild(elem);

				elem = doc.createElement("Price");
				elem.appendChild(doc.createTextNode(
						Integer.toString(item.getPrice())));
				secondElem.appendChild(elem);

				elem = doc.createElement("Total");
				elem.appendChild(doc.createTextNode(
						Integer.toString(item.getPrice()*item.getQuantity())));
				secondElem.appendChild(elem);
			}
			elem = doc.createElement("GrandTotal");
//			elem.appendChild(doc.createTextNode(Double.toString(cart.computeTotal())));
			elem.appendChild(doc.createTextNode(Integer.toString(cart.computeTotal())));
			topElem.appendChild(elem);
		}
		catch (ParserConfigurationException pcex) {
			Debug.println("ParserConfigurationException "+pcex.getMessage());
		}
		catch (Exception ex) {
			Debug.println("Exception "+ex.getMessage());
		}
		Debug.println ("<<< makeCart");
		return doc;
	}

	public Document makeCatalog(JVCatalog catalog) {
		JVCatalogItem item;
		Element topElem, secondElem, elem;
		DocumentBuilderFactory docBuilderFactory;
		DocumentBuilder docBuilder;
		Document doc = null;

		Debug.println (">>> makeCatalog;");
		try {
			docBuilderFactory = DocumentBuilderFactory.newInstance();
//			docBuilderFactory.setNamespaceAware(true);
			docBuilderFactory.setNamespaceAware(false);
			docBuilder = docBuilderFactory.newDocumentBuilder();
			doc = docBuilder.newDocument();	  

			topElem = doc.createElement("Data");
/*
		topElem.setAttribute("xmlns:xsi", 
				"http://www.w3.org/2001/XMLSchema-instance");
		topElem.setAttribute("xsi:schemaLocation",
				"http://java.sun.com/blueprints/ns/invoice " + 
				"http://java.sun.com/blueprints/schemas/invoice-lodging.xsd");
		topElem.setAttribute("xmlns", 
				"http://java.sun.com/blueprints/ns/invoice");
*/

			doc.appendChild(topElem);

			elem = doc.createElement("Title");
			elem.appendChild(doc.createTextNode("Thames Books"));
			topElem.appendChild(elem);

			elem = doc.createElement("Header");
			elem.appendChild(doc.createTextNode("Contents of Catalog"));
			topElem.appendChild(elem);

			secondElem = doc.createElement("Message");
			topElem.appendChild(secondElem);

			elem = doc.createElement("Header");
			elem.appendChild(doc.createTextNode("Message_Header"));
			secondElem.appendChild(elem);

			elem = doc.createElement("Text");
			elem.appendChild(doc.createTextNode("Message_Text"));
			secondElem.appendChild(elem);

			Iterator iter = catalog.getItems();
			while (iter.hasNext()) {
				item = (JVCatalogItem) iter.next();
				Debug.println("Itemid "+item.getItemid());

				secondElem = doc.createElement("Item");
				topElem.appendChild(secondElem);

				elem = doc.createElement("Itemid");
				elem.appendChild(doc.createTextNode(
						Integer.toString(item.getItemid())));
				secondElem.appendChild(elem);

				elem = doc.createElement("Catalogid");
				elem.appendChild(doc.createTextNode(
						Integer.toString(item.getCatalogid())));
				secondElem.appendChild(elem);

				elem = doc.createElement("Sds");
				elem.appendChild(doc.createTextNode(item.getSds()));
				secondElem.appendChild(elem);

				elem = doc.createElement("Lds");
				elem.appendChild(doc.createTextNode(item.getLds()));
				secondElem.appendChild(elem);

				elem = doc.createElement("Price");
				elem.appendChild(doc.createTextNode(
						Integer.toString(item.getPrice())));
				secondElem.appendChild(elem);
			}
		}
		catch (ParserConfigurationException pcex) {
			Debug.println("ParserConfigurationException "+pcex.getMessage());
		}
/*
		catch (TransformerConfigurationException tcex) {
			Debug.println("TransformerConfigurationException "+tcex.getMessage());
		}
		catch (TransformerException tex) {
			Debug.println("TransformerException "+tex.getMessage());
		}
		catch (UnsupportedEncodingException ueex) {
			Debug.println("UnsupportedEncodingException "+ueex.getMessage());
		}
*/
		catch (Exception ex) {
			Debug.println("Exception "+ex.getMessage());
		}
		Debug.println ("<<< makeCatalog");
		return doc;
	}

	public Document makeError (String strHeader, String strText) {
		Element topElem, secondElem, elem;
		DocumentBuilderFactory docBuilderFactory;
		DocumentBuilder docBuilder;
		Document doc = null;

		Debug.println (">>> makeError;");
		try {
			docBuilderFactory = DocumentBuilderFactory.newInstance();
//			docBuilderFactory.setNamespaceAware(true);
			docBuilderFactory.setNamespaceAware(false);
			docBuilder = docBuilderFactory.newDocumentBuilder();
			doc = docBuilder.newDocument();	  

			topElem = doc.createElement("Data");
			doc.appendChild(topElem);

			elem = doc.createElement("Title");
			elem.appendChild(doc.createTextNode("Thames Books"));
			topElem.appendChild(elem);

			elem = doc.createElement("Header");
			elem.appendChild(doc.createTextNode("An error has occured"));
			topElem.appendChild(elem);

			secondElem = doc.createElement("Message");
			topElem.appendChild(secondElem);

			elem = doc.createElement("Header");
			elem.appendChild(doc.createTextNode(strHeader));
			secondElem.appendChild(elem);

			elem = doc.createElement("Text");
			elem.appendChild(doc.createTextNode(strText));
			secondElem.appendChild(elem);
		}
		catch (Exception ex) {
			Debug.println("Exception "+ex.getMessage());
		}
		Debug.println ("<<< makeError");
		return doc;
	}
}
