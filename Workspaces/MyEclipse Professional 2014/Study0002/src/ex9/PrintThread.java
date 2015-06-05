package ex9;

public class PrintThread extends Thread {
	private int sleepTime;
	public PrintThread(String name){
		super(name);
		sleepTime=(int)(Math.random()*5001);
	}
	public void run(){
		try{
			System.err.println(getName()+"进入睡眠时间"+sleepTime);
			Thread.sleep(sleepTime);
		}catch(InterruptedException exception){
			exception.printStackTrace();
		}
		System.err.println(getName()+"正在睡眠。。。");
	}
}
