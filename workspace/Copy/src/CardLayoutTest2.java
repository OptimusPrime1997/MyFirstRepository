//���������裺
//
//��1��      ����ʹ�ÿ�Ƭ���ֵ�����
//
//���磺Panel cardPanel=new Panel();
//
//��2��      ���忨Ƭ����CardLayout ���ֶ�������=newCardLayout();
//
//���磺CardLayout card=new CardLayout();
//
//��3��      ����ʹ�ÿ�Ƭ���ֵ�����Ϊ��Ƭ���֣�
//
//��ʽ����������.setLayout(��Ƭ��������);
//
//���磺cardPanel.setLayout(card);
//
//��4��      ������������ʾ�����,ͬʱΪ���������Ӧ�Ŀ�Ƭ����
//
//��ʽ: ��������. Add(��Ƭ����,�������)
//
//���磺for (int i = 0; i < 4; i++) {
//
//                            cardPanel.add(��0��,newJButton("��ť"+i));
//
//                   }
//
//��5��      ������Ӧ�¼����룬��������ʾ��Ӧ�����
//
//��ʽ����Ƭ��������.show(��������,��Ƭ����)
//
//���磺card.show(cardPanel,��0��);
//
// 
//
//         ʵ������ʹ��CardLayout���show������ʾ�����
//
//����Ĭ�ϱ߽粼�֣�һ������Կ�Ƭ���֣���������4����ť���������ӵ�CENTERλ�ã���һ��������4����ť����4����ť����¼����л���ʾCENTERλ���е����������ť��
//
// 

// cardlayout1.java

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;//�����¼���

 

//������ʱ ʵ�ּ����ӿ�

public class CardLayoutTest2 extends JFrame implements ActionListener{

         JButton b0,b1,b2,b3;

    Panel cardPanel=new Panel();

    Panel controlpaPanel=new Panel();

         //���忨Ƭ���ֶ���

    CardLayout card=new CardLayout();

         //�����ַ����飬Ϊ��Ƭ����

         String[] cardName={"0","1","2","3"};

         //���幹�캯��

         public CardLayoutTest2() {

                   super("��Ƭ���ֹ�����");

                   setSize(400,200);

                   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                   setLocationRelativeTo(null);

                   setVisible(true);

 

                   //����cardPanel������Ϊ��Ƭ����

                   cardPanel.setLayout(card);    

 

                   //ѭ������cardPanel�����������4����ť

                   //��ΪcardPanel������Ϊ��Ƭ���֣���˳�ʼʱ��ʾ������ӵ����

                   for (int i = 0; i< 4; i++) {

                            //�������ӵ�ÿ����ť��Ӧ����һ����Ƭ��

                            cardPanel.add(cardName[i],new JButton("��ť"+i));

                   }

                   //ʵ������ť����

                   b0=new JButton("0");

                   b1=new JButton("1");

                   b2=new JButton("2");

                   b3=new JButton("3");

 

                   //Ϊ��ť����ע�������

                   b0.addActionListener(this);

                   b1.addActionListener(this);

                   b2.addActionListener(this);

                   b3.addActionListener(this);

 

                   controlpaPanel.add(b0);

                   controlpaPanel.add(b1);

                   controlpaPanel.add(b2);

                   controlpaPanel.add(b3);

                   //������������Ϊ��ǰ������������

                   Container container=getContentPane();

 

                   //�� cardPanel�������ڴ��ڱ߽粼�ֵ��м䣬����Ĭ��Ϊ�߽粼��

                   container.add(cardPanel,BorderLayout.CENTER);

                   // ��controlpaPanel�������ڴ��ڱ߽粼�ֵ��ϱߣ�

                   container.add(controlpaPanel,BorderLayout.SOUTH);

         }

 

         //ʵ�ְ�ť�ļ�������ʱ�Ĵ���

         public void actionPerformed(ActionEvent e){

                   //�û�����b0��ťʱִ�е����

                   if(e.getSource()==b0){

                            //ͨ��show()�����еĿ�Ƭ���ƣ���ʾ�����е������

                            card.show(cardPanel,cardName[0]);     

                   }

                   if(e.getSource()==b1){

                            card.show(cardPanel,cardName[1]);     

                   }

                   if(e.getSource()==b2){

                            card.show(cardPanel,cardName[2]);     

                   }

                   if(e.getSource()==b3){

                            card.show(cardPanel,cardName[3]);     

                   }

         }

         public static void main(String[] args) {

                   CardLayoutTest2 kapian=new CardLayoutTest2();

                  

         }

 }