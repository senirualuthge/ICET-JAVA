/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentMarkManagementMystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
class StudentController {

    public static boolean addNewStudent(Student student) throws ClassNotFoundException, SQLException {
        String SQL = "Insert into Student values('" + student.getId() + "','" + student.getName() + "'," + student.getPrfMarks() + "," + student.getDbmsMarks() + ")";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDB", "root", "12345");
        Statement stm = conn.createStatement();
        int res = stm.executeUpdate(SQL);
        return res > 0;
    }

    public static String getNewStudentId() throws ClassNotFoundException, SQLException {
        String SQL = "select id from Student order by id desc limit 1";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDB", "root", "12345");
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(SQL);
        if (rst.next()) {
            int lastStudentIdNo = Integer.parseInt(rst.getString("id").substring(1));//0001
            return String.format("S%04d", lastStudentIdNo + 1);
        }
        return "S0001";
    }

    public static Student searchStudent(String id) throws FileNotFoundException {
        Scanner input = new Scanner(new File("Student.txt"));
        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line.substring(0, 5).equalsIgnoreCase(id)) {
                String[] rowData = line.split(",");
                return new Student(rowData[0], rowData[1], Integer.parseInt(rowData[2]), Integer.parseInt(rowData[3]));
            }
        }
        return null;
    }

    public static boolean deleteStudent(String id) throws FileNotFoundException, IOException {
        if (searchStudent(id) != null) {
            File oldFile = new File("Student.txt");
            File tempFile = new File("TempFile.txt");
            Scanner input = new Scanner(oldFile);
            FileWriter fw = new FileWriter(tempFile, true);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                if (!line.substring(0, 5).equalsIgnoreCase(id)) {
                    fw.write(line + "\n");
                }
            }
            input.close();
            fw.close();
            oldFile.delete();
            try {
                Thread.sleep(7000);
            } catch (Exception ex) {
            }
            File newFile = new File("Student.txt");
            FileWriter newFileWriter = new FileWriter(newFile, true);
            input = new Scanner(tempFile);
            while (input.hasNextLine()) {
                newFileWriter.write(input.nextLine() + "\n");
            }
            newFileWriter.close();
            input.close();
            tempFile.delete();
            return true;
        }
        return false;
    }

    public static boolean updateStudent(Student student) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static Student[] getAllStudent() throws ClassNotFoundException, SQLException {
        String Sql = "Select * from Student";
        Student[] studentArray = new Student[0];

        //The connection comes from the DBConnection singleton and is shared, so it
        //is deliberately left open; only the statement and result set are closed.
        Connection connection = DBConnection.getInstance().getConnection();
        try (Statement stm = connection.createStatement();
                ResultSet rst = stm.executeQuery(Sql)) {
            while (rst.next()) {
                Student student = new Student(rst.getString("id"), rst.getString("name"),
                        rst.getInt("PRFMarks"), rst.getInt("DBMSMarks"));
                Student[] tempStudentArray = new Student[studentArray.length + 1];
                for (int i = 0; i < studentArray.length; i++) {
                    tempStudentArray[i] = studentArray[i];
                }
                tempStudentArray[tempStudentArray.length - 1] = student;
                studentArray = tempStudentArray;
            }
        }
        return studentArray;
    }
}
