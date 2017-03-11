<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">
  <xsl:output method="xml" indent="yes" />

  <xsl:variable name="Owner" select="/Collection/Owner" />

  <xsl:template match="/">
    <!-- Create a new document element for the output XML. -->
    <!-- Add attributes extracted from Owner element. -->
    <xsl:element name="Book.List" >
      <xsl:attribute name="seller" >
       <!-- Need to normal-space since Name has 2 children. -->
       <xsl:value-of select="normalize-space($Owner/Name)" />
      </xsl:attribute>
      <xsl:attribute name="city" >
       <xsl:value-of select="$Owner/Address/City" />
      </xsl:attribute>
      <xsl:attribute name="state" >
       <xsl:value-of select="$Owner/Address/State" />
      </xsl:attribute>
      <!-- Handle children of the document element. -->
      <xsl:apply-templates  select="/Collection/Book"/>
    </xsl:element>
  </xsl:template>

  <!-- Transform book hierarchy into flat hierarchy with a
       elements Type and ListPrice from original mapped to 
       attributes kind and price. Concatenate Last,First name.
  -->
  <xsl:template match="Book">

   <Book.Title>
      <xsl:attribute name="kind" >
        <xsl:value-of select="Type" />
      </xsl:attribute>
      <xsl:attribute name="price" >
        <xsl:value-of select="ListPrice" />
      </xsl:attribute>
     <xsl:value-of select="Title" />
   </Book.Title>

   <Book.Author>
     <xsl:value-of select="Author/Name/Last" />, <xsl:value-of select="Author/Name/First" />
   </Book.Author>

   <xsl:apply-templates  select="Published"/>

   <!-- Dynamic element naming via attribute value template. -->
   <xsl:element name="Book.{Type}" />

  </xsl:template>

  <!-- Turn element with attribute inside out, changing:
       <Published publisher="foo">year</Published> 
       into:
       <Publisher publicationYear="year">foo</Publisher>
  -->
  <xsl:template match="Published">
    <xsl:element name="Book.Publisher">
      <xsl:attribute name="publicationYear" >
        <xsl:value-of select="." />
      </xsl:attribute>
      <xsl:value-of select="@publisher"/>
    </xsl:element>
  </xsl:template>

</xsl:stylesheet>

