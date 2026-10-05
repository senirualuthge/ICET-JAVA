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

/**
 *
 * @author pc
 */
class StudentController {

    public static boolean addNewStudent(Student student) throws IOException {
        FileWriter fw=new FileWriter("Student.txt",true); //appendable
        fw.write(student.toString()+"\n");
        fw.close();
        return  true;
    }

    public static String getNewStudentId() throws FileNotFoundException {
        Scanner input=new Scanner(new File("Student.txt"));
        String line=null;
        while(input.hasNextLine()){
            line=input.nextLine();
        }
        if(line==null){
            return "S0001";
        }else{
            int lastStudentIdNo=Integer.parseInt(line.substring(1, 5));//0001
            return String.format("S%04d", lastStudentIdNo+1);
        }
    }

    public static Student searchStudent(String id) throws FileNotFoundException {
        Scanner input=new Scanner(new File("Student.txt"));
        while(input.hasNextLine()){
            String line=input.nextLine();
            if(line.substring(0, 5).equalsIgnoreCase(id)){
                String[] rowData=line.split(",");
                return new Student(rowData[0],rowData[1],Integer.parseInt(rowData[2]),Integer.parseInt(rowData[3]));
            }
        }
        return null;
    }

    public static boolean deleteStudent(String id) throws FileNotFoundException, IOException {
        if(searchStudent(id)!=null){
            File oldFile=new File("Student.txt");
            File tempFile=new File("TempFile.txt");
            Scanner input=new Scanner(oldFile);
            FileWriter fw=new FileWriter(tempFile,true);
            while(input.hasNextLine()){
                String line=input.nextLine();
                if(!line.substring(0, 5).equalsIgnoreCase(id)){
                   fw.write(line+"\n");
                }
            }
            input.close();
            fw.close();
            oldFile.delete();
            try{
                Thread.sleep(7000);
            }catch(Exception ex){}
            File newFile=new File("Student.txt");
            FileWriter newFileWriter=new FileWriter(newFile,true);
            input=new Scanner(tempFile);
            while(input.hasNextLine()){
                newFileWriter.write(input.nextLine()+"\n");
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

    public static Student[] getAllStudent() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
