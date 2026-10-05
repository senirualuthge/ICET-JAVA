import java.sql.*;
class Sql2{
	public static void main(String[] args){
		String SQL="Insert into Student values('S0005','Lakmal',87,34)";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDB","root","12345");
			Statement stm=conn.createStatement();
			stm.executeUpdate(SQL);
		}catch(ClassNotFoundException ex){
			System.out.println("Driver s/w not found...");
		}catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
	}
}
