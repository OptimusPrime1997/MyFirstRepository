import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// �ⲿ��ColorEventListener��ʵ��ActionListener�ӿ�

class ColorEventListener implements ActionListener {

	private EventListener4 el;

	ColorEventListener(EventListener4 el) {

		this.el = el;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Container c = el.getContentPane();

		c.setBackground(Color.BLUE);

	}

}