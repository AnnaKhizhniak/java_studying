package app;
/*
Хвилини в годинах:
   Напишіть програму, яка обчислює кількість повних годин у заданій кількості хвилин (наприклад, 150 хв → 2 години).
 */
public class Task_3 {
    static void main(String[] args) {
        int minutes = 150;
        int minutesPerHour = 60;
        double hours = (double) minutes / minutesPerHour;
        System.out.println(hours);
    }
}
