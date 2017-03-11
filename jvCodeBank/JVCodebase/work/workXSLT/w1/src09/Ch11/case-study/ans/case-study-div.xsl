<?xml version='1.0'?>
<!--
      XSLT stylesheet to extract only the link titles and URLs from
      the "For Further Exploration" section of a chapter and generate
      an HTML list of links, sorted by link title. Input is XML as
      output from FrameMaker 5.5.6.

      NOTE: This version is about twice as long and complicated as
      necessary to do the task, mainly to add some frills that 
      illustrate useful XSLT functionality.
-->
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>

<!-- 
     Alternatively, could generate XHTML output instead:
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns="http://www.w3.org/TR/xhtml1/strict">
<xsl:output method="xml" indent="yes" encoding="iso-8859-1"/>
-->

<!-- This makes a huge difference with our particular input. -->
<xsl:strip-space elements="*" />

<!-- Constants -->

<xsl:variable name="bookTitle">XML Family of Specifications: A Practical Guide</xsl:variable>
<xsl:variable name="bookURL">http://www.awlonline.com/product/0,2627,0201703599,00.html</xsl:variable>
<xsl:variable name="isbn">0-201-70359-9</xsl:variable>
<xsl:variable name="author">Kenneth B. Sall</xsl:variable>
<xsl:variable name="publisher">ADDISON WESLEY, INC.</xsl:variable>
<xsl:variable name="bookTitleStyle">padding: 5px; border: thin solid red; font-size: 150%; font-family: Helvetica, sans-serif; font-weight: bold;</xsl:variable>
<xsl:variable name="chapTitleStyle">padding: 2px; border: thick solid blue; font-size: 125%; font-family: Helvetica, sans-serif; font-weight: bold;</xsl:variable>

<!-- Default values; override by command line param passing. -->
<xsl:param name="chapNum" >0000</xsl:param>
<xsl:param name="chapTitle" >Unspecified Chapter Title</xsl:param>
<!-- Controls sorting of link titles -->
<xsl:param name="sortLinks" >no</xsl:param> 

<!-- end top level elements -->

<xsl:template match="/">
   <html>   
   <!-- or xhtml xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en" -->
     <head>
       <title>
       Ch. <xsl:value-of select="$chapNum"/>: <xsl:value-of select="$chapTitle"/>
       </title>
     </head>
     <body>
       <xsl:apply-templates select="XML"/> 
       <!-- FrameMaker DOCTYPE (root element) -->
     </body>
   </html>
</xsl:template>

<!--
<xsl:template match="FOOTNOTES">
  <h3>Chapter <xsl:value-of select="$chapNum"/> has 
<xsl:value-of select="count(FOOTNOTE)"/> footnotes.</h3>
</xsl:template>
-->

<!-- Display all HC headings; not required by the case study.
<xsl:template match="HC">
  <h3>HC =   <xsl:value-of select="$chapNum"/>
<xsl:number format=".1.1" /><xsl:value-of select="."/></h3>
</xsl:template>
-->

<!-- 
     Start the URL list with the beginning of the 
     'For Further Exploration' section.

             KLUDGE:
     Unfortunately, the XML exporting of FrameMaker 5.5.6 is limited. It
     doesn't maintain the hierarchy that all Link-Title and Link-URL elements
     are children of the 'For Further Exploration' <HC> element or better yet, a
     <DIV> element that contains <HC> and Link-Title and Link-URL elements. 
     Therefore, to begin/end the <ul> list properly and to be able to sort the 
     URLs by Link-Title, it is necessary to manually edit the XML output and 
     move the end </HC> tag to just after the last link, like so:
         <Link-Title>
         <A ID="pgfId-1034661"></A>
         Whatever Title</Link-Title>
         <Link-URL>
         <A ID="pgfId-1034082"></A>
         http://whatever</Link-URL>
         </HC> 
         <FOOTNOTES>
    It would seem that some variation of "following-sibling" would
    make this manual edit unnessary, such as this line in the <ul>:
      <xsl:apply-templates select="following-sibling::Link-Title" />
-->
<xsl:template match="HC[contains(text(),'For Further Exploration') and 
                     not(contains(text(),'Case Study')) ]">
  <!-- 
       Second predicate is only needed because the XSLT chapter's case study
       contains the words 'For Further Exploration' in its heading!
  -->

  <h1 align="center"
      style="{$bookTitleStyle}"><xsl:value-of select="$bookTitle"/></h1>    
  <h2 align="center"
      style="{$chapTitleStyle}">Ch. <xsl:value-of select="$chapNum"/>: 
      <xsl:value-of select="$chapTitle"/></h2>
  <h3 align="center">For Further Exploration</h3>

  <!-- Create bulleted list of link titles and links, possibly sorted. -->
  <ul style="font-weight: bold;">
   <xsl:choose>
    <xsl:when test="$sortLinks = 'yes'"> <!-- do sort -->
      <xsl:apply-templates select="//Link-Title">
        <xsl:sort data-type="text" order="ascending" select="." />
      </xsl:apply-templates> <!-- sort & process all Link-Title children -->
    </xsl:when>
    <xsl:when test="$sortLinks = 'no'"> <!-- don't  sort -->
      <xsl:apply-templates select="//Link-Title" /> <!-- process children -->
    </xsl:when>
   </xsl:choose>
  </ul>

  <!-- Footer is constant for all chapters. -->
  <p style="background-color: #ffff00;">
  Excerpted from <i><b>
   <xsl:element name="a" >
      <xsl:attribute name="href" >
       <xsl:value-of select="$bookURL" />
      </xsl:attribute>
      <xsl:value-of select="$bookTitle" />
   </xsl:element>
   </b></i> 
  (ISBN <xsl:value-of select="$isbn"/>)
  by <xsl:value-of select="$author"/>, 
  Copyright <xsl:text disable-output-escaping="no">&#169;</xsl:text> 2002
  <!-- 
      Above works for HTML, but not for XHTML or XML output, we'd need:  
      &amp;copy; with  disable-output-escaping="yes"
  -->
  <b><a href="http://www.awl.com/"><xsl:value-of select="$publisher"/></a></b><br/>
  All Rights Reserved.
  </p>
</xsl:template> <!-- For Further Exploration Section -->

<!-- 
     Link-Title template assumes there is a DIV element following
     Link-Title which contains the Link-URL associated with the current
     title. This is a bit strange since it would be more natural to have
     the DIV contain both the Link-Title and Link-URL, but that's not what
     is generated since the first Link-Title is in a different DIV.
     We use normalize-space() tp get rid of the extra white space due to
     the unnecessary <A> elements FrameMaker generates, such as:
         <Link-URL>
         <A ID="pgfId-1034082"></A>
         http://whatever</Link-URL>
     Without normalize-space() we'd get characters like "%0D%OA" before
     "http" which confuses browsers into thinking the URL is file:// [local].

         KLUDGE:
     Some chapters have an extra <DIV> level, so may need this line instead:
     <xsl:value-of select="normalize-space(following::DIV/Link-URL)" />
-->
<xsl:template match="Link-Title">
 <li>
   <xsl:element name="a" >
     <xsl:attribute name="href">
       <!-- Pick the first Link-URL that follows this Link-Title. -->
     <xsl:value-of select="normalize-space(following::DIV/Link-URL[1])" />
       <!-- xsl:value-of select="normalize-space(following-sibling::Link-URL[1])" / -->
     </xsl:attribute>
     <xsl:value-of select="." /><!-- link text -->
   </xsl:element>
 </li>
</xsl:template>

<!-- 
     Ignore all styles other than link info. Override default element rule. 
     It is certainly inconvenient and prone to error to have to explicitly
     list every element we want to skip, so we instead override text default.
     <xsl:template 
          match="BL1|BL|BLList|BX|BXT|Body|C1|CAPTION|CDT|CDT1|CELL|CP1|CP|CPX|Code|E1|E2|Emphasis|EX|FC|FN|FOOTNOTE|FOOTNOTES|FTN|Glossary-Term|HA|HB|HC|HD|HE|NL|NL1|NLList|Quotation|ROW|TABLE|TB1|TB|TBX|TCH|TH|TITLE|TN|" >
     </xsl:template>
-->
<xsl:template match="text()">
  <!-- Swallow all text content since we only care about Link-Title -->
</xsl:template>

</xsl:stylesheet>
