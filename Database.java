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

     public Customer addCustomer(String firstName, String lastName, double ccAmount)
     {
          int newID = customerList.size();
          customerList.add(new Customer(firstName, lastName, new CreditCard(ccAmount), newID+1));
          return customerList.get(newID);
     }

     public void addCustomer(String firstName, String lastName, double ccAmount, double amount)
     {
          int newID = customerList.size();
          customerList.add(new Customer(firstName, lastName, new CreditCard(ccAmount), newID+1, amount));
     }


     public void printAllCustomers()
     {
          for(Customer customersIn : customerList)
          {
               System.out.println(customersIn);
          }
     }

     public void stats()
     {
          System.out.println("Her er nogle stats 1+1=3"); 
     }

     // System.out.println("saa da");
}