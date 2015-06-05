package courseinput;

//问题是键盘事件和actionevent不能相互监听，还有快捷键怎样输入？例如backspace
import javax.swing.*; //开展的GUI工具包
import java.math.*;
import java.awt.*;
import java.awt.event.*;
//计算器类，只响应鼠标点击按钮时间
public class Calculator1 implements ActionListener,KeyListener{
//逻辑变量标志是输入的是否首位数，false标志首位
private boolean append = false;
JTextField jtf = new JTextField(10);//这里的10表示什么？？？？？？？？？？？？？
//计算器显示框
private String operator; //保存运算符
private String op1;
Label lb=new Label();
String s ;
//保存运算操作数1
//中断响应方法（接口中的虚方法actionPerformed）
public void actionPerformed(ActionEvent ae){

//点击的按钮名称记录在comm变量
String comm = ae.getActionCommand();

//判断点击了什么按钮
if("0123456789".indexOf(comm)!=-1){ //indexOf(String str) 
// 返回指定子字符串在此字符串中第一次出现处的索引
//点击了数字键
if(append){ //不是首位数
//计算器显示框连接显示
String temp = jtf.getText();
jtf.setText(temp+comm);
}else{ //是首位数
jtf.setText(comm);
append = true; //置非首位数标志
}
}else if("+-*/".indexOf(comm)!=-1){
//点击了+-*/运算符
op1 = jtf.getText(); //保存运算操作数
operator = comm; //保存运算符
append = false; //置首位数标志
}else if("=".equals(comm)){ //点击了=运算符
String op2 = jtf.getText(); //保存运算操作数2
BigDecimal d1 = new BigDecimal(op1);
//字符串到到大实数
BigDecimal d2 = new BigDecimal(op2);
if("+".equals(operator)){
d1 = d1.add(d2); //大实数类的成员方法
}else if("-".equals(operator)){
d1 = d1.subtract(d2);
}else if("*".equals(operator)){
d1 = d1.multiply(d2);
}else{
d1 = d1.divide(
d2,10,BigDecimal.ROUND_HALF_UP);
}
jtf.setText(d1.toString()); //显示结果
append = false; //本次运算结束，置首位数标志
}else if(".".equals(comm)){ //点击了小数点键
String temp = jtf.getText();
if(temp.indexOf(comm)==-1){
jtf.setText(temp+"."); //串连接
append = true; //置非首位数标志
}
}else if("+/-".equals(comm)){ //点击了符号求反键
String temp = jtf.getText();
if(temp.startsWith("-")){
jtf.setText(temp.substring(1));
}else{
jtf.setText("-"+temp);
}
}else if("Back".equals(comm)){
//点击了Back键
String temp = jtf.getText();
if(temp.length()>0){ //删除最后一位
jtf.setText(
temp.substring(0,temp.length()-1));
}
}else if("CE".equals(comm)|| "C".equals(comm)
){
jtf.setText("0"); //CE键清零
append = false;
}
}
//构造方法定义界面
public Calculator1(){
JFrame jf = new JFrame("算数计算器"); //窗口
JPanel jp = new JPanel();//面板
//字符串数组:定义按钮名称
String[] lab = {"Back","CE","C","+","7",
"8","9","-","4","5","6","*","1","2",
"3","/","0",".","+/-","="};
jp.setLayout(new GridLayout(5,4));
//面板布局
jtf.setEditable(false); //计算器显示框不能输入
//按钮组件按数组生成
JButton[] jb = new JButton[lab.length]; 
jf.add(jtf,BorderLayout.NORTH);
//计算器显示框钉上窗口
for(int i=0;i<jb.length;i++){
jb[i] = new JButton(lab[i]);
jp.add(jb[i]); //按钮组件逐一钉上面板
jb[i].addActionListener(this);
}
jf.add(jp);//面板钉上窗口
jf.setSize(300, 200); //设置窗口属性
jf.setLocation(350, 250);
jf.setResizable(false);
jf.setVisible(true);
jtf.addKeyListener(this);
///设置窗口属性：可关闭性
jf.setDefaultCloseOperation(
JFrame.EXIT_ON_CLOSE);
}
//main方法，定义本类的对象，激活构造方法
public static void main(String[] args) {
new Calculator1();
}

public void keyPressed(KeyEvent e) {
char c = e.getKeyChar();
s=String.valueOf(c);
if("0123456789".indexOf(s)!=-1){ //indexOf(String str) 
// 返回指定子字符串在此字符串中第一次出现处的索引
//点击了数字键
if(append){ //不是首位数
//计算器显示框连接显示
String temp = jtf.getText();
jtf.setText(temp+s);
}else{ //是首位数
jtf.setText(s);
append = true; //置非首位数标志
}
}else if("+-*/".indexOf(s)!=-1){
//点击了+-*/运算符
op1 = jtf.getText(); //保存运算操作数
operator = s; //保存运算符
append = false; //置首位数标志
}else if("=".equals(s)){ //点击了=运算符
String op2 = jtf.getText(); //保存运算操作数2
BigDecimal d1 = new BigDecimal(op1);
//字符串到到大实数
BigDecimal d2 = new BigDecimal(op2);
if("+".equals(operator)){
d1 = d1.add(d2); //大实数类的成员方法
}else if("-".equals(operator)){
d1 = d1.subtract(d2);
}else if("*".equals(operator)){
d1 = d1.multiply(d2);
}else{
d1 = d1.divide(
d2,10,BigDecimal.ROUND_HALF_UP);
}
jtf.setText(d1.toString()); //显示结果
append = false; //本次运算结束，置首位数标志
}else if(".".equals(s)){ //点击了小数点键
String temp = jtf.getText();
if(temp.indexOf(s)==-1){
jtf.setText(temp+"."); //串连接
append = true; //置非首位数标志
}
}else if("+/-".equals(s)){ //点击了符号求反键
String temp = jtf.getText();
if(temp.startsWith("-")){
jtf.setText(temp.substring(1));
}else{
jtf.setText("-"+temp);
}
}else if("b".equals(s)){
//点击了Back键
String temp = jtf.getText();
if(temp.length()>0){ //删除最后一位
jtf.setText(
temp.substring(0,temp.length()-1));
}
}else if("c".equals(s)){
jtf.setText("0");//CE键清零
append = false;

}



}

public void keyReleased(KeyEvent arg0) {}

public void keyTyped(KeyEvent arg0) {}
} 
