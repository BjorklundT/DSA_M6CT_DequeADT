package M6CT;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Iterator;


/**
 * A custom double-ended queue (deque) abstraction that supports insertion and deletion
 * from both the front and rear ends.
 *
 * <p>This implementation wraps a {@link LinkedList} via the {@link Deque} interface.
 * It also provides a custom iterator through an inner class to traverse elements
 * from front to rear.</p>
 */
public class CustDeque {

    /**
     * Internal storage for the deque. Uses a {@link LinkedList} implementation.
     */
	private final Deque<Integer> deque;
	
    /**
     * Constructs an empty {@code CustDeque}.
     */
	public CustDeque() {
		this.deque = new LinkedList<>();
	}
	
    /**
     * Returns an iterator for traversing the deque from front to rear.
     *
     * <p>The returned iterator is backed by the underlying deque. If the deque is
     * modified after the iterator is created, iteration behavior follows the rules
     * of the underlying {@link LinkedList} iterator (which is typically fail-fast).</p>
     *
     * @return an {@link Iterator} for the elements in this deque
     */
    public Iterator<Integer> iterator() {
        return new queIterator();
    }
	
	//****************************
	//Front
	//****************************
    
    /**
     * Inserts a new element at the front of the deque.
     *
     * @param data the integer value to insert
     */
	public void queFront(int data) {
		deque.addFirst(data);
	}
	
    /**
     * Removes and returns the element at the front of the deque.
     *
     * @return the integer removed from the front
     * @throws NoSuchElementException if the deque is empty
     */
	public int dequeFront() {
		requireNotEmpty();
		return deque.removeFirst();
	}
	
	//****************************
	//Rear
	//****************************
	
    /**
     * Inserts a new element at the rear (back) of the deque.
     *
     * @param data the integer value to insert
     */
	public void queBack(int data) {
		deque.addLast(data);
	}
	
    /**
     * Removes and returns the element at the rear (back) of the deque.
     *
     * @return the integer removed from the rear
     * @throws NoSuchElementException if the deque is empty
     */
    public int dequeRear() {
        requireNotEmpty();
        return deque.removeLast();
    }
	
	//****************************
	//Utilities and Helper Methods
	//****************************
    
    /**
     * Checks whether the deque is empty.
     *
     * @return {@code true} if the deque contains no elements, {@code false} otherwise
     */
	public boolean isEmpty() {
		return deque.isEmpty();
	}
	
    /**
     * Returns the number of elements currently stored in the deque.
     *
     * @return the element count
     */
	public int size() {
		return deque.size();
	}
	
    /**
     * Validates that the deque is not empty.
     *
     * @throws NoSuchElementException if the deque is empty
     */
    private void requireNotEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
    }
    
	//****************************
	//Inner CLASS: Private Iterator Logic
	//****************************
    
    /**
     * Custom iterator used to traverse this deque from front to rear.
     *
     * <p>This iterator wraps the underlying {@link Deque#iterator()} to preserve
     * encapsulation while still providing standard {@link Iterator} behavior.</p>
     */
    private class queIterator implements Iterator<Integer> {
    	
        /**
         * The underlying iterator from the internal deque.
         */
    	private final Iterator<Integer> iterator;
    	
        /**
         * Constructs an iterator positioned at the front of the deque.
         */
    	private queIterator() {
    		this.iterator = deque.iterator();
    	}
    	
        /**
         * Checks whether another element exists during traversal.
         *
         * @return {@code true} if another element exists, {@code false} otherwise
         */
    	@Override
    	public boolean hasNext() {
    		return iterator.hasNext();
    	}
    	
        /**
         * Returns the next element and advances the iterator.
         *
         * @return the next integer in traversal order
         * @throws NoSuchElementException if no next element exists
         */
    	@Override
    	public Integer next() {
    		if (!hasNext()) {
    			throw new NoSuchElementException("No more elements in deque");
    		}
    		return iterator.next();
    	}
    }
}

