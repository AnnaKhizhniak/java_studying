package app;
import java.util.Locale;

public class Store {
    static void main(String[] args) {
        Product smartphone = new Product("smartphone", 4555.12, "EUR");
        Product laptop = new Product("laptop", 124.78, "EUR");

        Store store = new Store();
        store.printProductInfo(smartphone, 15, 5);
        store.printProductInfo(laptop, 10, 7);
    }

    public void printProductInfo(Product product, int quantity, int days) {
        Order order = new Order();
        double total = order.calcTotalSales(quantity, product.productPrice);
        double avgPerDay = order.calcAvgPerDaySales(total, days);

        System.out.printf(Locale.GERMANY,"Product No %d: %s,%n", product.productId, product.productName);
        System.out.printf(Locale.GERMANY, "Total sales for %d days is %s %.2f,%n", days, product.currencyName, total);
        System.out.printf(Locale.GERMANY, "Sales by day is %s %.2f.%n", product.currencyName, avgPerDay);
        System.out.println(" ");
    }
}

