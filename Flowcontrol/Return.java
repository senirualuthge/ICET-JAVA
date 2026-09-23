import java.util.*;
class Return {
  
	public static void main(String args[]){
		System.out.println("Start");
		for (int i = 0; i < 10; i++){
			if(i==5){
				return;
			}
			System.out.println("i : "+i);
		}
		System.out.println("End");
	}
}

