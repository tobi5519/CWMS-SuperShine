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
          int nrGW = 0;
          double grGW = 0;
          int nrWW = 0;
          double grWW = 0;
          int nrCW = 0;
          double grCW = 0;

          double price = 0;

          int totalWashes = 0;
          double median = 0;

          for(Receipt r : receiptList)
          {
               // Getting the number of carWashes
               if(r.getCarWash().getName().equals("Greywash"))
               {
                    nrGW += 1;
                    grGW += r.getCarWash().getPrice();
               }
               else if (r.getCarWash().getName().equals("Whitewash"))
               {
                    nrWW += 1;
                    grWW += r.getCarWash().getPrice();
               }
               else if (r.getCarWash().getName().equals("Clearwash"))
               {
                    nrCW += 1;
                    grCW += r.getCarWash().getPrice();
               } 
               else
               {
                    System.out.println("Doh! (Error)");
               }
               
               // Price collection
               price += r.getCarWash().getPrice();
               totalWashes = nrGW + nrWW + nrCW;
               median = price / totalWashes;


               

               

          }
               // Print stats
               System.out.println("Number of carwashes: #" + totalWashes + " (Total gross: " + String.format("%.2f", price) + " kr.)");
               System.out.println("GreyWash: #" + nrGW + " (gross " + grGW + " kr.)");
               System.out.println("Whitewash: #" + nrWW + " (gross " + grWW + " kr.)");
               System.out.println("Clearwash: #" + nrCW + " (gross " + grCW + " kr.)");
               System.out.println("The average price for a carwash is : " + String.format("%.2f", median) + " kr.");
         
     }

     // System.out.println("saa da");
}