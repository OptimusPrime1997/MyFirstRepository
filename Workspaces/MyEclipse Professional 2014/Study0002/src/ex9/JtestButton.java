package ex9;
import javax.swing.*;
import java.awt.*;
import mypg.*;
public class JtestButton extends JApplet {
	JButton b1=new JButton("Ã·Ωª");
	JButton b2=new JButton("∏¥Œª");
	JTextField txt=new JTextField(16);
	public void init(){
		Container cp=getContainerPane();
		cp.setLayout(new FlowLayout());
		cp.add(b1);
		cp.add(b2);
		cp.add(txt);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Console.run(new JtestButton(),200,100);
	}

}
