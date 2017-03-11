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
       <xsl:apply-templates select="Collection/CD | //Book"/>
       <!-- In this example,  Collection/CD = //CD and
            Collection/Book = //Book.
       -->
     </body>
   </html>
</xsl:template>

<xsl:template match="CD">
   <br />CD title: 
   <i><xsl:value-of select="Title" /></i>
</xsl:template> 

<xsl:template match="Book">
   <br />Book title: 
   <i><xsl:value-of select="Title" /></i>
</xsl:template> 

</xsl:stylesheet>
