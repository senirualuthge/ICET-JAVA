import java.util.*;

public class PRFAssignment7 {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        q01();
        q02();
        q03();
        q04();
        q05();
        q06();
        q07();
        q08();
        q10();
        q11();
        q12();
        q13();
        q14();
        q15();
        q16();
        q17();
        q18();
        q19();
        q20();
        q24();
        q25();
        q26();
        q27();
        q28();
        q29();
        q30();
        q31();
        q32();
        q33();
        q34();
        q35();
        q36();
        q37();
        q38();
        q39();
        q40();
    }

    static void q01() {
        System.out.println("---- Q01 ----");
        int[] arr = new int[10];
        int[] values = { 12, 35, 47, 59, 62, 73, 81, 93, 111, 121 };
        for (int i = 0; i < values.length; i++) {
            arr[i] = values[i];
        }
        System.out.println(arr[0] + " " + arr[3] + " " + arr[5]);
    }

    static void q02() {
        System.out.println("---- Q02 ----");
        double[] averages = { 85.66, 78, 67.33, 57.66, 81, 91, 53.66, 61.66, 74.33, 79.33 };
        System.out.println("3rd student : " + averages[2]);
        System.out.println("7th student : " + averages[6]);
    }

    static void q03() {
        System.out.println("---- Q03 ----");
        int[] reserves = { 1625, 1748, 1900, 0, 1760, 1840, 0, 1690, 1850, 1780, 1820, 1700 };
        for (int r : reserves) {
            System.out.print(r + " ");
        }
        System.out.println();
        reserves[3] = 1812;
        reserves[6] = 1817;
        System.out.println("April : " + reserves[3]);
        System.out.println("July  : " + reserves[6]);
    }

    static void q04() {
        System.out.println("---- Q04 ----");
        String s = "Institute Of Computer Engineering Technology";
        char[] chars = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        String result = new String(chars);
        for (String word : result.split(" ")) {
            System.out.println(word);
        }
    }

    static void q05() {
        System.out.println("---- Q05 ----");
        int[] marks = { 56, 81, 43, 69, 93, 54, 48, 47, 51, 79, 82, 96, 57, 61, 66 };
        System.out.println("Number of marks : " + marks.length);
        for (int i = 0; i < 5; i++) {
            System.out.println(marks[i]);
        }
        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i] + " ");
        }
        System.out.println();
        for (int i = 9; i < marks.length; i++) {
            System.out.print(marks[i] + " ");
        }
        System.out.println();
    }

    static void q06() {
        System.out.println("---- Q06 ----");
        String[] days = new String[7];
        String[] week = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
        for (int i = 0; i < days.length; i++) {
            days[i] = week[i];
        }
        System.out.println(Arrays.toString(days));
        for (int i = days.length - 1; i >= 0; i--) {
            System.out.print(days[i] + " ");
        }
        System.out.println();
    }

    static void q07() {
        System.out.println("---- Q07 ----");
        String[] letters = { "A", "B", "C", "D", "E", "F", "G", "H", "I" };
        System.out.println(Arrays.toString(letters));
        for (int i = 0; i < letters.length; i++) {
            if (i % 2 == 0) {
                System.out.print(letters[i] + " ");
            }
        }
        System.out.println();
        for (int i = 0; i < letters.length; i++) {
            if (i % 2 == 1) {
                System.out.print(letters[i] + " ");
            }
        }
        System.out.println();
        for (int i = letters.length - 1; i >= 0; i--) {
            System.out.print(letters[i] + " ");
        }
        System.out.println();
    }

    static void q08() {
        System.out.println("---- Q08 ----");
        int[] rainfall = { 2346, 1945, 2060, 1781, 2365, 1005, 1162, 1016, 1512, 2231,
                1903, 12061, 1005, 1545, 2156, 2037, 1583, 3668 };
        System.out.println("Number of districts : " + rainfall.length);
        int more2000 = 0;
        int less1000 = 0;
        double sum = 0;
        for (int r : rainfall) {
            if (r > 2000) {
                more2000++;
            }
            if (r < 1000) {
                less1000++;
            }
            sum += r;
        }
        System.out.println("Districts > 2000mm : " + more2000);
        System.out.println("Districts < 1000mm : " + less1000);
        System.out.println("Average rainfall   : " + (sum / rainfall.length));
    }

    static void q10() {
        System.out.println("---- Q10 ----");
        int[] dice = { 6, 3, 3, 2, 4, 1, 6, 6, 2, 4 };
        int count3 = 0, count6 = 0, countOdd = 0;
        boolean rolled5 = false;
        for (int d : dice) {
            if (d == 3) {
                count3++;
            }
            if (d == 6) {
                count6++;
            }
            if (d % 2 == 1) {
                countOdd++;
            }
            if (d == 5) {
                rolled5 = true;
            }
        }
        System.out.println("Number of times 3 rolled : " + count3);
        System.out.println("Number of times 6 rolled : " + count6);
        System.out.println("Number of odd rolls      : " + countOdd);
        System.out.println("Was 5 rolled?            : " + rolled5);
    }

    static void q11() {
        System.out.println("---- Q11 ----");
        int[] xr = new int[3];
        System.out.println(xr[0] + " " + xr[1] + " " + xr[2]);
        char[] cr = new char[3];
        System.out.println("char default : [" + cr[0] + "|" + cr[1] + "|" + cr[2] + "]");
        boolean[] br = new boolean[3];
        System.out.println("boolean default : " + br[0] + " " + br[1] + " " + br[2]);
        double[] dr = new double[3];
        System.out.println("double default : " + dr[0] + " " + dr[1] + " " + dr[2]);
        String[] sr = new String[3];
        System.out.println("String default : " + sr[0] + " " + sr[1] + " " + sr[2]);
    }

    static void q12() {
        System.out.println("---- Q12 ----");
        int[] marks = new int[9];
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Enter mark " + (i + 1) + " : ");
            marks[i] = input.nextInt();
        }
        int total = 0, min = marks[0], max = marks[0];
        int count75 = 0, count45 = 0;
        boolean has100 = false;
        for (int m : marks) {
            total += m;
            if (m < min) {
                min = m;
            }
            if (m > max) {
                max = m;
            }
            if (m > 75) {
                count75++;
            }
            if (m < 45) {
                count45++;
            }
            if (m == 100) {
                has100 = true;
            }
        }
        System.out.println(Arrays.toString(marks));
        System.out.println("Total    : " + total);
        System.out.println("Average  : " + (total / 9.0));
        System.out.println("Minimum  : " + min);
        System.out.println("Maximum  : " + max);
        System.out.println("Marks > 75 : " + count75);
        System.out.println("Marks < 45 : " + count45);
        System.out.println("Got 100 in any subject? : " + has100);
    }

    static void q13() {
        System.out.println("---- Q13 ----");
        Random r = new Random();
        int[] numbers = new int[10];
        for (int i = 0; i < 10; i++) {
            numbers[i] = r.nextInt(101);
        }
        System.out.println(Arrays.toString(numbers));
    }

    static void q14() {
        System.out.println("---- Q14 ----");
        Random r = new Random();
        int[] marks = new int[20];
        int min = 101, pass = 0;
        boolean more90 = false;
        for (int i = 0; i < marks.length; i++) {
            marks[i] = r.nextInt(101);
            if (marks[i] < min) {
                min = marks[i];
            }
            if (marks[i] >= 50) {
                pass++;
            }
            if (marks[i] > 90) {
                more90 = true;
            }
        }
        System.out.println(Arrays.toString(marks));
        System.out.println("Minimum mark : " + min);
        System.out.println("Passed students : " + pass);
        System.out.println("Anyone got more than 90? : " + more90);
    }

    static void q15() {
        System.out.println("---- Q15 ----");
        System.out.print("Enter array size : ");
        int size = input.nextInt();
        int[] arr = new int[size];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100) + 1;
        }
        System.out.println(Arrays.toString(arr));
        int oddInOdd = 0;
        int max = arr[0], min = arr[0];
        boolean has100 = false;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 1 && arr[i] % 2 == 1) {
                oddInOdd++;
            }
            if (arr[i] == 100) {
                has100 = true;
            }
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Odd numbers in odd index : " + oddInOdd);
        System.out.println("Is 100 present? : " + has100);
        System.out.println("Max : " + max + " Min : " + min);
    }

    static void q16() {
        System.out.println("---- Q16 ----");
        int[] num = { 10, 20, 30, 40, 50, 60, 70 };
        System.out.println("Length : " + num.length);
        for (int i = 0; i < num.length; i++) {
            System.out.println("Element at index " + i + " is " + num[i]);
        }
    }

    static void q17() {
        System.out.println("---- Q17 ----");
        int[] arr = { 10, 20, 30, 40, 50, 60, 70 };
        int[] num = arr;
        System.out.println(Arrays.toString(num));
        System.out.println(Arrays.toString(arr));
        System.out.println("num == arr ??? " + (num == arr));
        System.out.println(arr);
        System.out.println(num);
    }

    static void q18() {
        System.out.println("---- Q18 ----");
        String[] month = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
        String[] arrMonth = new String[month.length];
        for (int i = 0; i < month.length; i++) {
            arrMonth[i] = month[i];
        }
        System.out.println(Arrays.toString(arrMonth));
        System.out.println("month == arrMonth ??? " + (month == arrMonth));
    }

    static void q19() {
        System.out.println("---- Q19 ----");
        Random r = new Random();
        int[] original = new int[50];
        int negatives = 0;
        for (int i = 0; i < original.length; i++) {
            original[i] = r.nextInt();
            if (original[i] < 0) {
                negatives++;
            }
        }
        int[] reversed = new int[50];
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        System.out.println("Original : " + Arrays.toString(original));
        System.out.println("Reversed : " + Arrays.toString(reversed));
        System.out.println("Probability of negative : " + negatives + "/50 = " + (negatives / 50.0));
    }

    static void q20() {
        System.out.println("---- Q20 ----");
        char[] vowels1 = { 'A', 'E', 'I', 'O', 'U' };
        char[] vowels2 = { 'a', 'e', 'i', 'o', 'u' };
        char[] merged = new char[vowels1.length + vowels2.length];
        for (int i = 0; i < vowels1.length; i++) {
            merged[i] = vowels1[i];
        }
        for (int i = 0; i < vowels2.length; i++) {
            merged[vowels1.length + i] = vowels2[i];
        }
        System.out.println(Arrays.toString(merged));
        char[] alternate = new char[10];
        for (int i = 0; i < 5; i++) {
            alternate[2 * i] = vowels1[i];
            alternate[2 * i + 1] = vowels2[i];
        }
        System.out.println(Arrays.toString(alternate));
        char[] reverse = new char[10];
        for (int i = 0; i < 5; i++) {
            reverse[2 * i] = vowels1[4 - i];
            reverse[2 * i + 1] = vowels2[4 - i];
        }
        System.out.println(Arrays.toString(reverse));
        char[] cross = { vowels1[0], vowels2[4], vowels1[1], vowels2[3], vowels1[2],
                vowels2[2], vowels1[3], vowels2[1], vowels1[4], vowels2[0] };
        System.out.println(Arrays.toString(cross));
    }

    static void q24() {
        System.out.println("---- Q24 ----");
        double[] salary = { 71, 86, 54, 89 };
        System.out.println(salary[0] + " " + salary[1] + " " + salary[2] + " " + salary[3]);
        for (int i = 0; i < salary.length; i++) {
            salary[i] += 5000;
        }
        System.out.println(salary[0] + " " + salary[1] + " " + salary[2] + " " + salary[3]);
    }

    static void q25() {
        System.out.println("---- Q25 ----");
        double[] usd = { 15000, 21000, 18500, 12275, 35550, 28760, 17175, 10500 };
        double[] lkr = new double[usd.length];
        final double rate = 366.10;
        for (int i = 0; i < usd.length; i++) {
            lkr[i] = usd[i] * rate;
        }
        int more = 0, less = 0;
        for (double s : lkr) {
            if (s > 7500000) {
                more++;
            } else {
                less++;
            }
        }
        double[] moreArr = new double[more];
        double[] lessArr = new double[less];
        int mi = 0, li = 0;
        for (double s : lkr) {
            if (s > 7500000) {
                moreArr[mi++] = s;
            } else {
                lessArr[li++] = s;
            }
        }
        System.out.println("Salaries in LKR : " + Arrays.toString(lkr));
        System.out.println("More than 7.5M  : " + more + " -> " + Arrays.toString(moreArr));
        System.out.println("Less than 7.5M  : " + less + " -> " + Arrays.toString(lessArr));
    }

    static void q26() {
        System.out.println("---- Q26 ----");
        int[] arr = { 96, 17, 54, 6, 81, 47, 63, 79, 32, 13 };
        for (int pass = 1; pass <= 3; pass++) {
            for (int j = 0; j < 3; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
        System.out.println("After 3 partial passes : " + Arrays.toString(arr));

        int[] arr2 = { 96, 17, 54, 6, 81, 47, 63, 79, 32, 13 };
        for (int i = 0; i < arr2.length - 1; i++) {
            for (int j = 0; j < arr2.length - 1 - i; j++) {
                if (arr2[j] > arr2[j + 1]) {
                    int t = arr2[j];
                    arr2[j] = arr2[j + 1];
                    arr2[j + 1] = t;
                }
            }
        }
        System.out.println("Correctly sorted : " + Arrays.toString(arr2));
    }

    static void q27() {
        System.out.println("---- Q27 ----");
        double[] usd = { 15000, 21000, 18500, 12275, 35550, 28760, 17175, 10500 };
        for (int i = 0; i < usd.length - 1; i++) {
            for (int j = 0; j < usd.length - 1 - i; j++) {
                if (usd[j] > usd[j + 1]) {
                    double t = usd[j];
                    usd[j] = usd[j + 1];
                    usd[j + 1] = t;
                }
            }
        }
        System.out.println("Dollar salaries sorted : " + Arrays.toString(usd));
    }

    static void q28() {
        System.out.println("---- Q28 ----");
        int[] arr = { 10, 20, 30, 40 };
        System.out.println("Input array  : " + Arrays.toString(arr));
        System.out.print("Enter index to replace : ");
        int idx = input.nextInt();
        System.out.print("Enter replace value : ");
        int val = input.nextInt();
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        newArr[idx] = val;
        System.out.println("New array    : " + Arrays.toString(newArr));
        System.out.println("Previous array : " + Arrays.toString(arr));
    }

    static void q29() {
        System.out.println("---- Q29 ----");
        String[] subjects = { "Mathematics", "Science", "English", "Sinhala", "History",
                "Buddhisum", "Business Studies", "Computer Studies" };
        int position = 7;
        String[] newSubjects = new String[subjects.length + 1];
        for (int i = 0; i < position; i++) {
            newSubjects[i] = subjects[i];
        }
        newSubjects[position] = "Music";
        for (int i = position; i < subjects.length; i++) {
            newSubjects[i + 1] = subjects[i];
        }
        subjects = newSubjects;
        System.out.println(Arrays.toString(subjects));
    }

    static void q30() {
        System.out.println("---- Q30 ----");
        String[] month = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
        int[] reserves = { 1625, 1748, 1900, 1812, 1760, 1840, 1817, 1690, 1850, 1780, 1820, 1700 };
        String[] newMonth = new String[month.length];
        int[] newReserves = new int[reserves.length];
        for (int i = 0; i < month.length; i++) {
            newMonth[i] = month[i];
            newReserves[i] = reserves[i];
        }
        System.out.println("Month order : ");
        for (int i = 0; i < newMonth.length; i++) {
            System.out.println(newMonth[i] + " - " + newReserves[i]);
        }
        String[] dMonth = new String[newMonth.length];
        int[] dReserves = new int[newReserves.length];
        for (int i = 0; i < newReserves.length; i++) {
            dMonth[i] = newMonth[i];
            dReserves[i] = newReserves[i];
        }
        for (int i = 0; i < dReserves.length - 1; i++) {
            for (int j = 0; j < dReserves.length - 1 - i; j++) {
                if (dReserves[j] < dReserves[j + 1]) {
                    int t = dReserves[j];
                    dReserves[j] = dReserves[j + 1];
                    dReserves[j + 1] = t;
                    String ts = dMonth[j];
                    dMonth[j] = dMonth[j + 1];
                    dMonth[j + 1] = ts;
                }
            }
        }
        System.out.println("Descending order of reserves : ");
        for (int i = 0; i < dMonth.length; i++) {
            System.out.println(dMonth[i] + " - " + dReserves[i]);
        }
    }

    static void q31() {
        System.out.println("---- Q31 ----");
        String[] names = { "Sachini", "Tharusha", "Shehan", "Ashini", "Sachin",
                "Kasun", "Lihini", "Hashini", "Ashini", "Kaveesha" };
        int[] marks = { 807, 796, 728, 801, 818, 746, 781, 756, 801, 812 };
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + " - " + marks[i]);
        }
        String[] newNames = new String[names.length + 1];
        for (int i = 0; i < names.length; i++) {
            newNames[i] = names[i];
        }
        newNames[names.length] = "Amesh";
        names = newNames;
        System.out.println("After adding Amesh : ");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + " - " + marks[i]);
        }
        int n = names.length;
        String[] uniqueNames = new String[n];
        int[] uniqueMarks = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            boolean dup = false;
            for (int j = 0; j < count; j++) {
                if (uniqueNames[j].equals(names[i])) {
                    dup = true;
                    break;
                }
            }
            if (!dup) {
                uniqueNames[count] = names[i];
                uniqueMarks[count] = marks[i];
                count++;
            }
        }
        System.out.println("After removing duplicates : ");
        for (int i = 0; i < count; i++) {
            System.out.println(uniqueNames[i] + " - " + uniqueMarks[i]);
        }
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - 1 - i; j++) {
                if (uniqueMarks[j] < uniqueMarks[j + 1]) {
                    int t = uniqueMarks[j];
                    uniqueMarks[j] = uniqueMarks[j + 1];
                    uniqueMarks[j + 1] = t;
                    String ts = uniqueNames[j];
                    uniqueNames[j] = uniqueNames[j + 1];
                    uniqueNames[j + 1] = ts;
                }
            }
        }
        System.out.println("Descending order of marks : ");
        for (int i = 0; i < count; i++) {
            System.out.println(uniqueNames[i] + " - " + uniqueMarks[i]);
        }
    }

    static void q32() {
        System.out.println("---- Q32 ----");
        int[] arr = { 10, 20, 30, 40, 50, 60, 70 };
        int first = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = first;
        System.out.println(Arrays.toString(arr));
    }

    static void q33() {
        System.out.println("---- Q33 ----");
        int[] binary = { 1, 0, 1, 0, 0, 1, 0, 1, 0, 0 };
        int count0 = 0;
        for (int b : binary) {
            if (b == 0) {
                count0++;
            }
        }
        for (int i = 0; i < binary.length; i++) {
            if (i < count0) {
                binary[i] = 0;
            } else {
                binary[i] = 1;
            }
        }
        System.out.println("Sorted binary array : " + Arrays.toString(binary));
    }

    static void q34() {
        System.out.println("---- Q34 ----");
        String[] countries = { "Switzerland(2)", "Ivory Coast(1)", "Jamaica(2)", "United States(1)",
                "United States(2)", "Great Britain", "Ivory Coast(2)", "Jamaica(3)",
                "Switzerland(1)", "Jamaica(1)" };
        double[] times = { 11.11, 10.86, 10.76, 10.98, 11.11, 11.05, 11.14, 10.61, 11.06, 10.74 };
        int gold = 0;
        for (int i = 1; i < times.length; i++) {
            if (times[i] < times[gold]) {
                gold = i;
            }
        }
        System.out.println("Gold medal 2021 : " + countries[gold] + " - " + times[gold] + "s");
        int silver = -1;
        double second = Double.MAX_VALUE;
        for (int i = 0; i < times.length; i++) {
            if (i != gold && times[i] < second) {
                second = times[i];
                silver = i;
            }
        }
        System.out.println("New gold medal (2nd place) : " + countries[silver] + " - " + times[silver] + "s");
        int[] order = new int[times.length - 1];
        int idx = 0;
        for (int i = 0; i < times.length; i++) {
            if (i != gold) {
                order[idx++] = i;
            }
        }
        for (int i = 0; i < order.length - 1; i++) {
            for (int j = 0; j < order.length - 1 - i; j++) {
                if (times[order[j]] > times[order[j + 1]]) {
                    int t = order[j];
                    order[j] = order[j + 1];
                    order[j + 1] = t;
                }
            }
        }
        System.out.println("List after removing 2021 gold medal (ascending time) : ");
        for (int i : order) {
            System.out.println(countries[i] + " - " + times[i] + "s");
        }
    }

    static void q35() {
        System.out.println("---- Q35 ----");
        int[] ar = { 10, 20, 30, 40, 50 };
        int[] br = { 10, 20, 10, 40, 50, 60 };
        int[] cr = { 30, 30, 30, 30 };
        int[] dr = { 40, 10, 50, 20, 30 };
        int[] er = { 10, 20, 30, 40, 50 };
        int[] fr = { 10, 20, 30, 40 };
        findDuplicate(ar);
        findDuplicate(br);
        findDuplicate(cr);
        findDuplicate(dr);
        findDuplicate(er);
        findDuplicate(fr);
        System.out.println("ar==br : " + equals(ar, br));
        System.out.println("ar==cr : " + equals(ar, cr));
        System.out.println("ar==dr : " + equals(ar, dr));
        System.out.println("ar==er : " + equals(ar, er));
        System.out.println("ar==fr : " + equals(ar, fr));
    }

    static void findDuplicate(int[] arr) {
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println("duplicate \"" + arr[i] + "\"");
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("no duplicate");
        }
    }

    static boolean equals(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    static void q36() {
        System.out.println("---- Q36 ----");
        String[] cricket = { "Shanaka", "Dinesh", "Amesh", "Lahiru", "Dilshan", "Hashan",
                "Wenura", "Randika", "Dasun", "Thisara", "Kasun", "Nisal", "Praveen" };
        String[] football = { "Anjana", "Chamara", "Kamal", "Dhanuka", "Shanaka", "Kasun",
                "Dineth", "Sahan", "Wenura", "Amesh", "Mahesh", "Randika", "Thisara" };
        System.out.println("Both cricket and football : ");
        for (String c : cricket) {
            for (String f : football) {
                if (c.equals(f)) {
                    System.out.println(c);
                    break;
                }
            }
        }
        System.out.println("Cricket or football (no duplicates) : ");
        String[] all = new String[cricket.length + football.length];
        int count = 0;
        for (String c : cricket) {
            all[count++] = c;
        }
        for (String f : football) {
            boolean dup = false;
            for (int i = 0; i < count; i++) {
                if (all[i].equals(f)) {
                    dup = true;
                    break;
                }
            }
            if (!dup) {
                all[count++] = f;
            }
        }
        for (int i = 0; i < count; i++) {
            System.out.println(all[i]);
        }
    }

    static void q37() {
        System.out.println("---- Q37 ----");
        System.out.print("Enter a String : ");
        String s = input.next();
        char[] chars = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        System.out.println(Arrays.toString(chars));
    }

    static void q38() {
        System.out.println("---- Q38 ----");
        for (int x = 1;; x++) {
            char[] base = sortedDigits(x);
            boolean same = true;
            for (int mult = 2; mult <= 6; mult++) {
                if (!Arrays.equals(base, sortedDigits(x * mult))) {
                    same = false;
                    break;
                }
            }
            if (same) {
                System.out.println("Smallest x = " + x);
                for (int mult = 1; mult <= 6; mult++) {
                    System.out.println(mult + "x = " + (x * mult));
                }
                break;
            }
        }
    }

    static char[] sortedDigits(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        Arrays.sort(digits);
        return digits;
    }

    static void q39() {
        System.out.println("---- Q39 ----");
        int[] admissionNumbers = new int[10];
        int count = 0;
        boolean running = true;
        while (running) {
            System.out.print("Enter admission number : ");
            int num = input.nextInt();
            boolean duplicate = false;
            for (int i = 0; i < count; i++) {
                if (admissionNumbers[i] == num) {
                    duplicate = true;
                    break;
                }
            }
            if (duplicate) {
                System.out.println("Duplicate Admission number...");
                System.out.print("Enter another? (y/n) : ");
                String choice = input.next();
                if (!choice.equalsIgnoreCase("y")) {
                    running = false;
                }
            } else {
                admissionNumbers[count++] = num;
                System.out.println("Enter student name : ");
                String name = input.next();
            }
        }
    }

    static void q40() {
        System.out.println("---- Q40 ----");
        int[] selected = new int[100];
        int count = 0;
        while (true) {
            System.out.print("Enter clothing ID (-1 to stop) : ");
            int id = input.nextInt();
            if (id == -1) {
                break;
            }
            if (id < 1 || id > 1000) {
                System.out.println("Invalid ID. Must be between 1 and 1000.");
                continue;
            }
            boolean duplicate = false;
            for (int i = 0; i < count; i++) {
                if (selected[i] == id) {
                    duplicate = true;
                    break;
                }
            }
            if (duplicate) {
                System.out.println("Duplicate element. Not added.");
            } else {
                selected[count++] = id;
            }
        }
        int[] finalArray = Arrays.copyOf(selected, count);
        System.out.println("Selected clothing IDs : " + Arrays.toString(finalArray));
    }
}
