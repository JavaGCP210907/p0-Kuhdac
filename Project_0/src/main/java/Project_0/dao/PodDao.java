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
					rs.getInt("pod_count"),
					rs.getInt("grid_id")
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
	public void addPod(int pod_count, int grid_id) {

		try (Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "insert into pod (h_count, grid_id) values (?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, pod_count);
			ps.setInt(2, grid_id);
			ps.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println("Unable to add pod");
			e.printStackTrace();
		}
		
	}
	

	@Override
	public List<Pod> getPodsById(int grid_id) {
		try(Connection conn = ConnectionUtil.getConnection()) {
					
					ResultSet rs = null;
					
					String sql = "select * from employees where pod_id = ?";
					
					PreparedStatement ps = conn.prepareStatement(sql);
					
					ps.setInt(1, grid_id);
					
					rs = ps.executeQuery();
					
					List<Pod> podList = new ArrayList<>();
								
					while(rs.next()) { 
						
						Pod e = new Pod(
							rs.getInt("pod_id"),
							rs.getInt("pod_count"),
							rs.getInt("grid_id")
						);
						
						podList.add(e);
					}
					
					return podList;
					
				} catch(SQLException e) {
					System.out.println("Something went wrong");
					e.printStackTrace();
				}
		return null;
	}

	
	@Override
	public void podCasualty(int grid_id, int casualities) {
		//Challenge
		
	}


}
