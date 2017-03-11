<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">
  <!-- Note no output method specified, so defaults to XML. -->
  <!-- xsl:output method="xml" indent="yes" /> -->

  <xsl:template match="Collections">
    <Collections>
      <xsl:for-each select="document(Col/@href)">
        <xsl:copy-of select="*" />
      </xsl:for-each>
    </Collections>
  </xsl:template>
 
</xsl:stylesheet>


