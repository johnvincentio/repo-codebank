<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

<xsl:output method="xml" omit-xml-declaration="yes"/>

<xsl:template match="/">
  <b><xsl:value-of select="hi"/></b>
</xsl:template>

</xsl:stylesheet>
