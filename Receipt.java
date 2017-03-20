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
        this.carwash = carWash;
        this.price = price;
        
    }
    public Receipt(Date date, Customer customer, double price)
    {
        this.date = date;
        this.customer = customer;
        this.price = price
    }

    @Override
    public String toString() 
    {
        return "Date: " + date + ", " + customer.getName() + ", " + carWash + ", " + price;
    }

}
