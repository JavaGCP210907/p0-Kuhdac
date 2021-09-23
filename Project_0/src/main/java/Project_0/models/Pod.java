package Project_0.models;

public class Pod {
	
	private int pod_id;
	private int pod_count;
	private int grid_id_fk;
	
	
	
	public Pod() {
		super();
	}



	public Pod(int pod_count, int grid_id_fk) {
		super();
		this.pod_count = pod_count;
		this.grid_id_fk = grid_id_fk;
	}



	public int getPod_id() {
		return pod_id;
	}



	public void setPod_id(int pod_id) {
		this.pod_id = pod_id;
	}



	public int getPod_count() {
		return pod_count;
	}



	public void setPod_count(int pod_count) {
		this.pod_count = pod_count;
	}



	public int getGrid_id_fk() {
		return grid_id_fk;
	}



	public void setGrid_id_fk(int grid_id_fk) {
		this.grid_id_fk = grid_id_fk;
	}



	@Override
	public String toString() {
		return "Pod [pod_id=" + pod_id + ", pod_count=" + pod_count + ", grid_id_fk=" + grid_id_fk + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + grid_id_fk;
		result = prime * result + pod_count;
		result = prime * result + pod_id;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pod other = (Pod) obj;
		if (grid_id_fk != other.grid_id_fk)
			return false;
		if (pod_count != other.pod_count)
			return false;
		if (pod_id != other.pod_id)
			return false;
		return true;
	}
	
	

	
}
