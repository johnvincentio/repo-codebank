package com.idc.file.dir;

import java.io.*;
import java.util.*;

public class MyTest1 {
	private static int indentLevel = -1;

	public MyTest1 () {}

	public void doit (String strDir) {
		System.out.println (strDir);
		listPath (new File (strDir));
	}
	private void listPath (File path) {
		File files[];		// list of files in a directory
		indentLevel++;
		files = path.listFiles();
		Arrays.sort (files);
		for (int i=0, n=files.length; i<n; i++) {
			for (int indent=0; indent<indentLevel; indent++) {
				System.out.print("    ");
			}
			System.out.println(files[i].toString());
			if (files[i].isDirectory()) {
				listPath (files[i]);
			}
		}
		indentLevel--;
	}
}

