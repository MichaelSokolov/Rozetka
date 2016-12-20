package pages;



public class Item {
    private String price;
    private String name;

    public Item(String price, String name) {
        this.price = price;
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}