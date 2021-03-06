package com.idc.diffall;

import java.io.*;

public class DiffAll {
	private String m_strWorkDir;
	private String m_strBaseDir;
	private boolean m_bDeleteActive = true;	//true will do the deletes

	private static final String[] m_astrTypes = {"unknown",
			"java", "jsp", "js", "xml", "xsl", "xsd", "xmi",
			"html", "css",
			"properties", "mf",
			"classpath", "serverPreference", "project"};
	private static final String[] m_astrDeleteTypes = {"class",
			"log", "ini", "bak", "dat", "swp"};

	public DiffAll() {
		m_strWorkDir = System.getProperty("user.dir");
		m_strWorkDir = "/tmp/test/work/filecompare";	// for now...
	}
	public static void main(String args[]) {
		DiffAll app = new DiffAll();
		app.doApp(args.length > 0 ? args[0] : "");
	}
	private void doApp (String arg) {
		String strDir = arg.trim();
		if (strDir == null || strDir.length() < 4) doUsageError();
		File file = new File(strDir);
		if (! file.exists()) doUsageError();
		if (! file.isDirectory()) doUsageError();
		if (strDir.toLowerCase().equals(m_strWorkDir.toLowerCase()))
			doSuicideError();
		m_strBaseDir = strDir;

		System.out.println("\nDiffAll is beginning\n");
		System.out.println("Baseline Directory: "+m_strBaseDir);
		System.out.println(" Current Directory: "+m_strWorkDir);
		doDirectory (new File(m_strWorkDir));
		System.out.println("\nDiffAll is Complete");
	}
	private void doUsageError() {
		System.out.println("Usage: DiffAll baseline_directory");
		System.exit(1);
	}
	private void doSuicideError() {
		System.out.println("You must be kidding...");
		System.exit(1);
	}
	private void doDirectory (File dir) {
//		System.out.println(">>> doDirectory; "+dir.getPath());
		if (! dir.isDirectory()) return;

		File file;
		File[] allFiles = dir.listFiles();
		for (int i=0; i<allFiles.length; i++) {
			file = allFiles[i];
			if (file.isFile()) doFile(file);
		}
		for (int i=0; i<allFiles.length; i++) {
			file = allFiles[i];
			if (file.isDirectory()) doDirectory(file);
		}
		if (dir.listFiles().length < 1) {	// empty directory
			System.out.println("\nDirectory is empty");
			removeDirectory(dir);
		}
//		System.out.println("<<< doDirectory");
	}
	private void doFile (File file) {
//		System.out.println(">>> doFile; "+file.getPath());
		if (! file.isFile()) return;
		if (isDeleteType (file)) {
			System.out.println("\nFile is not useful");
			removeFile(file);
			return;
		}
		if (getFileType(file) < 1) return;	// not a comparable file type

		String newFile = file.getPath();
		String oldFile = m_strBaseDir + 
				file.getPath().substring(m_strWorkDir.length());
		System.out.println("\nComparing: "+newFile+"\n     with: "+oldFile);
		DiffFiles diffFiles = new DiffFiles (newFile, oldFile);
		if (diffFiles.compareFiles()) {
			System.out.println("Files are identical");
			removeFile(file);
		}
		else {
			System.out.println("Files are different");
			com.idc.diff.Diff diff = new com.idc.diff.Diff();
			diff.doDiff (oldFile, newFile);
		}
//		System.out.println("<<< doFile");
	}
	private void removeDirectory (File dir) {
		System.out.println("Removing directory; "+dir.getPath());
		if (m_bDeleteActive) dir.delete();
	}
	private void removeFile (File file) {
		System.out.println("Removing file; "+file.getPath());
		if (m_bDeleteActive) file.delete();
	}
	private int getFileType(File file) {
		String strExt = getFileExtension (file.getName());
		if (strExt == null) return 0;	// no extension
		for (int i=0; i<m_astrTypes.length; i++) {
			if (strExt.equalsIgnoreCase(m_astrTypes[i]))
				return i;
		}
		return 0;
	}
	private boolean isDeleteType (File file) {
		String strExt = getFileExtension (file.getName());
		if (strExt == null) return false;	// no extension
		for (int i=0; i<m_astrDeleteTypes.length; i++) {
			if (strExt.equalsIgnoreCase(m_astrDeleteTypes[i]))
				return true;
		}
		return false;
	}
	private String getFileExtension (String strName) {
		int num = strName.lastIndexOf(".");
		if (num < 0) return null;		// no extension
		return strName.substring(num+1,strName.length());
	}
}



























