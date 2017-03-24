public class CarWash
{

    private String name;
    private double price;
    private int id;

    public CarWash(String name, double price, int id)
    {
        this.name = name;
        this.price = price;
        this.id = id+1;
    }

    public double getPrice()
    {
        return this.price;
    }

    public String getName()
    {
        return this.name;
    }

    @Override
    public String toString()
    {
        return this.id + " " + this.name + " " + this.price + "kr";
    }

}
