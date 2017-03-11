<?xml version="1.0"?>
<xsl:stylesheet
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  version="1.0">

<xsl:output method="html"/>

  <xsl:template match="/">
<!-- Take default of 10 iterations.
    <xsl:call-template name="recursive" />
-->
    <xsl:call-template name="recursive">
      <xsl:with-param name="loopControl" select="5" />
    </xsl:call-template>
  </xsl:template>

  <xsl:template name="recursive">
    <!-- Can override loopControl value on initial call to template. -->
    <xsl:param name="loopControl" select="10" />
    <xsl:if test="$loopControl"> <!-- continue if non-zero -->
      <!-- Do something useful here. -->
      <xsl:value-of select="$loopControl" /><br />
      <!-- Recurse but decrement loop control variable first. -->
      <xsl:call-template name="recursive">
        <xsl:with-param name="loopControl" select="$loopControl - 1"/>
      </xsl:call-template>
    </xsl:if>
  </xsl:template>

</xsl:stylesheet>

