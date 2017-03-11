<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:fo="http://www.w3.org/1999/XSL/Format"
	xmlns:jv="http://bob.marlboro.edu/~jvincent/schemas">
<xsl:output method="html" indent="yes"/>

<xsl:variable name="title">Project</xsl:variable>
<xsl:variable name="header">Working with XSLT</xsl:variable>

<xsl:template match="/">
	<html>
		<head><title><xsl:value-of select="$title"/></title></head>
		<body>
			<h1><xsl:value-of select="$header"/></h1>
			<xsl:apply-templates />
		</body>
	</html>
</xsl:template>

<xsl:template match="jv:Project">
	<h1><xsl:value-of select="jv:Projectid" /></h1>
	<br/><p><xsl:value-of select="jv:Description" /></p>
	<br/>
	<table cellpadding="5" border="1">
		<tr>
			<th>ActId</th>
			<th>Dur</th>
			<th>Priority</th>
			<th>Status</th>
			<th>Description</th>
		</tr>
		<xsl:apply-templates select="jv:Activity"/>
	</table>
</xsl:template>

<xsl:template match="jv:Activity">
	<tr bgcolor="#cccccc" style="font-weight: bold;">
		<td><xsl:value-of select="jv:Activityid" /></td>
		<td><xsl:value-of select="jv:Duration" /></td>
		<td><xsl:value-of select="jv:Priority" /></td>
		<td><xsl:value-of select="jv:Status" /></td>
		<td><xsl:value-of select="jv:Description" /></td>
	</tr>
</xsl:template>

</xsl:stylesheet>

