package org.ucm.tp1.p1.views;

import org.ucm.tp1.p1.logic.Game;
import org.ucm.tp1.p1.utils.MyStringUtils;

public class GamePrinter {
	
	Game game;
	int numRows; 
	int numCols;
	String[][] board;
	final String space = " ";
	
	public GamePrinter (Game game, int cols, int rows) {
		this.game = game;
		this.numRows = rows;
		this.numCols = cols;
		board= new String[rows][cols];
		draw();


	}
	
	private void encodeGame(Game game) {	
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j < numCols; j++) {
				if(game.posIsEmpty(i, j))
				    board[i][j] = space;
				else
					board[i][j]= game.toString(i, j);
			}
		}
		System.out.println(this.toString());
		// TODO fill your code
	}
	
	 public String toString() {
		//encodeGame(game);
		int cellSize = 7;
		int marginSize = 2;
		String vDelimiter = "|";
		String hDelimiter = "-";
		String intersect = space;
		String vIntersect = space;
		String hIntersect = "-";
		String corner = space;

		String cellDelimiter = MyStringUtils.repeat(hDelimiter, cellSize);

		String rowDelimiter = vIntersect + MyStringUtils.repeat(cellDelimiter + intersect, numCols-1) + cellDelimiter + vIntersect;
		String hEdge =  corner + MyStringUtils.repeat(cellDelimiter + hIntersect, numCols-1) + cellDelimiter + corner;

		String margin = MyStringUtils.repeat(space, marginSize);
		String lineEdge = String.format("%n%s%s%n", margin, hEdge);
		String lineDelimiter = String.format("%n%s%s%n", margin, rowDelimiter);

		StringBuilder str = new StringBuilder();

		str.append(lineEdge);
		for(int i=0; i<numRows; i++) {
		        str.append(margin).append(vDelimiter);
		        for (int j=0; j<numCols; j++)
		            str.append( MyStringUtils.centre(board[i][j], cellSize)).append(vDelimiter);
		        if (i != numRows - 1) str.append(lineDelimiter);
		        else str.append(lineEdge);   
		}

		return str.toString();
	 }
	 
	 public void draw() {
		 String numberOfCicles="Number of cicles: "+game.getContCiclos();
		 String coins = "Coins: " + game.getCoins();
		 String remainingVampires="Reamaining vampires: "+game.getReaminigVampires();
		 String vampsOnBoard = "Vampires on board: " + game.getVampOnBoard();
		 
		 System.out.println(numberOfCicles);
		 System.out.println(coins);
		 System.out.println(remainingVampires);
		 System.out.println(vampsOnBoard);
		 
			encodeGame(game);
		}


}

