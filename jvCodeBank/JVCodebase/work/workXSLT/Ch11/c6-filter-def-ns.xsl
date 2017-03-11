<?xml version="1.0"?>
<stylesheet   version="1.0"
  xmlns="http://www.w3.org/1999/XSL/Transform"
  xmlns:html="http://www.w3.org/1999/xhtml">
<output method="html"/>

<template match="/">
   <html:html>  
     <html:head>
       <html:title>XSLT: Filtering Titles</html:title>
     </html:head>
     <html:body>
       <html:h1>XSLT: Filtering Titles</html:h1>
       <apply-templates select="Collection/CD | //Book"/>
     </html:body>
   </html:html>
</template>

<template match="CD">
   <html:br /><text>CD title: </text>
   <html:i><value-of select="Title" /></html:i>
</template> 

<template match="Book">
   <html:br /><text>Book title: </text>
   <html:i><value-of select="Title" /></html:i>
</template> 
</stylesheet>
