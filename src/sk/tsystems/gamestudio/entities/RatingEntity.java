package sk.tsystems.gamestudio.entities;

public class RatingEntity {
	private int gameid;
	private int playerid;
	private int rating;
	
	
	public RatingEntity(int ratingid, int playerid, int rating) {
		super();
		this.gameid = ratingid;
		this.playerid = playerid;
		this.rating = rating;
	}
	public int getGameid() {
		return gameid;
	}
	public void setRatingid(int gameid) {
		this.gameid = gameid;
	}
	public int getPlayerid() {
		return playerid;
	}
	public void setPlayerid(int playerid) {
		this.playerid = playerid;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
}
