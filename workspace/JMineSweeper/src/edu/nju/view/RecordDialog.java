/*
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package edu.nju.view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import edu.nju.model.impl.StatisticModelImpl;

public class RecordDialog {
	private final String[] rank = { "Easy", "Hard", "Hell","Custom" };
  	private JDialog dialog;

	private JPanel panel;

	private JButton okBtn;

	private JButton clearBtn;

	private JSeparator line;

	private String names[];

	private int score[];

	private JPanel textPanel;
	
	private StatisticModelImpl statisticModelImpl;

	boolean clear;
	/**
	 *  
	 */
	public RecordDialog(JFrame parent) {
		super();
		initialization(parent);
	}

	public boolean show(String[] names, int[] score) {
		clear = false;
		this.names = names;
		this.score = score;
		dialog.setVisible(true);
		return clear;
	}
	
	public void show(){
		dialog.setVisible(true);
		this.names = new String[]{"UnKnown","UnKown","UnKnown","UnKnown"};
		this.score = new int[]{0,0,0,0};
		show(names,score);
	}

	private void initialization(JFrame parent) {
		
		dialog = new JDialog(parent, "record", true);
		
		
		okBtn = new JButton("Ok");
		okBtn.setFont(new Font("Monospaced", Font.PLAIN, 12));
		okBtn.setBounds(100, 135, 70, 23);
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(false);
			}
		});

		clearBtn = new JButton("Clear");
		clearBtn.setFont(new Font("Monospaced", Font.PLAIN, 12));
		clearBtn.setBounds(192, 135, 70, 23);
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear = true;
				int length = names.length;
				for (int i = 0; i < length; i++) {
					names[i] = "Unknow Name";
					score[i] = 0;
				}
				textPanel.repaint();
				edu.nju.model.data.StatisticData.clearStatistics();
			}
		});

		line = new JSeparator();
		line.setBounds(20, 105, 240, 4);

		panel = new JPanel();
		panel.setLayout(null);

		textPanel = new DescribeTextPanel();
		panel.add(textPanel);

		panel.add(okBtn);
		panel.add(clearBtn);
		panel.add(line);

		dialog.setContentPane(panel);
		dialog.setBounds(parent.getLocation().x + 50,
				parent.getLocation().y + 50, 300, 210);
		statisticModelImpl=new StatisticModelImpl();
		statisticModelImpl.showStatistics();

		if(clear){
			show();
		}else{
			String[] levelString={"Easy","Hard","Hell","Custom"};
			int[] temp=new int[4];
			for(int i=0;i<3;i++){
				temp[i]=statisticModelImpl.getRate()[i];
			}
			show(levelString,temp);
		}

		clear = false;

	}

	private class DescribeTextPanel extends JPanel {

		DescribeTextPanel() {
			super();
			setBounds(0, 0, 290, 150);
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setFont(new Font("Monospaced", Font.PLAIN, 12));
			int length = names.length;
			for (int i = 0; i < length; i++) {
				g.drawString(names[i], 20, 30 * (i + 1));
				g.drawString(String.valueOf(score[i]),140, 30 * (i + 1));
				g.drawString(rank[i], 230, 30 * (i + 1));
			}
		}
	}

	
}