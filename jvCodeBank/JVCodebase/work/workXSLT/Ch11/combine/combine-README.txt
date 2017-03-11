
	Combining Documents Using XSLT

Input: collection{7,8}.xml.
Output: collections.xml (and intermediate XML)

Task:
1. Write a stylesheet that combines the 2 input documents
   and creates a new XML document with the following structure:

	<Collections>
	  <Collection ...>
	  </Collection>
	  <Collection ...>
	  </Collection>
	</Collections>

Hint: First create yet another tiny XML document (by hand) that
      identifies the 2 input documents. The XSLT template to accomplish the
      task is about 7 lines and uses the dcoument() function.
