import java.sql.*;
class SqlSelect{
	public static void main(String[] args){
		String SQL="Select * from Student";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDB","root","12345");
			Statement stm=conn.createStatement();
			ResultSet rst=stm.executeQuery(SQL);
			while(rst.next()){
				System.out.println("ID: "+rst.getString("id")+", Name: "+rst.getString("name")+", Marks: "+rst.getInt("prfMarks")+",Marks:"+rst.getInt("dbmsMarks"));
			}
		}catch(ClassNotFoundException ex){
			System.out.println("Driver s/w not found...");
		}catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
	}
}

