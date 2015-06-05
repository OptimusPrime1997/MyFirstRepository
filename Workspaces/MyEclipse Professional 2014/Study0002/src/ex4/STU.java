package ex4;

public class STU {
	private int Num,Heav;
	private char Sex;
	STU(int id,int h,char s){
		Num=id;
		Heav=h;
		Sex=s;
	}
	int getH(){
		return Heav;
	}
	char getS(){
		return Sex;
	}
	void disp(){
		String st;
		System.out.println("编号："+Num);
		System.out.println("体重："+Heav);
		if(Sex=='m')
			st="男";
		else 
			st="女";
		System.out.println("性别："+st);
	}
}
