<?xml version="1.0"?>
<stylesheet xmlns="http://www.w3.org/1999/XSL/Transform"
                version="1.0">
  <output method="xml" indent="yes" />

  <variable name="Owner" select="/Collection/Owner" />

  <template match="/">
    <!-- Create a new document element for the output XML. -->
    <!-- Add attributes extracted from Owner element. -->
    <element name="Book.List" >
      <attribute name="seller" >
       <!-- Need to normal-space since Name has 2 children. -->
       <value-of select="normalize-space($Owner/Name)" />
      </attribute>
      <attribute name="city" >
       <value-of select="$Owner/Address/City" />
      </attribute>
      <attribute name="state" >
       <value-of select="$Owner/Address/State" />
      </attribute>
      <!-- Handle children of the document element. -->
      <apply-templates  select="/Collection/Book"/>
    </element>
  </template>

  <!-- Transform book hierarchy into flat hierarchy with a
       elements Type and ListPrice from original mapped to 
       attributes kind and price. Concatenate Last,First name.
  -->
  <template match="Book">
   <Book.Title>
      <attribute name="kind" >
        <value-of select="Type" />
      </attribute>
      <attribute name="price" >
        <value-of select="ListPrice" />
      </attribute>
     <value-of select="Title" />
   </Book.Title>
   <Book.Author>
     <value-of select="Author/Name/Last" />, <value-of select="Author/Name/First" />
   </Book.Author>
   <apply-templates  select="Published"/>

   <!-- Just to illustrate dynamic element naming. -->
   <element name="{Type}" />

  </template>

  <!-- Turn element with attribute inside out, changing:
       <Published publisher="foo">year</Published> 
       into:
       <Publisher publicationYear="year">foo</Published>
  -->
  <template match="Published">
    <element name="Book.Publisher">
      <attribute name="publicationYear" >
        <value-of select="." />
      </attribute>
      <value-of select="@publisher"/>
    </element>
  </template>

</stylesheet>

