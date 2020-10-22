package org.ucm.tp1.p1.logic.newobjects;

import org.ucm.tp1.p1.logic.Game;
import java.util.Random; 

public class Vampire {
	private int x,y;
	private int life;
	private Game game;
	private int damage;
	private int nextStep;
	public static final int SPEED=2;
	private int ciclosAlive;
	Random rand;
	
	public Vampire(int x, int y,Game game) {
		this.x=x;
		this.y=y;
		this.life=5;
		this.damage=1;
		this.nextStep=y-1;
		this.game=game;
		this.ciclosAlive = 0;
		
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
	public int getNextStep() {
		return nextStep;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int Damage) {
		this.damage = Damage;
	}
	public Boolean isAlive() {
		return(life>0);
	}
	public void decreaseLife(int damage) {
	life=life-damage;	
	}
	public void avanza() {
		ciclosAlive++;
		if(ciclosAlive%SPEED==0) {
		this.y=nextStep;
		nextStep--;
		}
	}
	public String toString() {
		String full;
		full="V ["+String.valueOf(life)+"]";
		return full;
	}
}
