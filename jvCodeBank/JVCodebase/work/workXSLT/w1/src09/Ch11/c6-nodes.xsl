<?xml version="1.0"?>
<xsl:stylesheet   version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>

<xsl:variable name="label">XSLT: XPath Nodes</xsl:variable>

<xsl:template match="/">
   <html>  
     <head>
       <title><xsl:value-of select="$label" /></title>
     </head>
     <body>
       <h1><xsl:value-of select="$label" /></h1>
       <!-- Root node is above the document element (Collection). -->
       <xsl:text>Root Node: (no name) </xsl:text>
       <br /><i><xsl:value-of select="normalize-space(.)" /></i>
       <!--
            In contrast to "*" which only matches element nodes,
            "node()" matches elements, attributes, text, comments,
            PIs, and namespaces nodes. "@*" matches only attributes.
       -->
       <xsl:apply-templates   select="node()" />
       <!--  select="*|@*|comment()|processing-instruction()|text()" /> 
       -->
     </body>
   </html>
</xsl:template>

<!-- * matches only elements -->
<xsl:template match="*">
   <br /><xsl:text>Element: </xsl:text>
   <i><xsl:value-of select="name()" /></i>
   <xsl:text>  + Child nodes: </xsl:text>
   <i><xsl:value-of select="count(./*)" /></i>
   <!-- If # children is 0, element must be terminal node. -->
   <xsl:if test="count(./*) = 0" >
     <xsl:text>  +++ Leaf node</xsl:text>
   </xsl:if>
   <!-- Handle attributes and then element children. -->
   <xsl:apply-templates select="@*" /> 
   <xsl:apply-templates />
</xsl:template> 

<!-- @* matches only attributes -->
<xsl:template match="@*">
   <br /><xsl:text>Attribute: </xsl:text>
   <i>c</i>
   <xsl:text>  - Value: </xsl:text>
   <b><xsl:value-of select="." /></b>
</xsl:template> 

<xsl:template match="text()">
  <!-- Skipping whitespace only nodes, plus a little more. -->
  <xsl:if test="string-length(normalize-space(.)) &gt; 1" >
   <br /><xsl:text>text: {</xsl:text>
   <xsl:value-of  select="normalize-space(.)" />
   <xsl:text>}</xsl:text>
  </xsl:if>
</xsl:template>

<xsl:template match="comment()">
   <p /><xsl:text>comment: </xsl:text>
   <b><i><xsl:value-of select="." /></i></b>
</xsl:template> 

<xsl:template match="processing-instruction()">
   <p /><xsl:text>processing-instruction: name: </xsl:text>
   <i><xsl:value-of select="name()" /></i>
   <xsl:text>  --- data: </xsl:text>
   <b><i><xsl:value-of select="." /></i></b>
</xsl:template> 

</xsl:stylesheet>
