public class Dish {
    private String name;
    private double price;
    private String category;

    // Конструктор класса Dish для инициализации нового блюда
    public Dish(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Геттер для получения названия блюда
    public String getName() {
        return name;
    }

    // Геттер для получения цены блюда
    public double getPrice() {
        return price;
    }

    // Геттер для получения категории блюда
    public String getCategory() {
        return category;
    }

    // Сеттер для установки новой цены блюда
    public void setPrice(double price) {
        this.price = price;
    }

    // Переопределение метода toString для красивого отображения информации о блюде
    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }
}
