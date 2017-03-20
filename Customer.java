public class Customer
{
     private String firstName;
     private String lastName;
     private WashCard washCard;
     private CreditCard creditCard;
     

     public Customer(String firstName, String lastName, WashCard washCard, CreditCard creditCard) 
     {
          this.firstName = firstName;
          this.lastName = lastName;
          this.washCard = washCard;
          this.creditCard = creditCard; 
          
     }
     
     public String getName()
     {
          return firstName + " " + lastName;
     }
}