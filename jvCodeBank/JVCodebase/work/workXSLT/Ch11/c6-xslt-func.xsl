<?xml version="1.0"?>
<xsl:stylesheet   version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns:xalan="http://xml.apache.org/xalan"
  xmlns:saxon="http://icl.com/saxon"
  extension-element-prefixes="xalan saxon"
> 
<!--   Older Saxon namespace was:
       xmlns:saxon="http://com.icl.saxon.functions.Extensions" 
-->

<xsl:output method="html" indent="yes" 
            encoding="ISO-8859-1" />

<xsl:variable name="label">XSLT: XSLT Functions and Key</xsl:variable>

<xsl:key name="TitleKey" match="CD | Book" use="Title" />
<xsl:key name="PriceKey" match="CD | Book" use="ListPrice" />
<xsl:key name="AuthorKey" match="Book" use="Author/Name/Last" />

<xsl:template match="/">
   <html>  
     <head>
       <title><xsl:value-of select="$label" /></title>
     </head>
     <body>
       <!-- Note conditional setting of variable. -->
       <xsl:variable name="processor">
         <xsl:choose>
           <xsl:when 
            test="contains(system-property('xsl:vendor'), 'SAXON')" >SAXON</xsl:when>   
           <xsl:when 
            test="contains(system-property('xsl:vendor'), 'Apache')" >Xalan</xsl:when>
           <xsl:otherwise>Unknown</xsl:otherwise>
         </xsl:choose>
       </xsl:variable>

       <h2><xsl:value-of select="$label" /></h2>
         <!--
              This example defines other namespaces for referencing
              extension functions. See the xsl:stylesheet element.
         -->
         <h3>function-available: <xsl:value-of select="$processor" /></h3>
 
         <xsl:text>xsl:function-available('element-available') = </xsl:text> 
         <xsl:value-of select="function-available('element-available')" /> 
         <br />
         <xsl:text>xalan:difference = </xsl:text> 
         <xsl:value-of select="function-available('xalan:difference')" /> 
         <br />

         <xsl:choose>
           <xsl:when test="$processor='SAXON'">
             <xsl:text>saxon:foobar = </xsl:text> 
             <xsl:value-of select="function-available('saxon:foobar')" />
           </xsl:when> 
           <xsl:when test="$processor='Xalan'">
             <xsl:text>xalan:foobar = </xsl:text> 
             <xsl:value-of select="function-available('xalan:foobar')" />
           </xsl:when> 
           <xsl:otherwise>
             <xsl:text>foobar = </xsl:text> 
             <xsl:value-of select="function-available('foobar')" />
           </xsl:otherwise> 
         </xsl:choose>
         <br />

         <xsl:text>saxon:difference = </xsl:text> 
         <xsl:value-of select="function-available('saxon:difference')" /> 
         <br />
         <xsl:text>saxon:forAll = </xsl:text> 
         <xsl:value-of select="function-available('saxon:forAll')" /> 
         <br />

         <h3>element-available: <xsl:value-of select="$processor" /></h3>

         <xsl:text>xsl:text = </xsl:text>     
         <xsl:value-of select="element-available('xsl:text')" /> 
         <br />
         <xsl:text>xsl:foobar = </xsl:text> 
         <xsl:value-of select="element-available('xsl:foobar')" /> 
         <br />
         <xsl:text>xsl:message = </xsl:text> 
         <xsl:value-of select="element-available('xsl:message')" /> 
         <br />

         <xsl:text>xalan:difference = </xsl:text> 
         <xsl:value-of select="element-available('xalan:difference')" /> 
         <br />

         <xsl:choose>
           <xsl:when test="$processor='SAXON'">
             <xsl:text>saxon:foobar = </xsl:text> 
             <xsl:value-of select="element-available('saxon:foobar')" />
           </xsl:when> 
           <xsl:when test="$processor='Xalan'">
             <xsl:text>xalan:foobar = </xsl:text> 
             <xsl:value-of select="element-available('xalan:foobar')" />
           </xsl:when> 
           <xsl:otherwise>
             <xsl:text>foobar = </xsl:text> 
             <xsl:value-of select="element-available('foobar')" />
           </xsl:otherwise> 
         </xsl:choose>
         <br />

         <xsl:text>saxon:preview = </xsl:text> 
         <xsl:value-of select="element-available('saxon:preview')" /> 
         <br />
         <xsl:text>saxon:script = </xsl:text> 
         <xsl:value-of select="element-available('saxon:script')" /> 

         <h3>system-property</h3>

         <xsl:text>xsl:version = </xsl:text> 
         <xsl:value-of select="system-property('xsl:version')" /> 
         <br />
         <xsl:text>xsl:vendor = </xsl:text> 
         <xsl:value-of select="system-property('xsl:vendor')" /> 
         <br />
         <xsl:text>xsl:vendor-url = </xsl:text> 
         <xsl:value-of select="system-property('xsl:vendor-url')" /> 

         <h3>document</h3>

         <xsl:text>document('collection7.xml')/Collection/CD[1]/Title = </xsl:text> 
         <i><xsl:value-of select="document('collection7.xml')/Collection/CD[1]/Title" /></i> 
         <br />

         <xsl:variable name="doc" select="document('collection7.xml')" />

         <xsl:text>$doc/Collection/Book[1]/Title = </xsl:text> 
         <i><xsl:value-of select="$doc/Collection/Book[1]/Title" /></i> 
         <br />
         <xsl:text>document('collection7.xml')/Collection/CD[2] = </xsl:text> 
         <xsl:value-of select="document('collection7.xml')/Collection/CD[2]" /> 
         <br />

         <h3>format-number</h3>

         <xsl:text>ListPrice of </xsl:text> 
         <i><xsl:value-of select="$doc//CD[1]/Title" /></i>
         <xsl:text> is $</xsl:text> 
         <xsl:value-of select="$doc//CD[1]/ListPrice" />
         <br />
         <xsl:text>ListPrice of </xsl:text> 
         <i><xsl:value-of select="$doc//Book[1]/Title" /></i>
         <xsl:text> is $</xsl:text> 
         <xsl:value-of select="$doc//Book[1]/ListPrice" />
         <br />
         <xsl:text>Combined price using format-number(sum($doc//ListPrice), '$#.00') = </xsl:text> 
         <xsl:value-of select="format-number(sum($doc//ListPrice), '$#.00')" />

         <h3>key</h3>
         <!-- 
              If we know only one match is possible, we could save the
              node in a variable for subsequent processing.
         -->
         <xsl:variable name="FoundPrice" select="key('PriceKey', '24.95')" />
         <xsl:text>Found key('PriceKey', '24.95') with Title = </xsl:text>
         <i><xsl:value-of select="$FoundPrice/Title" /></i>
         <br />
         <!-- 
              Although it doesn't apply in the first case, we could iterate
              over all of the instances that match a particular key,
              for example, if multiple books had the same author.
         -->
         <xsl:for-each select="key('TitleKey', 'Venus and Mars')" >
           <xsl:text>Found key('TitleKey', 'Venus and Mars') with ListPrice = $</xsl:text>
           <xsl:value-of select="./ListPrice" />
         </xsl:for-each>
         <br />
         <xsl:for-each select="key('AuthorKey', 'McCartney')" >
           <xsl:text>Found key('AuthorKey', 'McCartney') with Title = </xsl:text>
           <i><xsl:value-of select="./Title" /></i>
           <br />
         </xsl:for-each>

         <h3>generate-id</h3>

         <b>pass 1: Book and CD Nodes</b><br />
         <xsl:for-each select="//Book | //CD" >
           <i><xsl:value-of select="./Title" /></i>
           <xsl:text>, id = </xsl:text>
           <xsl:value-of select="generate-id()" />
           <br />
         </xsl:for-each>

         <b>pass 2: Title Nodes</b><br />
         <xsl:for-each select="//CD/Title | //Book/Title" >
           <i><xsl:value-of select="." /></i>
           <xsl:text>, id = </xsl:text>
           <xsl:value-of select="generate-id()" />
           <br />
         </xsl:for-each>

         <b>pass 3: Revisit Book and CD Nodes</b><br />
         <xsl:for-each select="//Book | //CD" >
           <i><xsl:value-of select="./Title" /></i>
           <xsl:text>, id = </xsl:text>
           <xsl:value-of select="generate-id()" />
           <br />
         </xsl:for-each>

     </body>
   </html>
</xsl:template>

</xsl:stylesheet>

