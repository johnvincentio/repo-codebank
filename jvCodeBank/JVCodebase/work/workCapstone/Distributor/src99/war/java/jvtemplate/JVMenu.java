
package jvtemplate;

import java.util.*;

public class JVMenu {
	private String m_strFile = null;
	private ArrayList m_submenus = new ArrayList();

	public JVMenu () {}
	public String getFile() {return m_strFile;}
	public void setFile (String strFile) {m_strFile = strFile;}

	public void addSubMenu (JVSubMenu submenu) {
		m_submenus.add (submenu);
	}
	public Iterator getSubmenus() {return m_submenus.iterator();}
	public int getSize() {return m_submenus.size();}
}

