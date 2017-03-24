import java.util.ArrayList;
import java.util.Date;

public class Database
{
     ArrayList<Receipt> receiptList = new ArrayList<Receipt>();
     ArrayList<Customer> customerList = new ArrayList<Customer>();
     ArrayList<CarWash> carWashList = new ArrayList<CarWash>();

     public Receipt getReceipt(int x)
     {
          return receiptList.get(x);
     }

     public void addReceipt(String date, Customer customer, CarWash carWash, double price)
     {
          int newID = receiptList.size();
          receiptList.add(new Receipt(date, customer, carWash, price, newID+1));
     }

     public Customer getCustomer(int id)
     {
          return customerList.get(id-1);
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

     public void addCarWash(String name, double price)
     {
          int newID = carWashList.size();       
          carWashList.add(new CarWash(name, price, newID));
     }

     public CarWash getCarWash(int choice)
     {
          return carWashList.get(choice-1);
     }

     public void printAllCarWash()
     {
          for(CarWash carwash : carWashList)
          {
               System.out.println(carwash);
          }
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