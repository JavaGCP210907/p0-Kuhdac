package Project_0.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Project_0.models.Production;
import Project_0.util.ConnectionUtil;

public class ProductionDao implements ProductionDaoInterface {
	
	PodDao pod = new PodDao();

	@Override
	public void assignPod(int grid_id, int pod_count) {
		try(Connection conn = ConnectionUtil.getConnection()){
					
					String sql = "update production set h_assigned = h_assigned + ? where grid_id = ?";
					
					PreparedStatement ps = conn.prepareStatement(sql);
					
					ps.setInt(1, pod_count);
					ps.setInt(2, grid_id);
					ps.executeUpdate();
					
					//Add pod with pod_count number to pod database
					pod.addPod(pod_count, grid_id);
					
					
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
			
			ps.setInt(2, grid_id);
			ps.setInt(1, casualties);
			ps.executeUpdate();
			
			pod.podCasualty(grid_id, casualties);
			
			System.out.println(casualties + " casualities in " + grid_id + " has been documented.");
			
		} catch(SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
		
	}
	
	public void podRemoval(int grid_id, int podCount) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "update production set h_assigned = h_assigned - ? where grid_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(2, grid_id);
			ps.setInt(1, podCount);
			ps.executeUpdate();

			
		} catch(SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Production> getGridsBySector(int sector_id) {
		try(Connection conn = ConnectionUtil.getConnection()) {
					
					ResultSet rs = null;
					
					String sql = "select * from production where sector_id_fk = ? order by sector_id_fk";
					
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
			
			String sql = "select * from production where industry_type_fk = ? order by sector_id_fk";
			
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
			
			String sql = "select * from production order by sector_id_fk";
			
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
	public void removeBySector(int sector_id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "update production set h_assigned = 0 where sector_id_fk = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, sector_id);
			ps.executeUpdate();
			
			pod.removePodBySector(sector_id);
			
			System.out.println("Sector " + sector_id + " has been purged");
			
		} catch(SQLException e) {
			System.out.println("The resistance is too strong");
			e.printStackTrace();
			}
	}

	
	@Override
	public void reinforceSector(int sector_id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
			String sql = "select sector_id_fk, industry_type_fk, grid_id , h_assigned, industry.industry_requirement,"
					+ " (industry.industry_requirement - production.h_assigned) as difference"
					+ " from production"
					+ " join industry on industry_type_fk = industry.industry_type"
					+ " where sector_id_fk = ?"
					+ " order by sector_id_fk";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, sector_id);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				int diff = rs.getInt("difference");
				int grid = rs.getInt("grid_id");
				
				if (diff > 0) {
				
					assignPod(grid, diff);
				}
			}
				
			System.out.println("Sector " + sector_id + " has been reinforced");
			
		} catch(SQLException e) {
			System.out.println("Unable to ship in new workers");
			e.printStackTrace();
		}
		
	}
	
}
