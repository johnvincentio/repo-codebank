import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.IOException;

public class Logger {		// Singleton
	private static Logger logger;
	private Logger() {}
	public static Logger getLogger() {
		if (logger == null)
			logger = new Logger();
		return logger;
	}

// allows methods to be non-static - easier to change the class if
// want all non-static.

/**
* Level of logging, error or information etc
*
* @return level, int
*/
	public int getRegisteredLevel() {
		int i = 0;
		try {
			InputStream inputstream = getClass().getResourceAsStream("Logger.properties");
			Properties properties = new Properties();
			properties.load(inputstream);
			inputstream.close();
			i = Integer.parseInt(properties.getProperty("logger.registeredlevel"));
			if(i < 0 || i > 1000) i = 0;
		}
		catch(Exception exception) {
			System.out.println("Logger: Failed in the getRegisteredLevel method");
			exception.printStackTrace();
		}
		return i;
	}

/**
* Return the log file name
*
* @return filename, String
*/
	public String getFilename() {
		String strFile = "";
		try {
			InputStream inputstream = getClass().getResourceAsStream("Logger.properties");
			Properties properties = new Properties();
			properties.load(inputstream);
			inputstream.close();
			strFile = properties.getProperty("logger.filename");
		}
		catch(Exception exception) {
			System.out.println("Logger: Failed in the getRegisteredLevel method");
			exception.printStackTrace();
		}
		return strFile;
	}

/**
* A mechanism to log message to the file.
*
* @param message String
*/
	public void logMessage(String message) {
		try {
			GregorianCalendar gc = new GregorianCalendar();
			String fileName = getFilename();
			FileOutputStream fos = new FileOutputStream(fileName, true);
			PrintStream ps = new PrintStream(fos);
			SimpleDateFormat dateFormat2 = new SimpleDateFormat("EEE, MMM d, yyyy 'at' hh:mm:ss a");
			ps.println("<"+dateFormat2.format(gc.getTime())+">["+message+"]");
			ps.close();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}
}

