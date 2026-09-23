import java.util.*;

class Coursework2 {
    public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		System.out.println("====================================================================================================================");
		System.out.println(" _	     _   _                              _            _ __  __              _                               ");  
		System.out.println("\\ \\        / /  | |                            | |          (_)  \\/  |            | |                            "); 
		System.out.println(" \\ \\  /\\  / /__ | | ___ ___  _ __ ___   ___    | |_  ___     _| \\  / | __ _   _,__| |_                          ");
		System.out.println("  \\ \\/  \\/ /  _ \\ |/ __/ _ \\|' _~  _ \\/  _ \\   |  __/ _ \\   | | |\\/| |/  _~| |  __| __|                    ");
		System.out.println("   \\  /\\  /   __/ | (_| (_) | | | | | |  __/   |  || (_) |  | | |  | | (_) | | |  | |_                            ");
		System.out.println("    \\/  \\/ \\___ |_|\\__ \\___/|_| |_| |_|\\___|    \\__ \\___/   |_|_|  |_|\\__,_| |_|   \\__|                   ");
		System.out.println("====================================================================================================================");

		System.out.print("Enter Customer Phone number : ");
		String phone = input.nextLine();
		System.out.println("Customer Phone number: " + phone);
		System.out.print("Enter Customer Name : ");
		String name = input.nextLine();
		System.out.println("Customer Name: " + name);
		

		
        double basmathiPrice = 250.00;
        double dhalPrice     = 180.00;
        double sugarPrice    = 150.00;
        double highlandPrice = 1200.00;
        double yoghurtPrice  = 50.00;
        double flourPrice    = 120.00;
        double soapPrice     = 160.00;

        
        System.out.println("\nEnter quantities (0 if not purchasing):");

        int basmathi = readQuantity(input, "Basmathi", basmathiPrice);
        int dhal = readQuantity(input, "Dhal", dhalPrice);
        int sugar = readQuantity(input, "Sugar", sugarPrice);
        int highland = readQuantity(input, "Highland", highlandPrice);
        int yoghurt = readQuantity(input, "Yoghurt", yoghurtPrice);
        int flour = readQuantity(input, "Flour", flourPrice);
        int soap = readQuantity(input, "Soap", soapPrice);

      
        double basmathiTotal = basmathiPrice * basmathi;
        double dhalTotal     = dhalPrice     * dhal;
        double sugarTotal    = sugarPrice    * sugar;
        double highlandTotal = highlandPrice * highland;
        double yoghurtTotal  = yoghurtPrice  * yoghurt;
        double flourTotal    = flourPrice    * flour;
        double soapTotal     = soapPrice     * soap;

        double Total = basmathiTotal + dhalTotal + sugarTotal +
                    highlandTotal + yoghurtTotal + flourTotal + soapTotal;
            
      double discount   = Total * 0.10;
      double finalPrice = Total - discount;

		System.out.printf("| %-34s Rs.%.2f |\n","Total", Total);
       




 		System.out.println("+------------------------------------------------------------------------------------------------------------------+ \n\n");
        System.out.println("| \t\t  _   __  __               _             |");
        System.out.println("| \t\t (_) |  \\/  |             | |            |");
        System.out.println("| \t\t  _  | \\  / |  __ _  _ __ | |_           |");
        System.out.println("| \t\t | | | |\\/| | / _` || '__|| __|          |");
        System.out.println("| \t\t | | | |  | || (_| || |   | |_           |");
        System.out.println("| \t\t |_| |_|  |_| \\__,_||_|    \\__|          |");
        System.out.println("| \t\t  225,Galle Road,Panadura.                                        \n\n");
		
        System.out.println("+-------------------------------------------------------+" );
        System.out.printf ("|                      (#Name : %-22s)|\n", name);             
        System.out.printf ("|                      (#Tel  : %-22s)|\n", phone);
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|            | QTY |  Unit Price  |   Price             |");
        System.out.println("+-------------------------------------------------------+");
        System.out.printf ("| Basmathi       | %3d | Rs.%10.2f | Rs.%10.2f |\n", basmathi, basmathiPrice, basmathiTotal);   
        System.out.printf ("| Dhal           | %3d | Rs.%10.2f | Rs.%10.2f |\n", dhal, dhalPrice, dhalTotal);   
        System.out.printf ("| Sugar          | %3d | Rs.%10.2f | Rs.%10.2f |\n", sugar, sugarPrice, sugarTotal);   
        System.out.printf ("| Highland       | %3d | Rs.%10.2f | Rs.%10.2f |\n", highland, highlandPrice, highlandTotal);   
        System.out.printf ("| Yoghurt        | %3d | Rs.%10.2f | Rs.%10.2f |\n", yoghurt, yoghurtPrice, yoghurtTotal);   
        System.out.printf ("| Flour          | %3d | Rs.%10.2f | Rs.%10.2f |\n", flour, flourPrice, flourTotal);   
        System.out.printf ("| Soap           | %3d | Rs.%10.2f | Rs.%10.2f |\n", soap, soapPrice, soapTotal);   
        System.out.println("-----------------+-----+------------+------------------+");
        System.out.printf ("|                      |  Total     |   Rs.%10.2f  |\n", Total);        
        System.out.println("|                      +-------------------------------+");                            
        System.out.printf ("|                      | Discount(10%%)|   Rs.%10.2f  |\n", discount);
        System.out.println("|                      +-------------------------------+");                          
        System.out.printf ("|                      |Price         |   Rs.%10.2f  |\n", finalPrice);  
        System.out.println("+----------------------+-------------------------------+");                             

