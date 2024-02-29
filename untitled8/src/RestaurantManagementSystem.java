import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RestaurantManagementSystem {
    private final IMenuManager menuManager;
    private final IOrderManager orderManager;
    private final Scanner scanner = new Scanner(System.in);

    public RestaurantManagementSystem(IMenuManager menuManager, IOrderManager orderManager) {
        this.menuManager = menuManager;
        this.orderManager = orderManager;
    }

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("\n1. Add Dish to Menu\n2. Remove Dish from Menu\n3. Update Dish Price\n4. Display Menu\n5. Create Order\n6. Display Orders\n7. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    addDish();
                    break;
                case 2:
                    removeDish();
                    break;
                case 3:
                    updateDishPrice();
                    break;
                case 4:
                    menuManager.displayMenu();
                    break;
                case 5:
                    createOrder();
                    break;
                case 6:
                    orderManager.displayOrders();
                    break;
                case 7:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
    }

    private void addDish() {
        System.out.print("Enter dish name: ");
        String name = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline left-over
        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        Dish dish = new Dish(name, price, category);
        menuManager.addDish(dish);
        System.out.println("Dish added successfully.");
    }

    private void removeDish() {
        System.out.print("Enter dish name to remove: ");
        String name = scanner.nextLine();
        menuManager.removeDish(name);
        System.out.println("Dish removed successfully.");
    }

    private void updateDishPrice() {
        System.out.print("Enter dish name to update price: ");
        String name = scanner.nextLine();
        System.out.print("Enter new price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline left-over

        menuManager.updateDishPrice(name, price);
        System.out.println("Dish price updated successfully.");
    }

    private void createOrder() {
        List<Dish> dishes = new ArrayList<>();
        System.out.println("Enter dish names to add to the order (type 'done' when finished):");

        while (true) {
            String dishName = scanner.nextLine();
            if ("done".equalsIgnoreCase(dishName)) {
                break;
            }
            Dish dish = menuManager.getDishByName(dishName);
            if (dish != null) {
                dishes.add(dish);
                System.out.println(dishName + " added.");
            } else {
                System.out.println("Dish not found.");
            }
        }

        orderManager.createOrder(dishes);
        System.out.println("Order created successfully.");
    }

    public static void main(String[] args) {
        IMenuManager menuManager = new MenuManager(new Menu()); // Assume MenuManager and Menu are implemented
        IOrderManager orderManager = new OrderManager(); // Assume OrderManager is implemented

        RestaurantManagementSystem system = new RestaurantManagementSystem(menuManager, orderManager);
        system.run();
    }
}
