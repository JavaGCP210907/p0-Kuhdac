package Project_0.dao;

import java.util.List;

import Project_0.models.Pod;

public interface PodDaoInterface {
	
	public List<Pod> getPods(); //Returns all Pods
	
	public List<Pod> getPodsById(int grid_id);
	
	public void removePod(int pod_id);
	
	public void removePodBySector(int sector_id);
	
	public void podCasualty(int grid_id, int casualities);
	
	public void addPod(int _count, int grid_id);
	

}
