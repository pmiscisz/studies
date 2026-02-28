package org.example.calculations;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class zad5_2 {




    // 1)
    class UserTest {

        @Test
        @DisplayName("Check if user has first name or last name 'Paweł'")
        void groupedAssertionsForUser() {

            User user = new User("Paweł", "Kowalski");

            assertAll("User name validation",
                    () -> assertEquals("Paweł", user.getFirstName(),
                            "First name should be Paweł"),
                    () -> assertEquals("Paweł", user.getLastName(),
                            "Last name should be Paweł")
            );
        }
    }
    // 2)
    public class SlowOperations {

        public String longOperation() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "OK";
        }
    }

    class SlowOperationsTest {

        @Test
        void testTimeoutExceeded() {
            SlowOperations ops = new SlowOperations();
            assertTimeout(ofSeconds(2), () -> {
                ops.longOperation();
            });
        }

        @Test
        void testTimeoutPreemptively() {
            SlowOperations ops = new SlowOperations();

            // Ten test przerwie wykonanie metody po timeout
            assertTimeoutPreemptively(ofSeconds(2), () -> {
                ops.longOperation();
            });
        }
    }
    public class Calculator {
        public int divide(int a, int b) {
            return a / b;
        }
    }

    class DynamicDivisionTest {

        @TestFactory
        Stream<DynamicTest> testDifferentDivisions() {

            Calculator calculator = new Calculator();

            // Format:
            // a, b, expectedResult (null oznacza oczekiwany wyjątek)
            List<int[]> cases = Arrays.asList(
                    new int[]{10, 2, 5},
                    new int[]{9, 3, 3},
                    new int[]{4, 1, 4},
                    new int[]{5, 0, 0} // dla b=0 spodziewamy się wyjątku
            );

            return cases.stream().map(entry -> {
                int a = entry[0];
                int b = entry[1];
                int expected = entry[2];

                if (b == 0) {
                    return dynamicTest(a + " / " + b + " -> ArithmeticException",
                            () -> assertThrows(ArithmeticException.class,
                                    () -> calculator.divide(a, b))
                    );
                }

                return dynamicTest(a + " / " + b + " = " + expected,
                        () -> assertEquals(expected, calculator.divide(a, b))
                );
            });
        }
    }




}
