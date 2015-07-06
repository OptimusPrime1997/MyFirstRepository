package edu.nju.controller.msgqueue.operation;

import edu.nju.controller.msgqueue.OperationQueue;
import edu.nju.model.service.GameModelService;

public class StartGameOperation extends MineOperation{

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		String tempString=edu.nju.view.listener.MenuListener.message;
		GameModelService game = OperationQueue.getGameModel();
		if(tempString.equals("easy")){
			game.setGameLevel("小");
		}else if(tempString.equals("hard")){
			game.setGameLevel("中");
		}else if(tempString.equals("hell")){
			game.setGameLevel("大");
		}else if(tempString.equals("custom")){
			int[] temp=new int[3];
			temp=edu.nju.view.CustomDialog.widHeiNum;
			game.setGameSize(temp[0], temp[1], temp[2]);
			game.setGameLevel("自定义");
			System.out.println("+++custom");
		}else{
			game.setGameLevel("小");
		}
		game.startGame();
	}

}
