
public class RecursionExcercise {
	public static void main(String [] args) {
		RecursionExcercise recursive = new RecursionExcercise(); 
		recursive.go(); 
		
	}
	
	public void go() {
		int[] arr = {1,3,6,3,4,8};
		System.out.println(findLargeElement(arr, arr.length)); 
		
		
		
		
		
		
	}
	
	public int findLargeElement(int[] arr, int arrayLength) {
		//base 
		if(arrayLength == 1) 
			return arr[0]; 
		
		return Math.max(arr[arrayLength-1], findLargeElement(arr, arrayLength-1));
		
			
		 
		
		
	}
	
	
	
}
