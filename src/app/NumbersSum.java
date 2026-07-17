
package app;

public class NumbersSum {
    static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            result += numbers[i];
            System.out.println(i + 1 + ") Num is " + numbers[i] + ", sum is " + result);
        }
        System.out.println("--------------");
        System.out.println("Sum of numbers is " + result);
    }
}

