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

     <xsl:when test="name() = 'CD'">
       <xsl:text>CD: </xsl:text>
     </xsl:when>

     <xsl:when test="name() = 'Book'">
       <xsl:text>Book: </xsl:text>
       <xsl:if test="position() = last()">
         <xsl:text>  {Last Entry}</xsl:text>
       </xsl:if>
       <xsl:if test="/Collection/Book[not(last())]">
         <xsl:text>  NOT last Book title: </xsl:text>
       </xsl:if>
     </xsl:when>

     <xsl:otherwise>
       <xsl:text>{skipping Owner}</xsl:text>
     </xsl:otherwise>
   </xsl:choose>
   <i><xsl:value-of select="Title" /></i>

</xsl:template> 

</xsl:stylesheet>
