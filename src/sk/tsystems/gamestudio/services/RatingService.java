package sk.tsystems.gamestudio.services;

public interface RatingService {
	
	public double getAverageRatingForGame(String game);
	
	
	
	public void addRating();
	
	public int getNumberOfRatingForGame(String game); 
	
	

}
