package edu.nju.model.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.sun.org.apache.regexp.internal.recompile;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import edu.nju.controller.impl.ClientControllerImpl;
import edu.nju.main.JMineSweeper;
import edu.nju.model.service.ChessBoardModelService;
import edu.nju.model.service.GameModelService;
import edu.nju.model.service.StatisticModelService;
import edu.nju.model.state.GameResultState;
import edu.nju.model.state.GameState;
import edu.nju.model.vo.GameVO;
import edu.nju.network.Player;

public class GameModelImpl extends BaseModel implements GameModelService {

	private StatisticModelService statisticModel;
	private ChessBoardModelService chessBoardModel;

	private List<GameLevel> levelList;

	private GameState gameState;
	private int width;
	private int height;
	private int mineNum;
	private static String level;

	private GameResultState gameResultState;
	private int time;

	private long startTime;

	public static int count;

	private static TimeThread thread;
	private String msg = "";

	public GameModelImpl(StatisticModelService statisticModel,
			ChessBoardModelService chessBoardModel) {
		this.statisticModel = statisticModel;
		this.chessBoardModel = chessBoardModel;
		gameState = GameState.OVER;

		chessBoardModel.setGameModel(this);

		levelList = new ArrayList<GameLevel>();
		levelList.add(new GameLevel(0, "大", 30, 16, 99));
		levelList.add(new GameLevel(1, "中", 16, 16, 40));
		levelList.add(new GameLevel(2, "小", 9, 9, 10));
		thread = new TimeThread();
		thread.clearCount();
	}

	@Override
	public boolean startGame() {
		// TODO Auto-generated method stub
		gameState = GameState.RUN;
		startTime = Calendar.getInstance().getTimeInMillis();

		GameLevel gl = null;
		for (GameLevel tempLevel : levelList) {
			if (tempLevel.getName().equals(level)) {
				gl = tempLevel;
				break;
			}
		}
		if (gl == null && width == 0 && height == 0)
			gl = levelList.get(2);

		if (gl != null) {
			height = gl.getWidth();
			width = gl.getHeight();
			mineNum = gl.getMineNum();
		}

		this.chessBoardModel.initialize(width, height, mineNum);
		if (ClientControllerImpl.getIsSetClient()) {
			super.updateChange(new UpdateMessage("start", this
					.convertToDisplayGame(), Player.CLIENT));
		} else {
			super.updateChange(new UpdateMessage("start", this
					.convertToDisplayGame(), Player.HOST));
		}
		return true;
	}

	@Override
	public boolean gameOver(GameResultState result, Player player) {
		// TODO Auto-generated method stub

		this.gameState = GameState.OVER;
		this.gameResultState = result;
		this.time = (int) (Calendar.getInstance().getTimeInMillis() - startTime) / 1000;

		this.statisticModel.recordStatistic(result, time);

		super.updateChange(new UpdateMessage("end",
				this.convertToDisplayGame(), player));

		return false;
	}

	@Override
	public boolean setGameLevel(String level) {
		// TODO Auto-generated method stub
		// 输入校验
		if (level.equals("小") || level.equals("中") || level.equals("大")
				|| (level.equals("自定义"))) {
			this.level = level;
		}
		System.out.println("+++" + level);
		return true;
	}

	@Override
	public boolean setGameSize(int width, int height, int mineNum) {
		// TODO Auto-generated method stub
		// 输入校验
		if ((width >= 9 && width <= 30) && (height >= 9 && height <= 24)) {
			this.width = width;
			this.height = height;
			if (mineNum >= 10 && mineNum <= 668) {
				this.mineNum = mineNum;
			}
		}
		System.out.println("+++" + width + "++" + height + "++" + mineNum);
		return true;
	}

	private GameVO convertToDisplayGame() {
		return new GameVO(gameState, width, height, level, gameResultState,
				time);
	}

	@Override
	public List<GameLevel> getGameLevel() {
		// TODO Auto-generated method stub
		return this.levelList;
	}

	public static String getLevel() {
		return level;
	}

	class TimeThread extends Thread {
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				int seconds;
				msg = "";
				seconds = (int) (count);
				if (seconds < 100 && seconds >= 10) {
					msg += "0" + seconds;
				} else if (seconds < 10) {
					msg += "00" + seconds;
				} else {
					msg += seconds;
				}
				// showTime();
				JMineSweeper.getMainFrame().getTimeLabel().setText(msg);
				count++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		public void clearCount() {
			count = 0;
		}

	}

	public static Thread getThread() {
		return thread;
	}

	public void showTime() {
		if (ClientControllerImpl.getIsSetClient()) {
			super.updateChange(new UpdateMessage("time", msg, Player.CLIENT));
		} else {
			super.updateChange(new UpdateMessage("time", msg, Player.HOST));
		}
	}

}