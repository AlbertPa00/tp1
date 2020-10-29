package org.ucm.tp1.p1.logic.newobjects;

import java.util.Random; 

public class Player {
	
	private int coins;
	
	Random rand;
	
	public Player(Random rand) {
		coins=50;
		this.rand=rand;
	}
	
	public void wasteCoins(int coins) {
		this.coins=this.coins-coins;;
	}
	
	public void receiveCoins() {
		float t = rand.nextFloat();
		if(t>0.5)
			this.coins=this.coins+10;
	}
	
	public int getCoins() {
		return coins;
	}
	

}
