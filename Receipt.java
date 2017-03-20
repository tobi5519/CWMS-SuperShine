import java.util.Date;

public class Receipt
{
    private Date date;
    private Customer customer;
    private CarWash carwash;
    private double price;
    private int id;

    public Receipt(Date date, Customer customer, CarWash carWash, double price, Int id)
    {
        this.date = date;
        this.customer = customer;
        this.carWash = carWash;
        this.price = price;
        this.id = id;
    }

    @Override
    public String toString() 
    {
        return "Date: " + date + ", ID: " + id + ", " + customer.getName() + ", " + washType + ", " + price;
    }

}




















