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
     	  
     }

     @Override
     public String toString()
     {
          return firstName + " " + lastName;
     }

}
