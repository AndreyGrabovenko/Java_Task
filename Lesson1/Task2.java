// Написать программу возвращающее число, которое без остатка делится на сумму цифр этого числа.

package Lesson1;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("\nВ диапазоне от 10 до 100 данные числа без остатка делятся на сумму цифр числа: ");
        for (int i = 10; i < 101; i++) {
            if (i % sum_numbers(i) == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\n\n");
    }

    public static int sum_numbers(int n) {
        int sum = 0;
        while (0 != n) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}