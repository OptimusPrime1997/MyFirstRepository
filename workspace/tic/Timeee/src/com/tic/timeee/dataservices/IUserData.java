package com.tic.timeee.dataservices;

import java.nio.channels.ScatteringByteChannel;

import com.tic.timeee.po.UserPo;

public interface IUserData {
	public String getPassword(String user);
	public void addUser(UserPo userPo);
	public void deleteUser(UserPo userPo);
	public UserPo findUser(String user);
	public void editUser(UserPo userPo);
}