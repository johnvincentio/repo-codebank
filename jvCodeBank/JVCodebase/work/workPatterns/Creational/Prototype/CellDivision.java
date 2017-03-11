
//
// Prototype pattern
//
// If cost of creating new object is large and creation is resource
// intensive, clone the object
//

public class CellDivision {
	public static void main(String[] args) {
		PlantCell cell = new PlantCell();
		PlantCell newPlantCell = (PlantCell)cell.split();
	}
}

