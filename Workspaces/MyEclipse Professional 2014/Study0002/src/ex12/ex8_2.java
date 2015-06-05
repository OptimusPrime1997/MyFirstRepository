package ex12;
import java.awt.*;
public class ex8_2 extends java.applet.Applet {
	StringBuffer buf=new StringBuffer();
	public void disp(String st){
		buf.append(st);
		System.out.println(st);
		repaint();
	}
	public void init(){
		resize(300,20);
		disp("[init]---Applet将要启动");
	}
	public void start(){
		disp("[start]---Applet启动");
	}
	public void stop(){
		disp("[stop]---Applet程序终止");
	}
	public void destroy(){
		disp("[destroy]---Applet退出");
	}
	public void paint(Graphics g){
		g.drawRect(0,0,300-1,20-1);
		g.drawString(buf.toString(), 5, 15);
	}

}
