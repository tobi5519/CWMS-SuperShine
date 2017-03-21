import java.util.ArrayList;

public class Database
{
     ArrayList<Receipt> receiptList = new ArrayList<Receipt>();
     ArrayList<Customer> customerList = new ArrayList<Customer>();
     ArrayList<WashCard> washCards = new ArrayList<WashCard>();


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

     public WashCard getWashCardByID(int id) {
          
          return washCards.get(id-1);
     }

     public void printAllWashCards()
     {
          for(WashCard washCardsIn : washCards)
          {
               System.out.println(washCardsIn.getWashCardNr() + " card for " + customerList.get(washCardsIn.getWashCardNr()-1).getName()); 
          }
     }

     public WashCard createWashCard(double amount)
     {
          int location = washCards.size();
          washCards.add(location , new WashCard(amount, location+1));
          return washCards.get(location);
     }

     public void stats()
     {
          System.out.println("Her er nogle stats 1+1=3"); 
     }
}