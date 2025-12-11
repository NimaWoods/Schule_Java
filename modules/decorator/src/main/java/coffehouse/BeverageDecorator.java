package coffehouse;

/**
 * Abstract decorator class that implements the coffehouse.Beverage interface
 * and holds a reference to a coffehouse.Beverage object
 */
public abstract class BeverageDecorator implements Beverage {
    protected Beverage beverage;
    
    /**
     * Creates a new decorator for the given beverage
     * @param beverage the beverage to decorate
     */
    public BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }
    
    @Override
    public String getDescription() {
        return beverage.getDescription();
    }
    
    @Override
    public double getPrice() {
        return beverage.getPrice();
    }
}
