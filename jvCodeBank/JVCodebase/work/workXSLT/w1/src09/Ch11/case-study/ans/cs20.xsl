<?xml version='1.0'?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>

<!-- This makes a huge difference with our particular input. -->
<xsl:strip-space elements="*" />

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

<xsl:template match="HC[contains(text(),'For Further Exploration') and 
                     not(contains(text(),'Case Study')) ]">

  <h1 align="center">bookTitle</h1>  
  <h2 align="center">chapNum and chapTitle</h2>   
  <h3 align="center">For Further Exploration</h3>

  <ul style="font-weight: bold;">
      <xsl:apply-templates select="//Link-Title" />
  </ul>

</xsl:template>

<xsl:template match="Link-Title">
 <li><xsl:value-of select="." /></li>
</xsl:template>

<xsl:template match="text()">
</xsl:template>

</xsl:stylesheet>
