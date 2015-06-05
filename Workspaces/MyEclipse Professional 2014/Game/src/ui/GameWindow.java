package ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameWindow extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GameWindow tbc = new GameWindow();

		tbc.setVisible(true);

	}

	private JPanel imagePanel;
	// private JPanel panel=new JPanel();

	private ImageIcon background;

	public GameWindow() {
		background = new ImageIcon("image/starter2.jpg");// 背景图片
		JLabel label = new JLabel(background);// 把背景图片显示在一个标签里面
		// 把标签的大小位置设置为图片刚好填充整个面板

		label.setBounds(0, 0, background.getIconWidth(),
				background.getIconHeight());

		// 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明

		imagePanel = (JPanel) this.getContentPane();
		imagePanel.setLayout(null);

		imagePanel.setOpaque(false);

		// 内容窗格默认的布局管理器为BorderLayout

		// imagePanel.setLayout(new BorderLayout());
		// panel.setLayout(new BorderLayout());

		imagePanel.setSize(background.getIconWidth(),
				background.getIconHeight());
		imagePanel.setLocation(200, 0);

		// panel.setSize(250,250);
		// panel.setLocation(620,300);

		String[] names = { "Start   ", "Continue", "Exit   " };
		JLabel[] mylabel = new JLabel[3];

		Font bigFont = new Font("serif", Font.BOLD, 28);

		// button1.setFont(bigFont);
		// button2.setFont(bigFont);
		// button3.setFont(bigFont);

		for (int i = 0; i <= 2; i++) {

			mylabel[i] = new JLabel(names[i]);
			mylabel[i].setFont(bigFont);
			mylabel[i].setSize(120, 60);
			mylabel[i].setLocation(430, 200 + (i) * 40);
			mylabel[i].setVisible(true);
			imagePanel.add(mylabel[i]);
		}

		// panel.add(button2);
		// panel.add(button3);

		// imagePanel.add(panel);
		// panel.setVisible(true);

		// this.getLayeredPane().setLayout(null);

		// 把背景图片添加到分层窗格的最底层作为背景

		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setForeground(Color.GREEN);
		this.setSize(background.getIconWidth(), background.getIconHeight());
		this.setUndecorated(true);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
