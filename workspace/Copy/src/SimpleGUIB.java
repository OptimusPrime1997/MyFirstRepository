import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//SimpleGUIB����������ʵ�ֹ���
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
// ��ťlabel�����ı����֣�color�����ı�ͼ����ɫ����ÿ�ΰ���label��ť�����Ǹı����ouch����ͼ����ɫҲ����ˣ�������label��ťʵ��repaint�Ĺ��ܣ�����֣�����֪��Ϊʲôô
//
// ������
// 2013-11-24 00:17
// �����߲���
//
// ���ȣ���ʹ�õ��Ǳ߽粼��BorderLayout��
// ���ն����ϱ��С���̬������Ľ����ϵ�����������ı��˽����ϵ������С����ô������������׸��Ÿı䡣
// ��WEST��label��ǩ��������i'm a label��Ȼ������ť������Ouch!
// ���ֳ��ȷ�ʽ�˸ı䣬����������BorderLayout��WEST�����С���м������Զ���չ��
// ����չ��ϵͳ�Զ�����repaint()�ػ���档���Ծ͸ı����м�ԲȦ����ɫ��
//
// ���������ťi'm a label==����� i'm b label ��ô���ֳ��Ȳ��䣬�м�Ľ���Ͳ����ػ