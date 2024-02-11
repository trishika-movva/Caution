package features;

import java.io.File; 
import java.io.PrintWriter;
import java.io.FileNotFoundException;


public class Location extends ReportIncident {
	
	private String name;
	private double openHour;
	private double closeHour;
	private int popDensityRating;
	private boolean am = true;
	private double estTime;
	
	public Location(String name, double openHour, double closeHour, boolean am, 
			double estTime, String reportStatement, String time, int[] arrRating) {
		super(reportStatement, time);
		this.name = name;
		this.openHour = openHour;
		this.closeHour = closeHour;
		this.popDensityRating = getPopDensityRating(arrRating);
		if(am == true) {
			this.estTime = estTime;
		} else {
			this.estTime = estTime+12;
		}
		
	}
	
	public Location(String name, double openHour, double closeHour, boolean am,
			double estTime, int[] arrRating) {
		super(null, null);
		this.name = name;
		this.openHour = openHour;
		this.closeHour = closeHour;
		this.popDensityRating = getPopDensityRating(arrRating);
		if(am == true) {
			this.estTime = estTime;
		} else {
			this.estTime = estTime+12;
		} 
		
	}
	
	public String getName() {
		return name;
	}
	
	
	public int getPopDensityRating(int[] arrRating) {
		//use data from the estTime to decide the time + density
		int index = -1;
		int count = 0;
		for(int i = 0; i < 24; i++) {
			if(estTime >= i || estTime <= i + 2) {
				index = count;
			}
			count++;
			i++; 
		}
		
		popDensityRating = arrRating[index];
		
		return popDensityRating;
	}
	
	public boolean isClosed() {
		if(closeHour == openHour) {
			return false;
		}
		if(estTime >= closeHour || estTime < openHour) {
			return true;
		}
		
		return false;
	}
	
	public void testerPrintLocationInfo() {
		System.out.println("Location: " + name);
		if(openHour > 12) {
			openHour -= 12;
		}
		if(closeHour > 12) {
			closeHour -= 12;
		}
		System.out.println("Hours: " + openHour + "0-" + closeHour + "0");
		if(isClosed() == true) {
			System.out.println("Closed currently.");
		}
		System.out.println("Population Density Rating: " + popDensityRating);
		System.out.println(super.getReportFile());
	}
	
	public void printLocationInfo(File file) throws FileNotFoundException {
		PrintWriter fileOut = new PrintWriter(file);
		fileOut.println("Location: " + this.name);
		if(openHour > 12) {
			openHour -= 12;
		}
		if(closeHour > 12) {
			closeHour -= 12;
		}
		fileOut.println("Hours: " + this.openHour + "0-" + this.closeHour + "0");
		if(isClosed() == true) {
			fileOut.println("Closed currently.");
		}
		fileOut.println("Population Density Rating: " + this.popDensityRating + "\n");
		fileOut.println(super.getReportFile());
		fileOut.close();
	}
	
	
	
	
	
}

