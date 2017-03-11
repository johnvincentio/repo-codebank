<?xml version="1.0"?>
<xsl:stylesheet   version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>

<xsl:variable name="label">XSLT: Attribute Sets for Re-use</xsl:variable>

<!-- The table in this example does not display correctly in Netscape 4.x -->

<xsl:attribute-set name="table-style" >
  <xsl:attribute name="align">center</xsl:attribute>
  <xsl:attribute name="width">75%</xsl:attribute>
  <xsl:attribute name="cellpadding">10</xsl:attribute>
  <xsl:attribute name="border">2</xsl:attribute>
</xsl:attribute-set>

<xsl:attribute-set name="row-style" >
  <xsl:attribute name="bgcolor">#bbbccc</xsl:attribute>
  <xsl:attribute name="bordercolor">#ff0000</xsl:attribute>
  <xsl:attribute name="style">font-family:Helvetica; font-weight:bold;</xsl:attribute>
</xsl:attribute-set>

<xsl:attribute-set name="CD-title-style" >
  <xsl:attribute name="bgcolor">#dddeee</xsl:attribute>
  <xsl:attribute name="style">font-family:Verdana; font-weight:bold; font-style:italic; text-align:center;</xsl:attribute>
</xsl:attribute-set>

<xsl:template match="/">
   <html>  
     <head>
       <title><xsl:value-of select="$label" /></title>
     </head>
     <body>
       <h1><xsl:value-of select="$label" /></h1>

       <!-- Note: XSL as an attribute of HTML table -->
       <table border="2"    xsl:use-attribute-sets="table-style" >
         <xsl:apply-templates select="//CD | //Book"/> 
       </table>
     </body>
   </html>
</xsl:template>

<xsl:template match="CD">
   <tr     xsl:use-attribute-sets="row-style" >
   <td>
   <xsl:text>CD</xsl:text>
   </td>
   <td     xsl:use-attribute-sets="CD-title-style" >
   <xsl:value-of select="Title" />
   </td>
   </tr>
</xsl:template> 

<xsl:template match="Book">
   <tr     xsl:use-attribute-sets="row-style" >
   <td>
   <xsl:text>Book</xsl:text>
   </td>
   <td> <!-- no special style -->
   <xsl:value-of select="Title" />
   </td>
   </tr>
</xsl:template>

</xsl:stylesheet>
