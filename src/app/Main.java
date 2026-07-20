package app;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        byte min = 1;
        byte max = 100;
        int[] numbers = new int[15];

        fillArrayWithRandoms(numbers, min, max);
        System.out.println("Start array: " + Arrays.toString(numbers));

        sortInsertion(numbers);
        System.out.println("Sorted array: " + Arrays.toString(numbers));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Enter value from " + min + " to " + max + " for search: ");
                int searchKey = scanner.nextInt();
                scanner.nextLine();

                if (searchKey > max || searchKey < min) {
                    System.out.println("Entered not valid value!");
                } else {
                    int index = searchValue(numbers, searchKey);

                    if (index != -1) {
                        System.out.println("Index for number " + searchKey + " in sorted array is: " + index);
                        return;
                    }

                    System.out.println("Number " + searchKey + " is not found in array!");

                    while (true) {
                       System.out.println("Want to try one more time? Y/N");
                       String userResponse = scanner.nextLine().trim();

                       if (userResponse.equalsIgnoreCase("y")) {
                           break;
                       }

                       if (userResponse.equalsIgnoreCase("n")) {
                           scanner.close();
                           return;
                       }

                        System.out.println("Please enter Y or N.");
                       }
                    }
                }
            catch (InputMismatchException e) {
                System.out.println("Please enter an integer number.");
                scanner.nextLine();
            }
        }
    }

    public static void fillArrayWithRandoms(int[] array, int min, int max) {
        int count = 0;
        while (count < array.length) {
            int randomNumber = (min + (int) (Math.random() * ((max - min) + 1)));
            if (!contains(randomNumber, array)) {
                array[count] = randomNumber;
                count++;
            }
        }
    }

    public static int searchValue(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == key) {
                return mid;
            }

            if (array[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void sortInsertion(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > current) {
                array[j+1] = array[j];
                j = j - 1;
            }
            array[j+1] = current;
        }
    }

    public static boolean contains(int value, int[] array) {
        for(int number : array) {
            if (number == value) {
                return true;
            }
        }
        return false;
    }
}

