package copy;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

//在JPanel中画图要重写
//public void paintComponent(Graphics g){
//        super.paintComponent(g);
//         ///
//}

//直接写到paintComponent里面的代码每次都会画图
//
//如果想改的话,应该在画图方法里面加一些控制代码,在其他地方改变一些变量的值,然后调用repaint();这才是正规的做法
//
//比如
public class RepaintTest extends JPanel{
        private Color color=Color.black;
        private boolean show=true;
                public void paintComponent(Graphics g){
                        super.paintComponent(g);
                        if(show){
                                g.setColor(color);
                                g.fillOval(0, 0,20, 20);
                        }
                }

public void setOvalColor(Color c){
                        color=c;
                        repaint();
                }

public void setOvalVivible(boolean v){
                        show=v;
                        repaint();
                }

}