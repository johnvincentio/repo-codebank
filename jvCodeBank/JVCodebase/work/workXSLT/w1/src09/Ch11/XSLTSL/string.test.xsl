<?xml version="1.0"?>
<xsl:stylesheet
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns:doc="http://xsltsl.org/xsl/documentation/1.0"
  xmlns:str="http://xsltsl.org/string"
  exclude-result-prefixes="doc"
  version="1.0">

  <xsl:include href="../string.xsl"/>

  <doc:article>
    <doc:title>String Module Test Suite</doc:title>

    <doc:para>This stylesheet tests the string stylesheet module.</doc:para>
  </doc:article>

  <xsl:template name="string">
    <xsl:message>String tests starting</xsl:message>
    <xsl:text>&#10;&#10;Running string tests&#10;&#10;</xsl:text>

    <xsl:message>Test str:to-lower template</xsl:message>

    <xsl:call-template name="test">

      <xsl:with-param name="description">str:to-lower test</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:to-lower">
          <xsl:with-param name="text">tHiS iS a TeSt</xsl:with-param>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">this is a test</xsl:with-param>

    </xsl:call-template>
    <xsl:call-template name="test">

      <xsl:with-param name="description">str:to-lower test (empty string)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:to-lower">
          <xsl:with-param name="text"/>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect"/>

    </xsl:call-template>

    <xsl:message>Test str:to-upper template</xsl:message>

    <xsl:call-template name="test">

      <xsl:with-param name="description">str:to-upper test</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:to-upper">
          <xsl:with-param name="text">tHiS iS a TeSt</xsl:with-param>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">THIS IS A TEST</xsl:with-param>

    </xsl:call-template>
    <xsl:call-template name="test">

      <xsl:with-param name="description">str:to-upper test (empty string)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:to-upper">
          <xsl:with-param name="text"/>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect"/>

    </xsl:call-template>

    <xsl:message>Test str:capitalise template</xsl:message>

    <xsl:call-template name="test">
      <xsl:with-param name="description">str:capitalise test (single word)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:capitalise">
          <xsl:with-param name="text">capITAL</xsl:with-param>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">Capital</xsl:with-param>
    </xsl:call-template>

    <xsl:call-template name="test">
      <xsl:with-param name="description">str:capitalise test (multiple words, default setting)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:capitalise">
          <xsl:with-param name="text">capITAL iDEa</xsl:with-param>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">Capital Idea</xsl:with-param>
    </xsl:call-template>

    <xsl:call-template name="test">
      <xsl:with-param name="description">str:capitalise test (multiple words, non-default setting)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:capitalise">
          <xsl:with-param name="text">capITAL iDEa</xsl:with-param>
          <xsl:with-param name="all" select="false()"/>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">Capital idea</xsl:with-param>
    </xsl:call-template>

    <xsl:call-template name="test">
      <xsl:with-param name="description">str:capitalise test (empty string)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:capitalise"/>
      </xsl:with-param>

      <xsl:with-param name="expect"/>
    </xsl:call-template>

    <xsl:message>Test str:substring-before-first template</xsl:message>

    <xsl:call-template name="test">
      <xsl:with-param name="description">str:substring-before-first test (no text)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:substring-before-first">
          <xsl:with-param name="text"/>
          <xsl:with-param name="chars">abc</xsl:with-param>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect"/>
    </xsl:call-template>

    <xsl:call-template name="test">
      <xsl:with-param name="description">str:substring-before-first test (no chars)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:substring-before-first">
          <xsl:with-param name="text">A string to test</xsl:with-param>
          <xsl:with-param name="chars"/>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">A string to test</xsl:with-param>
    </xsl:call-template>

    <xsl:call-template name="test">
      <xsl:with-param name="description">str:substring-before-first test (single char)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:substring-before-first">
          <xsl:with-param name="text">A string to test</xsl:with-param>
          <xsl:with-param name="chars" select="'g'"/>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">A strin</xsl:with-param>
    </xsl:call-template>

    <xsl:call-template name="test">
      <xsl:with-param name="description">str:substring-before-first test (single char, multiple occurrances)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:substring-before-first">
          <xsl:with-param name="text">A string to test</xsl:with-param>
          <xsl:with-param name="chars" select="' '"/>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">A</xsl:with-param>
    </xsl:call-template>

    <xsl:call-template name="test">
      <xsl:with-param name="description">str:substring-before-first test (multiple chars, single occurrance)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:substring-before-first">
          <xsl:with-param name="text">A string to test</xsl:with-param>
          <xsl:with-param name="chars" select="' &#9;$#10;'"/>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">A</xsl:with-param>
    </xsl:call-template>

    <xsl:call-template name="test">
      <xsl:with-param name="description">str:substring-before-first test (multiple chars, multiple occurrances)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:substring-before-first">
          <xsl:with-param name="text">FirstXSecondYThirdZ</xsl:with-param>
          <xsl:with-param name="chars" select="'ZYX'"/>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">First</xsl:with-param>
    </xsl:call-template>

    <xsl:message>Test str:subst template</xsl:message>

    <xsl:call-template name="test">
      <xsl:with-param name="description">str:subst test (no replacements)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:subst">
          <xsl:with-param name="text">This is a test</xsl:with-param>
          <xsl:with-param name="replace">foo</xsl:with-param>
          <xsl:with-param name="with">bar</xsl:with-param>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">This is a test</xsl:with-param>
    </xsl:call-template>

    <xsl:call-template name="test">
      <xsl:with-param name="description">str:subst test (one replacement)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:subst">
          <xsl:with-param name="text">This is a test</xsl:with-param>
          <xsl:with-param name="replace"> is</xsl:with-param>
          <xsl:with-param name="with"> was</xsl:with-param>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">This was a test</xsl:with-param>
    </xsl:call-template>

    <xsl:call-template name="test">
      <xsl:with-param name="description">str:subst test (contributed by Ken Sall, kensall@home.com)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:subst">
          <xsl:with-param name="text">BEATles</xsl:with-param>
          <xsl:with-param name="replace" select="'BEAT'"/>
          <xsl:with-param name="with">Fab</xsl:with-param>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">Fables</xsl:with-param>
    </xsl:call-template>

    <xsl:call-template name="test">
      <xsl:with-param name="description">str:subst test (mutliple replacements)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:subst">
          <xsl:with-param name="text">This is a test, This is a test, This is a test, This is a test</xsl:with-param>
          <xsl:with-param name="replace">test</xsl:with-param>
          <xsl:with-param name="with">success</xsl:with-param>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">This is a success, This is a success, This is a success, This is a success</xsl:with-param>
    </xsl:call-template>

    <xsl:call-template name="test">
      <xsl:with-param name="description">str:subst test (empty string)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:subst">
          <xsl:with-param name="text"/>
          <xsl:with-param name="replace">foo</xsl:with-param>
          <xsl:with-param name="with">bar</xsl:with-param>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect"/>
    </xsl:call-template>

    <xsl:call-template name="test">
      <xsl:with-param name="description">str:subst test (empty with)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:subst">
          <xsl:with-param name="text">This is a test</xsl:with-param>
          <xsl:with-param name="replace">is</xsl:with-param>
          <xsl:with-param name="with"/>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">Th  a test</xsl:with-param>
    </xsl:call-template>

    <xsl:call-template name="test">
      <xsl:with-param name="description">str:subst test (empty replace)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:subst">
          <xsl:with-param name="text">This is a test</xsl:with-param>
          <xsl:with-param name="replace"/>
          <xsl:with-param name="with">foobar</xsl:with-param>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">This is a test</xsl:with-param>
    </xsl:call-template>

    <xsl:message>Test str:substring-after-last</xsl:message>

    <xsl:call-template name="test">

      <xsl:with-param name="description">str:substring-after-last test (with text)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:substring-after-last">
          <xsl:with-param name="text">hello/there/is/a/string</xsl:with-param>
          <xsl:with-param name="char">/</xsl:with-param>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">string</xsl:with-param>
    </xsl:call-template>

    <xsl:call-template name="test">

      <xsl:with-param name="description">str:substring-after-last test (with chars)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:substring-after-last">
          <xsl:with-param name="text">helloo/there/is/a/oostring</xsl:with-param>
          <xsl:with-param name="char">oo</xsl:with-param>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">string</xsl:with-param>
    </xsl:call-template>

    <xsl:call-template name="test">
      <xsl:with-param name="description">str:substring-after-last test (with chars)</xsl:with-param>
      <xsl:with-param name="result">
        <xsl:call-template name="str:substring-after-last">
          <xsl:with-param name="text">helloo</xsl:with-param>
          <xsl:with-param name="char">uu</xsl:with-param>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">helloo</xsl:with-param>
    </xsl:call-template>

    <xsl:message>Test str:insert-at</xsl:message>

    <xsl:call-template name="test">
      <xsl:with-param name="description">str:insert-at test</xsl:with-param>
      <xsl:with-param name="result">
        <xsl:call-template name="str:insert-at">
          <xsl:with-param name="text">111333</xsl:with-param>
          <xsl:with-param name="position">4</xsl:with-param>
          <xsl:with-param name="chars">222</xsl:with-param>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">111222333</xsl:with-param>
    </xsl:call-template>

    <xsl:call-template name="test">
      <xsl:with-param name="description">str:insert-at test (position greater than string length)</xsl:with-param>
      <xsl:with-param name="result">
        <xsl:call-template name="str:insert-at">
          <xsl:with-param name="text">111333</xsl:with-param>
          <xsl:with-param name="position">10</xsl:with-param>
          <xsl:with-param name="chars">222</xsl:with-param>
        </xsl:call-template>
      </xsl:with-param>
      <xsl:with-param name="expect">111333222</xsl:with-param>
    </xsl:call-template>

    <xsl:message>Test str:substring-after-at</xsl:message>

    <xsl:call-template name="test">
      <xsl:with-param name="description">str:substring-after-at test (with chars)</xsl:with-param>
      <xsl:with-param name="result">
        <xsl:call-template name="str:substring-after-at">
          <xsl:with-param name="text">when%there%was%a%horse%</xsl:with-param>
          <xsl:with-param name="position">3</xsl:with-param>
          <xsl:with-param name="char">%</xsl:with-param>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">a</xsl:with-param>
    </xsl:call-template>

    <xsl:call-template name="test">
      <xsl:with-param name="description">str:substring-after-at test (non existing substring)</xsl:with-param>
      <xsl:with-param name="result">
        <xsl:call-template name="str:substring-after-at">
          <xsl:with-param name="text">when%there%was%a%horse%</xsl:with-param>
          <xsl:with-param name="position">3</xsl:with-param>
          <xsl:with-param name="char">6</xsl:with-param>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">when%there%was%a%horse%</xsl:with-param>

    </xsl:call-template>

    <xsl:call-template name="test">
      <xsl:with-param name="description">str:substring-after-at test (position greater than number of substring)</xsl:with-param>
      <xsl:with-param name="result">
        <xsl:call-template name="str:substring-after-at">
          <xsl:with-param name="text">when%there%was%a%horse%</xsl:with-param>
          <xsl:with-param name="position">7</xsl:with-param>
          <xsl:with-param name="char">%</xsl:with-param>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect"></xsl:with-param>
    </xsl:call-template>

    <xsl:message>Test backwards</xsl:message>

    <xsl:call-template name="test">
      <xsl:with-param name="description">str:backward test (empty string)</xsl:with-param>
      <xsl:with-param name="result">
        <xsl:call-template name="str:backward">
          <xsl:with-param name="text"/>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect"/>
    </xsl:call-template>

    <xsl:call-template name="test">
      <xsl:with-param name="description">str:backward test (with chars)</xsl:with-param>
      <xsl:with-param name="result">
        <xsl:call-template name="str:backward">
          <xsl:with-param name="text">Hello</xsl:with-param>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">olleH</xsl:with-param>
    </xsl:call-template>  

    <xsl:message>Test count-substring</xsl:message>

    <xsl:call-template name="test">
      <xsl:with-param name="description">str:count-substring test (empty text)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:count-substring">
          <xsl:with-param name="text"/>
          <xsl:with-param name="chars" select="'is'"/>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">0</xsl:with-param>
    </xsl:call-template>

    <xsl:call-template name="test">
      <xsl:with-param name="description">str:count-substring test (non-empty text)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:count-substring">
          <xsl:with-param name="text">This is a test</xsl:with-param>
          <xsl:with-param name="chars" select="'is'"/>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">2</xsl:with-param>
    </xsl:call-template>

    <xsl:call-template name="test">
      <xsl:with-param name="description">str:count-substring test (single character substring)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:count-substring">
          <xsl:with-param name="text">
	This is a
	bloody good
	test
	which counts newlines
