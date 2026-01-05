package ru.netology.service;

import ru.netology.utils.NumberUtils;

/**
 * Сервисный класс для выполнения математических операций
 * Использует утилиты из модуля utils
 */
public class MathService {

    /**
     * Вычисляет среднее арифметическое двух чисел
     *
     * @param a первое число
     * @param b второе число
     * @return среднее арифметическое
     */
    public double average(int a, int b) {
        return (a + b) / 2.0;
    }

    /**
     * Вычисляет степень числа
     *
     * @param base основание
     * @param exponent показатель степени
     * @return результат возведения в степень
     */
    public long power(int base, int exponent) {
        if (exponent < 0) {
            throw new IllegalArgumentException("Отрицательная степень не поддерживается");
        }
        long result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    /**
     * Проверяет, является ли число четным, используя утилиту
     *
     * @param number число для проверки
     * @return true, если число четное
     */
    public boolean checkEven(int number) {
        return NumberUtils.isEven(number);
    }

    /**
     * Вычисляет факториал, используя утилиту
     *
     * @param n число для вычисления факториала
     * @return факториал числа
     */
    public long calculateFactorial(int n) {
        return NumberUtils.factorial(n);
    }
}

