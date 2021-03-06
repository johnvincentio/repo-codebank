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
<h3><xsl:value-of select="/Employees/Employee[2]/Name/Last" /></h3>
<h3><xsl:value-of select="/Employees/Employee[@sex = 'male'][2]" /></h3>

        <table border="2" bgcolor="white" cellpadding="4" cellspacing="2" >
          <tr>
            <th>Last</th>
            <th>First</th>
            <th>Email</th>
            <th>Cell Phone</th>
          </tr>
          <xsl:for-each select="Employees/Employee" >
          <xsl:sort order="ascending" select="Name/Last" />
          <tr>
            <td><b><xsl:value-of select="Name/Last"/></b></td>
            <td><xsl:value-of select="Name/First"/></td>
            <td><xsl:value-of select="Email"/></td>
            <xsl:choose>
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

<xsl:apply-templates select="/Employees/Employee[2]" />

     </body>
   </html>
</xsl:template>

<xsl:template match="/Employees/Employee[2]">
   <h3><xsl:value-of select="Name/Last" /></h3>
   <h3><xsl:value-of select="@sex" /></h3>
</xsl:template>
</xsl:stylesheet>
