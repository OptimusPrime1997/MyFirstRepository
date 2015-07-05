package edu.nju.controller.impl;

import javax.swing.JFrame;

import edu.nju.controller.msgqueue.OperationQueue;
import edu.nju.controller.msgqueue.operation.StartGameOperation;
import edu.nju.controller.service.MenuControllerService;
import edu.nju.view.CustomDialog;
import edu.nju.view.MainFrame;
import edu.nju.view.RecordDialog;

public class MenuControllerImpl implements MenuControllerService{
	protected static String message;
	
	@Override
	public boolean startGame() {
		// TODO Auto-generated method stub
		OperationQueue.addMineOperation(new StartGameOperation());
		return true;
	}
	public boolean setRecordDialog(){
		JFrame jFrame=new JFrame();
		RecordDialog recordDialog=new RecordDialog(jFrame);
		return true;
	}
	public boolean setCustomDialog(MainFrame frame){
		CustomDialog customDialog=new CustomDialog(frame);
		customDialog.show();
		return true;
	}

}
