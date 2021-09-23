package Project_0.models;

public class Production {
	
	private int sector_id_fk;
	private String industry_type_fk;
	private int grid_id;
	private int h_assigned;
	
	
	
	//Constructors
	public Production() {
		super();
	}
	
	public Production(int sector_id_fk, String industry_type_fk, int grid_id, int h_assigned) {
		super();
		this.sector_id_fk = sector_id_fk;
		this.industry_type_fk = industry_type_fk;
		this.grid_id = grid_id;
		this.h_assigned = h_assigned;
	}
	
	
	
	//Getters & Setters
	
	public int getSector_id_fk() {
		return sector_id_fk;
	}
	public void setSector_id_fk(int sector_id_fk) {
		this.sector_id_fk = sector_id_fk;
	}
	public String getIndustry_type_fk() {
		return industry_type_fk;
	}
	public void setIndustry_type_fk(String industry_type_fk) {
		this.industry_type_fk = industry_type_fk;
	}
	public int getGrid_id() {
		return grid_id;
	}
	public void setGrid_id(int grid_id) {
		this.grid_id = grid_id;
	}
	public int getH_assigned() {
		return h_assigned;
	}
	public void setH_assigned(int h_assigned) {
		this.h_assigned = h_assigned;
	}
	@Override
	
	
	
	//ToString
	public String toString() {
		return "Production [sector_id_fk=" + sector_id_fk + ", industry_type_fk=" + industry_type_fk + ", grid_id="
				+ grid_id + ", h_assigned=" + h_assigned + "]";
	}
	
	

}
