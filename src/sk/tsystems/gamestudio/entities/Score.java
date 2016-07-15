package sk.tsystems.gamestudio.entities;

public class Score {
 private String gameName;
 private String userName;
 private int Score;
 
 


 
 
public Score(String gameName, String userName, int score) {
	super();
	this.gameName = gameName;
	this.userName = userName;
	Score = score;
}


public String getGameName() {
	return gameName;
}
public void setGameName(String gameName) {
	this.gameName = gameName;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public int getScore() {
	return Score;
}
public void setScore(int score) {
	Score = score;
}
}
