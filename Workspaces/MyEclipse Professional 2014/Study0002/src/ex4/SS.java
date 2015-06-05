package ex4;

public class SS {
	private double x,y; 
	void setX(double u){
		x=u;
	}
	void setY(double v){
		y=v;
	}
	double getX(){
		return x;
	}
	double getY(){
		return y;
	}
	SS(double u,double v){
		setX(u);setY(v);
	}
	SS mid(SS r){
		double midX=(x+r.getX())/2;
		double midY=(y+r.getY())/2;
		SS p=new SS(midX,midY);
		return p;
	}
}
