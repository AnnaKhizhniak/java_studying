package app;

public class Order {
    public double calcTotalSales(int quantity, double price) {
       return quantity * price;
    }

    public double calcAvgPerDaySales(double total, int days ) {
        if (days == 0) {
            System.out.println("Days quantity can't be 0");
            return 0;
        } else {
            return total / days;
        }
    }
}
