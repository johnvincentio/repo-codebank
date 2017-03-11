package com.idc.grepgui;

/**
 * @author PRC4031
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */

import com.idc.trace.Debug;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;

public class Grepdir {
	private GrepdirGui m_app;
	private static final int MAX_CNTR=1000;
	private int m_cntr = 0;

	public Grepdir (GrepdirGui app) {m_app = app;}
	private boolean isSearchStopped() {
		return m_app.getAppThread().getStopStatus();
	}
	private void setProgressBar() {
		m_cntr++;
		setProgressBar(m_cntr);
	}
	private void setProgressBar (int cntr) {
		m_cntr = cntr;		
		if (m_cntr > MAX_CNTR) m_cntr = 1;
		m_app.setProgressBar(m_cntr);		
	}
	public void doGrepdir (String strDir, String strFind, String strFiles) {
		Debug.println(">>> doGrepdir");
		Debug.println("strFind :"+strFind+":");
		Debug.println("strFiles :"+strFiles+":");
		Debug.println("strDir :"+strDir+":");
		m_app.setStatusMessage("searching...");
		m_app.initProgressBar(0,MAX_CNTR);
		m_app.addWord("");
		m_app.addWord("Searching from "+strDir);
		m_app.addWord("    for String "+strFind);
		m_app.addWord("    in files "+strFiles);
		m_app.addWord("");
		doDirectory (strDir, strFind, strFiles);
		if (isSearchStopped()) {
			m_app.addWord("---------------------------------------");	
			m_app.addWord("Search stopped by user");
			m_app.addWord("---------------------------------------");
			m_app.setStatusMessage("Stopped...");
		}
		else {		
			m_app.addWord("---------------------------------------");	
			m_app.addWord("Search is complete");
			m_app.addWord("---------------------------------------");
			setProgressBar(MAX_CNTR);
			m_app.setStatusMessage("Finished...");		
		}
		Debug.println("<<< doGrepdir");		
	}
	private void doDirectory (String strDir, String strFind, String strFiles) {	
		doDirectory (new File(strDir), strFind, strFiles);
	}	
	private void doDirectory (File dir, String strFind, String strFiles) {
		File [] allFiles;
		File file;

		if (isSearchStopped()) return;	// user stopped the search
							
		Debug.println(">>> doDirectory; "+dir.getPath());
		if (! dir.isDirectory()) return;
		setProgressBar();
		
// handle files
		
		GrepdirFilter filter = new GrepdirFilter();
		filter.setMask(strFiles);		
		allFiles = dir.listFiles(filter);
		for (int i=0; i<allFiles.length; i++) {
			file = allFiles[i];
			if (file.isFile()) {
				Debug.println("(File) i = "+i+" file :"+file.getPath()+":");				
				doFile (file, strFind);
			}
		}

// handle directories

		allFiles = dir.listFiles();
		for (int i=0; i<allFiles.length; i++) {
			file = allFiles[i];
			if (file.isDirectory()) {
				Debug.println("(Directory) i = "+i+" file :"+file.getPath()+":");				
				doDirectory (file, strFind, strFiles);
			}
		}
		Debug.println("<<< doDirectory");
	}
	private void doFile (File file, String strFind) {
		Debug.println(">>> doFile; "+file.getPath());
		if (! file.isFile()) return;
		
		boolean bCaseSensitive = false;
		String str = file.getName().toLowerCase();
		Debug.println("str :"+str+":");
		if (str.indexOf(".java") > -1)
			bCaseSensitive = true;

		ArrayList list = new ArrayList();	
		BufferedReader buf = null;
		String line;
		try {
			buf = new BufferedReader(new FileReader(file));
			while ((line = buf.readLine()) != null) {
				if (bCaseSensitive) {
					if (line.indexOf(strFind) > -1) list.add(line.trim());					
				}
				else {
					if (line.toLowerCase().indexOf(strFind.toLowerCase()) > -1)
						list.add(line.trim());
				}
			}
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		finally {
			try {
				if (buf != null) buf.close();
			}
			catch (IOException exception2) {
				exception2.printStackTrace();
			}
		}
		if (list.size() > 0) {
			Debug.println(list.size()+" occurance(s) in file "+
					file.getPath()+"\n");
			addMessage(list.size()+" occurance(s) in file "+
					file.getPath()+"\n");
			Iterator iterator = list.iterator();
			while (iterator.hasNext()) {
				line = (String) iterator.next();
				addMessage ("\t "+line.trim());				
			}
			addMessage("");
		}
		Debug.println("<<< doFile; "+file.getPath());		
		return;
	}
	private void addMessage (String msg) {m_app.setMessagesArea(msg);}					
	public class GrepdirFilter implements FilenameFilter {
		private String mask = "";
		private String first = "";
		private String second = "";
		public boolean accept (File dir, String name) {
			Debug.println(">>> GrepdirFilter::accept");				
			Debug.println("(Filter) name :"+name+":");
			Debug.println("m :"+mask+": 1 :"+first+": 2 :"+second+":");
			if (first.length() > 0) {
				if (! name.startsWith(first)) return false;
			}
			if (second.length() > 0) {
				if (! name.endsWith(second)) return false;
			}
			if (mask.length() > 0) {
				if (! mask.equals(name)) return false;
			}
			Debug.println("<<< GrepdirFilter::accept - true");						
			return true;
		}
		public void setMask (String mask) {
			int star = mask.indexOf("*");
			if (star < 0) {
				this.mask = mask;				
				return;
			}
			first = mask.substring(0,star);
			second = mask.substring(star+1,mask.length());
		}
	}
}
