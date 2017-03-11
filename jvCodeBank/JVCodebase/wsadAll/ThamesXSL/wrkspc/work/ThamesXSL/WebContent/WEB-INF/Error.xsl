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
		<br/>
		<h2><xsl:value-of select="Data/Message/Header"/></h2>
		<xsl:value-of select="Data/Message/Text"/>
		<br/>
	</CENTER>
	</BODY>
	</HTML>

</xsl:template>
</xsl:stylesheet>
