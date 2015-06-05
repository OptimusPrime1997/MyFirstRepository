package practice;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;

public class Calculator implements ActionListener,KeyListener {
	private boolean append=false;
	JTextField jtf=new JTextField(10);
	private String operator;
	private String oper1;
	Label lb=new Label();
	String s;
	
	

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		String comm=ae.getActionCommand();
		if("0123456789".indexOf(comm)!=-1){
			if(append){
				String temp=jtf.getText();
				jtf.setText(temp+comm);
			}else{
				jtf.setText(comm);
				append=true;
			}
		}else if("+-*/".indexOf(comm)!=-1){
			oper1=jtf.getText();
			append=false;
			comm=jtf.getText();
		}else if("=".equals(comm)){
			String oper2=jtf.getText();
			BigDecimal d1=new BigDecimal(comm);
			BigDecimal d2=new BigDecimal(comm);
			if("+".equals(comm)){
				d1=d1.add(d2);
			}else if("-".equals(comm)){
				d1=d1.subtract(d2);
			}else if("*".equals(comm)){
				d1=d1.multiply(d2);
			}else if("/".equals(comm)){
				d1=d1.divide(d2,10, BigDecimal.ROUND_HALF_UP);
			}
			jtf.setText(d1.toString());
			append=false;
		}else if(".".equals(comm)){
			String temp=jtf.getText();
			if(temp.indexOf(comm)==-1){
				jtf.setText(temp+".");
				append=true;
			}
		}else if("+/-".equals(comm)){
			String temp=jtf.getText();
			if(temp.startsWith("-")){
				temp.substring(1);
				jtf.setText(temp);
			}else{
				jtf.setText("-"+temp);
			}
		}else if("Back".equals(comm)){
			String temp=jtf.getText();
			if(temp.length()>0){
				temp.substring(0,temp.length()-1);
				jtf.setText(temp);
			}
		}else if("CE".equals(comm)||"C".equals(comm)){
			jtf.setText("0");
		}
	}
	public Calculator(){
		JFrame jf=new JFrame();
		JPanel jp=new JPanel();
		String lab[]={"Back","CE","C","+","7","8","9","-","4","5","6","*","1","2","3","/","+/-","0",".","="};
		jp.setLayout(new GridLayout(5,4));
		jtf.setEditable(false);
		JButton jb[]=new JButton[lab.length];
		jf.add(jtf,BorderLayout.NORTH);
		for(int i=0;i<jb.length;i++){
			jb[i]=new JButton(lab[i]);
			jp.add(jb[i]);
			jb[i].addActionListener(this);
		}
		jf.add(jp);
		jf.addKeyListener(this);
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setSize(300,200);
		jf.setLocation(400,400);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[]){
		new Calculator();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char c=e.getKeyChar();
		s=String.valueOf(c);
		if("0123456789".indexOf(s)!=-1){
			if(append){
				String temp=jtf.getText();
				jtf.setText(temp+s);
			}else{
				jtf.setText(s);
				append=true;
			}
		}else if("+-*/".indexOf(s)!=-1){
			oper1=jtf.getText();
			operator=s;
			append=false;
			s=jtf.getText();
		}else if("=".equals(s)){
			String oper2=jtf.getText();
			BigDecimal d1=new BigDecimal(oper1);
			BigDecimal d2=new BigDecimal(oper2);
			if("+".equals(operator)){
				d1=d1.add(d2);
			}else if("-".equals(operator)){
				d1=d1.subtract(d2);
			}else if("*".equals(operator)){
				d1=d1.multiply(d2);
			}else if("/".equals(operator)){
				d1=d1.divide(d2,10, BigDecimal.ROUND_HALF_UP);
			}
			jtf.setText(d1.toString());
			append=false;
		}else if(".".equals(s)){
			String temp=jtf.getText();
			if(temp.indexOf(s)==-1){
				jtf.setText(temp+".");
				append=true;
			}
		}else if("+/-".equals(s)){
			String temp=jtf.getText();
			if(temp.startsWith("-")){
				temp.substring(1);
				jtf.setText(temp);
			}else{
				jtf.setText("-"+temp);
			}
		}else if("b".equals(s)){
			String temp=jtf.getText();
			if(temp.length()>0){
				temp.substring(0,temp.length()-1);
				jtf.setText(temp);
			}
		}else if("c".equals(s)){
			jtf.setText("0");
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
