package edu.nju.controller.impl;

import javax.swing.JFrame;

import edu.nju.controller.msgqueue.OperationQueue;
import edu.nju.controller.msgqueue.operation.StartGameOperation;
import edu.nju.controller.service.MenuControllerService;
import edu.nju.view.RecordDialog;

public class MenuControllerImpl implements MenuControllerService{
	private JFrame jFrame;
	@Override
	public boolean startGame() {
		// TODO Auto-generated method stub
		OperationQueue.addMineOperation(new StartGameOperation());
		return true;
	}
	public boolean setRecordDialog(){
		jFrame=new JFrame();
		RecordDialog recordDialog=new RecordDialog(jFrame);
		return true;
	}

}
