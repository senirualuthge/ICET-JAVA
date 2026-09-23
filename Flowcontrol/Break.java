import java.util.*;
class Break{
	public static void main(String args[]){
		System.out.println("Start");
		for (int i = 0; i < 10; i++){
			System.out.println("i : "+i);
			if(i==5){
				break;
			}
		}
		System.out.println("End");
	}
}
    
