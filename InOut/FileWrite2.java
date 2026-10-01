import java.io.*;
class FileWrite2{
	public static void main(String[] args) {
		try{
			FileWriter fw=new FileWriter("Test.txt");
			fw.write("Hello java");
			//fw.flush(); 
			fw.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
}
