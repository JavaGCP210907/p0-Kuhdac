package Project_0.models;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Project_0.dao.IndustryDao;
import Project_0.dao.PodDao;
import Project_0.dao.ProductionDao;
import Project_0.dao.SectorDao;

public class Menu {
	
	PodDao pDao = new PodDao();
	ProductionDao proDao = new ProductionDao();
	IndustryDao inDao = new IndustryDao();
	SectorDao secDao = new SectorDao();
	Logger log = LogManager.getLogger(Menu.class);
	
	public void displayMenu() {
		
		boolean displayMenu = true;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to Human Resource Management System");
		
		while (displayMenu) {
			System.out.println("Make a selection");
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println(" ");
			System.out.println("podStatus -> Get Pod Status");
			System.out.println(" ");
			System.out.println("industryInfo -> Get Industry List");
			System.out.println(" ");
			System.out.println("productionInfo -> Get Production Status");
			System.out.println(" ");
			System.out.println("sectorInfo -> Get Sector List");
			System.out.println(" ");
			System.out.println("addPod -> Manually add Pod to grid");
			System.out.println(" ");
			System.out.println("purgeSector -> Ensure effective work habits (Removes workers from entire sector)");
			System.out.println(" ");
			System.out.println("casualty -> Report 'unfortunate' workplace casualties");
			System.out.println(" ");
			System.out.println("reinforceSector -> Assign a ready workforce to sector's vacancies");
			System.out.println(" ");
			System.out.println("removePod -> Remove pod via pod ID");
			System.out.println(" ");
			System.out.println("exit -> exit");
			System.out.println(" ");
			
			String input = scan.nextLine();
			
			switch(input) {
				
				
				case "podStatus":{
					List<Pod> pods = pDao.getPods();
					for(Pod pod: pods) {
						System.out.println("Pod ID: " + pod.getPod_id() + "  Pod Count: " + pod.getPod_count() + " Grid ID: " + pod.getGrid_id_fk());
						System.out.println("--------------------------------------------");
					}
					break;
				}
				
				case "productionInfo":{
					List<Production> pros = proDao.getGrids();
					for(Production pod: pros) {
						System.out.println("Sector ID: " + pod.getSector_id_fk()  + " Industry:  " + pod.getIndustry_type_fk() + " Humans Assigned: " + pod.getH_assigned() + "Grid ID: " + pod.getGrid_id());
						System.out.println("--------------------------------------------");
					}
					break;
				}
				//case "podStatId":{
					//System.out.println("Enter grid ID");
					//
					
					
					//List<Pod> pods = pDao.getPodsById(grid);
					//for(Pod pod: pods) {
						//System.out.println("Pod ID: " + pod.getPod_id() + "  Pod Count: " + pod.getPod_count() + " Grid ID: " + pod.getGrid_id_fk());
					//}
					//break;
				//}
				case "industryInfo":{
					List<Industry> ind = inDao.getIndustries();
					for(Industry x: ind) {
						System.out.println("Industry: " + x.getIndustry_type());
						System.out.println("--------------------------------------------");
					
					}
					break;
					
				}
				case "sectorInfo":{
					List<Sector> sects = secDao.getSectors();
					for(Sector sect: sects) {
						System.out.println("Sector ID: " + sect.getSector_id() + " AI: " + "'" + sect.getAi_codename() + "'" + " Server Location: " + sect.getServ_location());
						System.out.println("--------------------------------------------");
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
					
					log.info("User added pod under ID: " + pod);
					
					break;
					
				}
				case "purgeSector":{
					System.out.println("Enter sector");
					int sector = scan.nextInt();
					scan.nextLine();
					
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
					
					log.info("User reported " + casualties + " casualties");
					break;
				}
				case "reinforceSector":{
					System.out.println("Enter sector");
					int sector = scan.nextInt();
					scan.nextLine();
					
					proDao.reinforceSector(sector);
					break;
				}
				case "removePod":{
					
					List<Pod> pods = pDao.getPods();
					for(Pod p: pods) {
						System.out.println("Pod ID: " + p.getPod_id() + "  Pod Count: " + p.getPod_count() + " Grid ID: " + p.getGrid_id_fk());
						System.out.println("--------------------------------------------");
					}
					
					System.out.println("Enter pod ID");
					int pod = scan.nextInt();
					scan.nextLine();
					
					pDao.removePod(pod);
					break;
				}
				case "exit":{
					displayMenu = false;
					System.out.println("Thank you");
					break;
				}
				default:{
					System.out.println("Incorrect input");
				}
			
			}
		}
		scan.close();
	
		}
	
}

	