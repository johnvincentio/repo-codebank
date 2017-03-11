<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    version="1.0"
    xmlns:xalan="http://xml.apache.org/xslt">

<xsl:template match="/">
	<HTML>
	<HEAD>
		<TITLE><xsl:value-of select="Data/Title"/></TITLE>
	</HEAD>
	<BODY>
	<CENTER>
		<H1><xsl:value-of select="Data/Header"/></H1>

		<xsl:value-of select="Message/Text"/>
		<BR/>

		<TABLE>
		<TR>
			<TD BGCOLOR="AAAAAA">Stock ID</TD>
		    <TD BGCOLOR="AAAAAA">Title</TD>
		    <TD BGCOLOR="AAAAAA">Description</TD>
		    <TD BGCOLOR="AAAAAA" ALIGN="CENTER">Price</TD>
			<TD BGCOLOR="AAAAAA">Quantity</TD>
			<TD BGCOLOR="AAAAAA">Add</TD>
		</TR>
		<xsl:for-each select="Data/Item">
		<tr>
			<form method="post">
				<input type="hidden" name="jvaction" value="240" />
				<input type="hidden" name="item">
					<xsl:attribute name="value"><xsl:value-of select="Itemid"/></xsl:attribute>
				</input>
				<TD BGCOLOR="DDDDDD"><xsl:value-of select="Itemid"/></TD>	
				<TD BGCOLOR="DDDDDD"><xsl:value-of select="Sds"/></TD>
				<TD BGCOLOR="DDDDDD"><xsl:value-of select="Lds"/></TD>
				<TD BGCOLOR="DDDDDD" ALIGN="RIGHT"><xsl:value-of select="Price"/></TD>
				<TD BGCOLOR="DDDDDD">
					<input TYPE="text" NAME="quantity" SIZE="2" value=""/>
				</TD>	
				<TD BGCOLOR="DDDDDD">
					<input type="submit" name="add" value="Add"/>
				</TD>	
			</form>

		</tr>
		</xsl:for-each>
		</TABLE>

<!-- ViewCatalogs -->
		<hr/>
		<form method="post">
			<input type="hidden" name="jvaction" value="200" />
			<tr><td>
				<input type="submit" name="Catalogs" value="View Catalogs"/>
			</td></tr>
		</form>
<!-- End of ViewCatalogs -->

<!-- ViewCart -->
		<hr/>
		<form method="post">
			<input type="hidden" name="jvaction" value="300" />	
			<tr><td>
				<input type="submit" name="Cart" value="View Cart"/>
			</td></tr>
		</form>
<!-- End of ViewCart -->

	</CENTER>
	</BODY>
	</HTML>

</xsl:template>
</xsl:stylesheet>
