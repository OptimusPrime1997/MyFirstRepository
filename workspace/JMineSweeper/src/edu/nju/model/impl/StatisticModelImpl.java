package edu.nju.model.impl;



import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import com.sun.imageio.plugins.common.InputStreamAdapter;

import edu.nju.model.data.StatisticData;
import edu.nju.model.service.StatisticModelService;
import edu.nju.model.state.GameResultState;

public class StatisticModelImpl extends BaseModel implements StatisticModelService{
	
	private StatisticData statisticDao;
	File file=new File("./save.txt");
	public StatisticModelImpl(){
		//初始化Dao
		
		
	}

	@Override
	public void recordStatistic(GameResultState result, int time) {
		// TODO Auto-generated method stub
		String tempData="";
		tempData+=(result+",");
		tempData+=(edu.nju.model.impl.GameModelImpl.getLevel()+",");
		tempData+=(time+"\n");
		try{
			FileWriter writer=new FileWriter(file);
			writer.write(tempData);
			writer.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	@Override
	public void showStatistics() {
		// TODO Auto-generated method stub
		int wins0=0;
		int wins1=0;
		int wins2=0;
		int wins3=0;
		int sum0=0;
		int sum1=0;
		int sum2=0;
		int sum3=0;
		try{
			FileReader reader=new FileReader(file);
			String temp="";
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
