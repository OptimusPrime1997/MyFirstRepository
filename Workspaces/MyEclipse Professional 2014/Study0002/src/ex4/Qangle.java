package ex4;

public class Qangle {
	int a,h;
	Qangle(Qangle r){
		a=r.width();
		h=r.height();
	}
	Qangle(int x,int y){
		a=x;
		h=y;
	}
	Qangle(){
		a=10;
		h=20;
	}
	int width(){
		return a;
	}
	int height(){
		return h;
	}
	void set(int x,int y){
		a=x;h=y;
	}
}
