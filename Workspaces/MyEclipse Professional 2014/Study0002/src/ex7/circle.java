package ex7;


class circle implements base {
	double x,y,r;
	circle(double u,double v,double m){
		x=u;y=v;r=m;
	}
	public void parameter() {
		// TODO Auto-generated method stub
		System.out.println("λ�ã���"+x+","+y+") "+"�뾶��"+r);
	}

	@Override
	public void area() {
		// TODO Auto-generated method stub
		System.out.println("Բ�����"+pi*r*r);
	}

}
