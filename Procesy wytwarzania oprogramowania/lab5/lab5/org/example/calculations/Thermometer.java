package org.example.calculations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Thermometer {
    int minTemp;
    int maxTemp;
    int currentTemp;
    Thermometer(int minTemp, int maxTemp){
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }
    public static Thermometer createInstance(int minTemp, int
            maxTemp) {
        return new Thermometer(minTemp, minTemp);
    }
    public int getCurrentTemp(){
        return currentTemp;
    }
    public void setCurrentTemp(int currentTemp){
        this.currentTemp = currentTemp;
    }
    public int addDegrees(int degrees){
        currentTemp+=degrees;
        return currentTemp;
    }
    public int subtractDegrees(int degrees){
        currentTemp-=degrees;
        return currentTemp;
    }
    public boolean isBelowZero(){
        return currentTemp<0?true:false;
    }

    // 2)


//    class ThermometerTest {
//
//        Thermometer thermometer;
//
//        @BeforeEach
//        void init() {
//            thermometer = new Thermometer(-20, 40);
//        }
//
//        // ASSERT NOT NULL
//        @Test
//        @DisplayName("Ensure createInstance returns non-null object")
//        void testCreateInstanceNotNull() {
//            Thermometer t = Thermometer.createInstance(-10, 30);
//            assertNotNull(t, "Returned instance should not be null");
//        }
//
//        // ASSERT NOT EQUALS
//        @Test
//        @DisplayName("Ensure minTemp and maxTemp are not equal in main constructor")
//        void testMinMaxNotEqual() {
//            assertNotEquals(thermometer.minTemp, thermometer.maxTemp,
//                    "minTemp should not equal maxTemp");
//        }
//
//        // TRUE / FALSE
//        @Test
//        @DisplayName("isBelowZero should return true for negative temp")
//        void testBelowZeroTrue() {
//            thermometer.setCurrentTemp(-5);
//            assertTrue(thermometer.isBelowZero(), "Temperature -5 should be below zero");
//        }
//
//        @Test
//        @DisplayName("isBelowZero should return false for positive temp")
//        void testBelowZeroFalse() {
//            thermometer.setCurrentTemp(10);
//            assertFalse(thermometer.isBelowZero(),
//                    "Temperature 10 should NOT be below zero");
//        }
//
//        // addDegrees / subtractDegrees
//        @Test
//        @DisplayName("addDegrees should change currentTemp correctly")
//        void testAddDegrees() {
//            thermometer.setCurrentTemp(0);
//            int result = thermometer.addDegrees(5);
//            assertEquals(5, result,"zero plus five should be 5");
//        }
//
//        @Test
//        @DisplayName("subtractDegrees should change currentTemp correctly")
//        void testSubtractDegrees() {
//            thermometer.setCurrentTemp(10);
//            int result = thermometer.subtractDegrees(3);
//            assertEquals(7, result,"ten minus three should be seven");
//        }
//    }

    // 3)



    class ThermometerTest {

        Thermometer thermometer;

        @BeforeEach
        void init() {
            thermometer = new Thermometer(-20, 40);
        }

        // setCurrentTemp
        @Test
        void exceptionTesting_setCurrentTemp_wrongType() {
            Throwable exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> thermometer.setCurrentTemp("4")
            );

            assertEquals(
                    "CurrentTemp must be an integer",
                    exception.getMessage()
            );
        }

        // addDegrees – nieprawidłowy argument
        @Test
        void exceptionTesting_addDegrees_invalidArgument() {
            Throwable exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> thermometer.addDegrees("xyz"));

            assertEquals(
                    "Degrees must be a integer value.",
                    exception.getMessage()
            );
        }

        // subtractDegrees
        @Test
        void exceptionTesting_subtractDegrees_invalidArgument() {
            Throwable exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> thermometer.subtractDegrees(("12"))
            );

            assertEquals(
                    "Degrees must be a integer value.",
                    exception.getMessage()
            );
        }

        // createInstance
        @Test
        void exceptionTesting_createInstance_invalidRange() {
            Throwable exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> Thermometer.createInstance(50, -10)
            );

            assertEquals(
                    "maxTemp must be greater than or equal to minTemp.",
                    exception.getMessage()
            );
        }
    }


}