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

	// ���췽��

	public EventListener4() {

		// ���ñ���������

		setTitle("Java GUI �¼���������");

		// ���ó�ʼ������λ��

		setBounds(100, 100, 500, 350);

		// ���ô��ڲ���

		setLayout(new FlowLayout());

		// ������ť����

		btBlue = new JButton("��ɫ");

		// ����ť����¼�������

		btBlue.addActionListener(new ColorEventListener(this));

		// ������ť����

		btDialog = new JButton("����");

		// ����ť����¼�������

		btDialog.addActionListener(new DialogEventListener());

		// �Ѱ�ť������ӵ�JFrame������

		add(btBlue);

		add(btDialog);

		// ���ô��ڿ��ӻ�

		setVisible(true);

		// ���ô��ڹر�

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	// ***************************������***************************

	public static void main(String[] args) {

		new EventListener4();

	}

}