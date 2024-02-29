import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Menu {
    private List<Dish> dishes;

    public Menu() {
        this.dishes = new ArrayList<>();
    }

    // Метод для добавления блюда в меню
    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    // Метод для удаления блюда из меню по названию
    public void removeDish(String dishName) {
        dishes.removeIf(dish -> dish.getName().equals(dishName));
    }

    // Метод для обновления цены блюда
    public void updateDishPrice(String dishName, double newPrice) {
        for (Dish dish : dishes) {
            if (dish.getName().equals(dishName)) {
                dish.setPrice(newPrice);
                break;
            }
        }
    }

    // Метод для отображения всего меню
    public void displayMenu() {
        if (dishes.isEmpty()) {
            System.out.println("Menu is currently empty.");
        } else {
            System.out.println("Menu:");
            dishes.forEach(System.out::println);
        }
    }

    // Метод для получения блюда по названию
    public Dish getDishByName(String name) {
        for (Dish dish : dishes) {
            if (dish.getName().equalsIgnoreCase(name)) {
                return dish;
            }
        }
        return null; // Возвращаем null, если блюдо не найдено
    }

    // Метод для фильтрации блюд по категории
    public List<Dish> getDishesByCategory(String category) {
        return dishes.stream()
                .filter(dish -> dish.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    // Геттер для получения списка всех блюд
    public List<Dish> getDishes() {
        return new ArrayList<>(dishes); // Возвращаем копию списка для предотвращения изменений извне
    }
}
