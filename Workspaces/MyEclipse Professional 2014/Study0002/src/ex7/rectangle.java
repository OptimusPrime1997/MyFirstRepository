package ex7;


class rectangle implements base {
	double w,h;
	rectangle(double u,double v){
		w=u;h=v;
	}
	@Override
	public void parameter() {
		// TODO Auto-generated method stub
		System.out.println("width="+w+"high="+h);
	}

	@Override
	public void area() {
		// TODO Auto-generated method stub
		System.out.println("¾ØÐÎÃæ»ý£»"+w*h);
	}

}
