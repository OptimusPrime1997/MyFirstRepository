package ex9;

public class TestThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintThread thread1=new PrintThread("�߳�1");
		PrintThread thread2=new PrintThread("�߳�2");
		PrintThread thread3=new PrintThread("�߳�3");
		System.err.println("�߳̿�ʼ");
		thread1.start();
		thread2.start();
		thread3.start();
		System.err.println("�߳̿�ʼ��main��������\n");
	}

}
