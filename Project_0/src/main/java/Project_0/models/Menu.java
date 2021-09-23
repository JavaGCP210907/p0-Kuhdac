package Project_0.models;

import java.util.List;
import java.util.Scanner;

import Project_0.dao.PodDao;
import Project_0.dao.ProductionDao;

public class Menu {
	
	PodDao pDao = new PodDao();
	ProductionDao proDao = new ProductionDao();
	
	public void displayMenu() {
		
		boolean displayMenu = true;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to Computer World, beep boop");
		
		while (displayMenu) {
			System.out.println("Choose");
			
			System.out.println("podStatus -> Get Pod Status");
			
			String input = scan.nextLine();
			
			switch(input) {
			
				case "podStatus":{
					List<Pod> pods = pDao.getPods();
					for(Pod pod: pods) {
						System.out.println(pod);
					}
					break;
				}
				case "addPod":{
					
					
					System.out.println("Which Grid would you like to reinforce?");
					
					int grid =  scan.nextInt();
					scan.nextLine();
					
					System.out.println("How many will you add?");
					int pod = scan.nextInt();
					
					proDao.assignPod(grid, pod);
					
					break;
					
				}
				case "purgeSector":{
					System.out.println("Enter sector");
					int sector = scan.nextInt();
					
					proDao.removeBySector(sector);
					break;
				}
				
				case "casualty":{
					System.out.println("Enter grid");
					int grid = scan.nextInt();
					scan.nextLine();
					
					System.out.println("Enter casualties");
					int casualties = scan.nextInt();
					scan.nextLine();
					
					proDao.casualty(grid, casualties);
					break;
				}
				case "reinforceSector":{
					System.out.println("Enter sector");
					int sector = scan.nextInt();
					scan.nextLine();
					
					proDao.reinforceSector(sector);
					break;
				}
				case "exit":{
					displayMenu = false;
					System.out.println("Test completed");
					break;
				}

			}
		}
		scan.close();
	}
}
	