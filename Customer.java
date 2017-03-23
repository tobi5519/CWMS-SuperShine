public class Customer
{
     private String firstName;
     private String lastName;
     private WashCard washCard;
     private CreditCard creditCard;
     

     public Customer(String firstName, String lastName, CreditCard creditCard) 
     {
          this.firstName = firstName;
          this.lastName = lastName;
	      this.creditCard = creditCard;
     }

     public Customer(String firstName, String lastName, CreditCard creditCard, WashCard washCard) 
     {
          this.firstName = firstName;
          this.lastName = lastName;
	      this.creditCard = creditCard;
          this.washCard = washCard;
     }

     public WashCard getWashCard()
     {
         return this.washCard;
     }
     
     public String getName()
     {
          return firstName + " " + lastName;
     }
     public void buyWashCard(double amount)
     {
        if (creditCard.getBalance() >= amount && amount <= 1000 && amount >= 200)
        {
            if (this.washCard == null)
            {
                this.washCard = new WashCard(amount, 1);
                creditCard.setBalance(creditCard.getBalance() - amount);
            }
            else 
            {
                System.out.println(" You can't have more than one wash card, select another option");
            }
            
        }
        else 
        {
            System.out.println("Please enter a valid amount");
        }
     }

     public void refillWashCard(double amount)
     {
         if (washCard.getBalance() + amount <= 1000 && washCard.getBalance() + amount >= 200)
         {
            washCard.setBalance(washCard.getBalance() + amount);
         }
         else
         {
             System.out.println("Invalid amount! Enter new amount");
         }
     }

     

     @Override
     public String toString()
     {
         if (washCard != null)
         {
             return  firstName + " " + lastName + " har et wash card med " + washCard.getBalance() + " kr. paa.";
         } 
         else
         {
             return firstName + " " + lastName + " har ikke noget wash card";
         }
     }

}
