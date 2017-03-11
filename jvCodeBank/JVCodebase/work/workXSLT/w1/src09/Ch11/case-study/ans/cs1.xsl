<?xml version='1.0'?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>

<!-- This makes a huge difference with our particular input. -->
<xsl:strip-space elements="*" />

<!-- TBD variables, parameters, and style -->

<xsl:template match="/">
   <html> 
     <head>  
       <title>
       Chapter number and title will go here.
       </title>
     </head>
     <body>
       <xsl:apply-templates select="XML"/> 
     </body>
   </html>
</xsl:template>

<xsl:template match="FOOTNOTES">
  <h3>Chapter has 
<xsl:value-of select="count(FOOTNOTE)"/> footnotes.</h3>
</xsl:template>

<!-- TBD template to handle HC = "For Further Exploration" -->
<xsl:template match="HC">
  <xsl:value-of select="."/><br/>
</xsl:template>

<xsl:template match="text()">
</xsl:template>

</xsl:stylesheet>
