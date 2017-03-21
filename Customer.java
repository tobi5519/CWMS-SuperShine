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
     
     public String getName()
     {
          return firstName + " " + lastName;
     }
     public void buyWashCard(double amount)
     {
         if (creditCard.getBalance() >= amount && amount <= 1000 && amount >= 200)
         {
            this.washCard = new WashCard(amount);
            creditCard.setBalance(amount);
        }
        else 
        {
            System.out.println("Please enter a valid amount, you cunt!");
        }
    }

     @Override
     public String toString()
     {
         if (washCard != null)
         {
             return  firstName + " " + lastName + " har et wash card med " + washCard.getBalance() + " kr. på.";
         } 
         else
         {
             return firstName + " " + lastName + " har ikke noget wash card";
         }
     }

}
