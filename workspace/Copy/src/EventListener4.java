import java.awt.Color;

import java.awt.Container;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JDialog;

import javax.swing.JFrame;

public class EventListener4 extends JFrame {

	private JButton btBlue, btDialog;

	// 构造方法

	public EventListener4() {

		// 设置标题栏内容

		setTitle("Java GUI 事件监听处理");

		// 设置初始化窗口位置

		setBounds(100, 100, 500, 350);

		// 设置窗口布局

		setLayout(new FlowLayout());

		// 创建按钮对象

		btBlue = new JButton("蓝色");

		// 将按钮添加事件监听器

		btBlue.addActionListener(new ColorEventListener(this));

		// 创建按钮对象

		btDialog = new JButton("弹窗");

		// 将按钮添加事件监听器

		btDialog.addActionListener(new DialogEventListener());

		// 把按钮容器添加到JFrame容器上

		add(btBlue);

		add(btDialog);

		// 设置窗口可视化

		setVisible(true);

		// 设置窗口关闭

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	// ***************************主方法***************************

	public static void main(String[] args) {

		new EventListener4();

	}

}