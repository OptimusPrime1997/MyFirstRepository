package ex12;
import java.net.*;
public class ex12_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InetAddress hit=null;
		try{
			hit=InetAddress.getByName("localhost");
			System.out.println(hit);
		}catch(UnknownHostException e){
			System.out.println(hit);
		}
	}

}
