package coffehouse;

/**
 * Concrete decorator for adding chocolate to a beverage
 */
public class ChocolateDecorator extends BeverageDecorator {
    private final double price = 0.70;
    
    /**
     * Creates a new chocolate decorator for the given beverage
     * @param beverage the beverage to decorate
     */
    public ChocolateDecorator(Beverage beverage) {
        super(beverage);
    }
    
    @Override
    public String getDescription() {
        return beverage.getDescription() + " + Schoko";
    }
    
    @Override
    public double getPrice() {
        return beverage.getPrice() + price;
    }
}
