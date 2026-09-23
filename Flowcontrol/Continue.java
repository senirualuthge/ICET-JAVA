import java.util.*;
 class Continue {
    
	public static void main(String args[]){
		System.out.println("Start");
		for (int i = 0; i < 10; i++){
			if(i%2==0){
				continue;
			}
			System.out.println("i : "+i);
		}
		System.out.println("End");
	    }
    }

