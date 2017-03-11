<?xml version='1.0'?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>

<!-- This makes a huge difference with our particular input. -->
<xsl:strip-space elements="*" />

<!-- Constants -->
<xsl:variable name="bookTitle">XML Family of Specifications: A Practical Guide</xsl:variable>
<xsl:variable name="isbn">0-201-70359-9</xsl:variable>
<xsl:variable name="author">Ken Sall</xsl:variable>
<xsl:variable name="publisher">ADDISON WESLEY LONGMAN, INC.</xsl:variable>

<!-- Default values; override by command line param passing. -->
<xsl:param name="chapNum" >0000</xsl:param>
<xsl:param name="chapTitle" >Unspecified Chapter Title</xsl:param>

<xsl:template match="/">
   <html> 
     <head>  
       <title>
       Ch. <xsl:value-of select="$chapNum"/>: <xsl:value-of select="$chapTitle"/>
       </title>
     </head>
     <body>
       <xsl:apply-templates select="XML"/> 
     </body>
   </html>
</xsl:template>

<xsl:template match="FOOTNOTES">
  <h3>Chapter <xsl:value-of select="$chapNum"/> has 
<xsl:value-of select="count(FOOTNOTE)"/> footnotes.</h3>
</xsl:template>

<xsl:template match="HC[contains(text(),'For Further Exploration') and 
                     not(contains(text(),'Case Study')) ]">

  <h1 align="center"><xsl:value-of select="$bookTitle"/></h1>    
  <h2 align="center">Ch. <xsl:value-of select="$chapNum"/>: 
      <xsl:value-of select="$chapTitle"/></h2>  
  <h3 align="center">For Further Exploration</h3>

  <ul style="font-weight: bold;">
      <xsl:apply-templates select="//Link-Title" />
  </ul>

</xsl:template>

<xsl:template match="Link-Title">
<!-- Initially try just the title...
 <li><xsl:value-of select="." /></li>
 ...and then replace with the real link create instructions.
-->
 <li>
   <xsl:element name="a" >
     <xsl:attribute name="href">
       <xsl:value-of select="normalize-space(following-sibling::Link-URL[1])" />
     </xsl:attribute>
     <xsl:value-of select="." />
   </xsl:element>
 </li>

</xsl:template>

<xsl:template match="text()">
</xsl:template>

</xsl:stylesheet>
