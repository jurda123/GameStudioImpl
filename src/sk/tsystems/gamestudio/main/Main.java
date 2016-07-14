package sk.tsystems.gamestudio.main;

import sk.tsystems.gamestudio.games.guessthenumber.GuessTheNumber;
import sk.tsystems.gamestudio.services.JDBC.ConfigureJDBC;
import sk.tsystems.gamestudio.services.JDBC.RatingJDBC;

public class Main {

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.run();
//		System.out.println(System.getProperty("user.name"));
//		ConfigureJDBC configureJDBC= new ConfigureJDBC();
//		System.out.println(configureJDBC.getGameId("Minesweeper"));
		
//		GuessTheNumber g = new GuessTheNumber();
//		g.play();
		
//		RatingJDBC ratingjdbc = new RatingJDBC(6, 3, 69);
//		System.out.print(ratingjdbc.getAverageRatingForGame("asd"));
		
	}

}
