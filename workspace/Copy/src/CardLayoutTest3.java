/**
 *ע������CardLayout��Add()����,�����ñ�ע����Ƭ���Ϳ�Ƭ����ΰ�����ֹ�������.Ȼ��Ϳ����ÿ�Ƭ������
 *������ȥ���ÿ�Ƭ.. ���ǲ�û�� setLayout(new CardLayout()); ���Ǵ�����һ��CardLayout���� ������Ҫʵ������
 *�������,��Ҫһ�����������ֶ���������
 *���һ��  �Լ���д���� ���ַ���ĳ����OK��!! �⿴��д ����������û��
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
		});// �����ڲ���

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
		ShowFrame sf = new ShowFrame("�ҵĴ���!");
	}
}// end of FrameDemo