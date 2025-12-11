package coffehouse;

/**
 * Concrete decorator for adding sugar to a beverage
 */
public class SugarDecorator extends BeverageDecorator {
    private final double price = 0.20;
    
    /**
     * Creates a new sugar decorator for the given beverage
     * @param beverage the beverage to decorate
     */
    public SugarDecorator(Beverage beverage) {
        super(beverage);
    }
    
    @Override
    public String getDescription() {
        return beverage.getDescription() + " + Zucker";
    }
    
    @Override
    public double getPrice() {
        return beverage.getPrice() + price;
    }
}
