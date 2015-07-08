package edu.nju.controller.impl;

import edu.nju.controller.msgqueue.OperationQueue;
import edu.nju.controller.msgqueue.operation.MineOperation;
import edu.nju.controller.service.SettingControllerService;
import edu.nju.model.service.GameModelService;

public class SettingControllerImpl implements SettingControllerService{
	@Override
	public boolean setEasyGameLevel() {
		// TODO Auto-generated method stub
		OperationQueue.getGameModel().setGameLevel("小");
		OperationQueue.getGameModel().startGame();
		return true;
	}

	@Override
	public boolean setHardGameLevel() {
		// TODO Auto-generated method stub
		OperationQueue.getGameModel().setGameLevel("中");
		OperationQueue.getGameModel().startGame();
		return true;
	}

	@Override
	public boolean setHellGameLevel() {
		// TODO Auto-generated method stub
		OperationQueue.getGameModel().setGameLevel("大");
		OperationQueue.getGameModel().startGame();
		return true;
	}

	@Override
	public boolean setCustomizedGameLevel(int width,int heigth,int mineNum) {
		// TODO Auto-generated method stub
		
		OperationQueue.getGameModel().setGameLevel("自定义");
		OperationQueue.getGameModel().setGameSize(width,heigth,mineNum);
		OperationQueue.getGameModel().startGame();
		return true;
	}

}
