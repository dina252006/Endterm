import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Dish> dishes = new ArrayList<>();
    private double totalCost = 0.0;

    // Метод для добавления блюда в заказ
    public void addDish(Dish dish) {
        if (dish != null) {
            dishes.add(dish);
            totalCost += dish.getPrice();
            System.out.println(dish.getName() + " added to order with price $" + dish.getPrice());
        } else {
            System.out.println("Cannot add a null dish to the order.");
        }
    }

    // Геттер для получения списка блюд в заказе
    public List<Dish> getDishes() {
        return new ArrayList<>(dishes); // Возвращаем копию списка, чтобы предотвратить внешние изменения
    }

    // Метод для получения общей стоимости заказа
    public double getTotalCost() {
        return totalCost;
    }

    // Переопределенный метод toString для отображения информации о заказе
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Order Details:\n");
        for (Dish dish : dishes) {
            sb.append(dish.getName()).append(" - $").append(String.format("%.2f", dish.getPrice())).append("\n");
        }
        sb.append("Total Cost: $").append(String.format("%.2f", totalCost));
        return sb.toString();
    }
}
