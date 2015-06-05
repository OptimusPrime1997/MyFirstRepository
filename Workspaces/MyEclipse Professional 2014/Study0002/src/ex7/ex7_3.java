package ex7;

class ex7_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		triangle tt=new triangle(2,3);
		rectangle rr=new rectangle(4,5);
		circle cc=new circle(6,7,8);
		base baseSet[]={tt,rr,cc};
		for(int i=0;i<baseSet.length;i++){
			baseSet[i].parameter();
			baseSet[i].area();
		}
	}

}
