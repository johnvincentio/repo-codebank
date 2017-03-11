<?xml version="1.0"?>
<xsl:stylesheet   version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>

<xsl:variable name="label">XSLT: Attributes</xsl:variable>

<xsl:template match="/">
   <html>  
     <head>
       <title><xsl:value-of select="$label" /></title>
     </head>
     <body>
       <h1><xsl:value-of select="$label" /></h1>
       <xsl:apply-templates select="/Collection/CD" /> 
       <xsl:apply-templates select="/Collection/Book" /> 
       <xsl:apply-templates select="/Collection/CD/Remastered/@*" /> 
     </body>
   </html>
</xsl:template>

<xsl:template match="//CD/Remastered" > 
   <p />
     <i><xsl:value-of select="../Title" /></i> 
     <br /><xsl:text>format attribute: </xsl:text>
     <i><xsl:value-of select="./@format" /></i>
     <!-- Next yields same value since only one attribute possible.
     <br /><xsl:value-of select="attribute::node()" /> 
     -->
     <br /><xsl:value-of select="name()" />
     <xsl:text> = </xsl:text>
     <xsl:value-of select="." />
  
     <xsl:if test="@format[contains(., 'gold CD')]">
       <b><xsl:text> ++++++ Found 'gold CD'</xsl:text></b>
     </xsl:if>
</xsl:template> 

<xsl:template match="//CD/Chart/Peak" > 
   <p />
     <i><xsl:value-of select="../../Title" /></i> 
     <br /><xsl:value-of select="count(@*)" />
     <xsl:text> Peak attributes: </xsl:text>
     <xsl:for-each select="@*" > 
     <!-- Next yields same result regardless of # of attributes.
     <xsl:for-each select="attribute::node()" > 
     -->
       <br /><xsl:value-of select="name()" />
       <xsl:text> = </xsl:text>
       <xsl:value-of select="." />
     </xsl:for-each>
</xsl:template> 

<xsl:template match="//Book" > 
   <p />
     <i><xsl:value-of select="Title" /></i> 
     <br /><xsl:text>publisher attribute: </xsl:text>
     <i><xsl:value-of select="Published/@publisher" /></i>
     <br /><xsl:text>Published = </xsl:text>
     <xsl:value-of select="Published" />
  
     <xsl:if test="./Published/@publisher[.='Chronicle Books']">
       <b><xsl:text> ++++++ Found 'Chronicle Books'</xsl:text></b>
     </xsl:if>
</xsl:template>

<xsl:template match="//CD/Remastered/@format" > 
   <h5>format: <xsl:value-of select="."/></h5>
   <xsl:if test=". = 'gold CD'">
     <h5>Found exactly a "gold CD" format.</h5>       
   </xsl:if>
</xsl:template>

<xsl:template match="text()">
</xsl:template> 

</xsl:stylesheet>
