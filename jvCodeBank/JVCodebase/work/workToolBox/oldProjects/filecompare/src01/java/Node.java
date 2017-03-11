
/**
 * Class "Node". The symbol table routines in this class all
 * understand the symbol table format, which is a binary tree.
 * The methods are: addSymbol, symbolIsUnique, showSymbol.
 */ 

public class Node {    /* the tree is made up of these nodes */
	private Node m_left, m_right;

	private static Node m_topNode = null;    /* symtab is a tree hung from this */
	private static final int FRESHNODE = 0;
	private static final int OLDONCE = 1;
	private static final int NEWONCE = 2;
	private static final int BOTHONCE = 3;
	private static final int OTHER = 4;

	private int m_state;			/* enum m_state */
	private int m_linenum;
	private String m_strLine;

	/**
	 * Construct a new symbol table node and fill in its fields.
	 * @param        string	A line of the text file
	 */
	public Node(String strLine) {
	     m_left = m_right = null;
	     m_state = FRESHNODE;		/* linenum field is not always valid */     
	     m_strLine = strLine;
	}
	/**
	 * matchsymbol       Searches tree for a match to the line.
	 * @param	String	strLine, a line of text
	 * If node's m_state == FRESHNODE, then created the node.
	 */
	private static Node matchsymbol(String strLine) {
		int comparison;
		Node lNode = m_topNode;
		if (m_topNode == null) return m_topNode = new Node(strLine);
		for(;;) {
			comparison = lNode.m_strLine.compareTo(strLine);
			if (comparison == 0)
				return lNode;          /* found */
			else if (comparison < 0) {
				if (lNode.m_left == null) {
					lNode.m_left = new Node(strLine);
					return lNode.m_left;
				}
				lNode = lNode.m_left;
			}
			else if (comparison > 0) {
				if (lNode.m_right == null) {
					lNode.m_right = new Node(strLine);
					return lNode.m_right;
				}
				lNode = lNode.m_right;
			}
		}
	}

	/**
	 * addSymbol(String strLine) - Saves line into the symbol table.
	 * Returns a handle to the symtab entry for that unique line.
	 * If bInOldFile nonzero, then linenum is remembered.
	 */
	public static Node addSymbol(String strLine, boolean bInOldFile, int linenum)
	{
		Node lNode;
		lNode = matchsymbol(strLine);  /* find the node in the tree */
		if (lNode.m_state == FRESHNODE) {
			lNode.m_state = bInOldFile ? OLDONCE : NEWONCE;
		}
		else {
		  if ((lNode.m_state == OLDONCE && !bInOldFile) ||
		      (lNode.m_state == NEWONCE && bInOldFile)) 
		       lNode.m_state = BOTHONCE;
		  else
			lNode.m_state = OTHER;
		}
		if (bInOldFile) lNode.m_linenum = linenum;
		return lNode;
	}

	public int getLinenum() {return m_linenum;}
	public boolean symbolIsUnique() {return (m_state == BOTHONCE );}
	public void showSymbol() {System.out.println(m_strLine);}
}
