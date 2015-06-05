package ex4;

import java.io.IOException;

import mypg.InputData;

class ex5_7{
	public static void main(String args[])throws IOException{
		int i,sum=0;
		double ave;
		STU b[]=new STU[3];
		for(i=0;i<b.length;i++){
			System.out.println("输入数据：");
			int id=InputData.iRead();
			int h=InputData.iRead();
			char c=(char)System.in.read();
			b[i]=new STU(id,h,c);
		}
		for(i=0;i<b.length;i++)
			sum=sum+b[i].getH();
		ave=sum/3.0;
		System.out.println("超过平均体重的男同学：");
		for(i=0;i<b.length;i++)
			if(b[i].getH()>=ave&&b[i].getS()=='m')
				b[i].disp();
	}
}