</xsl:with-param>
          <xsl:with-param name="chars" select="'&#x0a;'"/>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">5</xsl:with-param>
    </xsl:call-template>

    <xsl:call-template name="test">
      <xsl:with-param name="description">str:count-substring test (empty substring)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:count-substring">
          <xsl:with-param name="text">This is a test</xsl:with-param>
          <xsl:with-param name="chars"/>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">0</xsl:with-param>
    </xsl:call-template>

    <xsl:message>Test str:string-match template</xsl:message>

    <xsl:call-template name="test">

      <xsl:with-param name="description">str:string-match test (empty text and pattern)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:string-match">
          <xsl:with-param name="text"/>
          <xsl:with-param name="pattern"/>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">1</xsl:with-param>

    </xsl:call-template>
    <xsl:call-template name="test">

      <xsl:with-param name="description">str:string-match test (empty text)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:string-match">
          <xsl:with-param name="text"/>
          <xsl:with-param name="pattern">test</xsl:with-param>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">0</xsl:with-param>

    </xsl:call-template>
    <xsl:call-template name="test">

      <xsl:with-param name="description">str:string-match test (empty pattern)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:string-match">
          <xsl:with-param name="text">this is a test</xsl:with-param>
          <xsl:with-param name="pattern"/>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">0</xsl:with-param>

    </xsl:call-template>
    <xsl:call-template name="test">

      <xsl:with-param name="description">str:string-match test (plain text, matching)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:string-match">
          <xsl:with-param name="text">this is a test</xsl:with-param>
          <xsl:with-param name="pattern">this is a test</xsl:with-param>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">1</xsl:with-param>

    </xsl:call-template>
    <xsl:call-template name="test">

      <xsl:with-param name="description">str:string-match test (plain text, not matching)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:string-match">
          <xsl:with-param name="text">this is a test</xsl:with-param>
          <xsl:with-param name="pattern">this is not a test</xsl:with-param>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">0</xsl:with-param>

    </xsl:call-template>
    <xsl:call-template name="test">

      <xsl:with-param name="description">str:string-match test (backslash)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:string-match">
          <xsl:with-param name="text">this is a backslash: "\"</xsl:with-param>
          <xsl:with-param name="pattern">this is a backslash: "\\"</xsl:with-param>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">1</xsl:with-param>

    </xsl:call-template>
    <xsl:call-template name="test">

      <xsl:with-param name="description">str:string-match test (?)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:string-match">
          <xsl:with-param name="text">this is a test</xsl:with-param>
          <xsl:with-param name="pattern">this is ? test</xsl:with-param>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">1</xsl:with-param>

    </xsl:call-template>
    <xsl:call-template name="test">

      <xsl:with-param name="description">str:string-match test (* - match all)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:string-match">
          <xsl:with-param name="text">this is a test</xsl:with-param>
          <xsl:with-param name="pattern">*</xsl:with-param>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">1</xsl:with-param>

    </xsl:call-template>
    <xsl:call-template name="test">

      <xsl:with-param name="description">str:string-match test (* - match empty)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:string-match">
          <xsl:with-param name="text"/>
          <xsl:with-param name="pattern">*</xsl:with-param>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">1</xsl:with-param>

    </xsl:call-template>
    <xsl:call-template name="test">

      <xsl:with-param name="description">str:string-match test (* - match end)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:string-match">
          <xsl:with-param name="text">abcd</xsl:with-param>
          <xsl:with-param name="pattern">a*</xsl:with-param>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">1</xsl:with-param>

    </xsl:call-template>
    <xsl:call-template name="test">

      <xsl:with-param name="description">str:string-match test (* - match end, no match)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:string-match">
          <xsl:with-param name="text">abcd</xsl:with-param>
          <xsl:with-param name="pattern">b*</xsl:with-param>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">0</xsl:with-param>

    </xsl:call-template>
    <xsl:call-template name="test">

      <xsl:with-param name="description">str:string-match test (* - match beginning)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:string-match">
          <xsl:with-param name="text">abcd</xsl:with-param>
          <xsl:with-param name="pattern">*cd</xsl:with-param>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">1</xsl:with-param>

    </xsl:call-template>
    <xsl:call-template name="test">

      <xsl:with-param name="description">str:string-match test (* - match beginning, no match</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:string-match">
          <xsl:with-param name="text">abcd</xsl:with-param>
          <xsl:with-param name="pattern">*ab</xsl:with-param>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">0</xsl:with-param>

    </xsl:call-template>
    <xsl:call-template name="test">

      <xsl:with-param name="description">str:string-match test (* - match middle)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:string-match">
          <xsl:with-param name="text">abcd</xsl:with-param>
          <xsl:with-param name="pattern">a*d</xsl:with-param>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">1</xsl:with-param>

    </xsl:call-template>
    <xsl:call-template name="test">

      <xsl:with-param name="description">str:string-match test (* - match nothing)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:string-match">
          <xsl:with-param name="text">abcd</xsl:with-param>
          <xsl:with-param name="pattern">ab*cd</xsl:with-param>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">1</xsl:with-param>

    </xsl:call-template>
    <xsl:call-template name="test">

      <xsl:with-param name="description">str:string-match test (* - match middle, no match)</xsl:with-param>

      <xsl:with-param name="result">
        <xsl:call-template name="str:string-match">
          <xsl:with-param name="text">abcd</xsl:with-param>
          <xsl:with-param name="pattern">ab*cde</xsl:with-param>
        </xsl:call-template>
      </xsl:with-param>

      <xsl:with-param name="expect">0</xsl:with-param>

    </xsl:call-template>
  </xsl:template>

</xsl:stylesheet>
