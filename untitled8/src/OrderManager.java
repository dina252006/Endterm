import java.util.ArrayList;
import java.util.List;

public class OrderManager implements IOrderManager {
    private final List<Order> orders = new ArrayList<>();

    @Override
    public void createOrder(List<Dish> dishes) {
        if (dishes == null || dishes.isEmpty()) {
            System.out.println("Cannot create an order with no dishes.");
            return;
        }

        Order newOrder = new Order();
        for (Dish dish : dishes) {
            newOrder.addDish(dish);
        }
        orders.add(newOrder);
        System.out.println("New order has been created with " + dishes.size() + " dishes.");
    }

    @Override
    public void displayOrders() {
        if (orders.isEmpty()) {
            System.out.println("There are no orders to display.");
            return;
        }

        System.out.println("Displaying all orders:");
        int orderNumber = 1;
        for (Order order : orders) {
            System.out.println("Order #" + orderNumber++ + ":");
            System.out.println(order); // Это вызывает метод toString класса Order
            System.out.println(); // Добавить пустую строку для улучшения читаемости
        }
    }
}
