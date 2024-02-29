import java.util.List;

public interface IOrderManager {
    //Создает новый заказ на основе списка блюд.

    void createOrder(List<Dish> dishes);

    //Отображает информацию о всех существующих заказах.

    void displayOrders();
}
