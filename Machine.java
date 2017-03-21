import java.util.ArrayList;
import java.util.Scanner;

public class Machine  
{
    
    public static void main(String[] args) 
    {   
        boolean turnedOn = true;
        
        while (turnedOn)
        {
            switch(showMainMenu())
            {
                case 1: 
                    showCustomerMenuFor(insertWashCardNr());
                    break;
                case 2:
                    showRegisterMenu();
                    break;
                case 3:
                    turnedOn = false;
                    break;
            } // end switch
        } //end while

        Database db = new Database();
        CreditCard cc1 = new CreditCard(2000);
        CreditCard cc2 = new CreditCard(2000000);
        Customer jens = new Customer("Jens", "Jensen", cc1);
        Customer bent = new Customer("bent", "jansen", cc2);

        db.addCustomer(jens);
        db.addCustomer(bent);
        
        System.out.println(db.getCustomer("bent jansen"));

        db.getCustomer("Jens Jensen").buyWashCard(500);
        System.out.println(db.getCustomer("Jens Jensen"));
        db.getCustomer("Jens Jensen").refillWashCard(501);
        System.out.println(db.getCustomer("Jens Jensen"));
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
            choice = getInput();
            
        }
        return choice;
    }

    private static void showRegisterMenu()
    {
        int balanceChoice = 0;
        do
        {
            balanceChoice = 0;
            System.out.println("------Choose a starting balance------");
            for(int i = 1; i < 6; i++)
            {
                System.out.println(i + ". OPTION");
            }
            
            balanceChoice = getInput();         

        } while(balanceChoice != 1 
                && balanceChoice != 2 
                && balanceChoice != 3 
                && balanceChoice != 4 
                && balanceChoice != 5);
        System.out.println("saa valgte du noget");
        waitForEnter();   
    }

    public static int getInput()
    {
        Scanner input = new Scanner(System.in);                     
        int numberToReturn = input.nextInt();
        input.nextLine(); //fanger den nye linie der kommer ved et entertryk
        clearTerm();
        return numberToReturn;
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

    private static int insertWashCardNr()
    {
        //skriver, choose a card to insert
        //en Customer har kun et kort saa, vi kan bare skriver
        //for hver customer i customer arraylisten
          //skriv: placering objekt i arraylist + customerObjektsNavn
        //scan for nr
        //return det valgte nummer
        System.out.println("Et kort bliver nu brugt til at vaelge bruger.");
        waitForEnter();    
        return 1;
    }
}