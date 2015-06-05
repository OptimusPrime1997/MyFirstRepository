package com.tic.timeee.po;

import com.tic.timeee.vo.UserVo;

import android.R.integer;
import android.R.string;

public class UserPo {
	int userID;
	String userName;
	String passWord;
	
	public UserPo(){};
	
	public UserPo(UserVo userVo){
		userName = userVo.getUserName();
		userID = userVo.getUserID();
	}
	
	public String getUserName(){
		return userName;
	}
	
	public int getUserID(){
		return userID;
	}
	
	public String getPassword(){
		return passWord;
	}
}
