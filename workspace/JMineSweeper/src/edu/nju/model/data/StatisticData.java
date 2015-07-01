package edu.nju.model.data;



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
		String temp="";
		temp+=(statistic.getWinrate()+",");
		temp+=(statistic.getWins()+",");
		temp+=(statistic.getSum()+",");
		temp+=(statistic.getLevel()+",");
		temp+=(statistic.getWidth()+",");
		temp+=(statistic.getHeight()+",");
//		temp+=(statistic.get)
		return false;
	}

}