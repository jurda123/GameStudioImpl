package sk.tsystems.gamestudio.entities;

public class CommentEntity {
	private int commentid;
	private int playerid;
	private int gameid;
	private String commentar;
	
	 
	public CommentEntity(int commentid, int playerid, int gameid, String commentar) {
		super();
		this.commentid = commentid;
		this.playerid = playerid;
		this.gameid = gameid;
		this.commentar = commentar;
	}
	public int getCommentid() {
		return commentid;
	}
	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}
	public int getPlayerid() {
		return playerid;
	}
	public void setPlayerid(int playerid) {
		this.playerid = playerid;
	}
	public int getGameid() {
		return gameid;
	}
	public void setGameid(int gameid) {
		this.gameid = gameid;
	}
	public String getCommentar() {
		return commentar;
	}
	public void setCommentar(String commentar) {
		this.commentar = commentar;
	}
	 
	 
}
