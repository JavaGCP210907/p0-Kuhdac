package Project_0.dao;

import java.util.List;

import Project_0.models.Production;

public interface ProductionDaoInterface {
	
	public void assignPod(int grid_id, int pod_count);
	
	public void casualty(int grid_id, int casualties);
	
	public List<Production> getGridsBySector(int sector_id);
	
	public List<Production> getGridsByIndustry(String industry);
	
	public List<Production> getGrids();
	
	public void podRemoval(int grid_id, int podCount);
	
	public void removeBySector(int sector_id);
	
	public void reinforceSector(int sector_id);
}
