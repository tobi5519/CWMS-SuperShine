import java.util.ArrayList;

public class Machine  
{
    public static void main(String[] args) 
    {        
        Database db = new Database();
        CreditCard cc1 = new CreditCard(2000);
        CreditCard cc2 = new CreditCard(2000000);
        Customer jens = new Customer("jens", "hansen", cc1);
        Customer bent = new Customer("bent", "jansen", cc2);

        db.addCustomer(jens);
        db.addCustomer(bent);
        System.out.println(db.getCustomer("jens hansen"));
        System.out.println(db.getCustomer("bent jansen"));

    }
}