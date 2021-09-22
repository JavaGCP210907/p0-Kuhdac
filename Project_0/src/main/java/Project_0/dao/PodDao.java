package Project_0.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "select from pod where sector_assigned IS NOT NULL";
			
			Statement s = conn.createStatement();
			
			rs = s.executeQuery(sql);
			
			List<Pod> podList = new ArrayList<>();
			
			while(rs.next()){
				
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
			
		} catch(SQLException e) {
			System.out.println("Connection Failed");
			e.printStackTrace();
		}
				
		return null;
	}

	@Override
	public List<Pod> getInactivePods() {
		{
			
			try(Connection conn = ConnectionUtil.getConnection()){
				
				ResultSet rs = null;
				
				String sql = "select from pod where sector_assigned IS NULL";
				
				Statement s = conn.createStatement();
				
				rs = s.executeQuery(sql);
				
				List<Pod> podList = new ArrayList<>();
				
				while(rs.next()){
					
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
				
			} catch(SQLException e) {
				System.out.println("Connection Failed");
				e.printStackTrace();
			}
					
			return null;
		}
	}

	@Override
	public void removePod(int pod_id) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "delete from pod where pod_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,pod_id);
			ps.executeUpdate();
			
			System.out.println("Pod:" + pod_id + " has been purged successfully");
		
		} catch(SQLException e) {
			System.out.println("Pod inacessible");
			e.printStackTrace();
		}
	}

	@Override
	public void addPod(double h_count) {
		try (Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "insert into pod (h_count) values ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setDouble(1, h_count);
			ps.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println("Unable to add pod");
			e.printStackTrace();
		}
		
	}

}
