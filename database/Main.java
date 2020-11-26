package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//getConnection();
		createTable();

	}
	public static void createTable() throws Exception{
		try {
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS word(id int NOT NULL AUTO_IN)");
			create.executeUpdate();
		}catch(Exception e) {System.out.println(e);}
		finally {
			System.out.println("Function complete.");
		};
	}
	
	
	public static Connection getConnection() throws Exception{
		  try{
		   String driver = "com.mysql.cj.jdbc.Driver";
		   String url = "jdbc:Mysql://127.0.0.1:3306/word occurrences";
		   String username = "root";
		   String password = "10511NewYork!";
		   Class.forName(driver);
		   
		   Connection conn = DriverManager.getConnection(url,username,password);
		   System.out.println("Connected");
		   return conn;
		  } catch(Exception e){System.out.println(e);}
		  
		  
		  return null;
		 }

}
