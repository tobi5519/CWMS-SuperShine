import java.util.ArrayList;

public class Database
{
     ArrayList<Receipt> receiptList = new ArrayList<Receipt>();
     ArrayList<Customer> customerList = new ArrayList<Customer>();

     public Receipt getReceipt(int x)
     {
          return receiptList.get(x);
     }

     public void addReceipt(Receipt receipt)
     {
          receiptList.add(receipt);
     }

     public Customer getCustomer(String name)
     {
          for(Customer customer : customerList)
          {
               if(customer.getName().equals(name))
               {
                    return customer;
               }
          }
          return null; 
     }

     public void addCustomer(Customer customer)
     {
          customerList.add(customer);
     }

     public void stats()
     {
          System.out.println("Her er nogle stats 1+1=3"); 
     }

     // System.out.println("saa da");
}