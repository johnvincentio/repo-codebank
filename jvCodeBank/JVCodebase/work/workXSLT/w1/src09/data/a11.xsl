<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>

<xsl:variable name="title">Project</xsl:variable>
<xsl:variable name="header">(a1) Kf Working with XSLT</xsl:variable>

<xsl:template match="/">
	<html>
		<head>
			<title><xsl:value-of select="$title"/></title>
		</head>
		<body>
			<h1><xsl:value-of select="$header"/></h1>
			<table>
				<xsl:apply-templates />
			</table>
		</body>
	</html>
</xsl:template>

<xsl:template match="Project">
	<xsl:apply-templates />
</xsl:template>

<xsl:template match="Activity">
	<tr>
		<td><xsl:value-of select="Activityid" /></td>
		<td><xsl:value-of select="Description" /></td>
	</tr>
</xsl:template>

</xsl:stylesheet>
