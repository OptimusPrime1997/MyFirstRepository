package edu.nju.controller.msgqueue.operation;

import java.io.Serializable;

import edu.nju.main.JMineSweeper;
import edu.nju.network.Player;
import jdk.internal.dynalink.beans.StaticClass;

	
	public  abstract class  MineOperation implements Serializable{
		public Player player;
		public MineOperation() {
			// TODO Auto-generated constructor stub
				this.player=JMineSweeper.localPlayer;
		}
		public abstract  void execute();
		
	}

	

