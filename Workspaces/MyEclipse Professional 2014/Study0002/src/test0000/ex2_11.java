package test0000;
import javax.swing.JOptionPane;
public class ex2_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1,s2;
		int a,b,sum;
		s1=JOptionPane.showInputDialog("�����һ������");
		s2=JOptionPane.showInputDialog("����ڶ�������");
		a=Integer.parseInt(s1);
		b=Integer.parseInt(s2);
		sum=a+b;
		JOptionPane.showMessageDialog(null, "��������Ϊ"+sum,"���",JOptionPane.PLAIN_MESSAGE);
	}

}
