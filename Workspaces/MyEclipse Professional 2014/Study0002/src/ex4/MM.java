package ex4;

public class MM {
	private int id;
	private sDate jb;
	MM(int ia,int ya,int ma,int da){
		id=ia;
		jb=new sDate(ya,ma,da);
	}
	void disp(){
		System.out.println("��ţ�"+id);
		System.out.println("�������ڣ�");
		jb.outDate();
	}
}
