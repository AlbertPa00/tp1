package org.ucm.tp1.p1.logic.lists;

import org.ucm.tp1.p1.logic.newobjects.Vampire;
import org.ucm.tp1.p1.logic.Game;

public class VampireList {
	
private Vampire[]VampireList;
private int contador;
	
public VampireList() {
	VampireList= new Vampire[50];
	this.contador=0;
}

public void add(Vampire s) {
	VampireList[contador]=s;
	contador++;
}
public void move(Game game) {
	for(int i=0;i<contador;i++) {
		int x=VampireList[i].getX();
		int y=VampireList[i].getY()-1;
		if(game.posIsEmpty(x, y))
			VampireList[i].avanza();
	}
}
public void attack(Game game) {
	for(int i=0;i<contador;i++) {
		if(isPositionEmpty(VampireList[i].getX(), VampireList[i].getY()-1))//Si en la siguiente posicion no hay vampiro
			if(!game.posIsEmpty(VampireList[i].getX(), VampireList[i].getY()-1))
				game.vampireAttacks(VampireList[i].getX(), VampireList[i].getY()-1, VampireList[i].getDamage());
			}
				
		
}
public Vampire getObjectInPosition(int x, int y) {
	Vampire Vamp = null;

	for(int i=0;i<contador;i++)
		if(VampireList[i].getX()==x && VampireList[i].getY()==y) {
			Vamp = VampireList[i];
			return Vamp;
			}

	return Vamp;
}
public boolean isPositionEmpty(int x, int y) {
	if(getObjectInPosition(x, y)==null)
		return true;
	return false;
}
public void removeDead() {
	for(int i=0;i<contador;i++)
		if(!VampireList[i].isAlive()) {
			deleteElementFromList(i);
			i--;
		}			
}
private void deleteElementFromList(int pos) {
contador--;
for(int i=pos;i<contador;i++) { 
	VampireList[i]=null;
	VampireList[i]=VampireList[i+1];
	}
}
public void addVampire(int x, int y,Game game) {
	VampireList[contador]=new Vampire(x,y,game);
	contador++;
}
public void decreaseLife(int x, int y, int damage) {
	getObjectInPosition(x, y).decreaseLife(damage);
}
public int getContador() {
	return contador;
}
}
