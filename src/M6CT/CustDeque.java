package M6CT;

import java.util.Deque;
import java.util.LinkedList;

public class CustDeque {

	private final Deque<Integer> deque;
		
	public CustDeque() {
		this.deque = new LinkedList<>();
	}
		
	public boolean isEmpty() {
		return deque.isEmpty();
	}
		
	public int size() {
		return deque.size();
	}
	
	public static void main(String[] args) {
		CustDeque DequeTemp = new CustDeque();
		
		System.out.println("Deque created.");
		System.out.println("isEmpty(): " + DequeTemp.isEmpty());
		System.out.println("size(): " + DequeTemp.size());
	}
	
}

