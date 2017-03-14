import java.util.Date;

public class Receipt
{
    private Date date;
    private Customer customer;
    private CarWash washType;
    private double price;
    private int id;

    @Override
    public String toString() 
    {
        return "Date: " + date + ", ID: " + id + ", " + customer.getName() + ", " + washType + ", " + price;
    }

}