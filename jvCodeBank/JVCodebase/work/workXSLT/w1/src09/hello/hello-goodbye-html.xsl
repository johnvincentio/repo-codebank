<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

<xsl:output method="html" />

<xsl:template match="/">  <!-- or /hello-goodbye -->
  <html>
    <head>
      <title>Hello Goodbye</title>
    </head>
    <body>
      <h1 align="center">Hello Goodbye</h1>
      <xsl:apply-templates />
    </body>
  </html>
</xsl:template>

<xsl:template match="hi">
  <p><b><xsl:value-of select="."/></b></p>
</xsl:template>

<xsl:template match="bye">
  <p><i><xsl:value-of select="."/></i></p>
</xsl:template>

</xsl:stylesheet>
