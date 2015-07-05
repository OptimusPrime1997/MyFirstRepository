package edu.nju.model.data;



import java.io.BufferedWriter;
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
		tempData+=(statistic.getlittleWins()+"/");
		tempData+=(statistic.getlittleSum()+"/");
		System.out.println(statistic.getlittleSum());
		tempData+=(statistic.getmiddleWins()+"/");
		tempData+=(statistic.getmiddleSum()+"/");
		tempData+=(statistic.getlargeWins()+"/");
		tempData+=(statistic.getlargeSum()+"/");
		tempData+=(statistic.getcustomerWins()+"/");
		tempData+=(statistic.getcustomerSum()+"\n");
		
		File file=new File("./save.txt");
		try{
			BufferedWriter writer =new BufferedWriter(new FileWriter(file,true));
			System.out.println("++++"+"Test write"+tempData+"+++++");
		
			writer.write(tempData);
		
			writer.flush();
			writer.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return false;
	}
	public static void clearStatistics(){
		try{
			FileWriter wr=new FileWriter("./save.txt");
			wr.write("");
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}