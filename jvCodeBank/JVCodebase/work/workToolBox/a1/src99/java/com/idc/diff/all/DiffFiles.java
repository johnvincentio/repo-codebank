package com.idc.diff.all;

import java.io.*;

public class DiffFiles {
	private static final int DATA_BLOCK_SIZE = 1024;
	private String m_strNewFile;
	private String m_strOldFile;
	private boolean m_bShowDifferences;
	private boolean m_bByteCompare;

	public DiffFiles (String newFile, String oldFile) {
		m_strNewFile = newFile;
		m_strOldFile = oldFile;
		m_bShowDifferences = false;
		m_bByteCompare = true;
	}
	public void setShowDifferences() {m_bShowDifferences = true;}
	public void setShowNoDifferences() {m_bShowDifferences = false;}
	public void setByteCompare() {m_bByteCompare = true;}
	public void setCharacterCompare() {m_bByteCompare = false;}

	public boolean compareFiles() {	//true => files are the same
		boolean bSame = false;		// assume files are different
		File file = new File (m_strNewFile);
		if (! file.isFile()) return bSame;	// ensure files exist
		file = new File (m_strOldFile);
		if (! file.isFile()) return bSame;

		int newByteCount, oldByteCount;
		try {
//			System.out.println("Opening file "+m_strNewFile);
			FileInputStream newFis = new FileInputStream (m_strNewFile);
			BufferedInputStream newBuf = new BufferedInputStream (
				newFis, DATA_BLOCK_SIZE);
//			System.out.println("Opening file "+m_strOldFile);
			FileInputStream oldFis = new FileInputStream (m_strOldFile);
			BufferedInputStream oldBuf = new BufferedInputStream (
				oldFis, DATA_BLOCK_SIZE);

			byte[] newData = new byte[DATA_BLOCK_SIZE];
			byte[] oldData = new byte[DATA_BLOCK_SIZE];
			while(true) {
				newByteCount = newBuf.read(newData, 0, DATA_BLOCK_SIZE);
				oldByteCount = oldBuf.read(oldData, 0, DATA_BLOCK_SIZE);
				if (newByteCount != oldByteCount) break;	// different
				if (newByteCount < 0) {	// no differences found and EOF
					bSame = true;
					break;
				}
				if (! compareByteArrays (newByteCount, newData, oldData))
					break;		// different data
			}
			newBuf.close(); oldBuf.close();
			newFis.close(); oldFis.close();
		}
		catch (IOException ex) {
			System.out.println("Unable to compare the files; "+ex.getMessage());
			bSame = false;
		}
		return bSame;
	}
	private boolean compareByteArrays (int count, byte[] arr1, byte[] arr2) {
		boolean bSame = true;
		for (int i=0; i<count; i++) {
			if (arr1[i] != arr2[i]) {
				bSame = false;
				break;
			}
		}
		return bSame;
	}
}

