<?xml version="1.0"?>
<xsl:stylesheet   version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>

<xsl:variable name="label">XSLT: Sorting and Filtering</xsl:variable>

<xsl:template match="/">
   <html>  
     <head>
       <title><xsl:value-of select="$label" /></title>
     </head>
     <body>
        <table border="2" bgcolor="white" cellpadding="4" cellspacing="2" >
          <tr>
            <th>Last</th>
            <th>First</th>
            <th>Title</th>
            <th>Projects</th>
          </tr>
          <xsl:for-each select="Employees/Employee" >
          <xsl:sort order="ascending" select="Name/Last" />
          <tr>
            <td><b><xsl:value-of select="Name/Last"/></b></td>
            <td><xsl:value-of select="Name/First"/></td>
            <td><xsl:value-of select="Title"/></td>
            <td>
              <xsl:for-each select="Projects/Project" >
                <b><xsl:value-of select="."/></b><br />
              </xsl:for-each>
            </td>
          </tr>
        </xsl:for-each>
      </table>

     </body>
   </html>
</xsl:template>

</xsl:stylesheet>
