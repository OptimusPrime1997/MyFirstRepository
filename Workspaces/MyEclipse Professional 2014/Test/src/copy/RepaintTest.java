package copy;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

//��JPanel�л�ͼҪ��д
//public void paintComponent(Graphics g){
//        super.paintComponent(g);
//         ///
//}

//ֱ��д��paintComponent����Ĵ���ÿ�ζ��ửͼ
//
//�����ĵĻ�,Ӧ���ڻ�ͼ���������һЩ���ƴ���,�������ط��ı�һЩ������ֵ,Ȼ�����repaint();��������������
//
//����
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