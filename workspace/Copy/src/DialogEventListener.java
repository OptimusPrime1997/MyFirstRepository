import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

// 外部类DialogEventListener，实现ActionListener接口

class DialogEventListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		// 创建JDialog窗口对象

		JDialog dialog = new JDialog();

		dialog.setBounds(300, 200, 400, 300);

		dialog.setVisible(true);

	}

}