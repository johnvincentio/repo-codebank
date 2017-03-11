<?xml version="1.0"?>
<xsl:stylesheet   version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>

<xsl:variable name="label">XSLT: Sort with Titles Second</xsl:variable>

<xsl:template match="/">
   <html>  
     <head>
       <title><xsl:value-of select="$label" /></title>
     </head>
     <body>
       <h2><xsl:value-of select="$label" /></h2>

       <h3>CDs in Ascending Order</h3>
       <xsl:apply-templates select="//CD" >
         <xsl:sort order="ascending" select="." />  
       </xsl:apply-templates> 

       <h3>Books in Descending Order</h3>
       <xsl:apply-templates select="//Book" >
         <xsl:sort order="descending" select="." />  
       </xsl:apply-templates> 

       <h3>CDs and Books (mixed) in Ascending Order</h3>
       <xsl:apply-templates select="//CD | //Book" >
         <xsl:sort order="ascending" select="." />  
       </xsl:apply-templates> 

     </body>
   </html>
</xsl:template>

<xsl:template match="CD | Book">
   <xsl:value-of select="position()" /><xsl:text>.) </xsl:text>
   <i><xsl:value-of select="Title" /></i>
   <xsl:text> by </xsl:text>
   <b><xsl:value-of select="Author/Name/Last | Artist" /></b>
   <br />
</xsl:template> 

</xsl:stylesheet>
