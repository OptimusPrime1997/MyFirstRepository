package mypg;
import java.io.*;
public class InputData {
		private static String st;
		private static boolean err;
		public static float fRead(){
			BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
			err=false;
			do{
				System.out.flush();
				try{
					st=in.readLine();
				}catch(IOException e){
					System.out.println(e);
					System.exit(1);
				}
				if(st.length()==0)
					err=true;
				else 
					try{
						return Float.valueOf(st).floatValue();
					}catch(NumberFormatException e){
						System.out.println(e);
						System.out.println("请重新输入一个浮点数");
						err=true;						
					}
			}while(err);
			return Float.valueOf(st).floatValue();
		}
		public static int iRead(){
			BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
			err=false;
			do{
				System.out.flush();
				try{
					st=in.readLine();
				}catch(IOException e){
					System.out.println(e);
					System.exit(1);
				}
				if(st.length()==0)
					err=true;
				else 
					try{
						return Integer.valueOf(st).intValue();
					}catch(NumberFormatException e){
						System.out.println(e);
						System.out.println("请重新输入一个整数");
						err=true;						
					}
			}while(err);
			return Integer.valueOf(st).intValue();
		}
		
	}


