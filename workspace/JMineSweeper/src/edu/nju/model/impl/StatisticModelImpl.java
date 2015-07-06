package edu.nju.model.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.sun.imageio.plugins.common.InputStreamAdapter;

import edu.nju.model.data.StatisticData;
import edu.nju.model.po.StatisticPO;
import edu.nju.model.service.StatisticModelService;
import edu.nju.model.state.GameResultState;

public class StatisticModelImpl extends BaseModel implements
		StatisticModelService {

	private StatisticData statisticDao;
	private StatisticPO statisticPO;
	File file = new File("./save.txt");
	private int littleWins;
	private int middleWins;
	private int largeWins;
	private int customerWins;
	private int littleSum;
	private int middleSum;
	private int largeSum;
	private int customerSum;
	private String[] play = new String[4];

	public StatisticModelImpl() {
		// 初始化Dao
		ArrayList<String> arrayString = new ArrayList<String>();
		String savedString = null;
		String[] split = new String[8];
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while ((savedString = reader.readLine()) != null) {
				arrayString.add(savedString);
			}
			if (!arrayString.isEmpty()) {
				savedString = arrayString.get(arrayString.size() - 1);
			}
			System.out.println(savedString);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (savedString == null) {
			littleWins = 0;
			middleWins = 0;
			largeWins = 0;
			customerWins = 0;
			littleSum = 0;
			middleSum = 0;
			largeSum = 0;
			customerSum = 0;
		} else {
			split = savedString.split("/");
			littleWins = Integer.parseInt(split[0]);
			littleSum = Integer.parseInt(split[1]);
			middleWins = Integer.parseInt(split[2]);
			middleSum = Integer.parseInt(split[3]);
			largeWins = Integer.parseInt(split[4]);
			largeSum = Integer.parseInt(split[5]);
			customerWins = Integer.parseInt(split[6]);
			customerSum = Integer.parseInt(split[7]);
		}
	}

	@Override
	public void recordStatistic(GameResultState result, int time) {
		// TODO Auto-generated method stub

		String level = edu.nju.model.impl.GameModelImpl.getLevel();

		if (level.equals("小")) {
			System.out.println("+++Game level is 小");
			littleSum++;
			if (result == GameResultState.SUCCESS) {
				littleWins++;
			}
		} else if (level.equals("中")) {
			System.out.println("+++Game level is " + level);
			middleSum++;
			if (result == GameResultState.SUCCESS) {
				middleWins++;
			}
		} else if (level.equals("大")) {
			System.out.println("+++Game level is " + level);
			largeSum++;
			if (result == GameResultState.SUCCESS) {
				largeWins++;
			}
		} else if (level.equals("自定义")) {
			System.out.println("+++Game level is " + level);
			customerSum++;
			if (result == GameResultState.SUCCESS) {
				customerWins++;
			}
		}
		statisticPO = new StatisticPO(littleWins, littleSum, middleWins,
				middleSum, largeWins, largeSum, customerWins, customerSum);
		statisticDao = new StatisticData(statisticPO);
		statisticDao.saveStatistic(statisticPO);
	}

	@Override
	public void showStatistics() {
		// TODO Auto-generated method stub
		play[0] = littleWins+"/"+littleSum;
		play[1] = middleWins+"/"+middleSum;
		play[2] = largeWins+"/"+largeSum;
		play[3] = customerWins+"/"+customerSum;

	}
	public String[] getRate() {
		return play;
	}

}
