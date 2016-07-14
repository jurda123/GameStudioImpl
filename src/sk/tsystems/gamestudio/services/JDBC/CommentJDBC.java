package sk.tsystems.gamestudio.services.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sk.tsystems.gamestudio.services.CommentService;

public class CommentJDBC extends ConfigureJDBC implements CommentService{
	public static final String ADDCOMMENT = "INSERT INTO commentar (commentid,  userid, gameid,commentar) VALUES (?, ?, ?, ?)";
	public static final String COMMENTNEXTVAL = "SELECT commentid.nextval from dual";
	private String comment;
	private int userID;
	private int gameID;
	
	
	public CommentJDBC(String comment,String gameName){
		this.userID=getUserId(System.getProperty("user.name"));
		 this.gameID = getGameId(gameName);
		 this.comment=comment;
	}
	@Override
	public void addComment() {
		
		 try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
					PreparedStatement stmt = con.prepareStatement(ADDCOMMENT);) {
				Statement scoreNextVal = con.createStatement();
				ResultSet rs = scoreNextVal.executeQuery(COMMENTNEXTVAL);
				int index = 0;
				while (rs.next()) {
					index = rs.getInt(1);
				}
				stmt.setInt(1, index);
				stmt.setInt(2, userID);
				stmt.setInt(3, gameID);
				stmt.setString(4, comment);
				stmt.executeUpdate();
				stmt.close();
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void getAllCommentsForGame(String game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getNumberOfComments() {
		// TODO Auto-generated method stub
		return 0;
	}

}
