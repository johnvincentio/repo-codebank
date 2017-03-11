package com.idc.diff.file;

public class App {
	App() {}
	public static void main(String args[]) {
		if (args.length != 2) {
		  System.err.println("Usage: diff oldfile newfile");
		  System.exit(1);
		}
		Diff diff = new Diff();
		boolean bDiff = diff.doDiff(args[0], args[1]);
		if (bDiff)
			System.exit(0);
		else
			System.exit(1);
	}
}

