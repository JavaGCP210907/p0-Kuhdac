package Project_0.models;

public class Pod {
	
	private int pod_id;
	private double h_count;
	private int sector_assigned;
	private String industry_assigned;
	private boolean smile;
	
	public Pod() {
		super();
	}
	
	
	public Pod(int pod_id, double h_count, int sector_assigned, String industry_assigned, boolean smile) {
		super();
		this.pod_id = pod_id;
		this.h_count = h_count;
		this.sector_assigned = sector_assigned;
		this.industry_assigned = industry_assigned;
		this.smile = smile;
	}



	public Pod(double h_count, int sector_assigned, String industry_assigned, boolean smile){
		super();
		this.h_count = h_count;
		this.sector_assigned = sector_assigned;
		this.industry_assigned = industry_assigned;
		this.smile = smile;
	}


	@Override
	public String toString() {
		return "Pod [pod_id=" + pod_id + ", h_count=" + h_count + ", sector_assigned=" + sector_assigned
				+ ", industry_assigned=" + industry_assigned + ", smile=" + smile + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(h_count);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((industry_assigned == null) ? 0 : industry_assigned.hashCode());
		result = prime * result + pod_id;
		result = prime * result + sector_assigned;
		result = prime * result + (smile ? 1231 : 1237);
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
		if (Double.doubleToLongBits(h_count) != Double.doubleToLongBits(other.h_count))
			return false;
		if (industry_assigned == null) {
			if (other.industry_assigned != null)
				return false;
		} else if (!industry_assigned.equals(other.industry_assigned))
			return false;
		if (pod_id != other.pod_id)
			return false;
		if (sector_assigned != other.sector_assigned)
			return false;
		if (smile != other.smile)
			return false;
		return true;
	}

	
}
