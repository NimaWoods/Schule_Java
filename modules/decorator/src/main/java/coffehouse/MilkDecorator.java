package coffehouse;

/**
 * Concrete decorator for adding milk to a beverage
 */
public class MilkDecorator extends BeverageDecorator {
    private final double price = 0.50;
    
    /**
     * Creates a new milk decorator for the given beverage
     * @param beverage the beverage to decorate
     */
    public MilkDecorator(Beverage beverage) {
        super(beverage);
    }
    
    @Override
    public String getDescription() {
        return beverage.getDescription() + " + Milch";
    }
    
    @Override
    public double getPrice() {
        return beverage.getPrice() + price;
    }
}
