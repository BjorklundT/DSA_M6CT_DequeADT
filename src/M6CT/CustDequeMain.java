package M6CT;

import java.util.Iterator;
import java.util.Random;


/**
 * Demonstration runner for {@link CustDeque}.
 *
 * <p>This class generates an array of ten random integers, enqueues them into a
 * {@code CustDeque} by alternating between the front and back, then prints the
 * deque contents using the custom iterator.</p>
 */
public class CustDequeMain {

    /**
     * Program entry point. Demonstrates insertion and traversal using {@link CustDeque}.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        CustDeque deque = new CustDeque();

        int[] testData = generateRandomArray(10, -50, 50);

        System.out.println("Random Test Array:");
        printArray(testData);

    	//****************************
        //Que array Alternating Front to Back
    	//****************************
        System.out.println("\nAdding data (alternating front/back)");
        
        for (int i = 0; i < testData.length; i++) {
            if (i % 2 == 0) {
                deque.queFront(testData[i]);
                System.out.println("queFront(" + testData[i] + ")");
            } else {
                deque.queBack(testData[i]);
                System.out.println("queBack(" + testData[i] + ")");
            }
        }

    	//****************************
        //Print using Iterator and Size method
    	//****************************
        System.out.println("\nPrint contents using iterator:");

        Iterator<Integer> iterator = deque.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " / ");
        }

        System.out.println("\n\nDeque size: " + deque.size());
    }

	//****************************
    //Helper Test Methods
	//****************************
    
    /**
     * Generates an array of random integers.
     *
     * @param size the number of integers to generate
     * @param min the minimum possible value (inclusive)
     * @param max the maximum possible value (inclusive)
     * @return an int array filled with random values in the given range
     */
    private static int[] generateRandomArray(int size, int min, int max) {
        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt((max - min) + 1) + min;
        }

        return array;
    }

    /**
     * Prints an array in a readable format.
     *
     * @param array the array to print
     */
    private static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}