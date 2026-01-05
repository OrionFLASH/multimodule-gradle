package ru.netology.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты для класса MathService
 */
class MathServiceTest {

    private final MathService mathService = new MathService();

    @Test
    void testAverage() {
        assertEquals(15.0, mathService.average(10, 20));
    }

    @Test
    void testPower() {
        assertEquals(8, mathService.power(2, 3));
        assertEquals(1, mathService.power(5, 0));
    }

    @Test
    void testPowerWithNegativeExponent() {
        assertThrows(IllegalArgumentException.class, () -> mathService.power(2, -1));
    }

    @Test
    void testCheckEven() {
        assertTrue(mathService.checkEven(4));
        assertFalse(mathService.checkEven(5));
    }

    @Test
    void testCalculateFactorial() {
        assertEquals(120, mathService.calculateFactorial(5));
    }
}

