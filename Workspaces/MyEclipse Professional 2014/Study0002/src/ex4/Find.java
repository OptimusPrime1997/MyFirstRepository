package ex4;

public class Find {
	int max,maxi,min,mini;
	private int b[]={16,6,10,15,2,17,3,14,7,13,8,11,19,9,12,5,20,1,18,4};
	Find(){
		max=b[0]+b[1]+b[2]+b[3];
		min=max;
		maxi=0;
		mini=0;
	}
	void total(){
		for(int i=1;i<20;i++){
			int sum=b[i]+b[(i+1)%20]+b[(i+2)%20]+b[(i+3)%20];
			if(sum>max){
				max=sum;
				maxi=i;
			}
			if(sum<min){
				min=sum;
				mini=i;
			}
		}
	}
		void show(int s,int id){
			System.out.println(s);
			System.out.print("这四个数是：");
			for(int i=0;i<4;i++)
				System.out.print(b[(i+id)%20]+" ");
			System.out.println();
		}
	}

