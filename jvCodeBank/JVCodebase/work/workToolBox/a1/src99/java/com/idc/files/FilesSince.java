package com.idc.files;

import java.util.*;
import java.text.*;
import java.io.*;

public class FilesSince {
	private PrintWriter m_out;
	public static void main (String[] args) {
		(new FilesSince()).app(args);
	}
	private void app (String[] args) {
		if (args.length < 1) doUsage();
		long lSince = 0;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date myDate = format.parse(args[0]);
			lSince = myDate.getTime();
		}
		catch (ParseException e) {
			System.out.println("Unable to parse "+args[0]);
			doUsage();
		}
		String strDir = System.getProperty("user.dir");
//		strDir = "/home/jv/work";
		System.out.println("workdir "+strDir+" Since "+lSince);

		makeFile();
		doDirectory (new File(strDir), lSince);
		closeFile();
	}
	private void doUsage() {
		System.out.println("Usage: com.idc.files.FilesSince dd/mm/yyyy");
		System.exit(1);
	}
	private void makeFile() {
		try {
			m_out = new PrintWriter (new BufferedWriter(
				new FileWriter("/tmp/since.txt")));
		}
		catch (IOException ex) {
			System.out.println("Unable to create output file: "+ex.getMessage());
			System.exit(1);
		}
	}
	private void closeFile() {m_out.close();}
	private void doDirectory (final File dir, long lSince) {
//		System.out.println(">>> doDirectory "+dir.getPath());
		if (! dir.isDirectory()) return;
		if (! isDirectoryOK(dir, "/home/jv")) return;
		if (! isDirectoryOK(dir, "/boot")) return;
		if (! isDirectoryOK(dir, "/dev")) return;
		if (! isDirectoryOK(dir, "/lost+found")) return;
		if (! isDirectoryOK(dir, "/proc")) return;
		if (! isDirectoryOK(dir, "/root/.gconfd")) return;
		if (! isDirectoryOK(dir, "/root/.gconf")) return;
		if (! isDirectoryOK(dir, "/root/.gnome")) return;
		if (! isDirectoryOK(dir, "/root/.gnome2")) return;
		if (! isDirectoryOK(dir, "/root/.mozilla")) return;
		if (! isDirectoryOK(dir, "/root/.nautilus")) return;
		if (! isDirectoryOK(dir, "/root/.openoffice")) return;
		if (! isDirectoryOK(dir, "/root/.thumbnails")) return;
		if (! isDirectoryOK(dir, "/root/evolution")) return;
		if (! isDirectoryOK(dir, "/tmp")) return;
		if (! isDirectoryOK(dir, "/usr/share")) return;
		if (! isDirectoryOK(dir, "/usr/X11R6")) return;
		if (! isDirectoryOK(dir, "/usr/include")) return;
		if (! isDirectoryOK(dir, "/usr/bin")) return;
		if (! isDirectoryOK(dir, "/usr/lib")) return;
		if (! isDirectoryOK(dir, "/var")) return;
		if (! isDirectoryOK(dir, "/opt/CodeBank")) return;
		if (! isDirectoryOK(dir, "/opt")) return;
		if (! isDirectoryOK(dir, "/etc/IBM")) return;
		if (! isDirectoryOK(dir, "/home/db2inst1")) return;
		if (! isDirectoryOK(dir, "/home/db2fenc1")) return;
		if (! isDirectoryOK(dir, "/home/dasusr1")) return;
		if (! isDirectoryOK(dir, "/home/downloads")) return;
		if (! isDirectoryOK(dir, "/home/jvdownloads")) return;
		if (! isDirectoryOK(dir, "/home/mqm")) return;
		if (! isDirectoryOK(dir, "/home/mqbrkrs")) return;
		if (! isDirectoryOK(dir, "/home/oracle")) return;
		if (! isDirectoryOK(dir, "/usr/src")) return;
		if (! isDirectoryOK(dir, "/usr/tmp")) return;
		if (! isDirectoryOK(dir, "/lib/modules")) return;

		File file;
		File[] allFiles = dir.listFiles();
		for (int i=0; i<allFiles.length; i++) {
			file = allFiles[i];
			if (! file.isFile()) continue;
			if (lSince < file.lastModified()) {
//				System.out.println("File "+file.getPath()+" modified "+	
//						file.lastModified());
				m_out.println(file.getPath());
			}
		}
		for (int i=0; i<allFiles.length; i++) {
			file = allFiles[i];
			if (file.isDirectory()) doDirectory(file,lSince);
		}
//		System.out.println("<<< doDirectory");
	}
	private boolean isDirectoryOK(final File dir, String mask) {
		String strDir = dir.getPath();
		int len = mask.length();
		if (strDir.length() != len) return true;
		if (strDir.substring(0,len).equals(mask)) return false;
		return true;
	}
}

