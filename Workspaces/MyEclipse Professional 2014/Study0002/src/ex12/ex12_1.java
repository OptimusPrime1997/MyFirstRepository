package ex12;
import java.net.*;
public class ex12_1 {
	public static void main(String args[]){
		InetAddress LocalIP=null;
		try{
			LocalIP=InetAddress.getLocalHost();
			System.out.println(LocalIP);
		}catch(UnknownHostException e){
			System.out.println(LocalIP);
		}
	}
}
