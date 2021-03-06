/*
 *
 * TODO To manage menu action
 */
package edu.nju.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import edu.nju.controller.impl.ClientControllerImpl;
import edu.nju.controller.impl.HostControllerImpl;
import edu.nju.controller.impl.MenuControllerImpl;
import edu.nju.controller.impl.SettingControllerImpl;
import edu.nju.controller.service.ClientControllerService;
import edu.nju.controller.service.HostControllerService;
import edu.nju.controller.service.MenuControllerService;
import edu.nju.controller.service.SettingControllerService;
import edu.nju.view.CustomDialog;
import edu.nju.view.MainFrame;
import edu.nju.view.RecordDialog;
 

public class MenuListener implements ActionListener{

	private MainFrame ui;
	MenuControllerService menuController = new MenuControllerImpl();
	SettingControllerService settingController = new SettingControllerImpl();
	ClientControllerService clientController=new ClientControllerImpl();
	HostControllerService hostController=new HostControllerImpl();
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
			edu.nju.view.listener.CoreListener.suspendTimer();
			menuController.startGame();
		} else if (e.getSource() == ui.getMenuItem("easy")) {//生成简单游戏
			edu.nju.view.listener.CoreListener.suspendTimer();
			menuController.startGame();
		} else if (e.getSource() == ui.getMenuItem("hard")) {//生成中等游戏
			edu.nju.view.listener.CoreListener.suspendTimer();
			menuController.setHardGame();
		} else if (e.getSource() == ui.getMenuItem("hell")) {//生成大型游戏
			edu.nju.view.listener.CoreListener.suspendTimer();
			menuController.setHellGame();
		} else if (e.getSource() == ui.getMenuItem("custom")) {//生成定制游戏，需要向controller传递棋盘的高、宽和雷数
			edu.nju.view.listener.CoreListener.suspendTimer();
			menuController.setCustomDialog(ui);
		} else if (e.getSource() == ui.getMenuItem("exit")) {
			System.exit(0);
		} else if (e.getSource() == ui.getMenuItem("record")) {//统计胜率信息
			menuController.setRecordDialog();
		}else if(e.getSource() == ui.getMenuItem("host")){//注册成为主机
			hostController.servicesetupHost();
		}else if(e.getSource() == ui.getMenuItem("client")){//注册成为客户端
			
			clientController.setupClient("127.0.0.1");
		}
	}
	

	


}