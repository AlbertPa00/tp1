package org.ucm.tp1.p1.logic.newobjects;

import org.ucm.tp1.p1.logic.Game;
public class Slayer {
	
	private int x,y;
	private int life;
	public static final int cost=50 ;
	private Game game;
	private int resistance;
	private int frequency;
	private int harm;
	
	
	public Slayer(int x, int y,Game game) {
		this.x=x;
		this.y=y;
		this.life=20;
		this.resistance=3;
		this.frequency=1;
		this.harm=1;
		this.game=game;
		
	}
	

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getResistance() {
		return resistance;
	}

	public void setResistance(int resistance) {
		this.resistance = resistance;
	}
	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public int getHarm() {
		return harm;
	}

	public void setHarm(int harm) {
		this.harm = harm;
	}
	public Boolean isAlive() {
		return(life>0);
	}
	public void decreaseLife(int damage) {
	life=life-damage;	
	}
	
	public String toString() {
		String full;
		full="S ["+String.valueOf(life)+"]";
		return full;
	}
	
}
