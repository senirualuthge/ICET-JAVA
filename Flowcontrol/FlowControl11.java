import java.util.*;
class FlowControl11{
	public static void main(String args[]){
		for(int i=0,j=10; i<10; i++,j--){
			System.out.println(i+" "+j);
		}
        for(int i=0,j=10; i<j; i++,j--){
			System.out.println(i+" "+j);
        }

	}
}
