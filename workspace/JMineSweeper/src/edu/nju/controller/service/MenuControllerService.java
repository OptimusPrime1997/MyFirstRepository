package edu.nju.controller.service;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import edu.nju.view.MainFrame;

public interface MenuControllerService {
	/**
	 * 开始游戏
	 * @return
	 */
	public boolean startGame();
	
	public boolean setHardGame();
	
	public boolean setHellGame();
	
	public boolean setCustomGame(int width,int heigth,int mineNum);
	
	public boolean setRecordDialog();

	public boolean setCustomDialog(MainFrame ui);
}	
