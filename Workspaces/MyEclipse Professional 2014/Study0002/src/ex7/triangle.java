package ex7;



class triangle implements base {
	double b,h;
	triangle(double u,double v){
		b=u;h=v;
	}
	@Override
	public void parameter() {
		// TODO Auto-generated method stub
		System.out.println("底边"+b+"高"+h);
	}

	@Override
	public void area() {
		// TODO Auto-generated method stub
		System.out.println("三角形面积"+half*b*h);
	}

}