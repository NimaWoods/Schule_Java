package coffehouse;

/**
 * Main class demonstrating the decorator pattern with various coffee combinations
 */
public class CoffeeShop {
    public static void main(String[] args) {
        System.out.println("=== Kaffeehaus Menü ===");
        
        // Basic coffees
        Beverage espresso = new Coffee("Espresso", 1.99);
        Beverage americano = new Coffee("Americano", 2.49);
        Beverage cappuccino = new Coffee("Cappuccino", 2.99);
        
        // Print basic coffees
        printBeverage(espresso);
        printBeverage(americano);
        printBeverage(cappuccino);
        
        System.out.println("\n=== Spezialitäten ===");
        
        // coffehouse.Coffee with milk
        Beverage espressoWithMilk = new MilkDecorator(espresso);
        printBeverage(espressoWithMilk);
        
        // coffehouse.Coffee with milk and sugar
        Beverage americanoWithMilkAndSugar = new SugarDecorator(new MilkDecorator(americano));
        printBeverage(americanoWithMilkAndSugar);
        
        // coffehouse.Coffee with chocolate
        Beverage cappuccinoWithChocolate = new ChocolateDecorator(cappuccino);
        printBeverage(cappuccinoWithChocolate);
        
        // coffehouse.Coffee with milk, chocolate and sugar
        Beverage deluxeCoffee = new SugarDecorator(
                                new ChocolateDecorator(
                                    new MilkDecorator(espresso)));
        printBeverage(deluxeCoffee);
        
        // Double milk, chocolate
        Beverage extraMilkyChocolateCoffee = new ChocolateDecorator(
                                              new MilkDecorator(
                                                new MilkDecorator(americano)));
        printBeverage(extraMilkyChocolateCoffee);
    }
    
    /**
     * Helper method to print beverage information
     * @param beverage the beverage to print
     */
    private static void printBeverage(Beverage beverage) {
        System.out.printf("%s: %.2f€%n", beverage.getDescription(), beverage.getPrice());
    }
}
