/*
 *
 TODO to start to program. this program are wrote base on MVC structure
 */
package edu.nju.main;

 
import java.util.Observable;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import edu.nju.controller.impl.MenuControllerImpl;
import edu.nju.controller.impl.SettingControllerImpl;
import edu.nju.controller.msgqueue.OperationQueue;
import edu.nju.controller.service.MenuControllerService;
import edu.nju.model.impl.ChessBoardModelImpl;
import edu.nju.model.impl.GameModelImpl;
import edu.nju.model.impl.ParameterModelImpl;
import edu.nju.model.impl.StatisticModelImpl;
import edu.nju.network.Player;
import edu.nju.view.MainFrame;
import edu.nju.view.MineBoardPanel;

public class JMineSweeper {
	private static SettingControllerImpl settingControllerImpl=new SettingControllerImpl();
	static MenuControllerService menuController = new MenuControllerImpl();
	private static GameModelImpl gameModel;
	private static MainFrame ui;
	private static ParameterModelImpl mineNumberModel;
	private static ChessBoardModelImpl mineBoardModel;
	public static Player localPlayer;

	public static void main(String[] args) {
		localPlayer=Player.HOST;
		
		ui = new MainFrame();
		StatisticModelImpl statisticModel = new StatisticModelImpl();
 		mineNumberModel = new ParameterModelImpl();
 		mineBoardModel = new ChessBoardModelImpl(mineNumberModel);
		gameModel = new GameModelImpl(statisticModel,mineBoardModel);		
 		
		gameModel.addObserver(ui);
 		mineNumberModel.addObserver(ui.getMineNumberLabel());
 		mineBoardModel.addObserver(ui.getMineBoard());
 		
 		OperationQueue operationQueue = new OperationQueue(mineBoardModel, gameModel);
 		Thread operationThread = new Thread(operationQueue);
 		operationThread.start();
 	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
 		menuController.startGame();
	}
	public  static SettingControllerImpl getSettingGameModelImpl() {
		return settingControllerImpl;
	}
	public  static GameModelImpl getGameModelImpl() {
		return gameModel;
	}
	public  static MainFrame getMainFrame() {
		return ui;
	}
	public static ParameterModelImpl getMineBoardModel() {
		// TODO Auto-generated method stub
		return mineNumberModel;
	}
	public static  ChessBoardModelImpl getMineNumberModel() {
		// TODO Auto-generated method stub
		return mineBoardModel;
	}
}

