
public class App {
	App() {}
	public static void main(String args[]) {
		if ( args.length != 2 ) {
		  System.err.println("Usage: diff oldfile newfile" );
		  System.exit(1);
		}
		Diff diff = new Diff();
		diff.doDiff(args[0], args[1]);
	}
}

