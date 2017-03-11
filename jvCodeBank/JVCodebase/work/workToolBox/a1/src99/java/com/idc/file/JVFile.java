package com.idc.file.copy;

import java.io.*;

public class JVFile {
	private static final int DATA_BLOCK_SIZE=1024;

	public boolean copyFile (String strFromFile, String strToFile) {
		System.out.println("Copying file "+strFromFile+" to file "+strToFile);
		int byteCount;
		try {
			FileInputStream fis = new FileInputStream (strFromFile);
			BufferedInputStream bufIn = new BufferedInputStream (fis, DATA_BLOCK_SIZE);

			FileOutputStream fos = new FileOutputStream (strToFile);
			BufferedOutputStream bufOut = new BufferedOutputStream (fos, DATA_BLOCK_SIZE);

			byte[] data = new byte[1024];
			while ((byteCount = bufIn.read(data, 0, DATA_BLOCK_SIZE)) != -1) {
				bufOut.write (data, 0, byteCount);
			}
			bufIn.close();
			bufOut.flush();
			bufOut.close();
		}
		catch (IOException ex) {
			System.out.println("Unable to copy the file; "+ex.getMessage());
			return false;
		}
		return true;
	}
	public void removeFile (String strFile) {removeFile(new File(strFile));}
	public void removeFile (File file) {
		System.out.println("Removing file "+file.getPath());
		if (file.isFile()) file.delete();
	}
}

