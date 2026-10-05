/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentMarkManagementMystem;

/**
 *
 * @author cs
 */
public class DBConnection {
    public static Connection getConnection(){
        class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDB", "root", "12345");
        
    }
    
}
