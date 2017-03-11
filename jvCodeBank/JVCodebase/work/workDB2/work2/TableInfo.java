/**
 * @author PRC4031
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class TableInfo implements Serializable {
	private String name;
	private String displayName;
	private String dialectName;
	private String translationType;
	private String typeOption;
	private ArrayList pk = new ArrayList();
	private ArrayList col = new ArrayList();
	private boolean dialect = false;
	private boolean delete = false;
	
	public TableInfo (String table) {
		name = table;
	}
	public String getName() {return name;}
	public String getDisplayName() {return displayName;}
	public String getDialectName() {return dialectName;}	
	public String getTranslationType() {return translationType;}
	public String getTypeOption() {return typeOption;}
	public boolean getDelete() {return delete;}
	public boolean getDialect() {return dialect;}	
	public ArrayList getPklist() {return pk;}
	public ArrayList getCollist() {return col;}
	
	public void setName (String str) {name = str;}
	public void setDisplayName (String str) {displayName = str;}
	public void setDialectName (String str) {dialectName = str;}	
	public void setTranslationType (String str) {translationType = str;}
	public void setTypeOption (String str) {typeOption = str;}
	public void setDelete() {delete = true;}
	public void setDialect() {dialect = true;}	
		
	public void addPklist (ArrayList list) {pk = list;}
	public void addColumnlist (ArrayList list) {col = list;}
	
	public ColumnInfo getColumn(String name) {
		ColumnInfo info;
		Iterator iterator = col.iterator();
		while (iterator.hasNext()) {
			info = (ColumnInfo) iterator.next();
			if ((info.getName()).equals(name)) return info;
		}
		return null;
	}
	
	public void doShowInfo() {
		if (getDelete()) {
			System.out.println("Deleted Table :"+getName()+":");
			return;
		}
		if (getDialect()) {
			System.out.println("Dialect Table: ("+getName()+")("+getDisplayName()+")("+getTranslationType()+
				")("+getTypeOption()+")");
		}
		else {
			System.out.println("Control Table: ("+getName()+")("+getDisplayName()+")("+getTranslationType()+
				")("+getTypeOption()+")");			
		}
		doShowPrimaryKeys();
		doShowColumnInfo();
	}

	private void doShowPrimaryKeys() {
		String column;
		Iterator iterator = pk.iterator();
		while (iterator.hasNext()) {
			column = (String) iterator.next();
			System.out.println("Primary key: "+column);
		}		
	}
	private void doShowColumnInfo() {
		ColumnInfo info;
		Iterator iterator = col.iterator();
		while (iterator.hasNext()) {
			info = (ColumnInfo) iterator.next();
			info.doShowInfo();
		}		
	}
}

	