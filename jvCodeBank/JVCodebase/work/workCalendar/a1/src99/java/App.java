package book;

public class App {

	public static void main (String args[]) {
		if (args.length < 2) {
			System.out.println ("Usage: MyBook Year output_file\n");
			System.exit(1);
		}
		MyBook book = new MyBook(args[0], args[1]);
		book.makeBook();
	}
}

