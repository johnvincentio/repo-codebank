<?xml version="1.0"?>
<xsl:stylesheet   version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" indent="yes" />

<xsl:variable name="label">XSLT: Table</xsl:variable>

<xsl:template match="/">
   <html>  
     <head>
       <title><xsl:value-of select="$label" /></title>
     </head>
     <body>
       <h1><xsl:value-of select="$label" /></h1>

       <table cellpadding="5" border="1" >
         <tr>
         <th>&#xA0;</th> <!-- nbsp -->
         <th>Title</th>
         <th>Author or Artist</th>
         <th>Type</th>
         <th>Published <br/>or Released</th>
         </tr>
         <xsl:apply-templates select="//CD|//Book" /> 
       </table>
       <xsl:apply-templates select="//Owner" /> 
     </body>
   </html>
</xsl:template>

<xsl:template match="Book">
   <tr bgcolor="#cccccc" style="font-weight: bold;"
foobar="{//Book[2]/Title}">
   <td><xsl:text>Book</xsl:text></td>
   <td><i><xsl:value-of select="Title" /></i></td>
   <td><xsl:value-of select="Author/Name/Last" /><xsl:text>, </xsl:text>
       <xsl:value-of select="Author/Name/First" /></td>
   <td><xsl:value-of select="Type" /></td>
   <td><xsl:value-of select="Published" /></td>
   </tr>
</xsl:template> 

<xsl:template match="CD">
   <tr bgcolor="#eeddcc" style="font-weight: bold;">
   <td><xsl:text>CD</xsl:text></td>
   <td><i><xsl:value-of select="Title" /></i></td>
   <td><xsl:value-of select="Artist" /></td>
   <td><xsl:value-of select="Type" /></td>
   <td><xsl:value-of select="AlbumReleased" /></td>
   </tr>
</xsl:template>

<xsl:template match="Owner">
   <p> </p>
     <h2>
     <xsl:value-of select="Name/First" />
     <xsl:text> </xsl:text>
     <xsl:value-of select="Name/Last" />
     <xsl:text>'s Collection</xsl:text>
     </h2>
     <xsl:value-of select="Address/Street" />
     <br />
     <xsl:value-of select="Address/City" />
     <xsl:text>, </xsl:text>
     <xsl:value-of select="Address/State" />
     <xsl:text> </xsl:text>
     <xsl:value-of select="Address/Zip" />
</xsl:template> 

</xsl:stylesheet>
