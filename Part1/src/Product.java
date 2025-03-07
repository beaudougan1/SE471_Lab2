public class Product {
    //initialize variables
    private String id;
    private String name;
    private double price;
    private String brand;
    private String category;
    private double customerRating;
    //constructor
    public Product(String id, String name, double price, String brand, String category, double customerRating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.category = category;
        this.customerRating = customerRating;
    }
    //getters
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getBrand() {
        return brand;
    }
    public String getCategory() {
        return category;
    }
    public double getCustomerRating() {
        return customerRating;
    }
}
