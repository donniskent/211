import java.util.ArrayList;
import java.util.Collections;

public class PriorityQueueImplementation<T extends Comparable<T>> implements PriorityQueue<T> {
	private ArrayList<T> items = new ArrayList<T>();
	@Override
	public void add(T item) {
		items.add(item);
		Collections.sort(items);
	}

	@Override
	public T remove() {
		if (!items.isEmpty()) {
			T data = items.get(items.size() - 1);
			items.remove(items.size() - 1);
			return data;
		}

		return null;

	}

	@Override
	public boolean isEmpty() {
		if (items.size() == 0) {
			return true;
		}
		return false;
	}

}
