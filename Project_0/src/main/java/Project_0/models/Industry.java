package Project_0.models;

public class Industry {
	
	//Fields matching corresponding table in Database
	private int industry_id;
	private String industry_type;
	private int sector_jur;
	private double hum_assigned;
	private double hum_required;
	
	//no args constructor
	public Industry() {
		super();
	}

	@Override
	public String toString() {
		return "Industry [industry_id=" + industry_id + ", industry_type=" + industry_type + ", sector_jur="
				+ sector_jur + ", hum_assigned=" + hum_assigned + ", hum_required=" + hum_required + "]";
	}

	public int getIndustry_id() {
		return industry_id;
	}

	public void setIndustry_id(int industry_id) {
		this.industry_id = industry_id;
	}

	public String getIndustry_type() {
		return industry_type;
	}

	public void setIndustry_type(String industry_type) {
		this.industry_type = industry_type;
	}

	public int getSector_jur() {
		return sector_jur;
	}

	public void setSector_jur(int sector_jur) {
		this.sector_jur = sector_jur;
	}

	public double getHum_assigned() {
		return hum_assigned;
	}

	public void setHum_assigned(double hum_assigned) {
		this.hum_assigned = hum_assigned;
	}

	public double getHum_required() {
		return hum_required;
	}

	public void setHum_required(double hum_required) {
		this.hum_required = hum_required;
	}
	
	

}
