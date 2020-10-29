package org.ucm.tp1.p1.logic.lists;
import org.ucm.tp1.p1.logic.newobjects.Slayer;
import org.ucm.tp1.p1.logic.Game;
public class SlayerList {
	private Slayer[]slayerList;
	private int contador;
	
	public SlayerList() {
		slayerList= new Slayer[50];
		this.contador=0;
	}
	 
	public void add(int x,int y,Game game) {
		Slayer sla=new Slayer(x,y,game);
		slayerList[contador]=sla;
		contador++;
	}
	public void attack(Game game) {
			for(int i=0;i<contador;i++){
				for(int w=0;w<slayerList[i].getFrequency();w++) 					
					game.slayerAttacks(slayerList[i].getX(),slayerList[i].getY(), slayerList[i].getHarm());
			
		} 
	}
	public Slayer getObjectInPosition(int x, int y) {
		Slayer sla=null;
		for(int i=0;i<contador;i++)
			if(slayerList[i].getX()==x && slayerList[i].getY()==y) {
				sla=slayerList[i];
				return sla;
				}
		return sla;
	}
	public boolean isPositionEmpty(int x, int y) {
		if(getObjectInPosition(x, y)==null)
			return true;
		return false;
	}
	public void removeDead() {
		for(int i=0;i<contador;i++)
			if(!slayerList[i].isAlive()) {
				deleteElementFromList(i);
				i--;
			}			
	}
	private void deleteElementFromList(int pos) {
	contador--;
	for(int i=pos;i<contador;i++)
		slayerList[i]=slayerList[i+1];
	}
	public void decreaseLife(int x, int y, int damage) {
		getObjectInPosition(x, y).decreaseLife(damage);
	}
	

}
