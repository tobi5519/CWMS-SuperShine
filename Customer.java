public class Customer{
     private String firstName;
     private String lastName;
     private WashCard washCard;
     private CreditCard creditCard;
     private int id;

     public Customer(String firstName, String lastName, WashCard washCard, CreditCard creditCard, int id) {
          this.firstName = firstName;
          this.lastName = lastName;
          this.washCard = washCard;
          this.creditCard = creditCard;
          this.id = id;
     }

}