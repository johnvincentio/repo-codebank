<?xml version="1.0"?>
<xsl:stylesheet   version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>

<xsl:variable name="label">XSLT: Math Functions; Boolean and Relational Operators</xsl:variable>

<xsl:template match="/">
   <html>  
     <head>
       <title><xsl:value-of select="$label" /></title>
     </head>
     <body>
       <h2><xsl:value-of select="$label" /></h2>
       <xsl:apply-templates /> 
       <p>
       <!-- We expect the sum of the CD prices and the sum of the Book
            prices to be the same as the sum of all ListPrices items,
            regardless of their parent element.
       --> 
       <xsl:text>Grand Total: $</xsl:text>
       <xsl:value-of select="sum(//CD/ListPrice) + sum(//Book/ListPrice)" />
       <xsl:text> should equal </xsl:text>
       <!-- Note the use of format-number to control precision. -->
       <xsl:value-of select="format-number(sum(//ListPrice), '$#.00')" />
       <br /><xsl:text> Unformatted: </xsl:text>
       <xsl:value-of select="sum(//ListPrice)" />
       </p> 

       <h3>Miscellaneous Boolean and Number Tests</h3>
	   <br /><xsl:text>boolean(*), boolean(0), boolean(-3), boolean (1.25): </xsl:text>
	   <b><xsl:value-of select='boolean(*)' /></b>, 
	   <b><xsl:value-of select='boolean(0)' /></b>, 
	   <b><xsl:value-of select='boolean(-3)' /></b>, 
	   <b><xsl:value-of select='boolean (1.25)' /></b>
	   <br /><xsl:text>not(name(//CD) = name(//Book)): </xsl:text>
	   <b><xsl:value-of select='not(name(//CD) = name(//Book))' /></b>
	   <br /><xsl:text>number('Beatles'): </xsl:text>
	   <xsl:value-of select="number('Beatles')" />

     </body>
   </html>
</xsl:template>

<xsl:template match="*"> <!-- note -->

   <h2 align="center">CD Prices</h2>
   <xsl:for-each select="//CD">
     <br />
     <xsl:text>CD </xsl:text><xsl:number /><xsl:text>.)  </xsl:text>
     <xsl:text>$</xsl:text>
     <xsl:value-of select="ListPrice" />
     <xsl:text> - </xsl:text>
     <i><xsl:value-of select="Title" /></i> 
     <xsl:text> --- floor: </xsl:text><xsl:value-of select="floor(ListPrice)" />
     <xsl:text>, ceiling: </xsl:text><xsl:value-of select="ceiling(ListPrice)" />
     <xsl:text>, round: </xsl:text><xsl:value-of select="round(ListPrice)" />
     <xsl:if test="(ListPrice &gt; 16) and (ListPrice &lt; 18)">
       <xsl:text>  --- Price is between $16 and $18. </xsl:text>
     </xsl:if>
   </xsl:for-each>

   <xsl:variable name="CDsubtotal" select="sum(//CD/ListPrice)" /> 
   <xsl:variable name="numCDs"  select="count(//CD)" /> 
   <br />
   <xsl:text>$</xsl:text><xsl:value-of select="$CDsubtotal" />
   <xsl:text> - Total for all </xsl:text>
   <xsl:value-of select="$numCDs" /><xsl:text> CDs</xsl:text>
   <br /><xsl:text>Average price: </xsl:text>
   <xsl:value-of select="format-number($CDsubtotal div $numCDs, '$#.00')" />

   <h2 align="center">Book Prices</h2>
   <xsl:for-each select="//Book">
     <br />
     <xsl:text>Book </xsl:text><xsl:number /><xsl:text>.)  </xsl:text>
     <xsl:text>$</xsl:text>
     <xsl:value-of select="ListPrice" />
     <xsl:text> - </xsl:text>
     <i><xsl:value-of select="Title" /></i> 
     <xsl:text> --- floor: </xsl:text><xsl:value-of select="floor(ListPrice)" />
     <xsl:text>, ceiling: </xsl:text><xsl:value-of select="ceiling(ListPrice)" />
     <xsl:text>, round: </xsl:text><xsl:value-of select="round(ListPrice)" />
     <xsl:if test="(ListPrice &gt; 25) and (ListPrice &lt;= 50)">
       <xsl:text>  --- Price is between $25 and $50 (inclusive). </xsl:text>
     </xsl:if>
   </xsl:for-each>

   <xsl:variable name="Booksubtotal" select="sum(//Book/ListPrice)" /> 
   <xsl:variable name="numBooks"  select="count(//Book)" /> 
   <br />
   <xsl:text>$</xsl:text><xsl:value-of select="$Booksubtotal" />
   <xsl:text> - Total for all </xsl:text>
   <xsl:value-of select="$numBooks" /><xsl:text> Books</xsl:text>
   <br /><xsl:text>Average price: </xsl:text>
   <xsl:value-of select="format-number($Booksubtotal div $numBooks, '$#.00')" />

</xsl:template>
</xsl:stylesheet>
