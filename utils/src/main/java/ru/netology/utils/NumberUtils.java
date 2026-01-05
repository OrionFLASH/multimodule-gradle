package ru.netology.utils;

/**
 * Утилитный класс для работы с числами
 * Предоставляет вспомогательные методы для математических операций
 */
public class NumberUtils {

    /**
     * Проверяет, является ли число четным
     *
     * @param number число для проверки
     * @return true, если число четное, иначе false
     */
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    /**
     * Вычисляет факториал числа
     *
     * @param n число для вычисления факториала
     * @return факториал числа
     * @throws IllegalArgumentException если число отрицательное
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал определен только для неотрицательных чисел");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Вычисляет наибольший общий делитель двух чисел
     *
     * @param a первое число
     * @param b второе число
     * @return НОД двух чисел
     */
    public static int gcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return gcd(b, a % b);
    }
}

