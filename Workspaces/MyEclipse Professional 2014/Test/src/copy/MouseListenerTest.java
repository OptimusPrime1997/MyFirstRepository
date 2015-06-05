package copy;

//这是应用程序，跟java小程序的大体思路还是差不多的，你改改

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;

/**
 * 建立个界面，可以加载本机中图片。 加载后可以通过鼠标点击获得图片上任意点坐标。
 */
public class MouseListenerTest extends JFrame implements MouseListener {
	private JLabel tipLabel;

	/**
	 * main()
	 */
	public static void main(String[] args) {
		MouseListenerTest frame = new MouseListenerTest();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	/**
	 * constructor
	 */
	public MouseListenerTest() {
		setSize(800, 600);// 根据要求调整大小
		setLocation(100, 100);
		setTitle("获得图片上任意点坐标");
		setResizable(false);

		Container con = getContentPane();

		ImageIcon bgIcon = new ImageIcon("image/starter3.jpg");// 注意图片的路径
		ImagePanel backpicPanel = new ImagePanel(bgIcon);
		backpicPanel.addMouseListener(this);
		con.add(backpicPanel, BorderLayout.CENTER);

		tipLabel = new JLabel(
				"--------------------提示：坐标依次打印在屏幕上!--------------------");
		con.add(tipLabel, BorderLayout.NORTH);
	}

	/**
*
*/
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		String message = "(" + x + "," + y + ")";
		tipLabel.setText(message);
		System.out.println(message);

	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mouseClicked(MouseEvent e) {

	}

}

/**
 * 类ImagePanel，用于添加背景图片
 */
class ImagePanel extends JPanel {
	private Image img;

	public ImagePanel(ImageIcon imageIcon) {
		img = imageIcon.getImage();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, this);
	}

}