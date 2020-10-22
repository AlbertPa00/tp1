package org.ucm.tp1.p1.logic;

import org.ucm.tp1.p1.logic.lists.*;

public class GameObjectBoard {
	private VampireList vampireList;
	private SlayerList slayerList;

	public GameObjectBoard() {
		vampireList = new VampireList();
		slayerList = new SlayerList();
	}

	public VampireList getVampireList() {
		return vampireList;
	}
	public void setVampireList(VampireList vampireList) {
		this.vampireList = vampireList;
	}
	public SlayerList getSlayerList() {
		return slayerList;
	}
	public void setSlayerList(SlayerList slayerList) {
		this.slayerList = slayerList;
	}
}
