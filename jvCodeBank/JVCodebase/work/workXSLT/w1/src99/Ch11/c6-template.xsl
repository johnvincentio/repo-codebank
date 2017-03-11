<?xml version="1.0"?>
<xsl:stylesheet
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  version="1.0">

<!-- Other top level elements, if needed, such as:
etc.
-->
<xsl:output method="html"/>
<xsl:variable name="label">Some String</xsl:variable>



  <!-- One or more templates -->
  <xsl:template match="/">
    <!-- XSLT Instructions and/or Literal Result Elements -->
    <xsl:apply-templates/>
  </xsl:template>

  <xsl:template match="*">
    <!-- p --> <!-- Do something and then process children -->
      <xsl:apply-templates/>
    <!-- /p -->
  </xsl:template>
</xsl:stylesheet>

