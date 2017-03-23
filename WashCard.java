public class WashCard
{
     private double balance;
     private int washCardNr;

     public WashCard(double balance, int washCardNr)
     {
        this.washCardNr = washCardNr;
        this.balance = balance;
     }

     public int getWashCardNr()
     {
         return washCardNr;
     }

     public double getBalance()
     {
         return balance;
     }

     public void setBalance(double amount)
     {
        this.balance = amount;
     }

     public void buyCarWash(double balance)
     {
         
     }

     
}