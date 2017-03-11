
/*
 * @(#)Echo10.java 1.5 99/02/09
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

import java.io.*;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;

public class Echo10 extends DefaultHandler
{
    StringBuffer textBuffer;
    
    public static void main(String argv[])
    {
        if (argv.length != 1) {
            System.err.println("Usage: cmd filename");
            System.exit(1);
        }
        
        // Use an instance of ourselves as the SAX event handler
        DefaultHandler handler = new Echo10();
      
        // Use the validating parser
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(true);
        //factory.setNamespaceAware(true);
        try {
            // Set up output stream
            out = new OutputStreamWriter(System.out, "UTF8");

            // Parse the input
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse( new File(argv[0]), handler);

        } catch (SAXParseException spe) {
           // Error generated by the parser
           System.out.println("\n** Parsing error"
              + ", line " + spe.getLineNumber()
              + ", uri " + spe.getSystemId());
           System.out.println("   " + spe.getMessage() );

           // Use the contained exception, if any
           Exception  x = spe;
           if (spe.getException() != null)
               x = spe.getException();
           x.printStackTrace();

        } catch (SAXException sxe) {
           // Error generated by this application
           // (or a parser-initialization error)
           Exception  x = sxe;
           if (sxe.getException() != null)
               x = sxe.getException();
           x.printStackTrace();

        } catch (ParserConfigurationException pce) {
            // Parser with specified options can't be built
            pce.printStackTrace();

        } catch (IOException ioe) {
           // I/O error
           ioe.printStackTrace();

        } catch (Throwable t) {
            t.printStackTrace();
        }
        System.exit(0);
    }

    static private Writer  out;
    private String indentString = "    "; // Amount to indent
    private int indentLevel = 0;

    //===========================================================
    // SAX DocumentHandler methods
    //===========================================================

    public void setDocumentLocator(Locator l)
    {
        // Save this to resolve relative URIs or to give diagnostics.
        try {
          out.write("LOCATOR");
          out.write("\n SYS ID: " + l.getSystemId() );
          out.flush();
        } catch (IOException e) {
            // Ignore errors
        }
    }

    public void startDocument()
    throws SAXException
    {
        nl();
        nl();
        emit("START DOCUMENT");
        nl();
        emit("<?xml version='1.0' encoding='UTF-8'?>");
    }

    public void endDocument()
    throws SAXException
    {
        nl(); 
        emit("END DOCUMENT");
        try {
            nl();
            out.flush();
        } catch (IOException e) {
            throw new SAXException("I/O error", e);
        }
    }

    public void startElement(String namespaceURI,
                             String sName, // simple name
                             String qName, // qualified name
                             Attributes attrs)
    throws SAXException
    {
        echoText();
        indentLevel++;
              nl(); 
        emit("ELEMENT: ");
        String eName = sName; // element name
        if ("".equals(eName)) eName = qName; // not namespaceAware
        emit("<"+eName);
        if (attrs != null) {
            for (int i = 0; i < attrs.getLength(); i++) {
                String aName = attrs.getLocalName(i); // Attr name 
                if ("".equals(aName)) aName = attrs.getQName(i);
                              nl();
                emit("   ATTR: ");
                emit(aName);
                emit("\t\"");
                emit(attrs.getValue(i));
                emit("\"");
            }
        }
        if (attrs.getLength() > 0) nl();
        emit(">");
    }

    public void endElement(String namespaceURI,
                           String sName, // simple name
                           String qName  // qualified name
                          )
    throws SAXException
    {
        echoText();
        nl();
        emit("END_ELM: ");
        String eName = sName; // element name
        if ("".equals(eName)) eName = qName; // not namespaceAware
        emit("</"+eName+">");
        indentLevel--;
    }

    public void characters(char buf[], int offset, int len)
    throws SAXException
    {
        String s = new String(buf, offset, len);
        if (textBuffer == null) {
           textBuffer = new StringBuffer(s);
        } else {
           textBuffer.append(s);
        }
    }
    
    public void ignorableWhitespace(char buf[], int offset, int len)
    throws SAXException
    {
              // Ignore it
    }

      public void processingInstruction(String target, String data)
    throws SAXException
    {
        nl();
        emit("PROCESS: ");
        emit("<?"+target+" "+data+"?>");
    }

      //===========================================================
    // SAX ErrorHandler methods
    //===========================================================

    // treat validation errors as fatal
    public void error(SAXParseException e)
    throws SAXParseException
    {
        throw e;
    }

    // dump warnings too
    public void warning(SAXParseException err)
    throws SAXParseException
    {
        System.out.println("** Warning"
            + ", line " + err.getLineNumber()
            + ", uri " + err.getSystemId());
        System.out.println("   " + err.getMessage());
    }

      //===========================================================
    // Utility Methods ...
    //===========================================================
    
    // Display text accumulated in the character buffer
    private void echoText()
    throws SAXException
    {
        if (textBuffer == null) return;      
              nl(); 
        emit("CHARS:   ");
        String s = ""+textBuffer;
        if (!s.trim().equals("")) emit(s);
              textBuffer = null;
    }

    // Wrap I/O exceptions in SAX exceptions, to
    // suit handler signature requirements
    private void emit(String s)
    throws SAXException
    {
        try {
            out.write(s);
            out.flush();
        } catch (IOException e) {
            throw new SAXException("I/O error", e);
        }
    }

    // Start a new line
    // and indent the next line appropriately
    private void nl()
    throws SAXException
    {
        String lineEnd =  System.getProperty("line.separator");
        try {
            out.write(lineEnd);
            for (int i=0; i < indentLevel; i++) out.write(indentString);
        } catch (IOException e) {
            throw new SAXException("I/O error", e);
        }
    }
}
