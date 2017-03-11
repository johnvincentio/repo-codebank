<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

<xsl:output method="html" />

<xsl:template match="/">
  <xsl:apply-templates />
</xsl:template>

<xsl:template match="hello-goodbye">
  <p><xsl:message>got hello-goodbye</xsl:message></p>
  <xsl:apply-templates /> <!-- important -->
</xsl:template>

<xsl:template match="hi">
  <p><b><xsl:value-of select="."/></b></p>
</xsl:template>

<xsl:template match="bye">
  <p><i><xsl:value-of select="."/></i></p>
</xsl:template>

</xsl:stylesheet>
