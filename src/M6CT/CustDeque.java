package M6CT;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Iterator;

public class CustDeque {

	private final Deque<Integer> deque;
		
	public CustDeque() {
		this.deque = new LinkedList<>();
	}
	
    public Iterator<Integer> iterator() {
        return new queIterator();
    }
	
	//****************************
	//Front
	//****************************
	public void queFront(int data) {
		deque.addFirst(data);
	}
	
	public int dequeFront() {
		requireNotEmpty();
		return deque.removeFirst();
	}
	
	//****************************
	//Rear
	//****************************
	public void queBack(int data) {
		deque.addLast(data);
	}
	
    public int dequeRear() {
        requireNotEmpty();
        return deque.removeLast();
    }
	
	//****************************
	//Utilities and Helper Methods
	//****************************
	public boolean isEmpty() {
		return deque.isEmpty();
	}
		
	public int size() {
		return deque.size();
	}
	
    private void requireNotEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
    }
    
	//****************************
	//Inner CLASS: Private Iterator Logic
	//****************************
    private class queIterator implements Iterator<Integer> {
    	private final Iterator<Integer> iterator;
    	
    	private queIterator() {
    		this.iterator = deque.iterator();
    	}
    	
    	@Override
    	public boolean hasNext() {
    		return iterator.hasNext();
    	}
    	
    	@Override
    	public Integer next() {
    		if (!hasNext()) {
    			throw new NoSuchElementException("No more elements in deque");
    		}
    		return iterator.next();
    	}
    }
}

