<?xml version="1.0"?>
<xsl:stylesheet   version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>

<xsl:variable name="label">XSLT: Param, Named Template, Call Template</xsl:variable>

<!-- Global param -->
<xsl:param name="SortTitle">s in Ascending Order</xsl:param>
<!-- Would also work as a global variable. -->
<xsl:variable name="NotUsed_SortTitle">s in Ascending Order</xsl:variable>

<xsl:template match="/">
   <html>  
     <head>
       <title><xsl:value-of select="$label" /></title>
     </head>
     <body>
       <h2><xsl:value-of select="$label" /></h2>
       <!-- 
           Note single quotes for var "item" so element name 'CD' is
           treated as a string. If not, there is no value-of output.
           In the second call to the Sorter template, we illustrate
           an alternative way of setting the string value for 'Book'.
       -->
       <xsl:call-template name="Sorter" > 
         <xsl:with-param name="item"     select="'CD'" />
         <xsl:with-param name="itemPath" select="//CD" />
       </xsl:call-template>

       <xsl:call-template name="Sorter" > 
         <xsl:with-param name="item">Book</xsl:with-param>
         <xsl:with-param name="itemPath" select="//Book" />
       </xsl:call-template>

       <!-- Bogus call (no params) to test template defaults. -->
       <xsl:call-template name="Sorter" />

     </body>
   </html>
</xsl:template>

<!-- 
     This is a named template. Specifying default values for the
     params using the select attribute is optional.
-->
<xsl:template name="Sorter"> 
   <xsl:param name="item"     select="'Default CD'" />
   <xsl:param name="itemPath" select="//CD" />

   <h3><xsl:value-of select="$item" /> 
       <xsl:value-of select="$SortTitle" /></h3>

   <xsl:for-each select="$itemPath" >
     <xsl:sort order="ascending" />
     <br />
     <xsl:value-of select="name()" />
     <xsl:text> </xsl:text><xsl:number /><xsl:text>: </xsl:text>
     <i><xsl:value-of select="Title" /></i>    
   </xsl:for-each>

</xsl:template>

</xsl:stylesheet>
