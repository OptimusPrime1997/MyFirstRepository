package ex6;
import javax.swing.JOptionPane;
public class PointTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point point=new Point(100,200);
		String output="X coordinate is"+point.getX()+"\nY coordinate is"+point.getY();
		point.setX(11);
		point.setY(22);
		output+="\n\nThe new location of point is"+point;
		JOptionPane.showMessageDialog(null, output);
		System.exit(0);
	}
		
}
