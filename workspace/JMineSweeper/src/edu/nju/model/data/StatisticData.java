package edu.nju.model.data;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import edu.nju.model.po.StatisticPO;

/**
 * 负责进行统计数据获取和记录操作
 * @author Wangy
 *
 */
public class StatisticData {
	private StatisticPO statisticPO;
	public StatisticData(StatisticPO sPO){
		this.statisticPO=sPO;
	}
	
	
	public StatisticPO getStatistic(){
		return statisticPO;
	}
	
	public boolean saveStatistic(StatisticPO statistic){
		String tempData="";
		tempData+=(statistic.getWinrate()+",");
		tempData+=(statistic.getWins()+",");
		tempData+=(statistic.getSum()+",");
		tempData+=(statistic.getLevel()+",");
		tempData+=(statistic.getWidth()+",");
		tempData+=(statistic.getHeight()+",");
		
		File file=new File("./save.txt");
		try{
			FileWriter writer=new FileWriter(file);
			writer.write(tempData);
			writer.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return false;
	}

}