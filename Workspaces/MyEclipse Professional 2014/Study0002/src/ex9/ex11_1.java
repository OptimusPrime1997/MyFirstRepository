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
		System.out.println("文件名："+f1.getName());
		System.out.println("路径："+f1.getPath());
		System.out.println("绝对路径："+f1.getAbsolutePath());
		System.out.println(f1.exists()?"文件存在":"文件不存在");
		System.out.println(f1.canWrite()?"文件可写":"文件不可写");
		System.out.println(f1.canRead()?"文件可读":"文件不可读");
		System.out.println(f1.isFile()?"是文件":"不是文件");
		System.out.println("文件长度"+f1.length()+"(Bytes)");
	}

}
