<?xml version="1.0"?>
<!DOCTYPE xsl:stylesheet  [
<!ENTITY copy  "&#169;">
<!ENTITY nbsp  "&#160;"> <!-- or &#xA0; -->
<!ENTITY alpha "&#945;">
<!ENTITY beta  "&#946;">
<!ENTITY gamma "&#947;">
<!ENTITY circ  "&#710;">
]>
<xsl:stylesheet   version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" indent="yes"/>

<xsl:variable name="label">XSLT: Disable Output Escaping</xsl:variable>

<xsl:template match="/">
   <html>  
     <head>
       <title><xsl:value-of select="$label" /></title>
     </head>
     <body>
       <h1><xsl:value-of select="$label" /></h1>
       <h3>View HTML Source for Differences</h3>
       <xsl:apply-templates select="//Book"/>
     </body>
   </html>
</xsl:template>

<xsl:template match="Book[3]">
   <p><xsl:text>Book title: </xsl:text>
   <i><xsl:value-of select="Title" /></i>

   <br />  <!-- correct since default is NOT to disable escaping -->
   default: <xsl:text disable-output-escaping="yes"> &amp;nbsp; &amp;nbsp; &amp;nbsp; &amp;nbsp;</xsl:text>
   Copyright <xsl:text>&copy;</xsl:text>
   <xsl:value-of select="Published" />

   <br />  <!-- correct -->
   disable=no:<xsl:text disable-output-escaping="yes">&amp;nbsp;</xsl:text>
   Copyright <xsl:text disable-output-escaping="no">&copy;</xsl:text>
   <xsl:value-of select="Published" />

   <br />  <!-- correct, except not for XML output -->
   disable=yes: 
   Copyright <xsl:text disable-output-escaping="yes">&copy;</xsl:text>
   <xsl:value-of select="Published" />
   </p>

   Copyright as hex (xA9): <xsl:text>&#xA9; and as decimal (169): &#169;</xsl:text>
   <br /> 
   disable=no (numeric):
   <xsl:text disable-output-escaping="no"> &#945; &#946; &#947; &#169; &#710;</xsl:text>
   <br /> 
   disable=yes (numeric): 
   <xsl:text disable-output-escaping="yes"> &#945; &#946; &#947; &#169; &#710;</xsl:text>
   <br />
   disable=no (internally defined symbols):
   <xsl:text disable-output-escaping="no"> &alpha; &beta; &gamma; &copy; &circ;</xsl:text>
   <br /> 
   disable=yes (internally defined symbols): 
   <xsl:text disable-output-escaping="yes"> &alpha; &beta; &gamma; &copy; &circ;</xsl:text>
   <br />
   disable=no:
   <xsl:text disable-output-escaping="no">3 nbsp:[&nbsp;&nbsp;&nbsp;] &lt; &gt; &amp; &quot; &apos;</xsl:text>
   <br /> 
   disable=yes: 
   <xsl:text disable-output-escaping="yes">3 nbsp:[&nbsp;&nbsp;&nbsp;] &lt; &gt; &amp; &quot; &apos;</xsl:text>
   <br /> 

</xsl:template> 

<xsl:template match="*"> 
</xsl:template> 

</xsl:stylesheet>
