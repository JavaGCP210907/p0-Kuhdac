package Project_0.dao;

import java.util.List;

import Project_0.models.Pod;

public interface PodDaoInterface {
	
	public List<Pod> getPods(); //Returns all Pods
	
	public List<Pod> getActivePods(); //Returns active Pods
	
	public List<Pod> getInactivePods();
	
	public void removePod(int pod_id);
	
	public void addPod(double h_count);

}
