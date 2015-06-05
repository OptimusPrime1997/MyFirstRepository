
//����һ���裺
//
//��1��      ����ʹ�ÿ�Ƭ���ֵ�����
//
//���磺Panel cardPanel=new Panel();
//
//��2��      ���忨Ƭ����CardLayout ���ֶ�������=new CardLayout();
//
//���磺CardLayout card=new CardLayout();
//
//��3��      ����ʹ�ÿ�Ƭ���ֵ�����Ϊ��Ƭ���֣�
//
//��ʽ����������.setLayout(���ֶ�������);
//
//���磺cardPanel.setLayout(card);
//
//��4��      ������������ʾ�����
//
//���磺for (int i = 0; i < 5; i++) {
//
//                            cardPanel.add(newJButton("��ť"+i));
//
//                   }
//
//��5��      ������Ӧ�¼����룬��������ʾ��Ӧ�����
//
//��ʽ��
//
//n  ���ֶ�������.next(��������)   ��ʾ�����е�ǰ���֮���һ�����������ǰ���Ϊ�����ӵ����������ʾ��һ�����������Ƭ�����ʾ��ѭ���ġ�
//
//n  ���ֶ�������.first(��������)   ��ʾ�����е�һ�����
//
//n  ���ֶ�������.last(��������)   ��ʾ���������һ�����
//
//n  ���ֶ�������.previous(��������)   ��ʾ�����е�ǰ���֮ǰ��һ�����������ǰ���Ϊ��һ����ӵ����������ʾ���һ�����������Ƭ�����ʾ��ѭ���ġ�
//
// 
//
//���磺
//
//card.next(cardPanel);
//
//card.previous(cardPanel);
//
//         card.first(cardPanel);      
//
//         card.last(cardPanel);      
//
// 
//
//ʵ��һ����Ƭ���л�
//
//����Ĭ�ϱ߽粼�֣�һ������Կ�Ƭ���֣��������������ť���������ӵ�CENTERλ�ã���һ��������������ť��������ť����¼����л���ʾCENTERλ���е��������

 

// cardlayout.java

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;//�����¼���

 

//������ʱʵ�ּ����ӿ�

public class CardLayoutTest1 extends JFrame implements ActionListener{

         JButton nextbutton;

         JButton preButton;

    Panel cardPanel=new Panel();

    Panel controlpaPanel=new Panel();

         //���忨Ƭ���ֶ���

    CardLayout card=new CardLayout();

         //���幹�캯��

         public CardLayoutTest1() {

                   super("��Ƭ���ֹ�����");

                   setSize(300, 200);

                   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                   setLocationRelativeTo(null);

                   setVisible(true);

 

                   //����cardPanel������Ϊ��Ƭ����

                   cardPanel.setLayout(card);    

 

                   //ѭ������cardPanel����������������ť

                   //��ΪcardPanel������Ϊ��Ƭ���֣����ֻ��ʾ������ӵ����

                   for (int i = 0; i < 5; i++) {

                            cardPanel.add(new JButton("��ť"+i));

                   }

                   //ʵ������ť����

                   nextbutton=new JButton("��һ�ſ�Ƭ");

                   preButton=new JButton("��һ�ſ�Ƭ");

 

                   //Ϊ��ť����ע�������

                   nextbutton.addActionListener(this);

                   preButton.addActionListener(this);

 

                   controlpaPanel.add(preButton);

                   controlpaPanel.add(nextbutton);

 

                   //������������Ϊ��ǰ������������

                   Container container=getContentPane();

 

                   //�� cardPanel�������ڴ��ڱ߽粼�ֵ��м䣬����Ĭ��Ϊ�߽粼��

                   container.add(cardPanel,BorderLayout.CENTER);

                   // ��controlpaPanel�������ڴ��ڱ߽粼�ֵ��ϱߣ�

                   container.add(controlpaPanel,BorderLayout.SOUTH);

         }

 

         //ʵ�ְ�ť�ļ�������ʱ�Ĵ���

         public void actionPerformed(ActionEvent e){

                   //����û�����nextbutton��ִ�е����

                   if (e.getSource()==nextbutton){

                            //�л�cardPanel����е�ǰ���֮���һ�����

                            //����ǰ���Ϊ�����ӵ����������ʾ��һ�����������Ƭ�����ʾ��ѭ���ġ�

                            card.next(cardPanel);     

                   }

                   if (e.getSource()==preButton){

                            //�л�cardPanel����е�ǰ���֮ǰ��һ�����

                            //����ǰ���Ϊ��һ����ӵ����������ʾ���һ�����������Ƭ�����ʾ��ѭ���ġ�

                            card.previous(cardPanel);

                   }

         }

         public static void main(String[] args) {

                   CardLayoutTest1 kapian=new CardLayoutTest1();

                  

         }

 }