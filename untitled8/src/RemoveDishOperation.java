public class RemoveDishOperation implements MenuOperation {
    @Override
    public void execute(Menu menu, Dish dish) {
        // Проверяем наличие блюда в меню перед его удалением
        Dish existingDish = menu.getDishByName(dish.getName());
        if (existingDish != null) {
            menu.removeDish(dish.getName());
            System.out.println(dish.getName() + " has been successfully removed from the menu.");
        } else {
            System.out.println("Could not find " + dish.getName() + " in the menu.");
        }
    }
}
