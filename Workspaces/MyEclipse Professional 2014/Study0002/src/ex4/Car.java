package ex4;
import java.io.*;
public class Car {
	private String Brand;
			int Gas;
	Car(String vBrand,int vGas){
		Brand=vBrand;
		Gas=vGas;
	}
	void Move(){
		if(Gas>0)
			Gas-=10;
		else 
			System.out.println("û�������������ˡ�");
	}
	void Show(){
		System.out.println("Ʒ�ƣ�"+Brand+"������"+Gas);
	}
}
