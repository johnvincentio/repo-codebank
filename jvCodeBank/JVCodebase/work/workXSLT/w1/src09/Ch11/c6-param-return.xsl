<?xml version="1.0"?>
<xsl:stylesheet   version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" indent="yes"/>

<xsl:variable name="label">XSLT: Named Template Returning a Value</xsl:variable>

<xsl:template match="/">
   <html>  
     <head>
       <title><xsl:value-of select="$label" /></title>
     </head>
     <body>
       <h2><xsl:value-of select="$label" /></h2>
       <xsl:apply-templates select="//CD | //Book" />
     </body>
   </html>
</xsl:template>

<xsl:template match="CD | Book">
    <i><xsl:value-of select="Title" /></i>
    <!-- Variable $newPrice receives output of CalcDiscount template. -->
    <xsl:variable name="newPrice">
      <xsl:call-template name="CalcDiscount" > 
        <xsl:with-param  name="price"  select="ListPrice" />
      </xsl:call-template>
    </xsl:variable>
    <!-- Check value upon return -->    
    <xsl:text> is: $</xsl:text><xsl:value-of select="$newPrice"/>
    <br />
</xsl:template>

<!--
     This named template computes a discount if the passed price meets 
     a minimum value. Both the minimum and discount can also be passed in,
     but aren't in the above call. 
-->

<xsl:template name="CalcDiscount"> 
   <xsl:param name="price">0.0</xsl:param>
   <xsl:param name="min">21.99</xsl:param>
   <xsl:param name="percent">0.75</xsl:param>
   <xsl:param name="discountRate">
     <xsl:value-of select="100 * (1.0 - $percent)" />
   </xsl:param>

   <xsl:choose>
     <xsl:when test="$price &gt;= $min">
       <!-- Apply the discount. -->
       <xsl:value-of select="format-number($price * $percent, '#.00')" /> 
       <xsl:text> (after </xsl:text>
       <xsl:value-of select="$discountRate" /><xsl:text>% discount)</xsl:text>
     </xsl:when>
     <xsl:otherwise>
       <!-- No discount, so return original price. -->
       <xsl:value-of select="$price" /> 
     </xsl:otherwise>
   </xsl:choose>  
</xsl:template>

</xsl:stylesheet>
