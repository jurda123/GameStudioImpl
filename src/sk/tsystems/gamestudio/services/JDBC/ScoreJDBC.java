package sk.tsystems.gamestudio.services.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sk.tsystems.gamestudio.services.ScoreService;

public class ScoreJDBC   extends ConfigureJDBC implements ScoreService{
	
	public static final String ADDSCORE = "INSERT INTO score (scoreid,  userid, gameid,score) VALUES (?, ?, ?, ?)";
	public static final String SCORENEXTVAL = "SELECT scoreid.nextval from dual";
	private int score;
	private int userID;
	private int gameID;
	public ScoreJDBC(String gameName, int score){
		this.userID=getUserId(System.getProperty("user.name"));
		 this.gameID = getGameId(gameName);
		 this.score=score;
	}
	
	@Override
	public void addScore() {
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement stmt = con.prepareStatement(ADDSCORE);) {
			Statement scoreNextVal = con.createStatement();
			ResultSet rs = scoreNextVal.executeQuery(SCORENEXTVAL);
			int index = 0;
			while (rs.next()) {
				index = rs.getInt(1);
			}
			stmt.setInt(1, index);
			stmt.setInt(2, userID);
			stmt.setInt(3, gameID);
			stmt.setInt(4, score);
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			System.err.println("Error reading database (addScore)");
			e.printStackTrace();
			
		}
	}

	@Override
	public void getTopTenScore() {
		// TODO Auto-generated method stub
		
	}

}
