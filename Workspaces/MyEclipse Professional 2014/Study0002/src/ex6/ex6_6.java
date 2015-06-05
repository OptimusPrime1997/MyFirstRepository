package ex6;

public class ex6_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rectangle rec=new rectangle(1.0,2.0);
		circle cir=new circle(3.0,"Red");
		angle ang=new angle(3.0,2.0);
		graphics g[]={rec,cir,ang};
		for(int i=0;i<g.length;i++){
			g[i].parameter();
			g[i].area();
		}
	}

}
