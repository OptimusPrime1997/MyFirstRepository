package ex9;

public class PrintThread extends Thread {
	private int sleepTime;
	public PrintThread(String name){
		super(name);
		sleepTime=(int)(Math.random()*5001);
	}
	public void run(){
		try{
			System.err.println(getName()+"����˯��ʱ��"+sleepTime);
			Thread.sleep(sleepTime);
		}catch(InterruptedException exception){
			exception.printStackTrace();
		}
		System.err.println(getName()+"����˯�ߡ�����");
	}
}
