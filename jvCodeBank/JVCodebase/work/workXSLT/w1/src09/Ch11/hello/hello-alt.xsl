<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">
<xsl:output method="html" />

<xsl:template match="/hi">
  <b><xsl:value-of select="."/></b>
</xsl:template>
</xsl:stylesheet>