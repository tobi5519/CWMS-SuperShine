import java.util.ArrayList;
import java.util.Scanner;

public class Machine  
{
    
    public static void main(String[] args) 
    {   
        Database db = new Database();
        CreditCard cc1 = new CreditCard(2000);
        CreditCard cc2 = new CreditCard(2000000);

        db.addCustomer("Jens", "Jensen", 2000, 200);
        db.addCustomer("bent", "jansen", 20000000, 500);
        
        // System.out.println(db.getCustomer("bent jansen"));

        // db.getCustomer("Jens Jensen").buyWashCard(500);
        // System.out.println(db.getCustomer("Jens Jensen"));
        // db.getCustomer("Jens Jensen").refillWashCard(501);
        // System.out.println(db.getCustomer("Jens Jensen"));
        boolean turnedOn = true;
        
        while (turnedOn)
        {
            switch(showMainMenu())
            {
                case 1: // login
                    showCustomerMenuFor(insertWashCardNr(db));
                    break;
                case 2: // new user
                    showRegisterMenu(db);
                    break;
                case 3:
                    turnedOn = false;
                    break;
            } // end switch
        } //end while

        
    } // end of main

    public static int showMainMenu()
    {
        int choice = 0;
        
        while(choice != 1 && choice != 2 && choice != 3)
        {
            clearTerm();   
            System.out.println("-----------Main Menu----------");
            
            System.out.println("1. Login");
            System.out.println("2. New User");
            System.out.println("3. QUIT");
            choice = getInt();
            
        }
        return choice;
    }

    private static void showRegisterMenu(Database db)
    {
        String firstName;
        String lastName;
        double ccAmount;
        double wcAmount;

        System.out.print("Please Insert First Name: ");
        firstName = getString();
        System.out.print("Please Insert Last Name: ");
        lastName = getString();
        System.out.print("Please Wish for magic creditcard! <3 \nWhat balance would you like to have on it?: ");
        ccAmount = getDouble();
        Customer currentCustomer = db.addCustomer(firstName, lastName, ccAmount);

        System.out.print("Would you like a WashCard with that? (y/n): ");
        
        if(getString().equalsIgnoreCase("y"))
        {
            System.out.println("With what amount? ");
            System.out.print("200 - 1000kr: ");

            wcAmount = getDouble();
            currentCustomer.buyWashCard(wcAmount);
            // System.out.println(" wcAmount: " + wcAmount + "\n firstName: " + firstName + "\n lastName: " + lastName);
            // System.out.println(currentCustomer);
            waitForEnter();
        }
        else
        {
            System.out.println("oki doki, du er nu oprettet UDEN WashCard");
            db.addCustomer(firstName, lastName, ccAmount);
        }
    }

    public static int getInt()
    {
        Scanner input = new Scanner(System.in);                     
        int numberToReturn = input.nextInt();
        input.nextLine(); //fanger den nye linie der kommer ved et entertryk
        clearTerm();
        return numberToReturn;
    }

    public static double getDouble()
    {
        Scanner input = new Scanner(System.in);                     
        double numberToReturn = input.nextDouble();
        input.nextLine(); //fanger den nye linie der kommer ved et entertryk
        clearTerm();
        return numberToReturn;
    }

    public static String getString()
    {
        Scanner input = new Scanner(System.in);                     
        String stringToReturn = input.next();
        input.nextLine(); //fanger den nye linie der kommer ved et entertryk
        clearTerm();
        return stringToReturn;
    }
    
    private static void waitForEnter()
    {
        Scanner input = new Scanner(System.in);                     
        input.nextLine(); //fanger den nye linie der kommer ved et entertryk
        clearTerm();        
    }

    public static void clearTerm()
    {
        for (int i = 0; i < 45; i++)
            {
                System.out.println("");
            }
    }

    private static void showCustomerMenuFor(int cardNr)
    {
        System.out.println("Har logget en bruger ind med WashCard nr: " + cardNr);
        waitForEnter();
    }

    private static int insertWashCardNr(Database db)
    {
        System.out.println("Choose a card to insert");
        db.printAllCustomers();
        System.out.println("Et kort bliver nu brugt til at vaelge bruger.");
        waitForEnter();    
        return 1;
    }
}