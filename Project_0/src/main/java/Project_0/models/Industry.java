package Project_0.models;

public class Industry {
	
	private String industry_type;
	private int industry_requirement;
	
	public Industry() {
		super();
	}

	public Industry(String industry_type, int industry_requirement) {
		super();
		this.industry_type = industry_type;
		this.industry_requirement = industry_requirement;
	}

	public String getIndustry_type() {
		return industry_type;
	}

	public void setIndustry_type(String industry_type) {
		this.industry_type = industry_type;
	}

	public int getIndustry_requirement() {
		return industry_requirement;
	}

	public void setIndustry_requirement(int industry_requirement) {
		this.industry_requirement = industry_requirement;
	}

	@Override
	public String toString() {
		return "Industry [industry_type=" + industry_type + ", industry_requirement=" + industry_requirement + "]";
	}
	
	
	
}
