<?xml version="1.0"?>
<xsl:stylesheet   version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>

<xsl:variable name="label">XSLT: Choose/When Test</xsl:variable>

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

<xsl:template match="CD | Book | Owner">
   <br />
   <xsl:choose>
     <xsl:when test="local-name() = 'CD'">
       <xsl:text>CD: </xsl:text>
       <i><xsl:value-of select="Title" /></i>
     </xsl:when>

     <xsl:when test="local-name() = 'Book'">
       <xsl:text>Book: </xsl:text>
       <i><xsl:value-of select="Title" /></i>
     </xsl:when>

     <xsl:otherwise>
       <xsl:text>{Skipping Owner} </xsl:text>
       <i><xsl:value-of select="Name" /></i>
     </xsl:otherwise>
   </xsl:choose>

</xsl:template> 

</xsl:stylesheet>
