<?xml version="1.0"?>
<xsl:stylesheet   version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>

<xsl:variable name="label">XSLT: XPath Axes</xsl:variable>

<!-- Used to prevent dumping the entire node as a string. -->
<xsl:variable name="maxLength" select="50" />

<xsl:template match="/">
   <html>  
     <head>
       <title><xsl:value-of select="$label" /></title>
     </head>
     <body>
       <h1><xsl:value-of select="$label" /></h1>
       <xsl:apply-templates select="//CD | //Book"/>
     </body>
   </html>
</xsl:template>

<!-- This clearly would have been more concise as a named template. -->

<!-- The process-axis template is the idea, but does not work as is. -->
<!-- Xalan reports: Can not convert #STRING to a NodeList! -->
<!-- Saxon reports: The value of $AxisNode is not a node-set -->


<xsl:template name="process-axis">
   <xsl:param name="Axis">self</xsl:param> <!-- default -->
   <xsl:variable name="AxisNode" select="concat($Axis, '::node()')" />

   <p /><b><xsl:value-of select="$Axis" /></b>

   <xsl:for-each select="$AxisNode" >
     <xsl:if test="name() != ''">
       <br /><xsl:number /><xsl:text>.) </xsl:text>
       <xsl:value-of select="name()" />
       <xsl:if test="string-length(current()) &lt; $maxLength" >
         <xsl:text> --- </xsl:text>
         <xsl:value-of select="." />
       </xsl:if>
     </xsl:if>
   </xsl:for-each>
</xsl:template>

