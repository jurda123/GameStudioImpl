package sk.tsystems.gamestudio.main;

import java.util.ArrayList;

import oracle.net.aso.e;
import sk.tsystems.gamestudio.entities.Score;
import sk.tsystems.gamestudio.services.JDBC.CommentJDBC;
import sk.tsystems.gamestudio.services.JDBC.ScoreJDBC;

public class Main {

	public static void main(String[] args) {
		
//		CommentJDBC c = new CommentJDBC("asd", "GuessTheNumber");
//		String[] pole =c.getAllCommentsForGame();
//		for(String s:pole){
//			System.out.println(s);
//		}
		new Menu().run();
	
	}

}
