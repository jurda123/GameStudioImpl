package sk.tsystems.gamestudio.services.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class ConfigureJDBC {
	public static final String DRIVER_CLASS = "org.apache.derby.jdbc.ClientDriver";
	public static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
	public static final String USER = "gamestudio";
	public static final String PASSWORD = "password";
	public static final String GETUSERID = "select userid from player where name like ?";
	public static final String GETGAMEID = "select gameid from game where name like ?";
	
	
	
	public int getUserId(String userName) {
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);) {
			PreparedStatement stmt = con.prepareStatement(GETUSERID);
			stmt.setString(1, userName);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				return  rs.getInt(1);
			}
		} catch (SQLException e) {
			System.err.println("Error reading database (getUserId)");
		}
		return 0;
	}
	
	public int getGameId(String gameName){
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);) {
			PreparedStatement stmt = con.prepareStatement(GETGAMEID);
			stmt.setString(1, gameName);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				return  rs.getInt(1);
			}
		} catch (SQLException e) {
			System.err.println("Error reading database (getGameId)");
		}
		return 0;
	}

}
