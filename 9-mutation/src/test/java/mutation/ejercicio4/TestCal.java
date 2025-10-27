package mutation.ejercicio4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCal {

    @Test
    public void testForMonthOneEqualsMonthTwoAndLeapYear() {
        int result = Cal.cal(2, 18, 2, 29, 2025); // febrero 18 → 29
        int expected = 11;
        assertEquals(expected, result);
    }

    @Test
    public void testForMonthOneEqualsMonthTwoAndNotLeapYear() {
        int result = Cal.cal(2, 18, 2, 29, 2020); // febrero 18 → 29
        int expected = 11;
        assertEquals(expected, result);
    }

    @Test
    public void testForMonthOneDifferentMonthTwoAndLeapYear() {
        int result = Cal.cal(1, 18, 2, 29, 2020); // enero 18 → feb 29 (bisiesto)
        int expected = 42;
        assertEquals(expected, result);
    }

    @Test
    public void testForMonthOneDifferentMonthTwoAndNotLeapYear() {
        int result = Cal.cal(1, 18, 2, 28, 2019); // enero 18 → feb 28
        int expected = 41;
        assertEquals(expected, result);
    }

    @Test
    public void testForDatesWithMoreThanTwoMonthsDifferenceAndLeapYear() {
        int result = Cal.cal(1, 18, 3, 28, 2020); // enero 18 → marzo 28
        int expected = 70;
        assertEquals(expected, result);
    }

    @Test
    public void testForDatesWithMoreThanTwoMonthsDifferenceAndNotLeapYear() {
        int result = Cal.cal(1, 18, 3, 28, 2019);
        int expected = 69;
        assertEquals(expected, result);
    }

    @Test
    public void testForCenturyNotLeapYear() {
        int result = Cal.cal(2, 10, 3, 10, 1900);
        int expected = 28;
        assertEquals(expected, result);
    }

    @Test
    public void testForCenturyNotLeapYearTwo() {
        int result = Cal.cal(2, 10, 3, 10, 400);
        int expected = 29;
        assertEquals(expected, result);
    }
}
