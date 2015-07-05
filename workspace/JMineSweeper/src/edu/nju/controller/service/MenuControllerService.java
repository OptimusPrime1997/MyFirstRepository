package edu.nju.controller.service;

import edu.nju.view.MainFrame;

public interface MenuControllerService {
	/**
	 * 开始游戏
	 * @return
	 */
	public boolean startGame();
	
	public boolean setRecordDialog();

	public boolean setCustomDialog(MainFrame ui);
}
