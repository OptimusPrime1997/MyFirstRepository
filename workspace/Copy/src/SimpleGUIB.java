import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//SimpleGUIB类用来监听实现功能
public class SimpleGUIB {

	JFrame frame;
	JLabel label;

	public static void main(String[] args) {
		SimpleGUIB gui = new SimpleGUIB();
		gui.go();
	}

	public void go() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton lbutton = new JButton("change label");
		lbutton.addActionListener(new LabelListener());

		JButton cbutton = new JButton("change colors");
		cbutton.addActionListener(new ColorListener());

		label = new JLabel("i'm a label");
		MyDrawPanel dp = new MyDrawPanel();

		frame.getContentPane().add(BorderLayout.SOUTH, cbutton);
		frame.getContentPane().add(BorderLayout.CENTER, dp);
		frame.getContentPane().add(BorderLayout.WEST, label);
		frame.getContentPane().add(BorderLayout.EAST, lbutton);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	class LabelListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			label.setText("Ouch!");
		}
	}

	class ColorListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			frame.repaint();
		}
	}

}
// 按钮label用来改变文字，color用来改变图形颜色，可每次按了label按钮文字是改变成了ouch但是图形颜色也会变了，就像是label按钮实现repaint的功能，很奇怪，有人知道为什么么
//
// 分享到：
// 2013-11-24 00:17
// 提问者采纳
//
// 首先，你使用的是边界布局BorderLayout。
// 按照东西南北中。动态管理你的界面上的组件。如果你改变了界面上的组件大小，那么其他组件很容易跟着改变。
// 在WEST的label标签，文字是i'm a label，然后点击按钮后变成了Ouch!
// 文字长度方式了改变，进而让整个BorderLayout的WEST方向变小，中间的组件自动扩展。
// 在扩展后，系统自动调用repaint()重绘界面。所以就改变了中间圆圈的颜色。
//
// 如过你点击按钮i'm a label==》变成 i'm b label 那么文字长度不变，中间的界面就不会重绘