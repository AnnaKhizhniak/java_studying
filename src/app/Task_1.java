package app;
/*
 Розрахунок вартості зі знижкою:
   Напишіть програму, яка обчислює фінальну ціну товару за формулою:
   finalPrice = originalPrice – (originalPrice * discountPercentage / 100).
 */

public class Task_1 {
    static void main(String[] args) {
        double originalPrice = 23000.45;
        int discountPercentage = 23;
        double finalPrice = originalPrice - (originalPrice * discountPercentage / 100);
        System.out.printf("Final price: %.2f", finalPrice);
    }
}

