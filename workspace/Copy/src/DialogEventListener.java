import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

// �ⲿ��DialogEventListener��ʵ��ActionListener�ӿ�

class DialogEventListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		// ����JDialog���ڶ���

		JDialog dialog = new JDialog();

		dialog.setBounds(300, 200, 400, 300);

		dialog.setVisible(true);

	}

}