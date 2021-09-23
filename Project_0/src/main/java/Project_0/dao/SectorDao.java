package Project_0.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Project_0.models.Sector;
import Project_0.util.ConnectionUtil;

public class SectorDao implements SectorDaoInterface {

	@Override
	public List<Sector> getSectors() {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "select * from sector";
			
			Statement s = conn.createStatement();
			
			rs = s.executeQuery(sql);
			
			List<Sector> sectorList = new ArrayList<>();
			
			while(rs.next()) {
				
				Sector d = new Sector(
					rs.getInt("sector_id"),
					rs.getString("ai_codename"),
					rs.getString("serv_location")
				);
				sectorList.add(d);
				
			}
			
			return sectorList;
			
		} catch(SQLException e) {
			System.out.println("Sector connection offline");
			e.printStackTrace();
		}
		return null;
	}

}
