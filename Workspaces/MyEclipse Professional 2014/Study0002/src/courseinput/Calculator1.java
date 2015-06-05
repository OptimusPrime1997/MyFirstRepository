package courseinput;

//�����Ǽ����¼���actionevent�����໥���������п�ݼ��������룿����backspace
import javax.swing.*; //��չ��GUI���߰�
import java.math.*;
import java.awt.*;
import java.awt.event.*;
//�������ֻ࣬��Ӧ�������ťʱ��
public class Calculator1 implements ActionListener,KeyListener{
//�߼�������־��������Ƿ���λ����false��־��λ
private boolean append = false;
JTextField jtf = new JTextField(10);//�����10��ʾʲô��������������������������
//��������ʾ��
private String operator; //���������
private String op1;
Label lb=new Label();
String s ;
//�������������1
//�ж���Ӧ�������ӿ��е��鷽��actionPerformed��
public void actionPerformed(ActionEvent ae){

//����İ�ť���Ƽ�¼��comm����
String comm = ae.getActionCommand();

//�жϵ����ʲô��ť
if("0123456789".indexOf(comm)!=-1){ //indexOf(String str) 
// ����ָ�����ַ����ڴ��ַ����е�һ�γ��ִ�������
//��������ּ�
if(append){ //������λ��
//��������ʾ��������ʾ
String temp = jtf.getText();
jtf.setText(temp+comm);
}else{ //����λ��
jtf.setText(comm);
append = true; //�÷���λ����־
}
}else if("+-*/".indexOf(comm)!=-1){
//�����+-*/�����
op1 = jtf.getText(); //�������������
operator = comm; //���������
append = false; //����λ����־
}else if("=".equals(comm)){ //�����=�����
String op2 = jtf.getText(); //�������������2
BigDecimal d1 = new BigDecimal(op1);
//�ַ���������ʵ��
BigDecimal d2 = new BigDecimal(op2);
if("+".equals(operator)){
d1 = d1.add(d2); //��ʵ����ĳ�Ա����
}else if("-".equals(operator)){
d1 = d1.subtract(d2);
}else if("*".equals(operator)){
d1 = d1.multiply(d2);
}else{
d1 = d1.divide(
d2,10,BigDecimal.ROUND_HALF_UP);
}
jtf.setText(d1.toString()); //��ʾ���
append = false; //�����������������λ����־
}else if(".".equals(comm)){ //�����С�����
String temp = jtf.getText();
if(temp.indexOf(comm)==-1){
jtf.setText(temp+"."); //������
append = true; //�÷���λ����־
}
}else if("+/-".equals(comm)){ //����˷����󷴼�
String temp = jtf.getText();
if(temp.startsWith("-")){
jtf.setText(temp.substring(1));
}else{
jtf.setText("-"+temp);
}
}else if("Back".equals(comm)){
//�����Back��
String temp = jtf.getText();
if(temp.length()>0){ //ɾ�����һλ
jtf.setText(
temp.substring(0,temp.length()-1));
}
}else if("CE".equals(comm)|| "C".equals(comm)
){
jtf.setText("0"); //CE������
append = false;
}
}
//���췽���������
public Calculator1(){
JFrame jf = new JFrame("����������"); //����
JPanel jp = new JPanel();//���
//�ַ�������:���尴ť����
String[] lab = {"Back","CE","C","+","7",
"8","9","-","4","5","6","*","1","2",
"3","/","0",".","+/-","="};
jp.setLayout(new GridLayout(5,4));
//��岼��
jtf.setEditable(false); //��������ʾ��������
//��ť�������������
JButton[] jb = new JButton[lab.length]; 
jf.add(jtf,BorderLayout.NORTH);
//��������ʾ���ϴ���
for(int i=0;i<jb.length;i++){
jb[i] = new JButton(lab[i]);
jp.add(jb[i]); //��ť�����һ�������
jb[i].addActionListener(this);
}
jf.add(jp);//��嶤�ϴ���
jf.setSize(300, 200); //���ô�������
jf.setLocation(350, 250);
jf.setResizable(false);
jf.setVisible(true);
jtf.addKeyListener(this);
///���ô������ԣ��ɹر���
jf.setDefaultCloseOperation(
JFrame.EXIT_ON_CLOSE);
}
//main���������屾��Ķ��󣬼���췽��
public static void main(String[] args) {
new Calculator1();
}

public void keyPressed(KeyEvent e) {
char c = e.getKeyChar();
s=String.valueOf(c);
if("0123456789".indexOf(s)!=-1){ //indexOf(String str) 
// ����ָ�����ַ����ڴ��ַ����е�һ�γ��ִ�������
//��������ּ�
if(append){ //������λ��
//��������ʾ��������ʾ
String temp = jtf.getText();
jtf.setText(temp+s);
}else{ //����λ��
jtf.setText(s);
append = true; //�÷���λ����־
}
}else if("+-*/".indexOf(s)!=-1){
//�����+-*/�����
op1 = jtf.getText(); //�������������
operator = s; //���������
append = false; //����λ����־
}else if("=".equals(s)){ //�����=�����
String op2 = jtf.getText(); //�������������2
BigDecimal d1 = new BigDecimal(op1);
//�ַ���������ʵ��
BigDecimal d2 = new BigDecimal(op2);
if("+".equals(operator)){
d1 = d1.add(d2); //��ʵ����ĳ�Ա����
}else if("-".equals(operator)){
d1 = d1.subtract(d2);
}else if("*".equals(operator)){
d1 = d1.multiply(d2);
}else{
d1 = d1.divide(
d2,10,BigDecimal.ROUND_HALF_UP);
}
jtf.setText(d1.toString()); //��ʾ���
append = false; //�����������������λ����־
}else if(".".equals(s)){ //�����С�����
String temp = jtf.getText();
if(temp.indexOf(s)==-1){
jtf.setText(temp+"."); //������
append = true; //�÷���λ����־
}
}else if("+/-".equals(s)){ //����˷����󷴼�
String temp = jtf.getText();
if(temp.startsWith("-")){
jtf.setText(temp.substring(1));
}else{
jtf.setText("-"+temp);
}
}else if("b".equals(s)){
//�����Back��
String temp = jtf.getText();
if(temp.length()>0){ //ɾ�����һλ
jtf.setText(
temp.substring(0,temp.length()-1));
}
}else if("c".equals(s)){
jtf.setText("0");//CE������
append = false;

}



}

public void keyReleased(KeyEvent arg0) {}

public void keyTyped(KeyEvent arg0) {}
} 
