package com.tic.timeee.ui;

import com.tic.timeee.blservices.IUserBL;

public class User {
	private IUserBL userbl;
	
	User()
	{
		if (userbl.login("123", "123"))
		{
			System.out.print("login ok");
		}
		else
		{
			System.out.print("login fail");
		}
	}
	
	public static void main(String args[])
	{
		
	}
}
