/**
 *注意用于CardLayout的Add()方法,必须用标注将卡片名和卡片本身伟到布局管理器中.然后就可以用卡片名代替
 *索引号去引用卡片.. 这是并没有 setLayout(new CardLayout()); 而是创建了一个CardLayout对象 这里需要实际引用
 *这个对象,需要一个变量来保持对它的引用
 *理解一下  自己多写几个 布局方面的程序就OK咯!! 光看不写 过几天又忘没了
 */

import java.awt.*;
import java.awt.event.*;

class ShowFrame implements ActionListener {
	private Frame frame = new Frame();
	private Button btn1 = new Button("OK");
	private Button btn2 = new Button("Cancel");
	private CardLayout layout;

	ShowFrame(String s) {
		init(s);
	}

	void init(String s) {
		layout = new CardLayout();
		frame.setTitle(s);
		frame.setBackground(Color.black);
		frame.setSize(640, 480);
		frame.setLocation(50, 50);
		frame.setLayout(layout);

		btn1.addActionListener(this);
		btn2.addActionListener(this);
		frame.add(btn1, "one");
		frame.add(btn2, "two");

		// frame.addWindowListener(new FrameListener());
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});// 匿名内部类

		frame.setVisible(true);
	}// end init

	public void actionPerformed(ActionEvent e) {
		layout.next(frame);
	}

}// end of ShowFrame

class FrameListener extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}// end of FrameListener

public class CardLayoutTest3 {
	public static void main(String[] args) {
		ShowFrame sf = new ShowFrame("我的窗口!");
	}
}// end of FrameDemo