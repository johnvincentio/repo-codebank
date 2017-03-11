/**
 * @author PRC4031
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */

import java.io.*;

public class Output {
	private boolean m_bOpen = false;
	private String filename;
	private BufferedWriter buffer;
	
	public Output() {}
	public boolean open (String filename) {
		this.filename = filename;
		try {
			buffer = new BufferedWriter(new FileWriter(filename));
		}
		catch (IOException e) {
			System.out.println("Unable to open file "+filename+". Aborting");
			return false;
		}
		return true;
    }
    public void close() {
    	try {
			buffer.close();
    	} catch (IOException e) {
    		System.out.println("Could not close file "+filename+":");
    	}
    }
	public void write (String msg) {
    	try {
        	buffer.write(msg);
    	} catch (IOException e) {
    		System.out.println("Could not write to file "+filename+": Aborting...");
    		System.exit(1);
    	}
    }
}


