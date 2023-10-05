import java.util.*;

public class BHFinder {

	public static boardinghouses hey = new boardinghouses();
	public static Scanner sc = new Scanner(System.in);
	public static String tempBH[][] = new String[hey.arrnum][hey.BHPeople[0].length];
	public static int rangeOccupants = 0, rangePrice = 0, rangeDistance = 0;
	public static boolean usedFilter = false;
	
	public static void main(String[] args) {
		
		for(int i=0;i<hey.BUCampuses.length;i++)
			System.out.print("\t"+hey.BUCampuses[i]+"\t");
		System.out.print("\n\nPick a campus: ");
		String campus = sc.nextLine();
		campusFinder(campus);
		filterPanel(campus);	
		displayBH(tempBH, campus);

	}
	
	public static String campusFinder(String campus) {
		for(int i = 0; i < hey.BUCampuses.length; i++) {
			if(campus.equalsIgnoreCase(hey.BUCampuses[i])) {
				for(int j = 0; j < hey.BHouses.length-1; j++) {
					System.out.println((j+1) + ". " + hey.BHouses[i][j] + ": " 
										+ hey.BHDeets[i][j] 
										+ "\nTotal Occupants in a Room: " + hey.BHPeople[i][j]
										+ "\nPrice: " + hey.BHPrice[i][j]
										+ "\nDistance: "+ hey.BHDistance[i][j] + "\n");
				}
				return campus;
			}
		}
		System.out.println("Wrong SHIT");
		main(null);	
		return campus;
	}
	
	public static void filterPanel(String campus) {
		System.out.println("-----------------\n"
				+ "Filter Options:\n"
				+ "[1] Occupants\n"
				+ "[2] Price\n"
				+ "[3] Distance\n"
				+ "[0] Done");
		int filter = 0;
		try {
			filter = Integer.parseInt(sc.nextLine());
		}
		catch(Exception e){
			filterPanel(campus);
		}
		filterOptions(filter, campus);
	}

	public static int filterOptions(int filter, String campus) {
		switch(filter) {
		case 1:
			System.out.println("Occupants Range:\n"
							+ "[1] 0-9\n" 
							+ "[2] 10-29\n"
							+ "[3] 30-69\n"
							+ "[4] 70 or more\n"
							+ "[0] Back");
				try {
					rangeOccupants = Integer.parseInt(sc.nextLine());
					if(rangeOccupants != 0) {
						usedFilter = true;
					}
					filterPanel(campus);
				}
				catch(Exception e){
					filterOptions(filter, campus);
				}
			break;
		case 2:
			System.out.println("Price Range:\n"
					+ "[1] 0-999\n" 
					+ "[2] 1000-1499\n"
					+ "[3] 1500-4999\n"
					+ "[4] 5000 or more\n"
					+ "[0] Back");
				try {
					rangePrice = Integer.parseInt(sc.nextLine());
					if(rangePrice != 0) {
						usedFilter = true;
					}
					filterPanel(campus);
				}
				catch(Exception e){
					filterOptions(filter, campus);
				}
			break;
		case 3:
			System.out.println("Distance Range:\n"
					+ "[1] 0-199\n" 
					+ "[2] 200-499\n"
					+ "[3] 500-1499\n"
					+ "[4] 1500 or more\n"
					+ "[0] Back");
				try {
					rangeDistance = Integer.parseInt(sc.nextLine());
					if(rangeDistance != 0) {
						usedFilter = true;
					}
					filterPanel(campus);
				}
				catch(Exception e){
					filterOptions(filter, campus);
				}
			break;
		case 0:
			if(usedFilter) {
				//testCheck
			//System.out.println(usedFilter);
				filter1(rangeOccupants, rangePrice, rangeDistance, campus);
			}
			else {
				//testCheckSystem.out.println(usedFilter);
				filter0(rangeOccupants, rangePrice, rangeDistance, campus);
			}
			break;
		default:
			filterPanel(campus);
		}
		
		return filter;
	}
	
	public static String[][] filter0(int rangeOccupants, int rangePrice, int rangeDistance, String campus) {
		int i = campusChecker(campus);
		
		for(int j = 0; j < hey.BHPeople[i].length; j++) {
			tempBH[j][0] = hey.BHPeople[i][j];
			tempBH[j][1] = hey.BHPrice[i][j];
			tempBH[j][2] = hey.BHDistance[i][j];
		}
		
		return tempBH;
	}
	
