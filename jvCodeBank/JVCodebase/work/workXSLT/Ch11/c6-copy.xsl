<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">
  <!-- Note no output method specified, so defaults to XML. -->
  <!-- xsl:output method="xml" indent="yes" /> -->

  <xsl:template match="/">
    <xsl:apply-templates 
         select="//CD[1] | Collection/CD[3] | Collection/Book[last()]"/>
  </xsl:template>

  <xsl:template 
       match="*|@*|comment()|processing-instruction()|text()"> 
    <xsl:copy>
      <!-- Copy elements, attributes, content, comments, PIs, etc. -->
      <!-- select="node()|@*" would yield the same result. -->
      <xsl:apply-templates select="*| @*| comment()| text()| 
                                   processing-instruction()"/>
    </xsl:copy>
  </xsl:template>

  <xsl:template match="CD[3]"> 
    <xsl:copy>
      <xsl:value-of select="AlbumReleased" />
    </xsl:copy>
  </xsl:template>

</xsl:stylesheet>

