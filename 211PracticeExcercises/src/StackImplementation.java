import java.util.ArrayList;

public class StackImplementation<T> implements Stack<T> {

	private ArrayList<T> items = new ArrayList<T>();

	public void push(T item) {

		items.add(item);

	}

	public T pop() {
		if (!items.isEmpty()) {
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

	public T getData(int index) {
		return items.get(index); 
	}

	public int length() {
		return items.size();
	}
	public void print() {
		for(int i = 0; i < items.size(); i ++) {
			System.out.println(items.get(i));
		}
	} 

}
