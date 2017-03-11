<?xml version="1.0"?>
<xsl:stylesheet   version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>

<xsl:variable name="label">XSLT: Passing Parameters on the Command Line</xsl:variable>

<!-- Global parameters -->
<xsl:param name="trackNum" select="2" />
<xsl:param name="title" select="'Even Better Than the Real Thing'" />

<xsl:template match="/">
   <html>  
     <head>
       <title><xsl:value-of select="$label" /></title>
     </head>
     <body>
       <h2><xsl:value-of select="$label" /></h2>
       <xsl:text>Parameter $trackNum has been set to: </xsl:text>
       <xsl:value-of select="$trackNum" />
       <br />
       <xsl:text>Parameter $title has been set to: </xsl:text>
       <xsl:value-of select="$title" />
     </body>
   </html>
</xsl:template>

</xsl:stylesheet>
