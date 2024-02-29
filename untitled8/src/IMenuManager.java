
public interface IMenuManager {

    void addDish(Dish dish);

    void removeDish(String dishName);

    void updateDishPrice(String dishName, double newPrice);

    void displayMenu();

    Dish getDishByName(String dishName);
}
