package org.ucm.tp1.p1.control;

import java.util.Scanner;

import org.ucm.tp1.p1.logic.Game;

import org.ucm.tp1.p1.utils.MyStringUtils;

public class Controller {

	
	public final String prompt = "Command > ";
	public static final String helpMsg = String.format(
			"Available commands:%n" +
			"[a]dd <x> <y>: add a slayer in position x, y%n" +
			"[h]elp: show this help%n" + 
			"[r]eset: reset game%n" + 
			"[e]xit: exit game%n"+ 
			"[n]one | []: update%n");
	
	public static final String unknownCommandMsg = String.format("Unknown command");
	public static final String invalidCommandMsg = String.format("Invalid command");
	public static final String invalidPositionMsg = String.format("Invalid position");

    private Game game;
    private Scanner scanner;
    
    public Controller(Game game, Scanner scanner) {
	    this.game = game;
	    this.scanner = scanner;
    }
    
    public void  printGame() {
   	 System.out.println(game);
   }
    
    public void run() {
    	while(!game.checkFinish()) {
    	game.update();
    	userCommand(); 		
    	}
    	if (game.getLost())
    		System.out.println("Vampire wins");
    	else
    		System.out.println("Player wins");
    }
		// TODO fill your code
    




private void userCommand() {
	System.out.println("Command >");
	String getLine = scanner.nextLine().trim().toLowerCase();
	String[] words = getLine.split(" +");
	if (words[0].equalsIgnoreCase("add") || words[0].equalsIgnoreCase("a")) {
		int x = Integer.parseInt(words[1]);
		int y = Integer.parseInt(words[2]);
		if(!game.addSlayer(x, y, game))
			userCommand();
		
	}
	else if (words[0].equalsIgnoreCase("help") || words[0].equalsIgnoreCase("h")) {
		System.out.println(helpMsg);
		userCommand();
		
	}
	else if (words[0].equalsIgnoreCase("reset") || words[0].equalsIgnoreCase("r")) {
		this.game= new Game(game.getSeed(),game.getLevel());
	}
	else if (words[0].equalsIgnoreCase("exit") || words[0].equalsIgnoreCase("e")) {
		game.setLost(true);
	}
	else if (words[0].equalsIgnoreCase("none") || words[0].equalsIgnoreCase("n")) {
	}
	
}
}