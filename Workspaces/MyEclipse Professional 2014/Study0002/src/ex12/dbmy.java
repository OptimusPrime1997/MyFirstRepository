package ex12;
import java.sql.*;
public class dbmy {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	String url="jdbc:odbc:dbtest";
	Connection con;
	String ss="create tableѧ���ɼ�"+"������VARCHAR��32����"+"ѧ��INTEGER,"+"�ɼ�FLOAT,"+"ƽ��INTEGER)";
	String st="SELECT �������ɼ� FROM ѧ���ɼ�";
	Statement stmt;
	try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	}catch(java.lang.ClassNotFoundException e){
		System.err.print("ClassNotFoundException:");
		System.err.println(e.getMessage());
		System.err.println("cannot load driver");
	}
	try{
		con=DriverManager.getConnection(url,"test","pass");
		stmt=con.createStatement();
		stmt.executeUpdate(ss);
		stmt.executeUpdate("INSERT INTOѧ���ɼ�"+"VALUES('����',15,99.5,17)");
		stmt.executeUpdate("INSERT INTOѧ���ɼ�"+"VALUES('����',16,87,16)");
		stmt.executeUpdate("INSERT INTOѧ���ɼ�"+"VALUES('����',17,65.5,17)");
		ResultSet rs=stmt.executeQuery(st);
		System.out.println("���� �ɼ�");
		System.out.println("---------");
		while(rs.next()){
			String s=rs.getString("����");
			float n=rs.getFloat("�ɼ�");
			System.out.println(s+" "+n);
		}
		stmt.close();
		con.close();
	}catch(SQLException ex){
		System.err.println("SQLException:"+ex.getMessage());
	}
	}

}
