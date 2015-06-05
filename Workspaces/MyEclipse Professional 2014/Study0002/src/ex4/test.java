package ex4;

public class test {
	int x,y,z;
	test(int a,int b){
		x=a;y=b;
		this.order(a,b);
	}
	test(int a,int b,int c){
		x=a;y=b;z=c;
		this.order(a,b,c);
	}
	void order(int a,int b){
		int t;
		if(x<y){
			t=x;
			x=y;
			y=t;
		}
	}
	void order(int a,int b,int c){
		int t;
		if(x<y){
			t=x;
			x=y;
			y=t;
		}
		if(x<z){
			t=x;
			x=z;
			z=t;
		}
		if(y<z){
			t=y;
			y=z;
			z=t;
		}
	}
	
}
	
