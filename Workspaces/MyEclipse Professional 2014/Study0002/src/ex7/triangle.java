package ex7;



class triangle implements base {
	double b,h;
	triangle(double u,double v){
		b=u;h=v;
	}
	@Override
	public void parameter() {
		// TODO Auto-generated method stub
		System.out.println("�ױ�"+b+"��"+h);
	}

	@Override
	public void area() {
		// TODO Auto-generated method stub
		System.out.println("���������"+half*b*h);
	}

}