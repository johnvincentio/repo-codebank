<?xml version="1.0"?>

<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:doc="http://xsltsl.org/xsl/documentation/1.0"
	xmlns:str="http://xsltsl.org/string"
	extension-element-prefixes="doc str">

  <doc:reference xmlns="">
    <referenceinfo>
      <releaseinfo role="meta">
	$Id: string.xsl,v 1.5 2001/11/03 00:46:01 balls Exp $
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

  <doc:template name="str:substring-after-last" xmlns="">
    <refpurpose>String extraction</refpurpose>

    <refdescription>
      <para>Extracts the portion of string 'text' which occurs after the last of the character in string 'chars'.</para>
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

  <xsl:template name="str:substring-after-last">
    <xsl:param name="text"/>
    <xsl:param name="char"/>

    <xsl:choose>

      <xsl:when test="contains($text, $char)">
        <xsl:variable name="last" select="substring-after($text, $char)"/>

	<xsl:choose>
	  <xsl:when test="contains($last, $char)">
	    <xsl:call-template name="str:substring-after-last">
	      <xsl:with-param name="text" select="$last"/>
	      <xsl:with-param name="char" select="$char"/>
	    </xsl:call-template>
	  </xsl:when>
	  <xsl:otherwise>
	    <xsl:value-of select="$last"/>
	  </xsl:otherwise>
	</xsl:choose>
      </xsl:when>

      <xsl:otherwise>
        <xsl:value-of select="$text"/>
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

  <doc:template name="str:count-substring" xmlns="">
    <refpurpose>Count Substrings</refpurpose>

    <refdescription>
      <para>Counts the number of times a substring occurs in a string.  This can also counts the number of times a character occurs in a string, since a character is simply a string of length 1.</para>
    </refdescription>

    <example>
      <title>Counting Lines</title>
      <programlisting><![CDATA[
<xsl:call-template name="str:count-substring">
  <xsl:with-param name="text" select="$mytext"/>
  <xsl:with-param name="chars" select="'&#x0a;'"/>
</xsl:call-template>
]]></programlisting>
    </example>

    <refparameter>
      <variablelist>
	<varlistentry>
	  <term>text</term>
	  <listitem>
	    <para>The source string.</para>
	  </listitem>
	</varlistentry>
	<varlistentry>
	  <term>chars</term>
	  <listitem>
	    <para>The substring to count.</para>
	  </listitem>
	</varlistentry>
      </variablelist>
    </refparameter>

    <refreturn>
      <para>Returns a non-negative integer value.</para>
    </refreturn>
  </doc:template>

  <xsl:template name="str:count-substring">
    <xsl:param name="text"/>
    <xsl:param name="chars"/>

    <xsl:choose>
      <xsl:when test="string-length($text) = 0 or string-length($chars) = 0">
	<xsl:text>0</xsl:text>
      </xsl:when>
      <xsl:when test="contains($text, $chars)">
	<xsl:variable name="remaining">
	  <xsl:call-template name="str:count-substring">
	    <xsl:with-param name="text" select="substring-after($text, $chars)"/>
	    <xsl:with-param name="chars" select="$chars"/>
	  </xsl:call-template>
	</xsl:variable>
	<xsl:value-of select="$remaining + 1"/>
      </xsl:when>
      <xsl:otherwise>
	<xsl:text>0</xsl:text>
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>

  <doc:template name="str:substring-after-at" xmlns="">
    <refpurpose>String extraction</refpurpose>
    <refdescription>
      <para>Extracts the portion of a 'char' delimited 'text' string "array" at a given 'position' </para>
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
          <para>delimiters</para>
          </listitem>
        </varlistentry>
        <varlistentry>
          <term>position</term>
          <listitem>
            <para>position of the elements</para>
          </listitem>
        </varlistentry>
      </variablelist>
    </refparameter>
    <refreturn>
      <para>Returns string.</para>
    </refreturn>
  </doc:template>


  <xsl:template name="str:substring-after-at">
    <xsl:param name="text"/>
    <xsl:param name="char"/>
    <xsl:param name="position"/>
    <xsl:choose>
      <xsl:when test="$position = 0 or not(contains($text ,$char))">
        <xsl:choose>
          <xsl:when test="contains($text ,$char)">
            <xsl:value-of select="substring-before($text,$char)"/>
          </xsl:when>
          <xsl:otherwise>
            <xsl:value-of select="$text"/>
          </xsl:otherwise>
        </xsl:choose>
      </xsl:when>
      <xsl:when test="contains($text ,$char) and $position &gt; 0">
        <xsl:variable name="last" select="substring-after($text,$char)"/>

        <xsl:choose>
          <xsl:when test="$position &gt; 0">
            <xsl:call-template name="str:substring-after-at">
              <xsl:with-param name="text" select="$last"/>
              <xsl:with-param name="char" select="$char"/>
              <xsl:with-param name="position" select="$position - 1"/>
            </xsl:call-template>
          </xsl:when>
        </xsl:choose>
      </xsl:when>
    </xsl:choose>
  </xsl:template>

  <doc:template name="str:insert-at" xmlns="">
    <refpurpose>String insertion</refpurpose>
    <refdescription>
      <para>Insert 'chars' into "text' at any given "position'</para>
    </refdescription>
    <refparameter>
      <variablelist>
        <varlistentry>
          <term>text</term>
          <listitem>
            <para>The string upon which to perform insertion</para>
          </listitem>
        </varlistentry>
        <varlistentry>
          <term>position</term>
          <listitem>
            <para>the position where insertion will be performed</para>
          </listitem>
        </varlistentry>
        <varlistentry>
          <term>with</term>
          <listitem>
            <para>The string to be inserted</para>
          </listitem>
        </varlistentry>
      </variablelist>
    </refparameter>
    <refreturn>
      <para>Returns string.</para>
    </refreturn>
  </doc:template>

  <xsl:template name="str:insert-at">
    <xsl:param name="text"/>
    <xsl:param name="position"/>
    <xsl:param name="chars"/>

    <xsl:variable name="firstpart" select="substring($text, 0, $position)"/>
    <xsl:variable name="secondpart" select="substring($text, $position, string-length($text))"/>

    <xsl:value-of select="concat($firstpart, $chars, $secondpart)"/>
  </xsl:template>
 

  <doc:template name="str:backward" xmlns="">
    <refpurpose>String reversal</refpurpose>

    <refdescription>
      <para>Reverse the content of a given string</para>
    </refdescription>

    <refparameter>
      <variablelist>
        <varlistentry>
          <term>text</term>
          <listitem>
            <para>The string to be reversed</para>
          </listitem>
        </varlistentry>
      </variablelist>
    </refparameter>

    <refreturn>
      <para>Returns string.</para>
    </refreturn>
  </doc:template>

  <xsl:template name="str:backward">
    <xsl:param name="text"/>
    <xsl:variable name="mirror">
      <xsl:call-template name="str:build-mirror">
        <xsl:with-param name="text" select="$text"/>
        <xsl:with-param name="position" select="string-length($text)"/>
      </xsl:call-template>
    </xsl:variable>
    <xsl:value-of select="substring($mirror, string-length($text) + 1, string-length($text))"/>
  </xsl:template>

  <xsl:template name="str:build-mirror">
    <xsl:param name="text"/>
    <xsl:param name="position"/>

    <xsl:choose>
      <xsl:when test="$position &gt; 0">
        <xsl:call-template name="str:build-mirror">
          <xsl:with-param name="text" select="concat($text, substring($text, $position, 1))"/>
          <xsl:with-param name="position" select="$position - 1"/>
        </xsl:call-template>
      </xsl:when>
      <xsl:otherwise>
        <xsl:value-of select="$text"/>
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>

  <doc:template name="str:character-first" xmlns="">
    <refpurpose>Find first occurring character in a string</refpurpose>

    <refdescription>
      <para>Finds which of the given characters occurs first in a string.</para>
    </refdescription>

    <refparameter>
      <variablelist>
	<varlistentry>
	  <term>text</term>
	  <listitem>
	    <para>The source string.</para>
	  </listitem>
	</varlistentry>
	<varlistentry>
	  <term>chars</term>
	  <listitem>
	    <para>The characters to search for.</para>
	  </listitem>
	</varlistentry>
      </variablelist>
    </refparameter>
  </doc:template>

  <xsl:template name="str:character-first">
    <xsl:param name="text"/>
    <xsl:param name="chars"/>

    <xsl:choose>
      <xsl:when test="string-length($text) = 0 or string-length($chars) = 0"/>

      <xsl:when test="contains($text, substring($chars, 1, 1))">
	<xsl:variable name="next-character">
	  <xsl:call-template name="str:character-first">
	    <xsl:with-param name="text" select="$text"/>
	    <xsl:with-param name="chars" select="substring($chars, 2)"/>
	  </xsl:call-template>
	</xsl:variable>

	<xsl:choose>
	  <xsl:when test="string-length($next-character)">
	    <xsl:variable name="first-character-position" select="string-length(substring-before($text, substring($chars, 1, 1)))"/>
	    <xsl:variable name="next-character-position" select="string-length(substring-before($text, $next-character))"/>

	    <xsl:choose>
	      <xsl:when test="$first-character-position &lt; $next-character-position">
		<xsl:value-of select="substring($chars, 1, 1)"/>
	      </xsl:when>
	      <xsl:otherwise>
		<xsl:value-of select="$next-character"/>
	      </xsl:otherwise>
	    </xsl:choose>
	  </xsl:when>
	  <xsl:otherwise>
	    <xsl:value-of select="substring($chars, 1, 1)"/>
	  </xsl:otherwise>
	</xsl:choose>
      </xsl:when>
      <xsl:otherwise>
	<xsl:call-template name="str:character-first">
	  <xsl:with-param name="text" select="$text"/>
	  <xsl:with-param name="chars" select="substring($chars, 2)"/>
	</xsl:call-template>
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>

  <doc:template name="str:string-match" xmlns="">
    <refpurpose>Match A String To A Pattern</refpurpose>

    <refdescription>
      <para>Performs globbing-style pattern matching on a string.</para>
    </refdescription>

    <example>
      <title>Match Pattern</title>
      <programlisting><![CDATA[
<xsl:call-template name="str:string-match">
  <xsl:with-param name="text" select="$mytext"/>
  <xsl:with-param name="pattern" select="'abc*def?g'"/>
</xsl:call-template>
]]></programlisting>
    </example>

    <refparameter>
      <variablelist>
	<varlistentry>
	  <term>text</term>
	  <listitem>
	    <para>The source string.</para>
	  </listitem>
	</varlistentry>
	<varlistentry>
	  <term>pattern</term>
	  <listitem>
	    <para>The pattern to match against.  Certain characters have special meaning:</para>
	    <variablelist>
	      <varlistentry>
		<term>*</term>
		<listitem>
		  <para>Matches zero or more characters.</para>
		</listitem>
	      </varlistentry>
	      <varlistentry>
		<term>?</term>
		<listitem>
		  <para>Matches a single character.</para>
		</listitem>
	      </varlistentry>
	      <varlistentry>
		<term>\</term>
		<listitem>
		  <para>Character escape.  The next character is taken as a literal character.</para>
		</listitem>
	      </varlistentry>
	    </variablelist>
	  </listitem>
	</varlistentry>
      </variablelist>
    </refparameter>

    <refreturn>
      <para>Returns "1" if the string matches the pattern, "0" otherwise.</para>
    </refreturn>
  </doc:template>

  <xsl:template name="str:string-match">
    <xsl:param name="text"/>
    <xsl:param name="pattern"/>

    <xsl:choose>
      <xsl:when test="$pattern = '*'">
	<!-- Special case: always matches -->
	<xsl:text>1</xsl:text>
      </xsl:when>
      <xsl:when test="string-length($text) = 0 and string-length($pattern) = 0">
	<xsl:text>1</xsl:text>
      </xsl:when>
      <xsl:when test="string-length($text) = 0 or string-length($pattern) = 0">
	<xsl:text>0</xsl:text>
      </xsl:when>
      <xsl:otherwise>
	<xsl:variable name='before-special'>
	  <xsl:call-template name='str:substring-before-first'>
	    <xsl:with-param name='text' select='$pattern'/>
	    <xsl:with-param name='chars' select='"*?\"'/>
	  </xsl:call-template>
	</xsl:variable>
	<xsl:variable name='special'>
	  <xsl:call-template name='str:character-first'>
	    <xsl:with-param name='text' select='$pattern'/>
	    <xsl:with-param name='chars' select='"*?\"'/>
	  </xsl:call-template>
	</xsl:variable>

	<xsl:variable name='new-text' select='substring($text, string-length($before-special) + 1)'/>
	<xsl:variable name='new-pattern' select='substring($pattern, string-length($before-special) + 1)'/>

	<xsl:choose>
	  <xsl:when test="not(starts-with($text, $before-special))">
	    <!-- Verbatim characters don't match -->
	    <xsl:text>0</xsl:text>
	  </xsl:when>

	  <xsl:when test="$special = '*' and string-length($new-pattern) = 1">
	    <xsl:text>1</xsl:text>
	  </xsl:when>
	  <xsl:when test="$special = '*'">
	    <xsl:call-template name='str:match-postfix'>
	      <xsl:with-param name='text' select='$new-text'/>
	      <xsl:with-param name='pattern' select='substring($new-pattern, 2)'/>
	    </xsl:call-template>
	  </xsl:when>

	  <xsl:when test="$special = '?'">
	    <xsl:call-template name="str:string-match">
	      <xsl:with-param name='text' select='substring($new-text, 2)'/>
	      <xsl:with-param name='pattern' select='substring($new-pattern, 2)'/>
	    </xsl:call-template>
	  </xsl:when>

	  <xsl:when test="$special = '\' and substring($new-text, 1, 1) = substring($new-pattern, 2, 1)">
	    <xsl:call-template name="str:string-match">
	      <xsl:with-param name='text' select='substring($new-text, 2)'/>
	      <xsl:with-param name='pattern' select='substring($new-pattern, 3)'/>
	    </xsl:call-template>
	  </xsl:when>
	  <xsl:when test="$special = '\' and substring($new-text, 1, 1) != substring($new-pattern, 2, 1)">
	    <xsl:text>0</xsl:text>
	  </xsl:when>

	  <xsl:otherwise>
	    <!-- There were no special characters in the pattern -->
	    <xsl:choose>
	      <xsl:when test='$text = $pattern'>
		<xsl:text>1</xsl:text>
	      </xsl:when>
	      <xsl:otherwise>
		<xsl:text>0</xsl:text>
	      </xsl:otherwise>
	    </xsl:choose>
	  </xsl:otherwise>
	</xsl:choose>
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>

  <xsl:template name="str:match-postfix">
    <xsl:param name="text"/>
    <xsl:param name="pattern"/>

    <xsl:variable name='result'>
      <xsl:call-template name='str:string-match'>
	<xsl:with-param name='text' select='$text'/>
	<xsl:with-param name='pattern' select='$pattern'/>
      </xsl:call-template>
    </xsl:variable>

    <xsl:choose>
      <xsl:when test='$result = "1"'>
	<xsl:value-of select='$result'/>
      </xsl:when>
      <xsl:when test='string-length($text) = 0'>
	<xsl:text>0</xsl:text>
      </xsl:when>
      <xsl:otherwise>
	<xsl:call-template name='str:match-postfix'>
	  <xsl:with-param name='text' select='substring($text, 2)'/>
	  <xsl:with-param name='pattern' select='$pattern'/>
	</xsl:call-template>
      </xsl:otherwise>
    </xsl:choose>

  </xsl:template>

</xsl:stylesheet>

