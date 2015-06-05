
//方法一步骤：
//
//（1）      定义使用卡片布局的容器
//
//例如：Panel cardPanel=new Panel();
//
//（2）      定义卡片对象：CardLayout 布局对象名称=new CardLayout();
//
//例如：CardLayout card=new CardLayout();
//
//（3）      设置使用卡片布局的容器为卡片布局：
//
//格式：容器名称.setLayout(布局对象名称);
//
//例如：cardPanel.setLayout(card);
//
//（4）      设置容器中显示的组件
//
//例如：for (int i = 0; i < 5; i++) {
//
//                            cardPanel.add(newJButton("按钮"+i));
//
//                   }
//
//（5）      定义响应事件代码，让容器显示相应的组件
//
//格式：
//
//n  布局对象名称.next(容器名称)   显示容器中当前组件之后的一个组件，若当前组件为最后添加的组件，则显示第一个组件，即卡片组件显示是循环的。
//
//n  布局对象名称.first(容器名称)   显示容器中第一个组件
//
//n  布局对象名称.last(容器名称)   显示容器中最后一个组件
//
//n  布局对象名称.previous(容器名称)   显示容器中当前组件之前的一个组件，若当前组件为第一个添加的组件，则显示最后一个组件，即卡片组件显示是循环的。
//
// 
//
//例如：
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
//实例一：卡片的切换
//
//窗体默认边界布局，一个面板以卡片布局，面板上添加五个按钮，该面板添加到CENTER位置，另一个面板添加两个按钮，两个按钮添加事件来切换显示CENTER位置中的面板的组件

 

// cardlayout.java

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;//引入事件包

 

//定义类时实现监听接口

public class CardLayoutTest1 extends JFrame implements ActionListener{

         JButton nextbutton;

         JButton preButton;

    Panel cardPanel=new Panel();

    Panel controlpaPanel=new Panel();

         //定义卡片布局对象

    CardLayout card=new CardLayout();

         //定义构造函数

         public CardLayoutTest1() {

                   super("卡片布局管理器");

                   setSize(300, 200);

                   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                   setLocationRelativeTo(null);

                   setVisible(true);

 

                   //设置cardPanel面板对象为卡片布局

                   cardPanel.setLayout(card);    

 

                   //循环，在cardPanel面板对象中添加五个按钮

                   //因为cardPanel面板对象为卡片布局，因此只显示最先添加的组件

                   for (int i = 0; i < 5; i++) {

                            cardPanel.add(new JButton("按钮"+i));

                   }

                   //实例化按钮对象

                   nextbutton=new JButton("下一张卡片");

                   preButton=new JButton("上一张卡片");

 

                   //为按钮对象注册监听器

                   nextbutton.addActionListener(this);

                   preButton.addActionListener(this);

 

                   controlpaPanel.add(preButton);

                   controlpaPanel.add(nextbutton);

 

                   //定义容器对象为当前窗体容器对象

                   Container container=getContentPane();

 

                   //将 cardPanel面板放置在窗口边界布局的中间，窗口默认为边界布局

                   container.add(cardPanel,BorderLayout.CENTER);

                   // 将controlpaPanel面板放置在窗口边界布局的南边，

                   container.add(controlpaPanel,BorderLayout.SOUTH);

         }

 

         //实现按钮的监听触发时的处理

         public void actionPerformed(ActionEvent e){

                   //如果用户单击nextbutton，执行的语句

                   if (e.getSource()==nextbutton){

                            //切换cardPanel面板中当前组件之后的一个组件

                            //若当前组件为最后添加的组件，则显示第一个组件，即卡片组件显示是循环的。

                            card.next(cardPanel);     

                   }

                   if (e.getSource()==preButton){

                            //切换cardPanel面板中当前组件之前的一个组件

                            //若当前组件为第一个添加的组件，则显示最后一个组件，即卡片组件显示是循环的。

                            card.previous(cardPanel);

                   }

         }

         public static void main(String[] args) {

                   CardLayoutTest1 kapian=new CardLayoutTest1();

                  

         }

 }