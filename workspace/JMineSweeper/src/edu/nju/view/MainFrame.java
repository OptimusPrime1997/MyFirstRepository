/*
 *
 * TODO the view of MVC structure. to create user interface and show result
 * automatically when model data are changed
 */
package edu.nju.view;

import java.awt.Dialog;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicBorders.MarginBorder;

import sun.net.www.content.text.plain;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import edu.nju.controller.impl.MenuControllerImpl;
import edu.nju.controller.service.MenuControllerService;
import edu.nju.main.JMineSweeper;
import edu.nju.model.impl.BaseModel;
import edu.nju.model.impl.ChessBoardModelImpl;
import edu.nju.model.impl.GameModelImpl;
import edu.nju.model.impl.UpdateMessage;
import edu.nju.model.po.BlockPO;
import edu.nju.model.state.GameResultState;
import edu.nju.model.state.GameState;
import edu.nju.model.vo.BlockVO;
import edu.nju.model.vo.GameVO;
import edu.nju.network.Player;
import edu.nju.network.modelProxy.GameModelProxy;
import edu.nju.view.listener.CoreListener;
import edu.nju.view.listener.MenuListener;

import java.util.Observer;

public class MainFrame extends JFrame implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Variables declaration
	private JFrame mainFrame;
	private JPanel head;
	private JMenuBar aJMenuBar;
	private JMenu game;
	private HashMap<String, JMenuItem> menuItemMap;
	private JMenuItem startItem;
	private JSeparator jSeparator;
	private JSeparator jSeparator1;
	private JSeparator jSeparator2;
	private ButtonGroup group;
	private JCheckBoxMenuItem easy;
	private JCheckBoxMenuItem hard;
	private JCheckBoxMenuItem hell;
	private JCheckBoxMenuItem custom;
	private JMenuItem record;
	private JMenuItem exit;
	private JMenu online;
	private JMenuItem host;
	private JMenuItem client;
	private MineNumberLabel mineNumberLabel;
	private JButton startButton;
	private JLabel timeLabel;
	private MineBoardPanel body;
	private final int buttonSize = 16;
	private final int bodyMarginNorth = 20;
	private final int bodyMarginOther = 12;
	private int defaultWidth = 9;
	private int defaultHeight = 9;
	private CoreListener coreListener;
	private MenuListener menuListener;

	private MineBoardPanel mineBoardPanel;
	
	private static int sTime;
	
	private Dialog uiDialog;
	

	// End of variables declaration

	public MainFrame() {
		
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		componentsInstantiation();
		initComponents();
		mainFrame.setVisible(true);
//		thread.start();
	}

	// Instantiation of components
	private void componentsInstantiation() {
		mainFrame = new JFrame();
		head = new JPanel();
		mineNumberLabel = new MineNumberLabel();
		startButton = new JButton();
		timeLabel = new JLabel();

		aJMenuBar = new JMenuBar();
		game = new JMenu();
		startItem = new JMenuItem();
		jSeparator = new JSeparator();
		jSeparator1 = new JSeparator();
		jSeparator2 = new JSeparator();
		easy = new JCheckBoxMenuItem();
		hard = new JCheckBoxMenuItem();
		hell = new JCheckBoxMenuItem();
		custom = new JCheckBoxMenuItem();
		record = new JMenuItem();
		exit = new JMenuItem();
		online = new JMenu();
		host = new JMenuItem();
		client = new JMenuItem();

		menuItemMap = new HashMap<String, JMenuItem>();
		group = new ButtonGroup();

		body = new MineBoardPanel(defaultHeight, defaultWidth);
		coreListener = new CoreListener(this);
		menuListener = new MenuListener(this);

		mineBoardPanel = new MineBoardPanel();
		uiDialog=new Dialog(this);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 */
	private void initComponents() {
		mainFrame
				.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		game.setText("Game");

		// build menu bar
		group.add(easy);
		group.add(hard);
		group.add(hell);
		group.add(custom);

		startItem.setText("Start");
		game.add(startItem);
		startItem.addActionListener(menuListener);
		menuItemMap.put("start", startItem);

		game.add(jSeparator1);

		easy.setText("Easy");
		game.add(easy);
		easy.addActionListener(menuListener);
		menuItemMap.put("easy", easy);

		hard.setText("Hard");
		hard.addActionListener(menuListener);
		game.add(hard);
		menuItemMap.put("hard", hard);

		hell.setText("Hell");
		hell.addActionListener(menuListener);
		game.add(hell);
		menuItemMap.put("hell", hell);

		custom.setText("Custom");
		custom.addActionListener(menuListener);
		game.add(custom);
		menuItemMap.put("custom", custom);

		game.add(jSeparator2);

		record.setText("Record");
		game.add(record);
		menuItemMap.put("record", record);
		record.addActionListener(menuListener);

		game.add(jSeparator);

		exit.setText("Exit");
		exit.addActionListener(menuListener);
		game.add(exit);
		menuItemMap.put("exit", exit);

		aJMenuBar.add(game);

		online.setText("online");
		host.setText("registe as host");
		host.addActionListener(menuListener);
		online.add(host);
		menuItemMap.put("host", host);

		client.setText("registe as client");
		client.addActionListener(menuListener);
		online.add(client);
		menuItemMap.put("client", client);

		aJMenuBar.add(online);
		mainFrame.setJMenuBar(aJMenuBar);
		// build menu bar end

		mainFrame.getContentPane().setLayout(null);

		// build head panel
		head.setBorder(new javax.swing.border.TitledBorder(null, "",
				javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.DEFAULT_POSITION));
		head.setLayout(null);

		startButton.setIcon(Images.START_BEGIN);
		startButton.addActionListener(coreListener);
		Font font = new Font("Serif", Font.BOLD, 12);
		mineNumberLabel.setFont(font);
		timeLabel.setFont(font);

		mineNumberLabel.setHorizontalAlignment(JLabel.CENTER);
		timeLabel.setHorizontalAlignment(JLabel.CENTER);

		mineNumberLabel.setText("剩余雷数");
		timeLabel.setText("000");

		head.add(mineNumberLabel);
		head.add(startButton);
		head.add(timeLabel);
		mainFrame.getContentPane().add(head);
		// build head panel end

		// build body panel
		mainFrame.getContentPane().add(body);
		// build body panel end

		mainFrame.setTitle("JMineSweeper");
		mainFrame.setIconImage(Images.FRAME_IMAGE);
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
				.getScreenSize();

		// build head, and body in detail
		head.setBounds(4, 5, body.getColumns() * buttonSize + bodyMarginOther
				* 2 - 4, 65);
		startButton.setBounds((head.getWidth() - 50) / 2,
				(head.getHeight() - 50) / 2, 50, 50);
		mineNumberLabel.setBounds(0, 0, head.getHeight(), head.getHeight());
		timeLabel.setBounds(head.getWidth() - head.getHeight(), 0, head.getHeight(),
				head.getHeight());

		body.setBounds(2, head.getHeight(), body.getColumns() * buttonSize + 2
				* bodyMarginOther, body.getRows() * buttonSize
				+ bodyMarginNorth + bodyMarginOther);
		body.setBorder(new javax.swing.border.TitledBorder(
				new javax.swing.border.TitledBorder(""), "Challenge Yourself!",
				javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.DEFAULT_POSITION));
		mainFrame.getContentPane().add(body);
		mainFrame.setSize(body.getWidth() + 10,
				body.getHeight() + head.getHeight() + 60);
		mainFrame.validate();
		mainFrame.repaint();
		easy.setSelected(true);
		mainFrame
				.setLocation(
						(screenSize.width - head.getWidth()) / 2,
						(screenSize.height - aJMenuBar.getHeight()
								- head.getHeight() - body.getHeight()) / 2);

		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {

			}
		});
	}

	public JFrame getMainFrame() {
		return mainFrame;
	}

	public JMenuItem getMenuItem(String name) {
		if (menuItemMap == null)
			return null;
		return (JMenuItem) menuItemMap.get(name);
	}

	public MineBoardPanel getMineBoard() {
		return this.body;
	}

	public MineNumberLabel getMineNumberLabel() {
		return this.mineNumberLabel;
	}

	public JButton getStartButton() {
		return this.startButton;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 * 游戏gameModel发生变化体现在这里
	 */
	@Override
	public void update(Observable o, Object arg) {
		
		UpdateMessage notifingObject = (UpdateMessage) arg;
		System.out.println("edu.nju.view.MainFrame -- "+notifingObject.getKey()+"\n");
		if (notifingObject.getKey().equals("start")) {
			GameVO newGame1 = (GameVO) notifingObject.getValue();
			int gameWidth = newGame1.getWidth();
			int gameHeight = newGame1.getHeight();
			String level = newGame1.getLevel();
			restart(gameHeight, gameWidth, level);
			startButton.setIcon(Images.START_RUN);
		} else if (notifingObject.getKey().equals("end")) {
			Player uiPlayer=notifingObject.getPlayer();
			GameModelImpl.getThread().suspend();
			BaseModel.isBlocked = true;
			GameVO newGame2 = (GameVO) notifingObject.getValue();
			if(newGame2.getGameResultState()==GameResultState.SUCCESS){
				startButton.setIcon(Images.START_BEGIN);
				if(uiPlayer==Player.HOST){
					JOptionPane.showMessageDialog(this, "HOST WIN :)\nCLINET LOSE :(");
				}else{
					JOptionPane.showMessageDialog(this, "CLIENT WIN :)\nHOST LOSE :(");
				}
			}else{
				startButton.setIcon(Images.START_END);
				if(uiPlayer==Player.HOST){
					JOptionPane.showMessageDialog(this, "CLIENT WIN :)\nHOST LOSE :(");
				}else{
					JOptionPane.showMessageDialog(this, "HOST WIN :)\nCLINET LOSE :(");
				}
			}
			System.out.println("更换图像！");
		}else if(notifingObject.getKey().equals("time")){
			timeLabel.setText(""+(String)notifingObject.getValue());
			System.out.println("更新时间！！！");
		}
	}

	private void restart(int mineBoardHeight, int mineBoardWidth, String type) {
		ChessBoardModelImpl.gameState=GameState.RUN;
		mainFrame.getContentPane().remove(body);
		body = new MineBoardPanel(mineBoardHeight, mineBoardWidth);
		head.setBounds(4, 5, mineBoardWidth * buttonSize + bodyMarginOther * 2
				- 4, 65);
		startButton.setBounds((head.getWidth() - 50) / 2,
				(head.getHeight() - 50) / 2, 50, 50);
		mineNumberLabel.setBounds(0, 0, head.getHeight(), head.getHeight());
		timeLabel.setBounds(head.getWidth() - head.getHeight(), 0, head.getHeight(),
				head.getHeight());

		body.setBounds(2, head.getHeight(), mineBoardWidth * buttonSize + 2
				* bodyMarginOther, mineBoardHeight * buttonSize
				+ bodyMarginNorth + bodyMarginOther);
		body.setBorder(new javax.swing.border.TitledBorder(
				new javax.swing.border.TitledBorder(""), "Challenge Yourself!",
				javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.DEFAULT_POSITION));
		mainFrame.getContentPane().add(body);
		mainFrame.setSize(body.getWidth() + 10,body.getHeight() + head.getHeight() + 60);
		timeLabel.setText("000");
		BaseModel.isFirstClick=true;

		if (type == "自定义") {
			custom.setSelected(true);
		} else if (type.equals("小")) {
			easy.setSelected(true);
		} else if (type.equals("中")) {
			hard.setSelected(true);
		} else if (type.equals("大")) {
			hell.setSelected(true);
		} else {
			custom.setSelected(true);
		}
		mainFrame.validate();
		mainFrame.repaint();
	}
	public JLabel getTimeLabel(){
		return this.timeLabel;
	}
	public void saveTime(int currentTime){
		sTime=currentTime;
	}
	
}
