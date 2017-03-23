public class Customer
{
     private String firstName;
     private String lastName;
     private WashCard washCard;
     private CreditCard creditCard;
     private int customerID;
     
     //for creation of a new customer in the menu
     public Customer(String firstName, String lastName, CreditCard creditCard, int customerID) 
     {
          this.firstName = firstName;
          this.lastName = lastName;
          this.creditCard = creditCard;
          this.customerID = customerID;
     }

     //for preloading of "already existing" customers..
     public Customer(String firstName, String lastName, CreditCard creditCard,int customerID, double amount) 
     {
          this.firstName = firstName;
          this.lastName = lastName;
	      this.creditCard = creditCard;
          this.customerID = customerID;
          buyWashCard(amount);
     }

     //get the washcard
     public WashCard getWashCard()
     {
         return this.washCard;
     }
     
     //get the name
     public String getName()
     {
          return firstName + " " + lastName;
     }

     //for purchasing washcards
     public void buyWashCard(double amount)
     {  
        //restrict the amount to insert to the washcard
        if (creditCard.getBalance() >= amount && amount <= 1000 && amount >= 200)
        {
            //allow the customer to buy a washcard, ONLY if he doesn't already have one
            if (this.washCard == null)
            {
                this.washCard = new WashCard(amount);
                creditCard.setBalance(creditCard.getBalance() - amount);
                //todo: add the washcard to the arraylist aswell
            }
            else 
            {
                System.out.println(" You can't have more than one wash card, select another option");
            }
            
        }
        else 
        {
            System.out.println("Invalid amount, aborting purchase.");

        }
     }

     //refill the washcard
     public void refillWashCard(double amount)
     {
         //restrict amount to insert on the washcard
         if (washCard.getBalance() + amount <= 1000 && washCard.getBalance() + amount >= 200)
         {
            washCard.setBalance(washCard.getBalance() + amount);
         }
         else
         {
             System.out.println("Invalid amount! Enter new amount");
         }
     }

     //toString overrider
     @Override
     public String toString()
     {
         if (washCard != null)
         {
             return customerID + ": " + firstName + " " + lastName + " has a washcard with a balance of " + washCard.getBalance() + " kr.";
         } 
         else
         {
             return customerID + ": " + firstName + " " + lastName + " doesn't have washcard";
         }
     }

}
