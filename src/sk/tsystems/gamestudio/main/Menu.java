package sk.tsystems.gamestudio.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import sk.tsystems.gamestudio.entities.Score;
import sk.tsystems.gamestudio.games.Game;
import sk.tsystems.gamestudio.services.CommentService;
import sk.tsystems.gamestudio.services.RatingService;
import sk.tsystems.gamestudio.services.ScoreService;
import sk.tsystems.gamestudio.services.JDBC.CommentJDBC;
import sk.tsystems.gamestudio.services.JDBC.RatingJDBC;
import sk.tsystems.gamestudio.services.JDBC.ScoreJDBC;

public class Menu {

	private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static final String MENU = "1.Minesweeper\n2.Kamene\n3.Guess The Number";
	private String[] listOfGames = new String[] { "Minesweeper", "Stones", "GuessTheNumber" };

	private void printMenuAndRating() {
		System.out.println(String.format("%-7s %-20s %-20s %-10s", "option", "Game name  ", "average rating ",
				"number of ratings "));
		System.out.println("------------------------------------------------------------------");
		for (int i = 0; i < listOfGames.length; i++) {
			RatingService ratingService = new RatingJDBC(listOfGames[i]);
			System.out.println(String.format("%-7d %-20s %-20.2f %-10d", i + 1, listOfGames[i],
					ratingService.getAverageRatingForGame(listOfGames[i]),
					ratingService.getNumberOfRatingForGame(listOfGames[i])));
		}
		System.out.println(String.format("%-7d %-20s", listOfGames.length + 1, "EXIT"));
	}

	private String readLine() {

		try {
			return input.readLine();
		} catch (IOException e) {
			System.err.println("Error reading from the console");
			return null;
		}
	}

	public void run() {
		while (true) {
			printMenuAndRating();
			System.out.println("-------------------------------");
			System.out.println("Enter option:");
			int option = 0;
			try {
				option = Integer.parseInt(readLine());
			} catch (NumberFormatException e) {
				System.err.println("Invalid input. Enter option(number)");
			}
			switch (option) {
			case 1:
				playGame("sk.tsystems.gamestudio.games.minesweeper.Minesweeper", "Minesweeper");
				break;
			case 2:
				playGame("sk.tsystems.gamestudio.games.stones.core.Stones", "Stones");
				break;
			case 3:
				playGame("sk.tsystems.gamestudio.games.guessthenumber.GuessTheNumber", "GuessTheNumber");
				break;

			case 4:
				return;

			}

		}
	}

	private void playGame(String path, String gameName) {
		try {
			Class clazz = Class.forName(path);
			Game game = (Game) clazz.newInstance();
			game.play();
			System.out.println("Your score: " + game.getScore());
			printTopTenScore(gameName);
			saveScore(game.getScore(), gameName);
			addComment(gameName);
			addRating(gameName);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addComment(String gameName) {
		System.out.println("Do you wish to add a comment ? \n1: yes\n2:no");
		int option = 0;
		try {
			option = Integer.parseInt(readLine());
		} catch (NumberFormatException e) {
			System.err.println("Invalid input. Enter option(number)");
		}
		switch (option) {
		case 1:
			saveComment(gameName);
			break;
		case 2:
			break;
		}
	}

	private void saveComment(String gameName) {
		String comment = null;
		System.out.println("Write Commentar:");
		comment = readLine();
		CommentService commentService = new CommentJDBC(comment, gameName);
		commentService.addComment();
	}

	private void saveScore(int score, String name) {
		ScoreService scoreService = new ScoreJDBC(name, score);
		scoreService.addScore();
	}

	private void addRating(String gameName) {
		System.out.println("Do you wish to rate the game? \n1: yes\n2:no");
		int option = 0;
		try {
			option = Integer.parseInt(readLine());
		} catch (NumberFormatException e) {
			System.err.println("Invalid input. Enter option(number)");
		}
		switch (option) {
		case 1:
			rate(gameName);
			break;
		case 2:
			break;
		}
	}

	private void rate(String gameName) {
		int rating = 0;
		while (true) {
			System.out.println("Write rating:");
			try {
				rating = Integer.parseInt(readLine());
				if (rating > 0 && rating <= 5) {

					RatingService ratingService = new RatingJDBC(gameName, rating);
					ratingService.addRating();
					break;
				} else {
					System.err.println("Rating must be in range 1-5");
				}
			} catch (NumberFormatException e) {
				System.err.println("Invalid input. Rating must be number in range 1-5");
			}

		}

	}
	
	private void printTopTenScore(String gameName){
		
		ScoreJDBC s = new ScoreJDBC(gameName, 69);
		
		ArrayList<Score> l = s.getTopTenScore();
		System.out.println("Top 10 for " + gameName); 
		for(int i = 0;i<10;i++){
			System.out.println(String.format("%-20s %-10d", l.get(i).getGameName() ,l.get(i).getScore()));
			
		}
	}

}