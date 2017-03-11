<?xml version="1.0"?>
<xsl:stylesheet   version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>

<xsl:variable name="label">XSLT: If Test</xsl:variable>

<xsl:template match="/">
   <html>  
     <head>
       <title><xsl:value-of select="$label" /></title>
     </head>
     <body>
       <h1><xsl:value-of select="$label" /></h1>
       <xsl:apply-templates select="//CD | //Book"/> 
     </body>
   </html>
</xsl:template>

<xsl:template match="CD | Book">
   <br />
   <xsl:if test="name() = 'CD'">
     <xsl:text>CD title: </xsl:text>
     <xsl:apply-templates select="Chart/Peak" />
   </xsl:if>

   <xsl:if test="name() = 'Book'">
     <xsl:text>Book title: </xsl:text>
     <xsl:apply-templates select="Published" />
   </xsl:if>

   <i><xsl:value-of select="Title" /></i>

   <xsl:if test="position() = last()">
     <xsl:text> {Last Entry}</xsl:text>
   </xsl:if>
</xsl:template> 

<xsl:template match="Published" >
  <br /><b><xsl:value-of select="attribute::publisher" /></b><br />
</xsl:template> 

<xsl:template match="Peak" >
  <br /><b><xsl:value-of select="attribute::node()" /></b><br />
  <br /><b>weeks: <xsl:value-of select="attribute::weeks" /></b><br />
</xsl:template>

</xsl:stylesheet>
