import java.util.ArrayList;

public class Datebase{
     ArrayList<Receipt> receiptlist = new ArrayList<Receipt>();

     public void printReceipt(int e){
          System.out.print(Receipt.get(e));
     }
}