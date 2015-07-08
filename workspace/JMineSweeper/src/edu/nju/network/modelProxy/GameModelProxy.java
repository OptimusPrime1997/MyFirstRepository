package edu.nju.network.modelProxy;

import java.util.List;

import edu.nju.controller.msgqueue.operation.CustomGameOperation;
import edu.nju.controller.msgqueue.operation.DoubleClickOperation;
import edu.nju.controller.msgqueue.operation.HardGameOperation;
import edu.nju.controller.msgqueue.operation.HellGameOperation;
import edu.nju.controller.msgqueue.operation.LeftClickOperation;
import edu.nju.controller.msgqueue.operation.MineOperation;
import edu.nju.controller.msgqueue.operation.RightClickOperation;
import edu.nju.controller.msgqueue.operation.StartGameOperation;
import edu.nju.model.impl.GameLevel;
import edu.nju.model.service.GameModelService;
import edu.nju.model.state.GameResultState;
import edu.nju.network.Player;
import edu.nju.network.client.ClientService;

/**
 * GameModel的代理，在网络对战时替代Client端的相应Model。
 * 
 * @author 晨晖
 *
 */
public class GameModelProxy extends ModelProxy implements GameModelService {

	public GameModelProxy(ClientService client) {
		this.net = client;
	}

	@Override
	public boolean setGameLevel(String level) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gameOver(GameResultState result,Player player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<GameLevel> getGameLevel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setGameSize(int width, int height, int mineNum) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean leftClick(int x, int y) {
		MineOperation op = new LeftClickOperation(x, y);
		net.submitOperation(op);
		return true;
	}

	public boolean rightClick(int x, int y) {
		MineOperation op = new RightClickOperation(x, y);
		net.submitOperation(op);
		return true;
	}

	public boolean doubleClick(int x, int y) {
		MineOperation op = new DoubleClickOperation(x, y);
		net.submitOperation(op);
		return true;
	}

	@Override
	public boolean startGame() {
		// TODO Auto-generated method stub
		net.submitOperation(new StartGameOperation());
		return true;
	}

	public boolean setHardGameOperation() {
		net.submitOperation(new HardGameOperation());
		return true;
	}

	public boolean setHellGameOperation() {
		net.submitOperation(new HellGameOperation());
		return true;
	}

	public boolean setCustomGameOperation(int width,int height,int mineNum) {
		net.submitOperation(new CustomGameOperation(width,height,mineNum));
		return true;
	}
	

}
