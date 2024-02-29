public class AddDishOperation implements MenuOperation {
    @Override
    public void execute(Menu menu, Dish dish) {
        // Проверка на null для dish, чтобы предотвратить добавление null-объектов в меню
        if (dish == null) {
            System.out.println("Cannot add a null dish to the menu.");
            return;
        }

        // Попытка добавить блюдо в меню
        if (menu.getDishByName(dish.getName()) == null) {
            menu.addDish(dish);
            System.out.println(dish.getName() + " has been successfully added to the menu.");
        } else {
            System.out.println("The dish " + dish.getName() + " already exists in the menu.");
        }
    }
}