        // ---------------- change ----------------
        System.out.print("\nEnter cash given by customer : ");
        double cash = input.nextDouble();
        input.nextLine(); // consume leftover newline

        double change = cash - finalPrice;

        if (change < 0) {
            System.out.println("Insufficient cash. Amount short: Rs." + String.format("%.2f", -change));
            input.close();
            return;
        }

        System.out.println();
        System.out.println("+--------------+----------------+");
        System.out.printf ("| %-12s | %14.1f |\n", "Net Amount", finalPrice);
        System.out.println("+--------------+----------------+");
        System.out.printf ("| %-12s | %14.1f |\n", "Cash", cash);
        System.out.println("+--------------+----------------+");
        System.out.printf ("| %-12s | %14.0f |\n", "Change", change);
        System.out.println("+--------------+----------------+");

        // ---------------- Notes and Coins ----------------
        int remaining = (int) Math.round(change); // treat change as whole rupees

        int count5000 = remaining / 5000;
        remaining = remaining % 5000;

        int count2000 = remaining / 2000;
        remaining = remaining % 2000;

        int count1000 = remaining / 1000;
        remaining = remaining % 1000;

        int count500 = remaining / 500;
        remaining = remaining % 500;

        int count100 = remaining / 100;
        remaining = remaining % 100;

        int count50 = remaining / 50;
        remaining = remaining % 50;

        int count20 = remaining / 20;
        remaining = remaining % 20;

        int totalNotes = count5000 + count2000 + count1000 + count500 + count100 + count50 + count20;

        int count10 = remaining / 10;
        remaining = remaining % 10;

        int count5 = remaining / 5;
        remaining = remaining % 5;

        int count2 = remaining / 2;
        remaining = remaining % 2;

        int count1 = remaining / 1;
        remaining = remaining % 1;

        int totalCoins = count10 + count5 + count2 + count1;

        System.out.println();
        System.out.println("+-----------------+-------------+");
        System.out.printf ("| %-15s | %11s |\n", "Value", "No");
        System.out.println("+-----------------+-------------+");

        System.out.printf("| %-15s | %11d |\n", "Rs.5000", count5000);
        System.out.println("+-----------------+-------------+");
        System.out.printf("| %-15s | %11d |\n", "Rs.2000", count2000);
        System.out.println("+-----------------+-------------+");
        System.out.printf("| %-15s | %11d |\n", "Rs.1000", count1000);
        System.out.println("+-----------------+-------------+");
        System.out.printf("| %-15s | %11d |\n", "Rs.500", count500);
        System.out.println("+-----------------+-------------+");
        System.out.printf("| %-15s | %11d |\n", "Rs.100", count100);
        System.out.println("+-----------------+-------------+");
        System.out.printf("| %-15s | %11d |\n", "Rs.50", count50);
        System.out.println("+-----------------+-------------+");
        System.out.printf("| %-15s | %11d |\n", "Rs.20", count20);
        System.out.println("+-----------------+-------------+");
        System.out.printf("| %-15s | %11d |\n", "Rs.10", count10);
        System.out.println("+-----------------+-------------+");
        System.out.printf("| %-15s | %11d |\n", "Rs.5", count5);
        System.out.println("+-----------------+-------------+");
        System.out.printf("| %-15s | %11d |\n", "Rs.2", count2);
        System.out.println("+-----------------+-------------+");
        System.out.printf("| %-15s | %11d |\n", "Rs.1", count1);
        System.out.println("+-----------------+-------------+");

        System.out.printf("| %-15s | %11d |\n", "No of Notes", totalNotes);
        System.out.println("+-----------------+-------------+");
        System.out.printf("| %-15s | %11d |\n", "No of Coins", totalCoins);
        System.out.println("+-----------------+-------------+");

        System.out.println();
        System.out.println("-------------------------------------------------------------");
        System.out.println("                 THANK YOU FOR SHOPPING WITH US");
        System.out.println("-------------------------------------------------------------");

        input.close();
	}

    private static int readQuantity(Scanner input, String itemName, double unitPrice) {
        while (true) {
            System.out.printf("%s  (Rs.%.2f)  : ", itemName, unitPrice);
            String line = input.nextLine().trim();
            try {
                int quantity = Integer.parseInt(line);
                if (quantity < 0) {
                    System.out.println("Please enter 0 or a positive whole number.");
                    continue;
                }
                return quantity;
            } catch (NumberFormatException e) {
                System.out.println("Invalid entry. Please enter a whole number like 0, 1, 2, ...");
            }
        }
    }
}