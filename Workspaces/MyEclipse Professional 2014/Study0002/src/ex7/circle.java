package ex7;


class circle implements base {
	double x,y,r;
	circle(double u,double v,double m){
		x=u;y=v;r=m;
	}
	public void parameter() {
		// TODO Auto-generated method stub
		System.out.println("Î»ÖÃ£º£¨"+x+","+y+") "+"°ë¾¶£º"+r);
	}

	@Override
	public void area() {
		// TODO Auto-generated method stub
		System.out.println("Ô²Ãæ»ý£º"+pi*r*r);
	}

}
