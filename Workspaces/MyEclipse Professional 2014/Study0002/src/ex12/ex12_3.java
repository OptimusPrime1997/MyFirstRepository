package ex12;
import java.net.*;
import java.io.*;
public class ex12_3 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		URL aURL=new URL("http://www.szcf.org/index.htm#DOWNLOADING");
		System.out.println("protocol="+aURL.getProtocol());
		System.out.println("host="+aURL.getHost());
		System.out.println("filename="+aURL.getFile());
		System.out.println("port="+aURL.getPort());
		System.out.println("ref="+aURL.getRef());
	}

}
