package ex9;
import java.io.*;
public class ex11_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		filetest();
		try{
			int s=System.in.read();
		}catch(Exception e){
			System.out.println("Exception");
		}
	}
	public static void filetest(){
		File f1=new File("G:/mjava/ch_11","ex11_1.java");
		System.out.println("�ļ�����"+f1.getName());
		System.out.println("·����"+f1.getPath());
		System.out.println("����·����"+f1.getAbsolutePath());
		System.out.println(f1.exists()?"�ļ�����":"�ļ�������");
		System.out.println(f1.canWrite()?"�ļ���д":"�ļ�����д");
		System.out.println(f1.canRead()?"�ļ��ɶ�":"�ļ����ɶ�");
		System.out.println(f1.isFile()?"���ļ�":"�����ļ�");
		System.out.println("�ļ�����"+f1.length()+"(Bytes)");
	}

}
