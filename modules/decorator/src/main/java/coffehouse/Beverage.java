package coffehouse;

/**
 * Base component interface for all beverages
 */
public interface Beverage {
    /**
     * Returns the description of the beverage
     * @return the description
     */
    String getDescription();
    
    /**
     * Returns the price of the beverage
     * @return the price in euros
     */
    double getPrice();
}
