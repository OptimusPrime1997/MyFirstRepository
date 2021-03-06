/*
 * Created on Dec 1, 2014
 *
 * TODO create the custom dialog
 */
package edu.nju.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.nju.controller.impl.MenuControllerImpl;
import edu.nju.controller.service.MenuControllerService;
import edu.nju.main.JMineSweeper;
import edu.nju.model.impl.GameModelImpl;
import edu.nju.view.listener.MenuListener;

public class CustomDialog {

	/**
	 *  
	 */
	private JFrame parent;

	private JPanel panel;

	private JDialog dialog;

	// private JFormattedTextField widthField;
	private JTextField widthField;

	private JTextField heightField;

	private JTextField mineNumberField;

	private JLabel widthLabel;

	private JLabel heightLabel;

	private JLabel mineNumberLabel;

	private JButton okBtn;

	private JButton cancelBtn;

	private boolean ok=false;

	private int width;

	private int height;

	private int mineNumber;
	
	public static int[] widHeiNum=new int[3];

	public CustomDialog(JFrame parent) {
		super();
		ok = false;

		panel = new JPanel();
		dialog = new JDialog(parent, "custom", true);
		widthField = new JTextField();
		heightField = new JTextField();
		mineNumberField = new JTextField();

		widthLabel = new JLabel("Width");
		heightLabel = new JLabel("Height");
		mineNumberLabel = new JLabel("Mine");
		okBtn = new JButton("ok");
		cancelBtn = new JButton("cancel");

		Font font = new Font("Monospaced", Font.PLAIN, 12);
		widthLabel.setFont(font);
		heightLabel.setFont(font);
		mineNumberLabel.setFont(font);
		okBtn.setFont(font);
		cancelBtn.setFont(font);

		widthLabel.setBounds(15, 30, 50, 20);
		heightLabel.setBounds(15, 60, 50, 20);
		mineNumberLabel.setBounds(15, 90, 50, 20);

		widthField.setBounds(60, 30, 50, 20);
		heightField.setBounds(60, 60, 50, 20);
		mineNumberField.setBounds(60, 90, 50, 20);

		okBtn.setBounds(120, 30, 70, 25);
		cancelBtn.setBounds(120, 85, 70, 25);

		okBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				parse();
				ok = true;
				dialog.setVisible(false);
			
				widHeiNum[0]=width;
				widHeiNum[1]=height;
				widHeiNum[2]=mineNumber;
				JMineSweeper.getSettingGameModelImpl().setCustomizedGameLevel(width,height,mineNumber);
			}

		});

		cancelBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(false);
			}

		});

		panel.setLayout(null);
		panel.add(widthLabel);
		panel.add(heightLabel);
		panel.add(mineNumberLabel);
		panel.add(widthField);
		panel.add(heightField);
		panel.add(mineNumberField);
		panel.add(okBtn);
		panel.add(cancelBtn);

		dialog.setContentPane(panel);
		dialog.setBounds(parent.getX() + 50, parent.getY() + 50, 215, 175);
		dialog.setVisible(true);
//		this.parent = parent;
	}

	public CustomDialog(JFrame parent, int width, int height, int mineNumber) {
		super();
		ok = false;

		panel = new JPanel();
		dialog = new JDialog(parent, "custom", true);
		widthField = new JTextField(String.valueOf(width));
		heightField = new JTextField(String.valueOf(height));
		mineNumberField = new JTextField(String.valueOf(mineNumber));

		widthLabel = new JLabel("Width");
		heightLabel = new JLabel("Height");
		mineNumberLabel = new JLabel("Mine");
		okBtn = new JButton("ok");
		cancelBtn = new JButton("cancel");

		Font font = new Font("Monospaced", Font.PLAIN, 12);
		widthLabel.setFont(font);
		heightLabel.setFont(font);
		mineNumberLabel.setFont(font);
		okBtn.setFont(font);
		cancelBtn.setFont(font);

		widthLabel.setBounds(15, 30, 50, 20);
		heightLabel.setBounds(15, 60, 50, 20);
		mineNumberLabel.setBounds(15, 90, 50, 20);

		widthField.setBounds(60, 30, 50, 20);
		heightField.setBounds(60, 60, 50, 20);
		mineNumberField.setBounds(60, 90, 50, 20);

		okBtn.setBounds(120, 30, 70, 25);
		cancelBtn.setBounds(120, 85, 70, 25);

		okBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				parse();
				ok = true;
				dialog.setVisible(false);
				
				widHeiNum[0]=width;
				widHeiNum[1]=height;
				widHeiNum[2]=mineNumber;
				
				 MenuControllerService menuController1=new MenuControllerImpl();
				 menuController1.startGame();
			}

		});
		

		cancelBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(false);
			}

		});

		panel.setLayout(null);
		panel.add(widthLabel);
		panel.add(heightLabel);
		panel.add(mineNumberLabel);
		panel.add(widthField);
		panel.add(heightField);
		panel.add(mineNumberField);
		panel.add(okBtn);
		panel.add(cancelBtn);

		dialog.setContentPane(panel);
		dialog.setBounds(parent.getX() + 50, parent.getY() + 50, 215, 175);
//		this.parent = parent;
	}

	public boolean show() {
		ok = false;
		dialog.setVisible(true);
		
		return ok;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getMineNumber() {
		return mineNumber;
	}

	private void parse() {
		try {
			width = Integer.parseInt(widthField.getText());
			height = Integer.parseInt(heightField.getText());
			mineNumber = Integer.parseInt(mineNumberField.getText());
			System.out.println("width: " + width);
			System.out.println("Height: " + height);
			System.out.println("Num: " + mineNumber);
		} catch (NumberFormatException e) {
			width = 9;
			height = 9;
			mineNumber = 10;
			return;
		}

		if (width < 9) {
			width = 9;
			widthField.setText("9");
		} else if (width > 30) {
			width = 30;
			widthField.setText("30");
		}

		if (height < 9) {
			height = 9;
			heightField.setText("9");
		} else if (height > 24) {
			height = 24;
			heightField.setText("24");
		}if(mineNumber>668&&mineNumber<height*width){
			mineNumber=668;
			mineNumberField.setText(String.valueOf(mineNumber));
		}

		if (mineNumber >= height * width || mineNumber < 1) {
			mineNumber = height * width / 7;
			mineNumberField.setText(String.valueOf(mineNumber));
		}

	}

}