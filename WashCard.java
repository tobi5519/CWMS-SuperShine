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

     public Boolean buyCarWash(CarWash carwash)
     {
         if(carwash.getPrice() <= this.balance)
         {
            this.balance -= carwash.getPrice();
            System.out.println("purchase successful!");
            return true;
         }
         else
         {
             System.out.println("Error, not enough money");
             return false;             
         }
     }

     
}