	public static String[][] filter1(int rangeOccupants, int rangePrice, int rangeDistance, String campus) {
		int i = campusChecker(campus);
		//testCheckSystem.out.println(i);
		for(int k = 1; k < 4; k++) {
			//rangeOccupants
		//	System.out.println("H");
			for(int j = 0; j < hey.BHPeople[i].length; j++) {
				if((Integer.parseInt(hey.BHPeople[i][j]) >= 0 && Integer.parseInt(hey.BHPeople[i][j]) <= 9) && ((k == rangeOccupants)&&(1 == rangeOccupants))) {
					tempBH[j][0] = hey.BHPeople[i][j];
				}
				else if((Integer.parseInt(hey.BHPeople[i][j]) >= 10 && Integer.parseInt(hey.BHPeople[i][j]) <= 29) && ((k == rangeOccupants)&&(2 == rangeOccupants))) {
					tempBH[j][0] = hey.BHPeople[i][j];
				}
				else if((Integer.parseInt(hey.BHPeople[i][j]) >= 30&& Integer.parseInt(hey.BHPeople[i][j]) <= 69) && ((k == rangeOccupants)&&(3 == rangeOccupants))) {
					tempBH[j][0] = hey.BHPeople[i][j];
				}
				else if((Integer.parseInt(hey.BHPeople[i][j]) >= 70) && ((k == rangeOccupants)&&(4 == rangeOccupants))) {
					tempBH[j][0] = hey.BHPeople[i][j];
				}
				else if(rangeOccupants==0) {
					tempBH[j][0] = hey.BHPeople[i][j];
				}
				//System.out.println("H");
			}
			//rangePrice
		//	System.out.println("H");
			for(int j = 0; j < hey.BHPrice[i].length; j++) {
				if((Integer.parseInt(hey.BHPrice[i][j]) >= 0 && Integer.parseInt(hey.BHPrice[i][j]) <= 999) && ((k == rangePrice)&&(1 == rangePrice))) {
					//testCheck
				//	System.out.println("*");
					tempBH[j][1] = hey.BHPrice[i][j];
				}
				else if((Integer.parseInt(hey.BHPrice[i][j]) >= 1000 && Integer.parseInt(hey.BHPrice[i][j]) <= 1499) && ((k == rangePrice)&&(2 == rangePrice))) {
					//testCheck
				//	System.out.println("%");
					tempBH[j][1] = hey.BHPrice[i][j];
				}
				else if((Integer.parseInt(hey.BHPrice[i][j]) >= 1500&& Integer.parseInt(hey.BHPrice[i][j]) <= 4999) && ((k == rangePrice)&&(3 == rangePrice))) {
					//System.out.println("$");
					tempBH[j][1] = hey.BHPrice[i][j];
				}
				else if((Integer.parseInt(hey.BHPrice[i][j]) >= 5000) && ((k == rangePrice)&&(4 == rangePrice))) {
					//System.out.println("#");
					tempBH[j][1] = hey.BHPrice[i][j];
				}
				else if(rangePrice==0) {
					//System.out.println("@");
					tempBH[j][1] = hey.BHPrice[i][j];
				}
			}
			//rangeDistance
			for(int j = 0; j < hey.BHDistance[i].length; j++) {
				if((Integer.parseInt(hey.BHDistance[i][j]) >= 0 && Integer.parseInt(hey.BHDistance[i][j]) <= 199) && ((k == rangeDistance)&&(1 == rangeDistance))) {
					tempBH[j][2] = hey.BHDistance[i][j];
				}
				else if((Integer.parseInt(hey.BHDistance[i][j]) >= 200 && Integer.parseInt(hey.BHDistance[i][j]) <= 499) && ((k == rangeDistance)&&(2 == rangeDistance))) {
					tempBH[j][2] = hey.BHDistance[i][j];
				}
				else if((Integer.parseInt(hey.BHDistance[i][j]) >= 500&& Integer.parseInt(hey.BHDistance[i][j]) <= 1499) && ((k == rangeDistance)&&(3 == rangeDistance))) {
					tempBH[j][2] = hey.BHDistance[i][j];
				}
				else if((Integer.parseInt(hey.BHDistance[i][j]) >= 1500) && ((k == rangeDistance)&&(4 == rangeDistance))) {
					tempBH[j][2] = hey.BHDistance[i][j];
				}
				else if(rangeDistance==0) {
					tempBH[j][2] = hey.BHDistance[i][j];
				}
			}
		}
		return tempBH;
	}
	
	public static void displayBH(String[][] tempBH, String campus) {
		int i = campusChecker(campus);
		for(int j = 0; j < tempBH[0].length; j++) {
			if(tempBH[i][j] != null) {
				System.out.println((j+1) + ". " + hey.BHouses[i][j] + ": " 
						+ "\nTotal Occupants in a Room: " + tempBH[j][0]
						+ "\nPrice: " + tempBH[j][1] 
						+ "\nDistance: "+ tempBH[j][2] + "\n");
			}
		}
		
	}
	
	public static int campusChecker(String campus) {
		int i = 0;
		for(boolean a = true; i < hey.BUCampuses.length && a;i++) {
			if(campus.equalsIgnoreCase(hey.BUCampuses[i])) {
				i--;
				a = false;
			}
		}
		return i;
	}
}
