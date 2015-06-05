package com.tic.timeee.vo;

import android.R.integer;

//import com.tic.timeee.po.UserPo;

public class UserVo {
	
	int userID;
	String userName;
	
	public UserVo(){};
	
	public String getUserName(){
		return userName;
	}
	
	public void setUserName(String name){
		userName=name;
	}
	
	public int getUserID(){
		return userID;
	}
	
	public void setUserID(int ID){
		userID = ID;
	}
}
