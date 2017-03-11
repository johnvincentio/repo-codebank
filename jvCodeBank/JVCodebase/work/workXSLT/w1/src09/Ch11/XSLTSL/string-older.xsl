<?xml version="1.0"?>

<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:doc="http://xsltsl.sourceforge.net/xsl/documentation/1.0"
	xmlns:str="http://xsltsl.sourceforge.net/string"
	extension-element-prefixes="doc str">

  <doc:reference xmlns="">
    <referenceinfo>
      <releaseinfo role="meta">
	$Id: string.xsl,v 1.3 2001/04/10 01:17:23 balls Exp $
      </releaseinfo>
      <author>
	<surname>Ball</surname>
	<firstname>Steve</firstname>
      </author>
      <copyright>
	<year>2001</year>
	<holder>Steve Ball</holder>
      </copyright>
    </referenceinfo>

    <title>String Processing</title>

    <partintro>
      <section>
	<title>Introduction</title>

	<para>This module provides templates for manipulating strings.</para>

      </section>
    </partintro>

  </doc:reference>

  <!-- Common string constants and datasets as XSL variables -->

  <xsl:variable name="str:lower" select="'abcdefghijklmnopqrstuvwxyz'"/>
  <xsl:variable name="str:upper" select="'ABCDEFGHIJKLMNOPQRSTUVWXYZ'"/>
  <xsl:variable name="str:digits" select="'0123456789'"/>
  <xsl:variable name="str:ws" select="' 	
