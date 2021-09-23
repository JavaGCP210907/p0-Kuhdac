package Project_0;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.stream.IntStream;

import com.google.common.collect.Range;

import Project_0.models.Menu;
import Project_0.util.ConnectionUtil;

public class Launcher {

	public static void main(String[] args) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			System.out.println("Connection was succesful");
		} catch(SQLException e) {
			System.out.println("Connection Failed");
			e.printStackTrace();
		}
		
		Range<Integer> range = Range.open(1,66);
		System.out.println(range);
		
		Menu menu = new Menu();
		menu.displayMenu();
		
		
		
	}

}
