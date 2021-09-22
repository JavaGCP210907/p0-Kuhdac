package Project_0.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Project_0.models.Pod;
import Project_0.util.ConnectionUtil;

public class PodDao implements PodDaoInterface{

	@Override
	public List<Pod> getPods() {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "select * from pod";
			
			Statement s= conn.createStatement();
			
			rs = s.executeQuery(sql);
			
			List<Pod> podList = new ArrayList<>();
			
			while(rs.next()) {
				
				Pod p = new Pod(
					rs.getInt("pod_id"),
					rs.getDouble("h_count"),
					rs.getInt("sector_assigned"),
					rs.getString("industry_assigned"),
					rs.getBoolean("smile")
					);
				
				podList.add(p);
			}
			
			return podList; 
			
			
		}catch(SQLException e) {
			System.out.println("Connection Failed");
			e.printStackTrace();
		}
		
		return null;
		
		
		
		
		
	}

	@Override
	public List<Pod> getActivePods() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pod> getInactivePods() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removePod(int pod_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPod(double h_count) {
		// TODO Auto-generated method stub
		
	}

}