'"/>

  <doc:template name="str:to-upper" xmlns="">
    <refpurpose>Make string uppercase</refpurpose>

    <refdescription>
      <para>Converts all lowercase letters to uppercase.</para>
    </refdescription>

    <refparameter>
      <variablelist>
	<varlistentry>
	  <term>text</term>
	  <listitem>
	    <para>The string to be converted</para>
	  </listitem>
	</varlistentry>
      </variablelist>
    </refparameter>

    <refreturn>
      <para>Returns string with all uppercase letters.</para>
    </refreturn>
  </doc:template>

  <xsl:template name="str:to-upper">
    <xsl:param name="text"/>

    <xsl:value-of select="translate($text, $str:lower, $str:upper)"/>
  </xsl:template>

  <doc:template name="str:to-lower" xmlns="">
    <refpurpose>Make string lowercase</refpurpose>

    <refdescription>
      <para>Converts all uppercase letters to lowercase.</para>
    </refdescription>

    <refparameter>
      <variablelist>
	<varlistentry>
	  <term>text</term>
	  <listitem>
	    <para>The string to be converted</para>
	  </listitem>
	</varlistentry>
      </variablelist>
    </refparameter>

    <refreturn>
      <para>Returns string with all lowercase letters.</para>
    </refreturn>
  </doc:template>

  <xsl:template name="str:to-lower">
    <xsl:param name="text"/>

    <xsl:value-of select="translate($text, $str:upper, $str:lower)"/>
  </xsl:template>

  <doc:template name="str:capitalise" xmlns="">
    <refpurpose>Capitalise string</refpurpose>

    <refdescription>
      <para>Converts first character of string to an uppercase letter.  All remaining characters are converted to lowercase.</para>
    </refdescription>

    <refparameter>
      <variablelist>
	<varlistentry>
	  <term>text</term>
	  <listitem>
	    <para>The string to be capitalised</para>
	  </listitem>
	</varlistentry>
	<varlistentry>
	  <term>all</term>
	  <listitem>
	    <para>Boolean controlling whether all words in the string are capitalised.</para>
	    <para>Default is true.</para>
	  </listitem>
	</varlistentry>
      </variablelist>
    </refparameter>

    <refreturn>
      <para>Returns string with first character uppcase and all remaining characters lowercase.</para>
    </refreturn>
  </doc:template>

  <xsl:template name="str:capitalise">
    <xsl:param name="text"/>
    <xsl:param name="all" select="true()"/>

    <xsl:choose>
      <xsl:when test="$all and (contains($text, ' ') or contains($text, '	') or contains($text, '&#10;'))">
	<xsl:variable name="firstword">
	  <xsl:call-template name="str:substring-before-first">
	    <xsl:with-param name="text" select="$text"/>
	    <xsl:with-param name="chars" select="$str:ws"/>
	  </xsl:call-template>
	</xsl:variable>
	<xsl:call-template name="str:capitalise">
	  <xsl:with-param name="text">
	    <xsl:value-of select="$firstword"/>
	  </xsl:with-param>
	  <xsl:with-param name="all" select="false()"/>
	</xsl:call-template>
	<xsl:value-of select="substring($text, string-length($firstword) + 1, 1)"/>
	<xsl:call-template name="str:capitalise">
	  <xsl:with-param name="text">
	    <xsl:value-of select="substring($text, string-length($firstword) + 2)"/>
	  </xsl:with-param>
	</xsl:call-template>
      </xsl:when>

      <xsl:otherwise>
	<xsl:call-template name="str:to-upper">
	  <xsl:with-param name="text" select="substring($text, 1, 1)"/>
	</xsl:call-template>
	<xsl:call-template name="str:to-lower">
	  <xsl:with-param name="text" select="substring($text, 2)"/>
	</xsl:call-template>
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>

  <doc:template name="str:substring-before-first" xmlns="">
    <refpurpose>String extraction</refpurpose>

    <refdescription>
      <para>Extracts the portion of string 'text' which occurs before any of the characters in string 'chars'.</para>
    </refdescription>

    <refparameter>
      <variablelist>
	<varlistentry>
	  <term>text</term>
	  <listitem>
	    <para>The string from which to extract a substring.</para>
	  </listitem>
	</varlistentry>
	<varlistentry>
	  <term>chars</term>
	  <listitem>
	    <para>The string containing characters to find.</para>
	  </listitem>
	</varlistentry>
      </variablelist>
    </refparameter>

    <refreturn>
      <para>Returns string.</para>
    </refreturn>
  </doc:template>

  <xsl:template name="str:substring-before-first">
    <xsl:param name="text"/>
    <xsl:param name="chars"/>

    <xsl:choose>

      <xsl:when test="string-length($text) = 0"/>

      <xsl:when test="string-length($chars) = 0">
	<xsl:value-of select="$text"/>
      </xsl:when>

      <xsl:when test="contains($text, substring($chars, 1, 1))">
	<xsl:variable name="this" select="substring-before($text, substring($chars, 1, 1))"/>
	<xsl:variable name="rest">
	  <xsl:call-template name="str:substring-before-first">
	    <xsl:with-param name="text" select="$text"/>
	    <xsl:with-param name="chars" select="substring($chars, 2)"/>
	  </xsl:call-template>
	</xsl:variable>

	<xsl:choose>
	  <xsl:when test="string-length($this) &lt; string-length($rest)">
	    <xsl:value-of select="$this"/>
	  </xsl:when>
	  <xsl:otherwise>
	    <xsl:value-of select="$rest"/>
	  </xsl:otherwise>
	</xsl:choose>
      </xsl:when>

      <xsl:otherwise>
	<xsl:call-template name="str:substring-before-first">
	  <xsl:with-param name="text" select="$text"/>
	  <xsl:with-param name="chars" select="substring($chars, 2)"/>
	</xsl:call-template>
      </xsl:otherwise>

    </xsl:choose>
  </xsl:template>

  <doc:template name="str:subst" xmlns="">
    <refpurpose>String substitution</refpurpose>

    <refdescription>
      <para>Substitute 'replace' for 'with' in string 'text'.</para>
    </refdescription>

    <refparameter>
      <variablelist>
	<varlistentry>
	  <term>text</term>
	  <listitem>
	    <para>The string upon which to perform substitution</para>
	  </listitem>
	</varlistentry>
	<varlistentry>
	  <term>replace</term>
	  <listitem>
	    <para>The string to substitute</para>
	  </listitem>
	</varlistentry>
	<varlistentry>
	  <term>with</term>
	  <listitem>
	    <para>The string to be substituted</para>
	  </listitem>
	</varlistentry>
      </variablelist>
    </refparameter>

    <refreturn>
      <para>Returns string.</para>
    </refreturn>
  </doc:template>

  <xsl:template name="str:subst">
    <xsl:param name="text"/>
    <xsl:param name="replace"/>
    <xsl:param name="with"/>

    <xsl:choose>
      <xsl:when test="string-length($replace) = 0">
        <xsl:value-of select="$text"/>
      </xsl:when>
      <xsl:when test="contains($text, $replace)">

	<xsl:variable name="before" select="substring-before($text, $replace)"/>
	<xsl:variable name="after" select="substring-after($text, $replace)"/>
	<xsl:variable name="prefix" select="concat($before, $with)"/>

	<xsl:value-of select="$before"/>
	<xsl:value-of select="$with"/>
        <xsl:call-template name="str:subst">
	  <xsl:with-param name="text" select="$after"/>
	  <xsl:with-param name="replace" select="$replace"/>
	  <xsl:with-param name="with" select="$with"/>
	</xsl:call-template>
      </xsl:when> 
      <xsl:otherwise>
        <xsl:value-of select="$text"/>  
      </xsl:otherwise>
    </xsl:choose>            
  </xsl:template>

</xsl:stylesheet>

