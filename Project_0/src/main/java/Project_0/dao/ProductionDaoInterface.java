package Project_0.dao;

import java.util.List;

import Project_0.models.Production;

public interface ProductionDaoInterface {
	
	public void assignPod(int grid_id, int pod_count);
	
	public void casualty(int grid_id, int casualties);
	
	public List<Production> getGridBySector(int sectorId);
	
	public List<Production> getGridByIndustry(String industry);
	
	public List<Production> getGrid();
	
	public List<Production> removeBySector(int sectorId);
}
