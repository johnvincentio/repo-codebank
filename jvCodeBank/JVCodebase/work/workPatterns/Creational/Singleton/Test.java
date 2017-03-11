/*
	Singleton Pattern example
*/

public class Test {
	public static void main(String args[]) {
//
// getLogger() to get THE reference.
//
		Logger.getLogger().logMessage("This is SINGLETON");
		System.out.println ("Level "+Logger.getLogger().getRegisteredLevel());
		System.out.println ("File "+Logger.getLogger().getFilename());
	}
}

