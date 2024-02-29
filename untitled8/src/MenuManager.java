import java.util.List;

public class MenuManager implements IMenuManager {
    private Menu menu;

    // Конструктор
    public MenuManager(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void addDish(Dish dish) {
        // Проверяем, существует ли уже такое блюдо
        if (menu.getDishes().stream().noneMatch(d -> d.getName().equalsIgnoreCase(dish.getName()))) {
            menu.addDish(dish);
            System.out.println("Dish " + dish.getName() + " added to the menu.");
        } else {
            System.out.println("Dish " + dish.getName() + " already exists in the menu.");
        }
    }

    @Override
    public void removeDish(String dishName) {
        if (menu.getDishes().removeIf(dish -> dish.getName().equalsIgnoreCase(dishName))) {
            System.out.println("Dish " + dishName + " removed from the menu.");
        } else {
            System.out.println("Dish " + dishName + " not found in the menu.");
        }
    }

    @Override
    public void updateDishPrice(String dishName, double newPrice) {
        Dish dishToUpdate = menu.getDishes().stream()
                .filter(dish -> dish.getName().equalsIgnoreCase(dishName))
                .findFirst()
                .orElse(null);
        if (dishToUpdate != null) {
            dishToUpdate.setPrice(newPrice);
            System.out.println("Price of " + dishName + " updated to $" + newPrice);
        } else {
            System.out.println("Dish " + dishName + " not found in the menu.");
        }
    }

    @Override
    public void displayMenu() {
        List<Dish> dishes = menu.getDishes();
        if (dishes.isEmpty()) {
            System.out.println("The menu is currently empty.");
        } else {
            System.out.println("Menu:");
            dishes.forEach(dish -> System.out.println(dish.getName() + " - $" + dish.getPrice()));
        }
    }

    @Override
    public Dish getDishByName(String dishName) {
        return menu.getDishes().stream()
                .filter(dish -> dish.getName().equalsIgnoreCase(dishName))
                .findFirst()
                .orElse(null);
    }
}
