import java.util.ArrayList;

public class StackImplementation<T> implements Stack<T> {

	private ArrayList<T> items = new ArrayList<T>();

	public void push(T item) {

		items.add(item);

	}

	public T pop() {
		if (items.isEmpty() == false) {
			T data = items.get(items.size() - 1);
			items.remove(items.size() - 1);
			return data;
		}

		return null;

	}

	public boolean isEmpty() {
		if (items.size() == 0) {
			return true;
		}
		return false;
	}

}
