import java.sql.*;
class SqlUpdate{
	public static void main(String[] args){
		String SQL=" Update Student set prfMarks=99 where id='S0001'";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDB","root","12345");		
           	Statement stm=conn.createStatement();
			int res=stm.executeUpdate(SQL);
			if(res>0){
				System.out.println("Update Success...");
			}
		}catch(ClassNotFoundException ex){
			System.out.println("Driver s/w not found...");
		}catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
	}
}
