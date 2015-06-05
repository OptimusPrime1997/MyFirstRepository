package ex12;
import java.io.*;
import java.net.*;
public class xServer {
	public static final int PORT=8080;
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		ServerSocket s=new ServerSocket(PORT);
		System.out.println("Begin:"+s);
		try{
			Socket socket=s.accept();
			try{
				System.out.println("Connection accepted:"+socket);
				BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
				while(true){
					String st=in.readLine();
					if(st.equals("END"))
						break;
					System.out.println("Recived:"+st);
					out.println("OK:");
				}
			}finally{
				System.out.println("closing...");
				socket.close();
			}
		}finally{
			s.close();
		}
	}

}