<xsl:template match="CD[2]">
   <p />
   <i><xsl:value-of select="Title" /></i>
   <i><xsl:text> = CD[2] </xsl:text></i>

   <xsl:call-template name="process-axis" >
     <xsl:with-param name="Axis">ancestor</xsl:with-param>
   </xsl:call-template>

   <xsl:call-template name="process-axis" >
     <xsl:with-param name="Axis">descendant-or-self</xsl:with-param>
   </xsl:call-template>

   <p /><b><xsl:text>ancestor-or-self: </xsl:text></b>
   <xsl:for-each select="ancestor-or-self::node()" >
     <xsl:if test="name() != ''">
       <br /><xsl:number /><xsl:text>.) </xsl:text>
       <xsl:value-of select="name()" />
       <xsl:if test="string-length(current()) &lt; $maxLength" >
         <xsl:text> --- </xsl:text>
         <xsl:value-of select="." />
       </xsl:if>
     </xsl:if>
   </xsl:for-each>

   <!-- 
       For the attribute case, we do things a little differently to
       poke inside CD[2] and find any children that have any attribute
       and then to obtain the name of such children and the name and 
       value of their attributes.
   -->   
   <p /><b><xsl:text>attribute: </xsl:text></b>
   <xsl:for-each select="//CD[2]/descendant::node()/@*" >
     <!-- 
        We could use "//CD[2]/*/attribute::node()"  but that 
        restricts our depth to one level.
     -->
     <xsl:if test="name() != ''">
       <br /><xsl:number /><xsl:text>.) </xsl:text>
       <xsl:text>Element: </xsl:text>
       <xsl:value-of select="name(parent::node())" />
       <xsl:text> has attribute: </xsl:text>
       <xsl:value-of select="name()" />
       <xsl:if test="string-length(current()) &lt; $maxLength" >
         <xsl:text> --- </xsl:text>
         <xsl:value-of select="." />
       </xsl:if>
     </xsl:if>
   </xsl:for-each>

   <p /><b><xsl:text>child: </xsl:text></b>
   <xsl:for-each select="child::node()" >
     <xsl:if test="name() != ''">
       <br /><xsl:number count="*" /><xsl:text>.) </xsl:text>
       <xsl:value-of select="name()" />
       <xsl:if test="string-length(current()) &lt; $maxLength" >
         <xsl:text> --- </xsl:text>
         <xsl:value-of select="." />
       </xsl:if>
     </xsl:if>
   </xsl:for-each>

   <p /><b><xsl:text>descendant: </xsl:text></b>
   <xsl:for-each select="descendant::node()" >
     <xsl:if test="name() != ''">
       <br /><xsl:number count="*" /><xsl:text>.) </xsl:text>
       <xsl:value-of select="name()" />
       <xsl:if test="string-length(current()) &lt; $maxLength" >
         <xsl:text> --- </xsl:text>
         <xsl:value-of select="." />
       </xsl:if>
     </xsl:if>
   </xsl:for-each>

   <p /><b><xsl:text>descendant-or-self: </xsl:text></b>
   <xsl:for-each select="descendant-or-self::node()" >
     <xsl:if test="name() != ''">
       <br /><xsl:number count="*" /><xsl:text>.) </xsl:text>
       <xsl:value-of select="name()" />
       <xsl:if test="string-length(current()) &lt; $maxLength" >
         <xsl:text> --- </xsl:text>
         <xsl:value-of select="." />
       </xsl:if>
     </xsl:if>
   </xsl:for-each>

   <p /><b><xsl:text>following: </xsl:text></b>
   <xsl:for-each select="following::node()" >
     <xsl:if test="name() != ''">
       <br /><xsl:number count="*" /><xsl:text>.) </xsl:text>
       <xsl:value-of select="name()" />
       <xsl:if test="string-length(current()) &lt; $maxLength" >
         <xsl:text> --- </xsl:text>
         <xsl:value-of select="." />
       </xsl:if>
     </xsl:if>
   </xsl:for-each>

   <p /><b><xsl:text>following-sibling: </xsl:text></b>
   <xsl:for-each select="following-sibling::node()" >
     <xsl:if test="name() != ''">
       <br /><xsl:number count="*" /><xsl:text>.) </xsl:text>
       <xsl:value-of select="name()" />
       <xsl:if test="string-length(current()) &lt; $maxLength" >
         <xsl:text> --- </xsl:text>
         <xsl:value-of select="." />
       </xsl:if>
     </xsl:if>
   </xsl:for-each>

   <p /><b><xsl:text>namespace(/Collection): </xsl:text></b>
   <xsl:for-each select="namespace::node()" >
     <xsl:if test="name() != ''">
       <br /><xsl:number count="*" /><xsl:text>.) </xsl:text>
       <xsl:value-of select="name()" />
       <xsl:if test="string-length(current()) &lt; $maxLength" >
         <xsl:text> --- </xsl:text>
         <xsl:value-of select="." />
       </xsl:if>
     </xsl:if>
   </xsl:for-each>

   <p /><b><xsl:text>parent: </xsl:text></b>
   <xsl:for-each select="parent::node()" >
     <xsl:if test="name() != ''">
       <br /><xsl:number count="*" /><xsl:text>.) </xsl:text>
       <xsl:value-of select="name()" />
       <xsl:if test="string-length(current()) &lt; $maxLength" >
         <xsl:text> --- </xsl:text>
         <xsl:value-of select="." />
       </xsl:if>
     </xsl:if>
   </xsl:for-each>

   <p /><b><xsl:text>preceding: </xsl:text></b>
   <xsl:for-each select="preceding::node()" >
     <xsl:if test="name() != ''">
       <br /><xsl:number count="*" /><xsl:text>.) </xsl:text>
       <xsl:value-of select="name()" />
       <xsl:if test="string-length(current()) &lt; $maxLength" >
         <xsl:text> --- </xsl:text>
         <xsl:value-of select="." />
       </xsl:if>
     </xsl:if>
   </xsl:for-each>

   <p /><b><xsl:text>preceding-sibling: </xsl:text></b>
   <xsl:for-each select="preceding-sibling::node()" >
     <xsl:if test="name() != ''">
       <br /><xsl:number count="*" /><xsl:text>.) </xsl:text>
       <xsl:value-of select="name()" />
       <xsl:if test="string-length(current()) &lt; $maxLength" >
         <xsl:text> --- </xsl:text>
         <xsl:value-of select="." />
       </xsl:if>
     </xsl:if>
   </xsl:for-each>

   <p /><b><xsl:text>self: </xsl:text></b>
   <xsl:for-each select="self::node()" >
     <xsl:if test="name() != ''">
       <br /><xsl:number count="*" /><xsl:text>.) </xsl:text>
       <xsl:value-of select="name()" />
       <xsl:if test="string-length(current()) &lt; $maxLength" >
         <xsl:text> --- </xsl:text>
         <xsl:value-of select="." />
       </xsl:if>
     </xsl:if>
   </xsl:for-each>
</xsl:template> 

<xsl:template match="*">
</xsl:template>

</xsl:stylesheet>
