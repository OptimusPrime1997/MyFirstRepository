package protice;
import javax.swing.JOptionPane;
public class st2_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1,s2,s3,s4,s5,s6;
		double a,b,c,d,e,f,sum;
		s1=JOptionPane.showInputDialog("���������ɼ���0~100��");
		s2=JOptionPane.showInputDialog("������ɢ�ɼ���0~100��");
		s3=JOptionPane.showInputDialog("����ƻ��ɼ���0~100��");
		s4=JOptionPane.showInputDialog("����Ӣ��ɼ���0~100��");
		s5=JOptionPane.showInputDialog("����˼�޳ɼ���0~100��");
		s6=JOptionPane.showInputDialog("������ѧ�ɼ���0~100��");
		a=Double.parseDouble(s1);
		b=Double.parseDouble(s2);
		c=Double.parseDouble(s3);
		d=Double.parseDouble(s4);
		e=Double.parseDouble(s5);
		f=Double.parseDouble(s6);
		sum=(a*1+b*4+c*4+d*4+e*1+f*5)/20;
		JOptionPane.showMessageDialog(null, "����Ϊ"+sum);
	}

}
