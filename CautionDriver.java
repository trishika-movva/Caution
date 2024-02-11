import java.io.File;
import java.io.FileNotFoundException;
import features.Location;



public class CautionDriver {

	public static void main(String[] args) {
		
		int[] smArr = {5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3};
		int[] tcbArr = {0, 0, 0, 0, 0, 1, 2, 2, 2, 2, 3, 0};
		int[] lipArr = {3, 3, 0, 0, 0, 0, 3, 2, 2, 3, 4, 0};
		int[] whArr = {4, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2};
		int[] mcArr = {4, 0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 3};
		int[] bsArr = {4, 0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 3};
		
		
		Location sakeMama = new Location("Sake Mama", 20.30, 2.00, false, 10.00, "Me and my friends were followed around by a strange man the whole night!", "9:50PM", smArr);
		Location taiChiBubbleTea = new Location("Tai Chi Bubble Tea", 11.30, 21.30, true, 12.00, tcbArr);
		Location littleItalyPizzeria = new Location("Little Italy Pizzeria", 11.00, 3.00, false, 12.00, lipArr);
		Location waffleHouse = new Location("Waffle House", 0.00, 0.00, true, 10.30, "Someone has been throwing around hateful speech for half an hour!!!", "9:30PM", whArr);
		Location manhattanCafe = new Location("Manhattan Cafe", 16.00, 2.00, false, 6.00, mcArr);
		Location barSouth = new Location("Bar South", 16.00, 2.00, false, 9.00, "Just witnessed a fight break out 20 minutes ago!", "7:00PM", bsArr);
		
		barSouth.fileStatement("Someone in the restaurant made a couple threats at me and my family before we left...", "9:30PM");
		barSouth.fileStatement("Police were nearing the area when I passed by.", "8:00PM");
		barSouth.fileStatement("A fight broke out!", "10:30PM");
		
		barSouth.testerPrintLocationInfo(); //checks statements will be printed to file correctly
		
		Location[] locArr = new Location[6];
		locArr[0] = sakeMama;
		locArr[1] = taiChiBubbleTea;
		locArr[2] = littleItalyPizzeria;
		locArr[3] = waffleHouse;
		locArr[4] = manhattanCafe;
		locArr[5] = barSouth;
		
		for(int i = 0; i < locArr.length; i++) {
			try {
				Location object = locArr[i];
				File saveFile = new File("caution" + i + ".txt");
				object.printLocationInfo(saveFile);
			} catch (FileNotFoundException nfe){
				System.err.println("Unable to save:");
				System.err.println(nfe.getMessage());
			}
		}
		
		
				
		
		
		

	}

}
