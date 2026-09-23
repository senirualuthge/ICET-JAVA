import java.util.*;
class Ex3i{
	public static void main(String[] args){
			try(Scanner input=new Scanner(System.in)){
			int[] dataArray=new int[0];
			System.out.print("Input an integer (press -1 to terminate) : ");
			int num=input.nextInt();
			int i=0;
			while(num!=-1){
				boolean isDuplicate=false;
				for(int j=0; j<dataArray.length;j++){
					if(dataArray[j]==num){
						isDuplicate=true;
						break;
					}
				}
				
				if(isDuplicate){
					System.out.println("Duplicate entry...");
				}else{
					int[] tempDataArray=new int[dataArray.length+1];
					for(int j=0; j<dataArray.length; j++){
						tempDataArray[j]=dataArray[j];
					}
					dataArray=tempDataArray;
					dataArray[i++]=num;
				}
				System.out.print("Input an integer (press -1 to terminate) : ");
				num=input.nextInt();
			}
			System.out.println(Arrays.toString(dataArray));
		}
	}
}



