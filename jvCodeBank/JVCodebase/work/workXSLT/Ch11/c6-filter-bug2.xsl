<?xml version="1.0"?>
<xsl:stylesheet   version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>

<xsl:template match="/">
   <html>  
     <head>
       <title>XSLT: Filtering Titles</title>
     </head>
     <body>
       <h1>XSLT: Filtering Titles</h1>
       <xsl:apply-templates />
     </body>
   </html>
</xsl:template>

<xsl:template match="//CD">
   <br /><xsl:text>CD title: </xsl:text>
   <i><xsl:value-of select="Title" /></i>
</xsl:template> 

<xsl:template match="//Book">
   <br /><xsl:text>Book title: </xsl:text>
   <i><xsl:value-of select="Title" /></i>
</xsl:template> 

<xsl:template match="*">
   <br /><xsl:text>name: </xsl:text>
   <xsl:value-of select="name()" />
   <xsl:apply-templates />
</xsl:template>


</xsl:stylesheet>
