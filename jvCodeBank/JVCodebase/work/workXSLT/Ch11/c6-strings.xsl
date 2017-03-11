<?xml version="1.0"?>
<xsl:stylesheet   version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>

<xsl:variable name="label">XSLT: String Functions</xsl:variable>

<xsl:template match="/">
   <html>  
     <head>
       <title><xsl:value-of select="$label" /></title>
     </head>
     <body>
       <h2><xsl:value-of select="$label" /></h2>
       <xsl:apply-templates select="//CD | //Book" /> 

       <p /><xsl:text>String length of first CD's title: </xsl:text>
       <xsl:value-of select="string-length(/Collection/CD[1]/Title)" />
       <xsl:text> ++ </xsl:text>
       <i><xsl:value-of select="/Collection/CD[1]/Title" /></i>

       <p /><xsl:text>String value of first CD: </xsl:text>
       <xsl:value-of select="string(/Collection/CD[1])" />

       <p /><xsl:text>String value with normalize-space (View Source): </xsl:text>
       <xsl:value-of select="normalize-space(/Collection/CD[1])" />
     </body>
   </html>
</xsl:template>

<xsl:template match="Book[position() = 1]">
   <p /><xsl:text>First Book: </xsl:text>

   <!-- Store the title in a variable. -->
   <xsl:variable name="title" select="Title/text()"/>
   <i><xsl:value-of select="$title" /></i>

   <br /><xsl:text>substring-before "Beatles": [</xsl:text>
   <i><xsl:value-of select="substring-before($title, 'Beatles')"/></i>]

   <br /><xsl:text>substring-after "Beatles": [</xsl:text>
   <i><xsl:value-of select="substring-after($title, 'Beatles')"/></i>]

   <br /><xsl:text>translate "Beatles" to uppercase: </xsl:text>
   <i><xsl:value-of select="translate('Beatles', 'eatles', 'EATLES')"/></i>

   <br /><xsl:text>concat of 'The' and rest of title: </xsl:text>
   <xsl:variable name="titlePart" select="substring-before($title, ',')"/>
   <xsl:variable name="titleExtra" select="substring-after($title, ',')"/>
   <i><xsl:value-of select="concat($titleExtra, ' ', $titlePart)"/></i>

   <br /><xsl:text>translate ("John", "nohjq", "NarXQ"): </xsl:text>
   <b><xsl:value-of select='translate ("John", "nohjq", "NarXQ")' /></b>

   <br /><xsl:text>translate ("Harrison", "Hranosi", "hRAN"): </xsl:text>
   <b><xsl:value-of select='translate ("Harrison", "Hranosi", "hRAN")' /></b>

</xsl:template> 

<xsl:template match="CD">
   <p />

   <!-- Store the title in a variable. Name is same but different scope. -->
   <xsl:variable name="title" select="Title/text()"/>
   <i><xsl:value-of select="$title" /></i>

   <xsl:if test="starts-with($title, 'Beatles')">
     <br /><xsl:text>Above title starts-with "Beatles".</xsl:text>
   </xsl:if>

   <xsl:if test="substring($title, 6, 6) = 'on the'">
     <br /><xsl:text>Substring from position 6 with length 6 is "on the".</xsl:text>
   </xsl:if>

   <xsl:if test="contains($title, 'Mar')">
     <br /><xsl:text>Above title contains the string "Mar".</xsl:text>
   </xsl:if>

</xsl:template>

<xsl:template match="text()">
  <!-- Discard other text content. -->
</xsl:template>

</xsl:stylesheet>
