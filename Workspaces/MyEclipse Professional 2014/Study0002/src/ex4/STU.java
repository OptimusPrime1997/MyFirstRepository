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
		System.out.println("��ţ�"+Num);
		System.out.println("���أ�"+Heav);
		if(Sex=='m')
			st="��";
		else 
			st="Ů";
		System.out.println("�Ա�"+st);
	}
}
