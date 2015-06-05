package ex12;
import java.net.*;
import java.io.*;
public class ex12_4 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		URL MyUrl=new URL("http://www.baidu.com");
		BufferedReader in=new BufferedReader(new InputStreamReader(MyUrl.openStream()));
		String inputLine;
		while((inputLine=in.readLine())!=null)
			System.out.println(inputLine);
		in.close();
	}

}
