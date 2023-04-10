
import java.util.LinkedList;

/**
 * 
 * @author Venkateswarlu
 *
 * @param <E>
 */
public class GenericQueue<E> {

	private LinkedList<E> list = new LinkedList<E>();

	
	public void enqueue(E item) {

		list.addFirst(item);
	}

	
	public E dequeue() {

		return list.removeFirst();
	}

	
	public int size() {

		return list.size();
	}
}
