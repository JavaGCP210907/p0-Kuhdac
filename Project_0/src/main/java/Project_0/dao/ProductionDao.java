package Project_0.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Project_0.models.Pod;
import Project_0.models.Production;
import Project_0.util.ConnectionUtil;

public class ProductionDao implements ProductionDaoInterface {

	@Override
	public void assignPod(int grid_id, int pod_count) {
		try(Connection conn = ConnectionUtil.getConnection()){
					
					String sql = "update production set h_assigned = h_assigned + ? where grid_id = ?";
					
					PreparedStatement ps = conn.prepareStatement(sql);
					
					ps.setInt(1, pod_count);
					ps.setInt(2, grid_id);
					ps.executeUpdate();
					
					System.out.println(grid_id + "has been succesfully bolstered with " + pod_count + " eager workers");
					
				} catch(SQLException e) {
					System.out.println("Connection failed");
					e.printStackTrace();
				}
		
	}

	@Override
	public void casualty(int grid_id, int casualties) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "update production set h_assigned = h_assigned - ? where grid_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, grid_id);
			ps.setInt(2, casualties);
			ps.executeUpdate();
			
			System.out.println(casualties + " casualities in " + grid_id + " has been documented.");
			
		} catch(SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Production> getGridsBySector(int sector_id) {
		try(Connection conn = ConnectionUtil.getConnection()) {
					
					ResultSet rs = null;
					
					String sql = "select * from production where sector_id_fk = ?";
					
					PreparedStatement ps = conn.prepareStatement(sql);
					
					ps.setInt(1, sector_id);
					
					rs = ps.executeQuery();
					
					List<Production> productionList = new ArrayList<>();
								
					while(rs.next()) { 
						
						Production p = new Production(
							rs.getInt("sector_id_fk"),
							rs.getString("industry_type_fk"),
							rs.getInt("grid_id"),
							rs.getInt("h_assigned")
						);
						
						productionList.add(p);
					}
					
					return productionList;
					
				} catch(SQLException e) {
					System.out.println("Production access offline");
					e.printStackTrace();
				}
		return null;
	}

	@Override
	public List<Production> getGridsByIndustry(String industry) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			ResultSet rs = null;
			
			String sql = "select * from production where industry_type_fk = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, industry);
			
			rs = ps.executeQuery();
			
			List<Production> productionList = new ArrayList<>();
						
			while(rs.next()) { 
				
				Production p = new Production(
					rs.getInt("sector_id_fk"),
					rs.getString("industry_type_fk"),
					rs.getInt("grid_id"),
					rs.getInt("h_assigned")
				);
				
				productionList.add(p);
			}
			
			return productionList;
			
		} catch(SQLException e) {
			System.out.println("Production access offline");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Production> getGrids() {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "select * from production";
			
			Statement s = conn.createStatement();
			
			rs = s.executeQuery(sql);
			
			List<Production> productionList = new ArrayList<>();
			
			while(rs.next()) {
				
				Production d = new Production(
					rs.getInt("sector_id_fk"),
					rs.getString("industry_type_fk"),
					rs.getInt("grid_id"),
					rs.getInt("h_assigned")
				);
				
				productionList.add(d);
				
			}
			
			return productionList;
			
		} catch(SQLException e) {
			System.out.println("Production connection offline");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Production> removeBySector(int sector_id) {
		try(Connection conn = ConnectionUtil.getConnection()){
					
					String sql = "update production set h_assigned = 0 where sector_id_fk = ?";
					
					PreparedStatement ps = conn.prepareStatement(sql);
					
					ps.setInt(1, sector_id);
					ps.executeUpdate();
					
					System.out.println("Sector " + sector_id + " has been purged");
					
				} catch(SQLException e) {
					System.out.println("The resistance is too strong");
					e.printStackTrace();
				}
		return null;
	}

}
