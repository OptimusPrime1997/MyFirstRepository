package ex9;

public class TestThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintThread thread1=new PrintThread("线程1");
		PrintThread thread2=new PrintThread("线程2");
		PrintThread thread3=new PrintThread("线程3");
		System.err.println("线程开始");
		thread1.start();
		thread2.start();
		thread3.start();
		System.err.println("线程开始、main方法结束\n");
	}

}
