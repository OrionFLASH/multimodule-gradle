package ru.netology.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты для класса NumberUtils
 */
class NumberUtilsTest {

    @Test
    void testIsEven() {
        assertTrue(NumberUtils.isEven(2));
        assertTrue(NumberUtils.isEven(0));
        assertFalse(NumberUtils.isEven(3));
    }

    @Test
    void testFactorial() {
        assertEquals(1, NumberUtils.factorial(0));
        assertEquals(1, NumberUtils.factorial(1));
        assertEquals(120, NumberUtils.factorial(5));
    }

    @Test
    void testFactorialWithNegative() {
        assertThrows(IllegalArgumentException.class, () -> NumberUtils.factorial(-1));
    }

    @Test
    void testGcd() {
        assertEquals(6, NumberUtils.gcd(48, 18));
        assertEquals(1, NumberUtils.gcd(17, 13));
    }
}

