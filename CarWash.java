public class CarWash
{

    private String name;
    private double price;

    public CarWash(String name, double price)
    {
        this.name = name;
        this.price = price;
    }

    public double getPrice()
    {
        return this.price;
    }

    public String getName()
    {
        return this.name;
    }
}
