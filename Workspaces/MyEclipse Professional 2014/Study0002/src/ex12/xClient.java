package ex12;
import java.net.*;
import java.io.*;
public class xClient {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		InetAddress addr=InetAddress.getByName("localhost");
		System.out.println("addr="+addr);
		Socket socket=new Socket(addr,xServer.PORT);
		try{
			System.out.println("socket="+socket);
			BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
			for(int i=0;i<5;i++){
				out.println(i+"Hello!");
				String st=in.readLine();
				System.out.println(">>"+st);
			}
			out.println("END");
		}finally{
			System.out.println("closing...");
			socket.close();
		}
	}

}
