<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:str="http://xsltsl.sourceforge.net/string"
	extension-element-prefixes="str">
<!-- 
     Imported stylesheet from the XSLT Standard Library,
     http://sourceforge.net/projects/xsltsl/

     This example will fail if the imported stylesheet
     hasn't been downloaded into the same directory as 
     the current stylesheet; otherwise, adjust 'href' below.
-->
<xsl:import href="string.xsl" />

<xsl:output method="text" />

<xsl:param name="strToConvert">BEATles anthOLogy</xsl:param>

  <xsl:template match="/">
    <xsl:call-template name="str:capitalise">
      <xsl:with-param name="text" select="$strToConvert"/>
    </xsl:call-template>

    <xsl:text>&#xd;&#xa;</xsl:text> <!-- Newline in DOS -->

    <xsl:call-template name="str:subst">
      <xsl:with-param name="text" select="$strToConvert" />
      <xsl:with-param name="replace">BEATles</xsl:with-param>
<!-- WRONG
      <xsl:with-param name="replace" select="BEATles"/>
     OKAY
      <xsl:with-param name="replace" select="'BEATles'"/>
-->
      <xsl:with-param name="with">Fab Four</xsl:with-param>
    </xsl:call-template>

  </xsl:template>
</xsl:stylesheet>

