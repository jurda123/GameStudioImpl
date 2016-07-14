package sk.tsystems.gamestudio.entities;

public class ScoreEntity {
	private int scoreid;
	private int userid;
	private int gameid;
	private int score;
	
	
	
	public ScoreEntity(int scoreid, int userid, int gameid, int score) {
		super();
		this.scoreid = scoreid;
		this.userid = userid;
		this.gameid = gameid;
		this.score = score;
	}
	
	
	public int getScoreid() {
		return scoreid;
	}
	public void setScoreid(int scoreid) {
		this.scoreid = scoreid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getGameid() {
		return gameid;
	}
	public void setGameid(int gameid) {
		this.gameid = gameid;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
