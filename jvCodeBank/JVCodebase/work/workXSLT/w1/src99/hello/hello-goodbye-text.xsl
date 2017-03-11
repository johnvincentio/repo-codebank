<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

<!-- Only change from hello-goodbye.xsl output method. -->
<xsl:output method="text" />

<xsl:template match="/"> 
  <xsl:apply-templates />
</xsl:template>

<xsl:template match="hi">
  <p><b><xsl:value-of select="."/></b></p>
</xsl:template>

<xsl:template match="bye">
  <p><i><xsl:value-of select="."/></i></p>
</xsl:template>

</xsl:stylesheet>
