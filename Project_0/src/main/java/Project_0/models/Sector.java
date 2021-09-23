package Project_0.models;

public class Sector {
	
	//Fields matching corresponding table in Database
	private int sector_id;
	private String ai_codename;
	private String serv_location;
	
	public Sector() {
		super();
	}
	

	public Sector(int sector_id, String ai_codename, String serv_location) {
		super();
		this.sector_id = sector_id;
		this.ai_codename = ai_codename;
		this.serv_location = serv_location;
	}



	@Override
	public String toString() {
		return "Sector [sector_id=" + sector_id + ", ai_codename=" + ai_codename + ", serv_location=" + serv_location
				+ "]";
	}

	public int getSector_id() {
		return sector_id;
	}

	public void setSector_id(int sector_id) {
		this.sector_id = sector_id;
	}

	public String getAi_codename() {
		return ai_codename;
	}

	public void setAi_codename(String ai_codename) {
		this.ai_codename = ai_codename;
	}

	public String getServ_location() {
		return serv_location;
	}

	public void setServ_location(String serv_location) {
		this.serv_location = serv_location;
	}
	
	

}
