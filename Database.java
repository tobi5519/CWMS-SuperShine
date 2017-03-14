import java.util.ArrayList;

public class Database
{
     ArrayList<Receipt> receiptList = new ArrayList<Receipt>();
     ArrayList<Customer> customers = new ArrayList<Customer>();

     public Receipt getReceipt(int i)
     {
          return receiptList.get(i);          
     }

     public void addReceipt(Receipt r)
     {
          receiptList.add(r);
     }
     public void addCustomer(Customer c)
     {
          receiptList.add(c);
     }
// Har ikke specificeret hvilke stats vi vil have endnu
     // public String stats(){
     //      return null;
     // }
}