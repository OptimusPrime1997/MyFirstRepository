// �����֣�ͨ���ڲ��ദ��
//
//���ַ�����������������̵�˼�롣

import java.awt.Color;

import java.awt.Container;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JDialog;

import javax.swing.JFrame;

public class EventListener3 extends JFrame {

	private JButton btBlue, btDialog;

	// ���췽��

	public EventListener3() {

		// ���ñ���������

		setTitle("Java GUI �¼���������");

		// ���ó�ʼ������λ��

		setBounds(100, 100, 500, 350);

		// ���ô��ڲ���

		setLayout(new FlowLayout());

		// ������ť����

		btBlue = new JButton("��ɫ");

		// ����¼�����������(�������˼��)

		btBlue.addActionListener(new ColorEventListener());

		btDialog = new JButton("����");

		btDialog.addActionListener(new DialogEventListener());

		// �Ѱ�ť������ӵ�JFrame������

		add(btBlue);

		add(btDialog);

		// ���ô��ڿ��ӻ�

		setVisible(true);

		// ���ô��ڹر�

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	// �ڲ���ColorEventListener��ʵ��ActionListener�ӿ�

	class ColorEventListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			Container c = getContentPane();

			c.setBackground(Color.BLUE);

		}

	}

	// �ڲ���DialogEventListener��ʵ��ActionListener�ӿ�

	class DialogEventListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			// ����JDialog���ڶ���

			JDialog dialog = new JDialog();

			dialog.setBounds(300, 200, 400, 300);

			dialog.setVisible(true);

		}

	}

	// ***************************������***************************

	public static void main(String[] args) {

		new EventListener3();

	}

}
