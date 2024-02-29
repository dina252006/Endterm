public class UpdatePriceOperation implements MenuOperation {
    private double newPrice;

    // Конструктор для установки новой цены
    public UpdatePriceOperation(double newPrice) {
        this.newPrice = newPrice;
    }

    @Override
    public void execute(Menu menu, Dish dish) {
        Dish dishToUpdate = menu.getDishByName(dish.getName());
        if (dishToUpdate != null) {
            dishToUpdate.setPrice(newPrice);
            System.out.println("The price of " + dish.getName() + " has been updated to $" + String.format("%.2f", newPrice));
        } else {
            System.out.println("Could not find " + dish.getName() + " in the menu to update the price.");
        }
    }
}
