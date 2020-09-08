import java.util.ArrayList;

public class Coordinates {
	private ArrayList <Integer> list; 
	
	Coordinates() {
		list = new ArrayList<Integer>();
		
	}
	
	public void add(int num) {
		list.add(num);
		
		
	}
	public int get(int num) {
		return list.get(num); 
		
	}
	
	public void print() {
		for (int i = 0; i  < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
	
	
}
