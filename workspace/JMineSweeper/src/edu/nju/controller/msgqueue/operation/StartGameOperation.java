package edu.nju.controller.msgqueue.operation;

import edu.nju.controller.impl.SettingControllerImpl;
import edu.nju.controller.msgqueue.OperationQueue;
import edu.nju.controller.service.SettingControllerService;
import edu.nju.main.JMineSweeper;
import edu.nju.model.service.GameModelService;
import edu.nju.view.listener.MenuListener;

public class StartGameOperation extends MineOperation {
	

	@Override
	public void execute() {
			JMineSweeper.getSettingGameModelImpl().setEasyGameLevel();
	}

}
