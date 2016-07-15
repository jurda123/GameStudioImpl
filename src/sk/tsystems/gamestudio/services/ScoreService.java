package sk.tsystems.gamestudio.services;

import java.util.ArrayList;

import sk.tsystems.gamestudio.entities.Score;

public interface ScoreService {
	
	public void addScore();
	
	public ArrayList<Score> getTopTenScore();
}
