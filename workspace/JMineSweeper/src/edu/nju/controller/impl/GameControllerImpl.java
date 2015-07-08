package edu.nju.controller.impl;
import edu.nju.controller.msgqueue.OperationQueue;
import edu.nju.controller.msgqueue.operation.DoubleClickOperation;
import edu.nju.controller.msgqueue.operation.LeftClickOperation;
import edu.nju.controller.msgqueue.operation.MineOperation;
import edu.nju.controller.msgqueue.operation.RightClickOperation;
import edu.nju.controller.service.GameControllerService;
import edu.nju.network.modelProxy.GameModelProxy;
public class GameControllerImpl implements GameControllerService{
	
	@Override
	public boolean handleLeftClick(int x, int y) {
		// TODO Auto-generated method stub
		MineOperation op1 = new LeftClickOperation(x,y);
		OperationQueue.addMineOperation(op1);
		if(ClientControllerImpl.getIsSetClient()==true){
			ClientControllerImpl.getGameModelProxy().leftClick(x, y);
		}
		return true;
	}

	@Override
	public boolean handleRightClick(int x, int y) {
		// TODO Auto-generated method stub
		MineOperation op2 = new RightClickOperation(x,y);
		OperationQueue.addMineOperation(op2);
		if(ClientControllerImpl.getIsSetClient()==true){
			ClientControllerImpl.getGameModelProxy().rightClick(x, y);
		}
		return true;
	}

	@Override
	public boolean handleDoubleClick(int x, int y) {
		// TODO Auto-generated method stub
		MineOperation op3 = new DoubleClickOperation(x,y);
		OperationQueue.addMineOperation(op3);
		if(ClientControllerImpl.getIsSetClient()==true){
			ClientControllerImpl.getGameModelProxy().doubleClick(x, y);
		}
		return true;
	}

}
