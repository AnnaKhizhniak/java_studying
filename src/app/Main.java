
package app;

public class Main {
    static void main(String[] args) {
        double income = 1000.00;
        double totalTax = 0;

        if (income < 0) {
            System.out.println("Income cannot be negative");
            return;
        } else if (income <= 10000) {
            totalTax = income * 2.5 / 100;
        } else if (income > 10000 && income <= 25000) {
            totalTax = income * 4.3 / 100;
        } else {
            totalTax = income * 6.7 / 100;
        }

        System.out.println("Total tax for income " + income + " is " + totalTax );
    }
}

