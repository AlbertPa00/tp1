package org.ucm.tp1.p1.logic;

import org.ucm.tp1.p1.logic.newobjects.Player;
import org.ucm.tp1.p1.logic.newobjects.Vampire;
import org.ucm.tp1.p1.logic.newobjects.Slayer;
import org.ucm.tp1.p1.logic.lists.SlayerList;
import org.ucm.tp1.p1.logic.lists.VampireList;

import org.ucm.tp1.p1.views.GamePrinter;
import java.util.Random;

public class Game {
	private Level level;
	private long seed;
	
	private int puntuacion;
	private int ciclos;
	private int remainingVampires;
	private int vampsOnBoard;
	private int coins;
	
	private GamePrinter gamePrinter;
	private boolean lost;
	
	Random rand;
	private Player player;
	
	
	private GameObjectBoard gameObjects;
	
	public Game(long seed, Level level) {
		this.level = level;
		this.seed = seed;
		this.rand = new Random(seed);
		
		this.lost = false;
		this.gameObjects = new GameObjectBoard();
		this.player = new Player(rand);
		this.vampsOnBoard = 0;
		this.puntuacion = 0;
		this.ciclos = 0;
		this.coins= player.getCoins();
		this.remainingVampires=level.getNumberOfVampires();
		this.gamePrinter =new GamePrinter(this,level.getDim_x(),level.getDim_y());
		
	}
	
	 public void update() {
		 
		 updatePlayer();
		 updateGameObjectBoard();
		 ciclos++;
		 addVampire(this);
		 gamePrinter.draw();
		 	 
	 }
	public boolean posIsEmpty(int x, int y)
	{
		return (gameObjects.getVampireList().isPositionEmpty(x, y) && gameObjects.getSlayerList().isPositionEmpty(x, y));
	}
	public boolean checkFinish() {
		updateVampsOnBoard();
		for(int i=0;i<level.getDim_y();i++) {
			if (!gameObjects.getVampireList().isPositionEmpty(i,-1)) {
				lost=true;
				return true;
			}
		if(remainingVampires==0 && vampsOnBoard == 0)
			return true;
		}
		return lost;
	}
	public void addVampire(Game game) {
		double n= rand.nextDouble();
		if(n < level.getVampireFrequency() && remainingVampires!=0) {
			int x=getRandomVampireStart();
			int y=level.getDim_x()-1;
			if(posIsEmpty(x,y)) {			
				gameObjects.getVampireList().addVampire(x, y,game);
				vampsOnBoard = getVampOnBoard() + 1;
				remainingVampires--;}			
		}
	}
	public boolean addSlayer(int y , int x,Game game) {
		if(posIsEmpty(x,y) && player.getCoins()>=Slayer.cost && (x >= 0 && x <= level.getDim_x()) && (y >= 0 && y <= level.getDim_y())) {
			player.wasteCoins(Slayer.cost);	
			gameObjects.getSlayerList().add(x, y, game);					
			return true;
		}
		return false;

	}
	public String toString(int x,int y) {
		Vampire v=null;
		Slayer s=null;
		String code;
		if (!gameObjects.getVampireList().isPositionEmpty(x, y)) {
			v=gameObjects.getVampireList().getObjectInPosition(x, y);
			code = v.toString();
		}		
		else{
			s=gameObjects.getSlayerList().getObjectInPosition(x, y);
			code=s.toString();
		}
		return code;
	}
	public int getRandomVampireStart() {
		int x;
		x= rand.nextInt(level.getDim_y());
		return x;
	}
	public boolean getLost() {
		return lost;
	}
	public void vampireAttacks(int x, int y, int damage){
		gameObjects.getSlayerList().decreaseLife(x, y, damage);
		
	}
	public void slayerAttacks(int x, int y, int damage){
		for(int i=y+1;i<level.getDim_x();i++)
			if(gameObjects.getVampireList().getObjectInPosition(x, i)!=null) {
				gameObjects.getVampireList().decreaseLife(x, i, damage);
				i=level.getDim_x();
				}
		
		
	}
	public int getVampOnBoard() {
		return vampsOnBoard;
	}
	public int getContCiclos() {

		return ciclos;
	}
	public void setContCiclos(int i) {
		this.ciclos =i;
		
	}

	public int getCoins() {
		return coins;
	}
	public int getReaminigVampires() {
		return remainingVampires;
	}

	public long getSeed() {
		return seed;
	}
	public Level getLevel() {
		return level;
	}
	public void setLost(boolean lost) {
		this.lost = lost;
	}
	private void updateVampsOnBoard() {
		this.vampsOnBoard = gameObjects.getVampireList().getContador();
	}
	private void updateGameObjectBoard() {
		 gameObjects.getVampireList().move(this);
		 gameObjects.getSlayerList().attack(this);
		 gameObjects.getVampireList().removeDead();
		 gameObjects.getVampireList().attack(this);
	}
	private void updatePlayer() {
		player.receiveCoins();
		this.coins=player.getCoins();
	}

}
