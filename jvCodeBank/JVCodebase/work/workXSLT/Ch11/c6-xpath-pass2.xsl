<?xml version="1.0"?>
<xsl:stylesheet   version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>

<xsl:variable name="label">XSLT: XPath Expressions and Predicates (also Modes)</xsl:variable>

<xsl:template match="/">
   <html>  
     <head>
       <title><xsl:value-of select="$label" /></title>
     </head>
     <body>
       <h2><xsl:value-of select="$label" /></h2>
       <!-- 
            Here we are processing all nodes in the default mode,
            and then again in "pass2" mode, but in a different order.
            Consider why there is no output for Owner in pass2.
       -->
       <h2 align="center">Pass 1</h2>
       <xsl:apply-templates select="//CD" />
       <xsl:apply-templates select="//Book" />
       <xsl:apply-templates select="//Owner" />

       <h2 align="center">Pass 2</h2>
       <xsl:apply-templates select="//Book"    mode="pass2" />
       <xsl:apply-templates select="//CD"      mode="pass2" />
       <xsl:apply-templates select="//Owner"   mode="pass2" />
     </body>
   </html>
</xsl:template>
                       <!-- pass1 -->

<xsl:template match="Book[position() = 1]">
   <br /><xsl:text>First Book: </xsl:text>
   <i><xsl:value-of select="Title" /></i>
</xsl:template> 

<xsl:template match="Book[position() = last()]">
   <br /><xsl:text>Last Book: </xsl:text>
   <i><xsl:value-of select="Title" /></i>
</xsl:template> 

<xsl:template match="Book[2]">
   <br /><xsl:text>Second Book: </xsl:text>
   <i><xsl:value-of select="Title" /></i>
</xsl:template> 

<xsl:template match="CD[position() &gt; 2]">
   <br /><xsl:text>CD is greater than 2: </xsl:text>
   <i><xsl:value-of select="Title" /></i>
</xsl:template>

<xsl:template match="CD[not(Title/text() = 'Beatles 1')]">
   <br /><xsl:text>CD title is not "Beatles 1": </xsl:text>
   <i><xsl:value-of select="Title" /></i>
</xsl:template> 

<xsl:template match="Owner">
   <p align="center">
     <xsl:value-of select="Name/First" />
     <xsl:text> </xsl:text>
     <xsl:value-of select="Name/Last" />
     <xsl:text>'s Collection; </xsl:text> 
     <xsl:value-of select="Address/Street" />
     <xsl:text>; </xsl:text>    
     <xsl:value-of select="Address/City" />
     <xsl:text>, </xsl:text>
     <xsl:value-of select="Address/State" />
     <xsl:text> </xsl:text>
     <xsl:value-of select="Address/Zip" />
   </p>
</xsl:template> 
                       <!-- pass2 -->

<!-- COMMENT OUT FROM HERE....

<xsl:template match="Book/Published[@publisher = 'Harmony Books']"
              mode="pass2" >
   <br /><xsl:text>Harmony Books is publisher of book with title: </xsl:text>
   <i><xsl:value-of select="../Title" /></i>
   <xsl:text> ++ date: </xsl:text>
   <i><xsl:value-of select="." /></i>
</xsl:template> 

<xsl:template match="Book[Published &gt;= 1993]"    mode="pass2" >
   <br /><xsl:text>Book published >= 1993: </xsl:text>
   <i><xsl:value-of select="./Title" /></i>
   <xsl:text> ++ date: </xsl:text>
   <i><xsl:value-of select="./Published" /></i>
   <xsl:text> ++ publisher: </xsl:text>
   <i><xsl:value-of select="./Published/@publisher" /></i>
</xsl:template> 

<xsl:template match="CD/Title[. != 'Beatles 1']"   mode="pass2" >
   <br /><xsl:text>CD title is not "Beatles 1": </xsl:text>
   <i><xsl:value-of select="." /></i>
</xsl:template> 

<xsl:template match="//Chart/Peak[@weeks &gt;= 5]"   mode="pass2" >
   <br /><xsl:text>CD with Peek weeks >= 5: </xsl:text>
   <i><xsl:value-of select="../../Title" /></i>
</xsl:template> 

 ....TO HERE
-->

<xsl:template match="text()"    mode="pass2" >
</xsl:template>

<!--  BEGIN COMMENT

      The next few templates work, but are mutually exclusive with the
      pass 2 templates above.
-->
<xsl:template match="Book[3]/Author[4]/Name/Last"     
              mode="pass2" >
   <br /><xsl:text> Book 3: </xsl:text>
   <i><xsl:value-of select="." /></i>
</xsl:template> 
 
<xsl:template match="Book[3]/Author[4][Name/Last = 'Lennon']"     
              mode="pass2" >
   <br /><xsl:text> Book 3: </xsl:text>
   <i><xsl:value-of select="." /></i>
</xsl:template>

<xsl:template match="Book[3]/Author[2][Name/Last = 'Harrison']"     
              mode="pass2" >
   <br /><xsl:text> Book 3: </xsl:text>
   <i><xsl:value-of select="." /></i>
</xsl:template>

<xsl:template match="CD[2] | CD[3]"     
              mode="pass2" >
   <br /><i><xsl:value-of select="Title" /></i>
   <xsl:text>,  Peak/@country: </xsl:text>
   <i><xsl:value-of select="descendant::Peak/@country" /></i>
   <xsl:text>,  Peak[@country]: </xsl:text>
   <i><xsl:value-of select="descendant::Peak[@country]" /></i>
</xsl:template> 

<xsl:template match="Book[position()=last()]/Author[4][@age='40']"     
              mode="pass2" >
   <br /><xsl:text> Got Age, Book 3: </xsl:text>
   <i><xsl:value-of select="." /></i>
</xsl:template> 

<!-- END COMMENT -->

</xsl:stylesheet>

