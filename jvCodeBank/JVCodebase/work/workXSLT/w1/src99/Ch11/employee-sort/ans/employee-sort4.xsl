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
            <th>Sex</th>
            <th>Projects</th>
            <th>First</th>
            <th>Last</th>
            <th>Home Phone</th>
            <th>Cell Phone</th>
          </tr>
          <xsl:for-each select="Employees/Employee" >
          <xsl:sort order="ascending" select="@sex" />
          <tr>
            <td><b><xsl:value-of select="@sex"/></b></td>
            <td>
              <xsl:for-each select="Projects/Project" >
                <b><xsl:value-of select="."/></b><br />
              </xsl:for-each>
            </td>
            <td><b><xsl:value-of select="Name/Last"/></b></td>
            <td><xsl:value-of select="Name/First"/></td>
            <td><xsl:value-of select="PhoneNumbers/Home"/></td>
            <xsl:choose>
<!-- fix this -->
            <xsl:when test="PhoneNumbers/Cell[. != '']"> 
              <td><xsl:value-of select="PhoneNumbers/Cell" /></td>
            </xsl:when>
            <xsl:otherwise>
              <td align="center">none</td> 
            </xsl:otherwise>
            </xsl:choose>
          </tr>
        </xsl:for-each>
      </table>

     </body>
   </html>
</xsl:template>

</xsl:stylesheet>
