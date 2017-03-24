import java.util.Date;

public class Receipt
{
    private String date;
    private Customer customer;
    private CarWash carWash;
    private double price;
    private int id;
    

    public Receipt(String date, Customer customer, CarWash carWash, double price, int id)
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
        return id +  ". Date: " + date + ", " + customer.getName() + ", " + carWash.getName() + ", " + price + "kr.";
    }

}
