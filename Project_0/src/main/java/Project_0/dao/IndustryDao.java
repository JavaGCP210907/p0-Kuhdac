package Project_0.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Project_0.models.Industry;
import Project_0.util.ConnectionUtil;

public class IndustryDao implements IndustryDaoInterface {

	@Override
	public List<Industry> getIndustries() {

		try(Connection conn = ConnectionUtil.getConnection()){
					
					ResultSet rs = null;
					
					String sql = "select * from industry";
					
					Statement s = conn.createStatement();
					
					rs = s.executeQuery(sql);
					
					List<Industry> industryList = new ArrayList<>();
					
					while(rs.next()) {
						
						Industry d = new Industry(
							rs.getString("industry_type"),
							rs.getInt("industry_requirement")
						);
						
						industryList.add(d);
						
					}
					
					return industryList;
					
				} catch(SQLException e) {
					System.out.println("Sector connection offline");
					e.printStackTrace();
				}
		return null;
	}

}
