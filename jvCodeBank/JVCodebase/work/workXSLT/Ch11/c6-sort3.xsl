<?xml version="1.0"?>
<xsl:stylesheet   version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>

<xsl:variable name="label">XSLT: Sort with Primary and Secondary Keys</xsl:variable>

<xsl:template match="/">
   <html>  
     <head>
       <title><xsl:value-of select="$label" /></title>
     </head>
     <body>
       <h2><xsl:value-of select="$label" /></h2>

       <!-- Primary sort key=Title, secondary=Artist or Author -->
       <h3>CDs Ascending, 1st=Title, 2nd=Artist</h3>
       <xsl:apply-templates select="//CD" >
         <xsl:sort order="ascending" select="Title" />
         <xsl:sort order="ascending" select="Artist" />   
       </xsl:apply-templates> 

       <h3>Books Descending, 1st=Title, 2nd=Author</h3>
       <xsl:apply-templates select="//Book" >
         <xsl:sort order="descending" select="Title" />
         <xsl:sort order="descending" select="Author/Name/Last" />  
       </xsl:apply-templates> 

       <!-- Primary sort key=Artist or Author, secondary=ListPrice -->
       <h3>Mixed Ascending, 1st=Artist or Author, 2nd=ListPrice</h3>
       <xsl:apply-templates select="//CD | //Book" >
         <xsl:sort order="ascending" select="Artist | Author/Name/Last" /> 
         <xsl:sort order="ascending" select="ListPrice" 
          data-type="number" />
       </xsl:apply-templates> 

     </body>
   </html>
</xsl:template>

<xsl:template match="CD | Book">
   <xsl:value-of select="position()" /><xsl:text>.) </xsl:text>
   <i><xsl:value-of select="Title" /></i>
   <xsl:text> by </xsl:text>
   <b><xsl:value-of select="Author/Name/Last | Artist" /></b>
   <xsl:text> at $</xsl:text>
   <xsl:value-of select="ListPrice" />
   <br />
</xsl:template> 

</xsl:stylesheet>
