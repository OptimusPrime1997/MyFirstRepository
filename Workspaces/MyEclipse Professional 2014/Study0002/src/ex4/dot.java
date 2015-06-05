package ex4;

public class dot {
	static final int xM=120,yM=320;
	private int x,y;
	dot(){
		x=0;y=0;
	}
	dot(int xC,int yC){
		setX(xC);
		setY(yC);
	}
	void setX(int h){
		x=((h>=0&&h<=xM)?h:0);
	}
	void setY(int v){
		y=((v>=0&&v<=yM)?v:0);
	}
	int getX(){return x;}
	int getY(){return y;}
}
