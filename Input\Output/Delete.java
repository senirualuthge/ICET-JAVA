import java.io.*;
class Delete{
	public static void main(String[] args) {
		try{
			File f1=new File("Test.txt");//absolute path
			FileWriter fw=new FileWriter(f1,true);
			fw.write("Hello java"+"\n");
			//fw.flush(); 
			fw.close();
			Thread.sleep(5000);
			f1.delete();
		}catch(IOException ex){
			ex.printStackTrace();
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
	}
}
