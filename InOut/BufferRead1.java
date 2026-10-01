import java.io.*;
class BufferRead1{
	public static void main(String[] args) {
		try{
			File f1=new File("Demo.java");//Working directory
			try (BufferedReader br=new BufferedReader(new FileReader(f1))) {
				String line=br.readLine();
				while(line!=null){
					System.out.println(line);
					line=br.readLine();
				}
			}
		}catch(IOException ex){
			
		}
	}
}
