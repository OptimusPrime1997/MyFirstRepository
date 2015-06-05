package copy;

//����Ӧ�ó��򣬸�javaС����Ĵ���˼·���ǲ��ģ���ĸ�

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;

/**
 * ���������棬���Լ��ر�����ͼƬ�� ���غ����ͨ����������ͼƬ����������ꡣ
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
		setSize(800, 600);// ����Ҫ�������С
		setLocation(100, 100);
		setTitle("���ͼƬ�����������");
		setResizable(false);

		Container con = getContentPane();

		ImageIcon bgIcon = new ImageIcon("image/starter3.jpg");// ע��ͼƬ��·��
		ImagePanel backpicPanel = new ImagePanel(bgIcon);
		backpicPanel.addMouseListener(this);
		con.add(backpicPanel, BorderLayout.CENTER);

		tipLabel = new JLabel(
				"--------------------��ʾ���������δ�ӡ����Ļ��!--------------------");
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
 * ��ImagePanel��������ӱ���ͼƬ
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