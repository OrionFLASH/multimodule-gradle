package ru.netology.app;

import ru.netology.service.MathService;
import ru.netology.utils.NumberUtils;

/**
 * Главный класс приложения
 * Демонстрирует использование модулей utils и service
 */
public class Main {

    /**
     * Точка входа в приложение
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        System.out.println("=== Многомодульное приложение Gradle ===");
        
        // Использование утилит из модуля utils
        int testNumber = 8;
        System.out.println("Число: " + testNumber);
        System.out.println("Четное: " + NumberUtils.isEven(testNumber));
        System.out.println("Факториал 5: " + NumberUtils.factorial(5));
        System.out.println("НОД(48, 18): " + NumberUtils.gcd(48, 18));
        
        // Использование сервиса из модуля service
        MathService mathService = new MathService();
        int a = 10;
        int b = 20;
        System.out.println("\n=== Математические операции ===");
        System.out.println("Среднее арифметическое " + a + " и " + b + ": " + mathService.average(a, b));
        System.out.println("2 в степени 8: " + mathService.power(2, 8));
        System.out.println("Число " + testNumber + " четное: " + mathService.checkEven(testNumber));
        System.out.println("Факториал 6: " + mathService.calculateFactorial(6));
    }
}

