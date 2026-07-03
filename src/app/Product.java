package app;

public class Product {
    private static int nextId = 1;
    int productId;
    String productName;
    double productPrice;
    String currencyName;

    Product(String name, double price, String currency) {
        productId = nextId;
        nextId++;
        productName = name;
        productPrice = price;
        currencyName = currency;
    }
}
