import java.util.*;

public class Task3 {
    public static String[] CusId = new String[0];
    public static int[] bill = new int[0];


    public static void Garray(String cid, int bills){
        String[] tempCusId  = new String[CusId.length +1];
        int[] tempbill  = new int[bill.length +1];

        for(int i=0;i<CusId.length;i++){ // fixed: was `1<CusId.length` (infinite loop)
            tempCusId[i] = CusId[i];
            tempbill[i] = bill[i];

        }
        tempCusId[tempCusId.length - 1] =cid;
        tempbill[tempbill.length - 1] =bills;

        CusId = tempCusId;
        bill = tempbill;

    }

    public static void Report (){
        for (int i = 0; i<CusId.length;i++){
            for(int j = i+1; j < CusId.length ; j++){
                if(CusId[i] .equals((CusId[j]))){
                    bill[i]= bill[i] + bill[j];

                    for(int x = j; x< CusId.length-1;x++){
                        CusId[x] = CusId[x+1];
                        bill[x] = bill[x+1]; // fixed: was `bill[j]` (wrong index variable)
                    }
                    CusId = java.util.Arrays.copyOf(CusId, CusId.length - 1); // fixed: shrink array after removing duplicate
                    bill = java.util.Arrays.copyOf(bill, bill.length - 1);
                    j--; // fixed: re-check index since shifted element needs to be compared
                }
            }
        }

        //bubble sorting
        for(int i = 0; i<bill.length -1 ;i++){
            for(int j = 0 ; j < bill.length -1 -i ;j++){
				if(bill[j] < bill[j+1]){
                    

                    //value swapping
                    String tempCusId=CusId[j];
                    CusId[j] = CusId[j+1];
                    CusId[j+1] = tempCusId;

                    int tempbill =bill[j];
                    bill[j] = bill[j+1];
                    bill[j+1] = tempbill;;


                }

			}
        }
        System.out.println();
        System.out.println("Customer Id \t\t| Total bill Value");
        System.out.println("-----------------------------------------");

        for(int i = 0; i < CusId.length ; i++){
            System.out.println(CusId[i]+"\t\t"+bill[i]);
        }

    }
    public static void main  (String args[]){
        Scanner input = new Scanner(System.in);
        boolean num=true;
        

        while(num){
            System.out.print("Enter Customer Id (Enter -1 to stop):");
            String CusId = input.nextLine();
            

            if(CusId.equals("-1")){
                num = false;
                break;

            }
            
            System.out.print("Enter Bill Value :");
            int bill = input.nextInt();
            input.nextLine(); // fixed: consume leftover newline to prevent InputMismatchException
            Garray(CusId, bill);


        }
        Report();


        input.close();
	}


}
