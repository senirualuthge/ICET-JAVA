import java.util.*;

class Example {
    public static int[] dataArray = new int[0];

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Input an integer (press -1 to terminate) : ");
            int num = input.nextInt();
            int i = 0;

            while (num != -1) {
                if (isDuplicate(num)) {
                    System.out.println("Duplicate entry...");
                } else {
                    extendsDataArray();
                    dataArray[i++] = num;
                }
                System.out.print("Input an integer (press -1 to terminate) : ");
                num = input.nextInt();
            }
            System.out.println(Arrays.toString(dataArray));
        }
    }

    public static void extendsDataArray() {
        int[] tempDataArray = new int[dataArray.length + 1];
        for (int j = 0; j < dataArray.length; j++) {
            tempDataArray[j] = dataArray[j];
        }
        dataArray = tempDataArray;
    }

    public static boolean isDuplicate(int num) {
        for (int i = 0; i < dataArray.length; i++) {
            if (dataArray[i] == num) {
                return true;
            }
        }
        return false;
    }
}






