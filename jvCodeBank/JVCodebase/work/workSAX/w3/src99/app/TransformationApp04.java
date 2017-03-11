
/*
 * @(#)TransformationApp04.java	1.9 98/11/10
 *
 * Copyright (c) 2004 Sun Microsystems, Inc.  All rights reserved.  U.S.
 * Government Rights - Commercial software.  Government users are subject
 * to the Sun Microsystems, Inc. standard license agreement and
 * applicable provisions of the FAR and its supplements.  Use is subject
 * to license terms. 
 *
 * This distribution may include materials developed by third parties.
 * Sun, Sun Microsystems, the Sun logo, Java and J2EE are trademarks
 * or registered trademarks of Sun Microsystems, Inc. in the U.S. and
 * other countries. 
 *
 * Copyright (c) 2004 Sun Microsystems, Inc. Tous droits reserves.
 *
 * Droits du gouvernement americain, utilisateurs gouvernementaux - logiciel
 * commercial. Les utilisateurs gouvernementaux sont soumis au contrat de
 * licence standard de Sun Microsystems, Inc., ainsi qu'aux dispositions
 * en vigueur de la FAR (Federal Acquisition Regulations) et des
 * supplements a celles-ci.  Distribue par des licences qui en
 * restreignent l'utilisation.
 *
 * Cette distribution peut comprendre des composants developpes par des
 * tierces parties. Sun, Sun Microsystems, le logo Sun, Java et J2EE
 * sont des marques de fabrique ou des marques deposees de Sun
 * Microsystems, Inc. aux Etats-Unis et dans d'autres pays.
 */

import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.FactoryConfigurationError;  
import javax.xml.parsers.ParserConfigurationException;
 
import org.xml.sax.SAXException;  
import org.xml.sax.SAXParseException;  
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;



// For write operation
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerConfigurationException;

import javax.xml.transform.sax.SAXSource;  
import javax.xml.transform.stream.StreamResult; 

import java.io.*;

public class TransformationApp04{

    public static void main (String argv [])
    {
        if (argv.length != 1) {
            System.err.println ("Usage: java TransformationApp filename");
            System.exit (1);
        }

              // Create the sax "parser".
        AddressBookReader02 saxReader = new AddressBookReader02();
        try {
            File f = new File(argv[0]);
                                        
            // Use a Transformer for output
            TransformerFactory tFactory =
                TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
                                                   
            // Use the parser as a SAX source for input
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            InputSource inputSource = new InputSource(fr);
            SAXSource source = new SAXSource(saxReader, inputSource);
            StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);
           
                   
        } catch (TransformerConfigurationException tce) {
           // Error generated by the parser
           System.out.println ("\n** Transformer Factory error");
           System.out.println("   " + tce.getMessage() );

           // Use the contained exception, if any
           Throwable x = tce;
           if (tce.getException() != null)
               x = tce.getException();
           x.printStackTrace();
      
        } catch (TransformerException te) {
           // Error generated by the parser
           System.out.println ("\n** Transformation error");
           System.out.println("   " + te.getMessage() );

           // Use the contained exception, if any
           Throwable x = te;
           if (te.getException() != null)
               x = te.getException();
           x.printStackTrace();
           
               } catch (IOException ioe) {
           // I/O error
           ioe.printStackTrace();
        }

    } // main  

}
