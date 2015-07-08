package edu.nju.controller.impl;

import javax.swing.JFrame;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import edu.nju.controller.msgqueue.OperationQueue;
import edu.nju.controller.msgqueue.operation.CustomGameOperation;
import edu.nju.controller.msgqueue.operation.HardGameOperation;
import edu.nju.controller.msgqueue.operation.HellGameOperation;
import edu.nju.controller.msgqueue.operation.StartGameOperation;
import edu.nju.controller.service.MenuControllerService;
import edu.nju.view.CustomDialog;
import edu.nju.view.MainFrame;
import edu.nju.view.RecordDialog;

public class MenuControllerImpl implements MenuControllerService {
	protected static String message;

	@Override
	public boolean startGame() {
		// TODO Auto-generated method stub
		OperationQueue.addMineOperation(new StartGameOperation());
		if(ClientControllerImpl.getIsSetClient()==true){
			ClientControllerImpl.getGameModelProxy().startGame();
		}
		return true;
	}

	public boolean setHardGame() {
		OperationQueue.addMineOperation(new HardGameOperation());
		if(ClientControllerImpl.getIsSetClient()==true){
			ClientControllerImpl.getGameModelProxy().setHardGameOperation();
		}
		return true;
	}

	public boolean setHellGame() {
		OperationQueue.addMineOperation(new HellGameOperation());
		if(ClientControllerImpl.getIsSetClient()==true){
			ClientControllerImpl.getGameModelProxy().setHellGameOperation();
		}
		return true;
	}

	public boolean setCustomGame(int width,int height,int mineNum) {
		OperationQueue.addMineOperation(new CustomGameOperation(width,height,mineNum));
		if(ClientControllerImpl.getIsSetClient()==true){
			ClientControllerImpl.getGameModelProxy().setCustomGameOperation(width, height, mineNum);
		}
		return true;
	}

	public boolean setRecordDialog() {
		JFrame jFrame = new JFrame();
		RecordDialog recordDialog = new RecordDialog(jFrame);
		return true;
	}

	public boolean setCustomDialog(MainFrame frame) {
		CustomDialog customDialog = new CustomDialog(frame);
		customDialog.show();
		return true;
	}

	
}
