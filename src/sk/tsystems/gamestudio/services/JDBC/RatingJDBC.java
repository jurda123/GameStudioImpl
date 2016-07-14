package sk.tsystems.gamestudio.services.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import sk.tsystems.gamestudio.services.RatingService;

public class RatingJDBC extends ConfigureJDBC implements RatingService{
	 int gameid;//= getGameId(gameName);
	 int userid;
	 int rating;
	 public static final String GETRATINGCOUNT = "SELECT count(*) from rating where gameid = ?";
	 public static final String GETRATINGAVG = "SELECT avg(rating) from rating where gameid = ?";
	 public static final String ADDRATING = "INSERT INTO raing (userid, gameid,score) VALUES (?, ?, ?)";
	 private String gameName;
	public RatingJDBC(int gameid, int userid, int rating) {
		super();
		this.gameid = gameid;
		this.userid = userid;
		this.rating = rating;
	}
	
	public RatingJDBC(String gameName){
		this.gameName=gameName;
		
	}

	@Override
	public double getAverageRatingForGame(String game) {
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);) {
			PreparedStatement scoreNextVal = con.prepareStatement(GETRATINGAVG);
			scoreNextVal.setInt(1, getGameId(gameName));
			ResultSet rs = scoreNextVal.executeQuery();
			while (rs.next()) {
				return rs.getDouble(1);
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		
	}
	
	@Override
	public int getNumberOfRatingForGame(String game) {
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);) {
		PreparedStatement scoreNextVal = con.prepareStatement(GETRATINGCOUNT);
		scoreNextVal.setInt(1, getGameId(gameName));
		ResultSet rs = scoreNextVal.executeQuery();
		while (rs.next()) {
			return rs.getInt(1);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public void addRating() {
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement stmt = con.prepareStatement(ADDRATING);) {
			
			stmt.setInt(1, userid);
			stmt.setInt(2, gameid);
			stmt.setInt(3, rating);
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			System.err.println("Error reading database (addScore)");
			
		}
		
	}

	

	@Override
	public void changeRating() {
		// TODO Auto-generated method stub
		
	}
	

}
