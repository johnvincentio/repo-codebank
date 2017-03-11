<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">
  <xsl:output method="xml" indent="yes" />

  <!-- Convert source.xml to target.xml -->

  <xsl:template match="/Invoice">
    <Inv.Statement>  
      <xsl:apply-templates select="Items" /> 
      <Customer>
        <xsl:value-of select="@custid" />
      </Customer> 
      <xsl:apply-templates select="ShipTo" />     
    </Inv.Statement>   
  </xsl:template>

  <xsl:template match="Items">
    <Goods>
      <xsl:apply-templates select="Item" />       
      <ItemCount><xsl:value-of select="@count" /></ItemCount>
    </Goods>
  </xsl:template>

  <xsl:template match="Item">
    <ItemDetail>
      <ProductNumber><xsl:value-of select="@id" /></ProductNumber>
      <Price><xsl:value-of select="Price" /></Price>
      <Note><xsl:value-of select="Description" /></Note>
    </ItemDetail>
  </xsl:template>

  <xsl:template match="ShipTo">
    <Shipping>
    <Address>
      <Street><xsl:value-of select="Address/Street" /></Street>
      <City><xsl:value-of 
               select="substring-before(Address/CityAndState, ',')" /></City>
      <State><xsl:value-of 
               select="substring(substring-after(Address/CityAndState, ','), 2, 2)" />
      </State>
      <!-- OR:
               select="substring-after(substring-after(Address/CityAndState, ','), ' ')" /></State>
      -->
    </Address>
    <Last.Name><xsl:value-of select="substring-after(Name, ' ')" /></Last.Name>
    <First.Name><xsl:value-of select="substring-before(Name, ' ')" /></First.Name>
    </Shipping>

  </xsl:template>

  <xsl:template match="Published">
    <xsl:element name="Book.Publisher">
      <xsl:attribute name="publicationYear" >
        <xsl:value-of select="." />
      </xsl:attribute>
      <xsl:value-of select="@publisher"/>
    </xsl:element>
  </xsl:template>

</xsl:stylesheet>

