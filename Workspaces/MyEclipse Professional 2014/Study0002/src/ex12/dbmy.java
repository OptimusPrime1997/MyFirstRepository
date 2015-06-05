package ex12;
import java.sql.*;
public class dbmy {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	String url="jdbc:odbc:dbtest";
	Connection con;
	String ss="create table学生成绩"+"（姓名VARCHAR（32），"+"学号INTEGER,"+"成绩FLOAT,"+"平均INTEGER)";
	String st="SELECT 姓名，成绩 FROM 学生成绩";
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
		stmt.executeUpdate("INSERT INTO学生成绩"+"VALUES('张三',15,99.5,17)");
		stmt.executeUpdate("INSERT INTO学生成绩"+"VALUES('李四',16,87,16)");
		stmt.executeUpdate("INSERT INTO学生成绩"+"VALUES('王五',17,65.5,17)");
		ResultSet rs=stmt.executeQuery(st);
		System.out.println("姓名 成绩");
		System.out.println("---------");
		while(rs.next()){
			String s=rs.getString("姓名");
			float n=rs.getFloat("成绩");
			System.out.println(s+" "+n);
		}
		stmt.close();
		con.close();
	}catch(SQLException ex){
		System.err.println("SQLException:"+ex.getMessage());
	}
	}

}
