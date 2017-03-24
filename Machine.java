// import java.util.ArrayList;
// import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.text.*;


public class Machine  
{
    public static void main(String[] args) 
    {   
        Database db = new Database();
        CreditCard cc1 = new CreditCard(2000);
        CreditCard cc2 = new CreditCard(2000000);
        

        db.addCustomer("Jens", "Jensen", 1100, 200);
        db.addCustomer("bent", "jansen", 20000000, 500);
        db.addCarWash("Greywash", 50);
        db.addCarWash("Whitewash", 100);
        db.addCarWash("Clearwash", 500);

        boolean turnedOn = true;
        
        while (turnedOn)
        {
            switch(showMainMenu())
            {
                case 1: // login
                    showCustomerMenu(chooseCustomer(db), db);
                    break;
                case 2: // new user
                    showRegisterMenu(db);
                    break;
                case 3:
                    db.stats();
                    waitForEnter();
                    break;
                case 4:
                    turnedOn = false;
                    break;
            } // end switch
        } //end while

        
    } // end of main

    public static int showMainMenu()
    {
        int choice = 0;
        
        while(choice != 1 && choice != 2 && choice != 3 && choice != 4)
        {
            clearTerm();   
            System.out.println("-----------Main Menu----------");
            System.out.println("1: Login");
            System.out.println("2: New User");
            System.out.println("3: Stats");
            System.out.println("4: QUIT");
            System.out.println("------------------------------");
            System.out.print("Choice: ");
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
        }
        else
        {
            System.out.println("You have been registered without a washcard");
            db.addCustomer(firstName, lastName, ccAmount);
            waitForEnter();
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
        try { 
            Process p = Runtime.getRuntime().exec("clear"); 
            BufferedReader in = new BufferedReader( 
                                new InputStreamReader(p.getInputStream())); 
            String line = null; 
            while ((line = in.readLine()) != null) { 
                System.out.println(line); 
            } 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
    }

    private static void showCustomerMenu(Customer thisCustomer, Database db)
    {
        int choice = 0;

        while(choice != 3)
        {   
            clearTerm();
            System.out.println("Customer Menu for: " + thisCustomer.getName());
            System.out.println("Your balance is: " + thisCustomer.getWashCard().getBalance());
            System.out.println("1. Buy Carwash.");
            System.out.println("2. Refill Washcard");
            System.out.println("3. Return to Main Menu.");
            choice = getInt();
            
            switch(choice)
            {
                case 1:

                    CarWash carWash = chooseCarWash(db); 
                    if(thisCustomer.getWashCard().buyCarWash(carWash))
                    {
                        System.out.print("Would you like a receipt? (y/n): ");
                        db.addReceipt(getDate(), thisCustomer, carWash, carWash.getPrice());
                        if(getString().equalsIgnoreCase("y"))
                        {
                            System.out.println(db.getReceipt(db.receiptList.size()-1));
                        }
                    }
                    waitForEnter();
                    break;
                
                case 2:
                    System.out.println("With what amount? ");
                    System.out.print("200 - 1000kr: ");
                    if( !(thisCustomer.refillWashCard(getDouble() ) ) )
                    {
                        waitForEnter();
                    }
                    break;
            }
        }
    }

    private static Customer chooseCustomer(Database db)
    {
        System.out.println("Choose a card to insert");
        db.printAllCustomers();
        System.out.print("Choice: ");
        return db.getCustomer(getInt());
    }

    private static CarWash chooseCarWash(Database db)
    {
        System.out.println("What wash would you like?");
        db.printAllCarWash();
        System.out.println("Choice: ");
        return db.getCarWash(getInt());
    }

    public static String getDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }
}