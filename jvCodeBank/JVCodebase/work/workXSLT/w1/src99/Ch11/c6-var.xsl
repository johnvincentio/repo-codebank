<?xml version="1.0"?>
<xsl:stylesheet   version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>

<xsl:variable name="label">XSLT: Variable for Re-use</xsl:variable>
<xsl:variable name="ex2"  select="concat('Another ', 'Variable ', 'Example')" />

<xsl:template match="/">
   <html>  
     <head>
       <title><xsl:value-of select="$label" /></title>
     </head>
     <body>
       <h1><xsl:value-of select="$label" /></h1>
       <h2><xsl:value-of select="$ex2" /></h2>
       <xsl:apply-templates select="//CD | //Book"/> 
     </body>
   </html>
</xsl:template>

<xsl:template match="CD">
   <br /><xsl:text>CD title: </xsl:text>
   <i><xsl:value-of select="Title" /></i>
</xsl:template> 

<xsl:template match="Book">
   <br /><xsl:text>Book title: </xsl:text>
   <i><xsl:value-of select="Title" /></i>
</xsl:template> 

</xsl:stylesheet>
