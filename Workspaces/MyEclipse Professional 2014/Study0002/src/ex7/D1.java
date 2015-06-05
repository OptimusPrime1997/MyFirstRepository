package ex7;

import java.util.Random;

class D1 implements DA0 {
	Random rand=new Random();
	int ask(){
		int p=0,i=0;
	
	for(i=1;i<=90;i++)
		p=(int)(80*rand.nextDouble());
	if(p<10)
		return x1;
	else if(p<20)
		return x2;
	else if(p<30)
		return x3;
	else if(p<40)
		return x4;
	else if(p<50)
		return x5;
	else if(p<60)
		return x6;
	else if(p<70)
		return x7;
	else return x8;
	}
}
