package test0000;
import javax.swing.JOptionPane;
public class ex2_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1,s2;
		int a,b,sum;
		s1=JOptionPane.showInputDialog("输入第一个整数");
		s2=JOptionPane.showInputDialog("输入第二个整数");
		a=Integer.parseInt(s1);
		b=Integer.parseInt(s2);
		sum=a+b;
		JOptionPane.showMessageDialog(null, "两整数和为"+sum,"求和",JOptionPane.PLAIN_MESSAGE);
	}

}
