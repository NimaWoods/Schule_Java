package coffehouse;

/**
 * Concrete component representing a basic coffee
 */
public class Coffee implements Beverage {
    private String name;
    private double price;
    
    /**
     * Creates a new coffee with the given name and price
     * @param name the name of the coffee
     * @param price the price of the coffee
     */
    public Coffee(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    @Override
    public String getDescription() {
        return name;
    }
    
    @Override
    public double getPrice() {
        return price;
    }
}
