<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
	<HTML>
	<HEAD>
		<TITLE><xsl:value-of select="Data/Title"/></TITLE>
	</HEAD>
	<BODY>
	<CENTER>
		<H1><xsl:value-of select="Data/Header"/></H1>
		<TABLE>
		<TR>
			<TD BGCOLOR="AAAAAA" ALIGN="CENTER">Catalog</TD>
			<TD BGCOLOR="AAAAAA"></TD>	
		</TR>
		<xsl:for-each select="Data/Catalogs/Catalog">
		<tr>
			<form method="post">
				<input type="hidden" name="jvaction" value="210" />
				<input type="hidden" name="item">
					<xsl:attribute name="value"><xsl:value-of select="Id"/></xsl:attribute>
				</input>
				<TD BGCOLOR="DDDDDD"><xsl:value-of select="Description"/></TD>
				<TD BGCOLOR="DDDDDD">
					<INPUT TYPE="submit" Name="select" Value="Select"/>
				</TD>	
			</form>
		</tr>
		</xsl:for-each>
		</TABLE>

<!-- ViewCart -->
		<hr/>
		<form method="post">
			<input type="hidden" name="jvaction" value="300" />	
			<tr><td>
				<INPUT TYPE="submit" Name="Cart" Value="View Cart"/>
			</td></tr>
		</form>
<!-- End of ViewCart -->

	</CENTER>
	</BODY>
	</HTML>

</xsl:template>
</xsl:stylesheet>
