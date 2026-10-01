import java.io.*;
import java.util.*;
class Student2{
	private String id;
	private String name;
	private int prfMarks;
	private int dbmsMarks;
	
	public Student2(String id, String name, int prfMarks, int dbmsMarks){
		this.id=id;
		this.name=name;
		this.prfMarks=prfMarks;
		this.dbmsMarks=dbmsMarks;
	}
	public String toString(){
		return id+"\t"+name+"\t"+prfMarks+"\t"+dbmsMarks;
	}
	public String getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	
	public int getPrfMarks(){
		return prfMarks;
	}
	public int getDbmsMarks(){
		return dbmsMarks;
	}
}

class Scanner2{
	public static void main(String[] args)throws IOException {
		File f1=new File("samre.txt");
		java.util.Scanner input = new java.util.Scanner(f1);
		while(input.hasNextLine()){
			String line=input.nextLine();
			String[] rowData=line.split(",");
			String id=rowData[0];
			String name=rowData[1];
			int prfMarks=Integer.parseInt(rowData[2]);
			int dbmsMarks=Integer.parseInt(rowData[3]);
		
			Student2 s1=new Student2(id,name,prfMarks,dbmsMarks);
			System.out.println(s1.toString());
		}
		input.close();
	}
}

