//方法二步骤：
//
//（1）      定义使用卡片布局的容器
//
//例如：Panel cardPanel=new Panel();
//
//（2）      定义卡片对象：CardLayout 布局对象名称=newCardLayout();
//
//例如：CardLayout card=new CardLayout();
//
//（3）      设置使用卡片布局的容器为卡片布局：
//
//格式：容器名称.setLayout(卡片对象名称);
//
//例如：cardPanel.setLayout(card);
//
//（4）      设置容器中显示的组件,同时为组件命名对应的卡片名称
//
//格式: 容器名称. Add(卡片名称,组件名称)
//
//例如：for (int i = 0; i < 4; i++) {
//
//                            cardPanel.add(“0”,newJButton("按钮"+i));
//
//                   }
//
//（5）      定义响应事件代码，让容器显示相应的组件
//
//格式：卡片对象名称.show(容器名称,卡片名称)
//
//例如：card.show(cardPanel,”0”);
//
// 
//
//         实例二：使用CardLayout类的show方法显示组件。
//
//窗体默认边界布局，一个面板以卡片布局，面板上添加4个按钮，该面板添加到CENTER位置，另一个面板添加4个按钮，这4个按钮添加事件来切换显示CENTER位置中的面板的组件按钮。
//
// 

// cardlayout1.java

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;//引入事件包

 

//定义类时 实现监听接口

public class CardLayoutTest2 extends JFrame implements ActionListener{

         JButton b0,b1,b2,b3;

    Panel cardPanel=new Panel();

    Panel controlpaPanel=new Panel();

         //定义卡片布局对象

    CardLayout card=new CardLayout();

         //定义字符数组，为卡片命名

         String[] cardName={"0","1","2","3"};

         //定义构造函数

         public CardLayoutTest2() {

                   super("卡片布局管理器");

                   setSize(400,200);

                   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                   setLocationRelativeTo(null);

                   setVisible(true);

 

                   //设置cardPanel面板对象为卡片布局

                   cardPanel.setLayout(card);    

 

                   //循环，在cardPanel面板对象中添加4个按钮

                   //因为cardPanel面板对象为卡片布局，因此初始时显示最先添加的组件

                   for (int i = 0; i< 4; i++) {

                            //面板中添加的每个按钮对应设置一个卡片名

                            cardPanel.add(cardName[i],new JButton("按钮"+i));

                   }

                   //实例化按钮对象

                   b0=new JButton("0");

                   b1=new JButton("1");

                   b2=new JButton("2");

                   b3=new JButton("3");

 

                   //为按钮对象注册监听器

                   b0.addActionListener(this);

                   b1.addActionListener(this);

                   b2.addActionListener(this);

                   b3.addActionListener(this);

 

                   controlpaPanel.add(b0);

                   controlpaPanel.add(b1);

                   controlpaPanel.add(b2);

                   controlpaPanel.add(b3);

                   //定义容器对象为当前窗体容器对象

                   Container container=getContentPane();

 

                   //将 cardPanel面板放置在窗口边界布局的中间，窗口默认为边界布局

                   container.add(cardPanel,BorderLayout.CENTER);

                   // 将controlpaPanel面板放置在窗口边界布局的南边，

                   container.add(controlpaPanel,BorderLayout.SOUTH);

         }

 

         //实现按钮的监听触发时的处理

         public void actionPerformed(ActionEvent e){

                   //用户单击b0按钮时执行的语句

                   if(e.getSource()==b0){

                            //通过show()方法中的卡片名称，显示容器中的组件。

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