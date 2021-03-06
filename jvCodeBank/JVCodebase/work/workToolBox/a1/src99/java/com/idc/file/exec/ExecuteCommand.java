package com.idc.file.exec;

//import java.net.*;
import java.io.*;

public class ExecuteCommand {

	public void executeCommand (String strCmd) {
		System.out.println (strCmd);
		System.out.println ("OS :"+getOSName()+":");
		StringBuffer sb = new StringBuffer();
		try {
			Process proc = Runtime.getRuntime().exec(strCmd);
			InputStream in = new BufferedInputStream (proc.getInputStream());
			for (;;) {
				int c = in.read();
				if (c == -1) break;
				sb.append ((char) c);
			}
			in.close();
		}
		catch (IOException ioex) {
			ioex.printStackTrace();
		}
		System.out.println (sb.toString());
	}
	public String getOSName() {return System.getProperty ("os.name");}
}

