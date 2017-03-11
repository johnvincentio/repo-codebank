
package com.idc.saaj;

import java.util.Iterator;

import javax.xml.soap.*;

public class ReceivingServlet extends SAAJServlet {

	public SOAPMessage onMessage(SOAPMessage soapMessage) {
		AttachmentPart attachmentPart;
		SOAPBodyElement bodyElement1;
		SOAPElement elem1, elem2;

		JVBarcodes barcodes = new JVBarcodes();
		String strNodeName, strNodeValue;
		int nBarcodeid, nItemid;
		String strCompany, strImageurl, strName, strDs;

		System.out.println(">>> onMessage");
		try {
			System.out.println("stage 1");
			System.out.println("Here's the message: "); // Yuk...
			soapMessage.writeTo(System.out);	// but OK for now

			SOAPHeader soapHeader = soapMessage.getSOAPHeader();
			SOAPBody soapBody = soapMessage.getSOAPBody();

			System.out.println("stage 2");
			Iterator bodyIter1 = soapBody.getChildElements();
			System.out.println("stage 3");
			bodyElement1 = (SOAPBodyElement) bodyIter1.next();
			System.out.println("stage 4");
			Iterator bodyIter2 = bodyElement1.getChildElements();

			while (bodyIter2.hasNext()) {
				System.out.println("stage 5");
				elem1 = (SOAPElement) bodyIter2.next();
				strNodeName = elem1.getElementName().getLocalName();
				System.out.println("strNodeName "+strNodeName);
				if (! strNodeName.equals("Barcode")) break;

				System.out.println("stage 5");
				Iterator bodyIter3 = elem1.getChildElements();

				nBarcodeid = nItemid = -1;
				strCompany = strImageurl = strName = strDs = "";
				while (bodyIter3.hasNext()) {
					System.out.println("stage 6");
					elem2 = (SOAPElement) bodyIter3.next();
					strNodeName = elem2.getElementName().getLocalName();
					strNodeValue = elem2.getValue();
					System.out.println("strNodeName "+strNodeName);
					System.out.println("strNodeValue "+strNodeValue);
					if (strNodeName.equals("Barcodeid"))
						nBarcodeid = (new Integer(strNodeValue).intValue());
					else if (strNodeName.equals("Itemid"))
						nItemid = (new Integer(strNodeValue).intValue());
					else if (strNodeName.equals("Company"))
						strCompany = strNodeValue;
					else if (strNodeName.equals("Imageurl"))
						strImageurl = strNodeValue;
					else if (strNodeName.equals("Name"))
						strName = strNodeValue;
					else if (strNodeName.equals("Description"))
						strDs = strNodeValue;
					else if (strNodeName.equals("Imageid"))
						;
					else
						throw new Exception ("unknown node name "+strNodeName);
				}
				barcodes.addBarcode (
					new JVBarcode (nBarcodeid, nItemid, strCompany, strImageurl,
							strName, strDs));
			}

//	get attachments - do nothing with them for now...

			System.out.println("stage 10");
			Iterator iter = soapMessage.getAttachments();
			System.out.println("stage 11");
			while (iter.hasNext()) {
				System.out.println("stage 12");
				attachmentPart = (AttachmentPart) iter.next();
				System.out.println("stage 13");
				String id = attachmentPart.getContentId();
				String type = attachmentPart.getContentType();
				System.out.println("Attachment; Id "+id+" type "+type);
			}
			System.out.println("stage 20");

// make a response....

			SOAPMessage msg = msgFactory.createMessage();
			SOAPEnvelope env = msg.getSOAPPart().getEnvelope();
			env.getBody()
				.addChildElement (env.createName ("Answer"))
				.addTextNode ("Silly answer");
			return msg;
		}
		catch(Exception ex) {
			System.out.println("Exception; "+ex.getMessage());
            return null;
        }
    }
}

