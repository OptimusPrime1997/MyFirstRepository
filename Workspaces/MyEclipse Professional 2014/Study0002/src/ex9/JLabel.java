package ex9;
import javax.swing.*;
import java.awt.*;
public class JLabel extends JApplet{
	public void init(){
		getContentPane().add(new JLabel("ª∂”≠ π”√Java Swing!"));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JApplet Applet=new JLabel1();
		JFrame frame=new JFrame("Applet/application");
		frame.getContentPane().add(Applet);
		frame.setSize(260,80);
		Applet.init();
		Applet.start();
		frame.setVisible(true);
	}

}
