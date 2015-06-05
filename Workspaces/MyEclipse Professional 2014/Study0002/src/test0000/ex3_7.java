package test0000;
import mypg.InputData;
public class ex3_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please Input month:");
		int m=InputData.iRead();
		String s=" ";
		switch(m){
		case 12:
		case 1:
		case 2:s="winter";break;
		case 3:
		case 4:
		case 5:s="spring";break;
		case 6:
		case 7:
		case 8:s="summer";break;
		case 9:
		case 10:
		case 11:s="autumn";break;
		}
		System.out.println(m+" month is "+s);
	}

}
