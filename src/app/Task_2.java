package app;

/*
Розрахунок швидкості:
   Напишіть програму, яка зчитує відстань (у кілометрах) та час (у годинах) і обчислює швидкість (км/год).
 */

public class Task_2 {
    static void main(String[] args) {
        int distance = Integer.parseInt(args[0]);
        int time = Integer.parseInt(args[1]);
        double speed = (double) distance / time;
        System.out.printf("Speed for distance: %d and time %d equal = %.2f", distance, time, speed);
    }
}
