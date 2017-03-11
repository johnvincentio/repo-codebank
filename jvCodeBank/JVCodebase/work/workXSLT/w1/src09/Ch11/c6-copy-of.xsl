<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">
  <xsl:output method="xml" indent="yes" />

  <xsl:variable name="Owner" select="/Collection/Owner" />

  <xsl:template match="/">
    <!-- Create a new document element for the output XML. -->
    <!-- Add attributes extracted from Owner element. -->
    <xsl:element name="CD.Collection" >
      <xsl:attribute name="owner" >
       <!-- Need to normal-space since Name has 2 children. -->
       <xsl:value-of select="normalize-space($Owner/Name)" />
      </xsl:attribute>
      <xsl:attribute name="sex" >
       <xsl:value-of select="$Owner/Name/@sex" />
      </xsl:attribute>
      <xsl:attribute name="state" >
       <xsl:value-of select="$Owner/Address/State" />
      </xsl:attribute>

      <!-- Handle children of the document element. -->
      <xsl:apply-templates  select="/Collection"/>

    </xsl:element>
  </xsl:template>

  <xsl:template match="*">
    <!-- Copy only CD elements and PIs (comments omitted). -->
    <xsl:copy-of select="CD | processing-instruction()" />
    <!-- 
    Or, could deep copy everything under the document element. 
    <xsl:copy-of select="node()" />
    -->
  </xsl:template>

</xsl:stylesheet>

