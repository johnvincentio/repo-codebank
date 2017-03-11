<?xml version="1.0"?>
<xsl:stylesheet
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  version="1.0">
<xsl:output method="text" indent="yes" />

<xsl:template match="/">
  <xsl:text>...Value of root= </xsl:text>
  <xsl:value-of select="." />
  <xsl:apply-templates />
</xsl:template>

<xsl:template match="Collection">
  <xsl:text>
...Value of /Collection= </xsl:text>
  <xsl:value-of select="." />
  <xsl:apply-templates select="Book"/>
  <xsl:apply-templates select="comment()"/>
  <xsl:apply-templates select="processing-instruction()"/>
</xsl:template>


<xsl:template match="//comment()">
  <xsl:text>
...Value of comment= </xsl:text>
  <xsl:value-of select="." />
</xsl:template>

<xsl:template match="//processing-instruction()">
  <xsl:text>
...Value of processing-instruction(appSpecificPI) = </xsl:text>
  <xsl:value-of select="." />
<!--  <xsl:value-of select="processing-instruction(appSpecificPI)" /> -->
</xsl:template>


<xsl:template match="Book">
  <xsl:text>
... name() = </xsl:text><xsl:value-of select="name()" />
  <xsl:text>
... name(child::*[4]) = </xsl:text><xsl:value-of select="name(child::*[4])" />
  <xsl:text>

... select="//text()"  results:
</xsl:text>
  <xsl:for-each select="//text()" >
   <xsl:value-of select="position()" />
    <xsl:text>. name = {</xsl:text>
    <xsl:value-of select="name()" />
    <xsl:text>}, value = [</xsl:text>
    <xsl:value-of select="normalize-space(.)" />
    <!-- <xsl:value-of select="." /> -->
    <xsl:text>]
</xsl:text>
  </xsl:for-each>

  <xsl:text>
... select="child::*"  results:
</xsl:text>
  <xsl:for-each select="child::*" >
  <!-- same as   <xsl:for-each select="*" > -->
   <xsl:value-of select="position()" />
    <xsl:text>. name = {</xsl:text>
    <xsl:value-of select="name()" />
    <xsl:text>}, value = [</xsl:text>
    <xsl:value-of select="normalize-space(.)" />
    <!-- <xsl:value-of select="." /> -->
    <xsl:text>]
</xsl:text>
  </xsl:for-each>

    <xsl:text>
... select="child::node()"  results:
</xsl:text>
  <xsl:for-each select="child::node()" >
 
   <xsl:value-of select="position()" />
    <xsl:text>. name = {</xsl:text>
    <xsl:value-of select="name()" />
    <xsl:text>}, value = [</xsl:text>
    <xsl:value-of select="." />
    <xsl:text>]
</xsl:text>
  </xsl:for-each>

  <xsl:apply-templates />
</xsl:template>

<xsl:template match="Book/Published">
  <xsl:text>
...Value of /Collection/Book/Published= </xsl:text>
  <xsl:value-of select="." />
  <xsl:text>
...Value of /Collection/Book/Published/@publisher= </xsl:text>
  <xsl:value-of select="@publisher" />
</xsl:template>

<xsl:template match="text()">
</xsl:template>

</xsl:stylesheet>

