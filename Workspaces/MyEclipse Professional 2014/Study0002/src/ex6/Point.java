package ex6;

public class Point {
	private int x,y;
	public Point(int xValue,int yValue){
		x=xValue;
		y=yValue;
	}
	public void setX(int xValue){
		x=xValue;
	}
	public int getX(){
		return x;
	}
	public void setY(int yValue){
		y=yValue;
	}
	public int getY(){
		return y;
	}
	public String toString(){
		return "["+x+","+y+"]";
	}
}
