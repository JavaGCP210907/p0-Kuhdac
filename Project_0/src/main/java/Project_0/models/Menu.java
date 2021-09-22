package Project_0.models;

import java.util.List;
import java.util.Scanner;

import Project_0.dao.PodDao;

public class Menu {
	
	PodDao pDao = new PodDao();
	
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
	