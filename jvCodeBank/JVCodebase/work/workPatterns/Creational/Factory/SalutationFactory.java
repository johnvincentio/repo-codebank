//
// Factory Pattern example
//

public class SalutationFactory {
	private static SalutationFactory instance;
	private SalutationFactory () {}
	public static SalutationFactory getSalutationFactory() {
		if (instance == null)
			instance = new SalutationFactory();
		return instance;
	}
//
// The object type that is created by the factory
//
// As a Person class may be subclassed by many classes, the factory
// creates many different classes
//
	public Person getPerson(String name, String gender) {
		if (gender.equals("M"))
			return new Male(name);
		else if(gender.equals("F"))
			return new Female(name);
		else
			return null;
	}
//
// Nothing to prevent the factory from creating many object types
//
// ........
//
}

