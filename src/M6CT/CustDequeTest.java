package M6CT;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Lightweight test harness for {@link CustDeque}.
 *
 * <p>This class does not use JUnit. Instead, it runs a set of small tests and prints
 * PASS/FAIL output to verify correct behavior, including edge cases.</p>
 */
public class CustDequeTest {

    /**
     * Runs all tests for {@link CustDeque}.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

    	testInqueOrder();
        testDequeFront();
        testDequeRear();
        testIterator();
        testEmptyQueThrow();

        System.out.println("\nALL TESTS COMPLETED");
    }

	//****************************
	//TESTERS
	//****************************
    
    /**
     * Verifies that alternating front/back insertions produce the expected order
     * when traversed from front to rear.
     */
    private static void testInqueOrder() {
        CustDeque deque = new CustDeque();

        deque.queFront(10);  // [10]
        deque.queBack(20);   // [10, 20]
        deque.queFront(5);   // [5, 10, 20]
        deque.queBack(30);   // [5, 10, 20, 30]

        int[] expected = {5, 10, 20, 30};
        assertQueEquals("testInQueOrder", deque, expected);
    }

    /**
     * Verifies that {@link CustDeque#dequeFront()} removes the correct value.
     */
    private static void testDequeFront() {
        CustDeque deque = new CustDeque();
        deque.queBack(1);
        deque.queBack(2);
        deque.queBack(3);

        int value = deque.dequeFront();
        assertEquals("testDequeFront", 1, value);
    }

    /**
     * Verifies that {@link CustDeque#dequeRear()} removes the correct value.
     */
    private static void testDequeRear() {
        CustDeque deque = new CustDeque();
        deque.queBack(1);
        deque.queBack(2);
        deque.queBack(3);

        int value = deque.dequeRear();
        assertEquals("testDequeRear", 3, value);
    }

    /**
     * Verifies that the custom iterator traverses elements in correct front-to-rear order.
     */
    private static void testIterator() {
        CustDeque deque = new CustDeque();
        deque.queBack(-10);
        deque.queBack(0);
        deque.queBack(999999);

        int[] expected = {-10, 0, 999999};
        assertQueEquals("testIterator", deque, expected);
    }

    /**
     * Verifies that attempting to dequeue from an empty deque throws exceptions
     * for both front and rear removals.
     */
    private static void testEmptyQueThrow() {
        CustDeque deque = new CustDeque();

        boolean threwFront = false;
        try {
            deque.dequeFront();
        } catch (NoSuchElementException ex) {
            threwFront = true;
        }

        boolean threwRear = false;
        try {
            deque.dequeRear();
        } catch (NoSuchElementException ex) {
            threwRear = true;
        }

        assertTrue("testEmptyQueThrow (front)", threwFront);
        assertTrue("testEmptyQueThrow (rear)", threwRear);
    }

	//****************************
	//Assert Helpers
	//****************************
    
    /**
     * Compares the deque contents (via iterator traversal) against an expected array.
     *
     * @param testName the name to print in PASS/FAIL output
     * @param deque the deque being tested
     * @param expected the expected front-to-rear traversal order
     */
    private static void assertQueEquals(String testName, CustDeque deque, int[] expected) {
        int index = 0;
        Iterator<Integer> queIterator = deque.iterator();

        while (queIterator.hasNext()) {
        	
        	//To many items
            if (index >= expected.length) {
                System.out.println("[FAIL] " + testName + "  Deque had extra item.");
                return;
            }
            
            int actualValue = queIterator.next();
            
            //Wrong Value
            if (actualValue != expected[index]) {
                System.out.println("[FAIL] " + testName + "  Index: " + index +
                        "  Expected: " + expected[index] + "  Actual: " + actualValue);
                return;
            }

            index++;
        }
        
        //Incorrect Length
        if (index != expected.length) {
            System.out.println("[FAIL] " + testName + "  Expected length: " + expected.length +
                    "  Actual length: " + index);
            return;
        }

        System.out.println("[PASS] " + testName);
    }
    
    /**
     * Asserts that two integer values are equal and prints PASS/FAIL output.
     *
     * @param testName the name to print in PASS/FAIL output
     * @param expected the expected value
     * @param actual the actual value
     */
    private static void assertEquals(String testName, int expected, int actual) {
        if (expected == actual) {
            System.out.println("[PASS] " + testName + "  Expected: " + expected + "  Actual: " + actual);
        } else {
            System.out.println("[FAIL] " + testName + "  Expected: " + expected + "  Actual: " + actual);
        }
    }

    /**
     * Asserts that a condition is true and prints PASS/FAIL output.
     *
     * @param testName the name to print in PASS/FAIL output
     * @param condition the boolean condition that must be true
     */
    private static void assertTrue(String testName, boolean condition) {
        if (condition) {
            System.out.println("[PASS] " + testName);
        } else {
            System.out.println("[FAIL] " + testName);
        }
    }
}