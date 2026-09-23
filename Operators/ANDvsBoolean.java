import java.util.*;
public class ANDvsBoolean {
	public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		int x=4,y=5,z=5; 
		System.out.println(x+" "+y+" "+z); //4 5 5
		if(x++==5 && y++==5 && z++==5){ //Short Circuit Boolean AND (&&)
			//task
		}
		System.out.println(x+" "+y+" "+z); //5 5 5
        input.close();
	}
}
  


