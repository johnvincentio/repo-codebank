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
			<TD BGCOLOR="AAAAAA" ALIGN="CENTER">Catalog</TD>
		    <TD BGCOLOR="AAAAAA">Description</TD>
			<TD BGCOLOR="AAAAAA">Items</TD>			
		    <TD BGCOLOR="AAAAAA" ALIGN="CENTER">Price</TD>
		    <TD BGCOLOR="AAAAAA" ALIGN="CENTER">Total</TD>	
			<TD BGCOLOR="AAAAAA">Remove</TD>
			<TD BGCOLOR="AAAAAA">Update</TD>
		</TR>

		<xsl:for-each select="Data/Item">
		<tr>
			<FORM METHOD="POST">
				<input type="hidden" name="jvaction" value="320" />
				<input type="hidden" name="item">
					<xsl:attribute name="value">
						<xsl:value-of select="Cartid"/>
					</xsl:attribute>
				</input>
				<TD BGCOLOR="DDDDDD"><xsl:value-of select="Itemid"/></TD>	
				<TD BGCOLOR="DDDDDD"><xsl:value-of select="Catalog"/></TD>
				<TD BGCOLOR="DDDDDD"><xsl:value-of select="Sds"/></TD>
				<TD BGCOLOR="DDDDDD"><xsl:value-of select="Quantity"/></TD>				  
				<TD BGCOLOR="DDDDDD" ALIGN="RIGHT"><xsl:value-of select="Price"/></TD>
				<TD BGCOLOR="DDDDDD" ALIGN="RIGHT"><xsl:value-of select="Total"/></TD>
				<TD BGCOLOR="DDDDDD">
					<INPUT TYPE="submit" Name="remove" Value="Remove"/>
				</TD>	
				<TD BGCOLOR="DDDDDD">
					<INPUT TYPE="submit" Name="update" Value="Update"/>
				</TD>	
			</FORM>
		</tr>
		</xsl:for-each>
		<TR>
			<TD></TD><TD></TD><TD></TD><TD></TD>
			<TD BGCOLOR="DDDDDD">Total</TD>
			<TD BGCOLOR="DDDDDD" ALIGN="RIGHT"><xsl:value-of select="Data/GrandTotal"/></TD>
		</TR>
		</TABLE>

<!-- ViewCheckout -->
		<hr/>
		<form method="post">
			<input type="hidden" name="jvaction" value="400" />
			<tr><td>
				<input type="submit" name="Checkout" value="Checkout"/>
			</td></tr>
		</form>
<!-- End of ViewCheckout -->

<!-- ViewCatalogs -->
		<hr/>
		<form method="post">
			<input type="hidden" name="jvaction" value="200" />
			<tr><td>
				<input type="submit" name="Catalogs" value="View Catalogs"/>
			</td></tr>
		</form>
<!-- End of ViewCatalogs -->

</CENTER>

</BODY>
</HTML>

</xsl:template>
</xsl:stylesheet>
