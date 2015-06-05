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
			System.out.println("没油啦，不能跑了。");
	}
	void Show(){
		System.out.println("品牌："+Brand+"油量："+Gas);
	}
}
