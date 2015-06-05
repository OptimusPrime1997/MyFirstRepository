package ex4;

public class ex4_7 {
	static double Triangle(int a,int b){
		float d=(float)a*b/2;
		return d;
	}
	static double Triangle(int a,int b,int c){
		double s=(a+b+c)/2;
		double area=Math.sqrt(s*(s-a)*(s-b)*(s-c));
		return area;
	}
	static double Triangle(){
		int width=30,height=40;
		double d=width*height/2;
		return d;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x=5,y=4,z=3;
		System.out.println(Triangle(x,y,z)+"\n"+Triangle(z,y)+"\n"+Triangle());
	}

}
