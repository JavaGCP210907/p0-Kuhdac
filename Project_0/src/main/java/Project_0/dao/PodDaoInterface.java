package Project_0.dao;

import java.util.List;

import Project_0.models.Pod;

public interface PodDaoInterface {
	
	public List<Pod> getPods(); //Returns all Pods
	
	public List<Pod> getPodsByID(int pod_id);
	
	public void removePod(int pod_id);
	
	public void podCasualty(int grid_id, int casualities);
	
	public void addPod(int h_count, int grid_id);

}
