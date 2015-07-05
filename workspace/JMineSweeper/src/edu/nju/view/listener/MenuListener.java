/*
 *
 * TODO To manage menu action
 */
package edu.nju.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import edu.nju.controller.impl.MenuControllerImpl;
import edu.nju.controller.impl.SettingControllerImpl;
import edu.nju.controller.service.MenuControllerService;
import edu.nju.controller.service.SettingControllerService;
import edu.nju.view.CustomDialog;
import edu.nju.view.MainFrame;
import edu.nju.view.RecordDialog;
 

public class MenuListener implements ActionListener{
	public static String message="";
	private MainFrame ui;
	MenuControllerService menuController = new MenuControllerImpl();
	SettingControllerService settingController = new SettingControllerImpl();
	
	public MenuListener(MainFrame ui){
		this.ui = ui;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ui.getMenuItem("start")) {//生成游戏，默认生成简单游戏
			message="start";
			menuController.startGame();
		} else if (e.getSource() == ui.getMenuItem("easy")) {//生成简单游戏
			message="easy";
			menuController.startGame();
		} else if (e.getSource() == ui.getMenuItem("hard")) {//生成中等游戏
			message="hard";
			menuController.startGame();
		} else if (e.getSource() == ui.getMenuItem("hell")) {//生成大型游戏
			message="hell";
			menuController.startGame();
		} else if (e.getSource() == ui.getMenuItem("custom")) {//生成定制游戏，需要向controller传递棋盘的高、宽和雷数
			menuController.setCustomDialog(ui);
		} else if (e.getSource() == ui.getMenuItem("exit")) {
			System.exit(0);
		} else if (e.getSource() == ui.getMenuItem("record")) {//统计胜率信息
			menuController.setRecordDialog();
		}else if(e.getSource() == ui.getMenuItem("host")){//注册成为主机
			
		}else if(e.getSource() == ui.getMenuItem("client")){//注册成为客户端
			
		}
	}


}