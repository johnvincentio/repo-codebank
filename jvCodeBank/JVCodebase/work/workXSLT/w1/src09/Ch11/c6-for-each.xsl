<?xml version="1.0"?>
<xsl:stylesheet   version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>

<xsl:variable name="label">XSLT: For-Each</xsl:variable>

<xsl:template match="/">
   <html>  
     <head>
       <title><xsl:value-of select="$label" /></title>
     </head>
     <body>
       <h1><xsl:value-of select="$label" /></h1>
       <xsl:apply-templates /> 
     </body>
   </html>
</xsl:template>

<xsl:template match="*"> <!-- note -->

   <h2>CDs in Ascending Order</h2>
   <xsl:for-each select="//CD">
     <xsl:sort order="ascending" />
     <br />
     <xsl:value-of select="name()" />
     <xsl:text> </xsl:text><xsl:number /><xsl:text>: </xsl:text>
     <i><xsl:value-of select="Title" /></i>    
   </xsl:for-each>

   <h2>Books in Ascending Order</h2>
   <xsl:for-each select="//Book">
     <xsl:sort order="ascending" />
     <br />
     <xsl:value-of select="name()" />
     <xsl:text> </xsl:text><xsl:number /><xsl:text>: </xsl:text>
     <i><xsl:value-of select="Title" /></i>    
   </xsl:for-each>

</xsl:template>

</xsl:stylesheet>
