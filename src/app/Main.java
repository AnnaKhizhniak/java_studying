package app;
import java.util.*;

public class Main {
    byte min = -100;
    byte max = 100;
    int[] numbers = new int[20];

    public static void main(String[] args) {
        Main main = new Main();

        main.fillArrayWithRandoms();
        System.out.println("Array of random numbers: " + Arrays.toString(main.numbers));

        int sumOfNegatives = main.countNegatives();
        System.out.printf("Sum of negatives: %d%n", sumOfNegatives);

        Map<String, Integer> evenAndOdd = main.countQuantityOfOddsAndEvens();
        System.out.printf("Quantity on even numbers: %d%n", evenAndOdd.get("even"));
        System.out.printf("Quantity on odd numbers: %d%n", evenAndOdd.get("odd"));

        Map<String, Integer> minAndMaxValues = main.findMinAndMaxValue();
        System.out.printf("Min value: %d (with index: %d) %n", minAndMaxValues.get("min"), minAndMaxValues.get("minIndex"));
        System.out.printf("Max value: %d (with index: %d) %n", minAndMaxValues.get("max"), minAndMaxValues.get("maxIndex"));

        double average = main.countAverageAfterFirstNegative();
        System.out.printf("Average after first negative value: %.2f", average);
    }

    public void fillArrayWithRandoms() {
        int count = 0;
        while (count < numbers.length) {
            int randomNumber = (min + (int) (Math.random() * ((max - min) + 1)));
            if (!contains(randomNumber)) {
                numbers[count] = randomNumber;
                count++;
            }
        }
    }

    public int countNegatives() {
        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                result += numbers[i];
            }
        }
        return result;
    }

    public Map<String, Integer> countQuantityOfOddsAndEvens() {
        HashMap<String, Integer> resultMap = new HashMap<>();
        resultMap.put("odd", 0);
        resultMap.put("even", 0);

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                resultMap.merge("odd", 1, Integer::sum);
            } else {
                resultMap.merge("even", 1, Integer::sum);
            }
        }

        return resultMap;
    }

    public Map<String, Integer> findMinAndMaxValue() {
        HashMap<String, Integer> resultMap = new HashMap<>();
        resultMap.put("min", numbers[0]);
        resultMap.put("max", numbers[0]);
        resultMap.put("minIndex", 0);
        resultMap.put("maxIndex", 0);

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < resultMap.get("min")) {
                resultMap.put("min", numbers[i]);
                resultMap.put("minIndex", i);
            } else if (numbers[i] > resultMap.get("max")) {
                resultMap.put("max", numbers[i]);
                resultMap.put("maxIndex", i);
            }
        }
        return resultMap;
    }

    public double countAverageAfterFirstNegative() {
        double result = 0;
        int index = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                index = i + 1;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Here is no negative values in array");
            return 0;
        }

        for (int i = index; i < numbers.length; i++) {
            result += numbers[i];
        }

        return result / (numbers.length - index);
    }

    public boolean contains(int value) {
        for(int number : numbers) {
            if (number == value) {
                return true;
            }
        }
        return false;
    }
}

