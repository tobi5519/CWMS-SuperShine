import java.util.Date;

public class Receipt
{
    private Date date;
    private Customer customer;
    private CarWash carwash;
    private double price;
    

    public Receipt(Date date, Customer customer, CarWash carWash, double price)
    {
        this.date = date;
        this.customer = customer;
        this.carWash = carWash;
        this.price = price;
        
    }

    @Override
    public String toString() 
    {
        return "Date: " + date + ", " + customer.getName() + ", " + washType + ", " + price;
    }

}
