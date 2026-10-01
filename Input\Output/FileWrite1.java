import java.io.*;
class FileWrite1{
	public static void main(String[] args) {
		try{
			FileWriter fw=new FileWriter("Test.txt");
			fw.write("Hello java");
			fw.close(); //fw.flush();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
}
