package sk.tsystems.gamestudio.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Comment {

private String playerName;
	
	private String Game;
	
	private int vek;
	@Id
	@GeneratedValue
	private int id;
}
