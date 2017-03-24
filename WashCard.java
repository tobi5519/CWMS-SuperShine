public class WashCard
{
     private double balance;

     public WashCard(double balance)
     {
        this.balance = balance;
     }

     public double getBalance()
     {
         return balance;
     }

     public void setBalance(double amount)
     {
        this.balance = amount;
     }

     public CarWash buyCarWash(CarWash carwash)
     {
         this.balance -= carwash.getPrice();
         System.out.println("purchase successful!");
         return carwash;
     }

     
}