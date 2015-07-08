package edu.nju.model.impl;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import edu.nju.model.service.ParameterModelService;
import edu.nju.network.Player;

public class ParameterModelImpl extends BaseModel implements ParameterModelService{
	
	private int maxMine;
	private int mineNum;

	@Override
	public boolean setMineNum(int num) {
		// TODO Auto-generated method stub
		mineNum = num;
		maxMine = num;
		
		super.updateChange(new UpdateMessage("mineNum", mineNum,Player.HOST));
		return true;
	}

	@Override
	public boolean addMineNum() {
		// TODO Auto-generated method stub
		mineNum++;
		
		if(mineNum>maxMine){
			mineNum--;
			return false;
		}
		
		super.updateChange(new UpdateMessage("mineNum", mineNum,Player.HOST));
		return true;
	}

	@Override
	public boolean minusMineNum() {
		// TODO Auto-generated method stub
		if(mineNum<=0){
			return false;
		}
		mineNum--;
		super.updateChange(new UpdateMessage("mineNum", mineNum,Player.HOST));
		return true;
	}
	
	@Override
	public boolean isOKMinus() {
		// TODO Auto-generated method stub
		if(mineNum<=0){
			return false;
		}else{
			return true;
		}
	}
	

}
