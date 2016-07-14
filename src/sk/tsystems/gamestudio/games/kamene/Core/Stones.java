package sk.tsystems.gamestudio.games.kamene.Core;

import sk.tsystems.gamestudio.games.kamene.consoleUI.ConsoleUI;

public class Stones {
	private ConsoleUI consoleUI;

	public Stones() {
		consoleUI = new ConsoleUI();
		consoleUI.startGame();

	}

	public static void main(String[] args) {
		new Stones();

	}

}
