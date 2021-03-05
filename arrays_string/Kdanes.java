package arrays_string;

public class Kdanes {
	
	public static int maxSum(int arr[]) {
		int global_max ;
		int current_max = global_max = arr[0];
		
		for(int i =1  ; i< arr.length ; i++) {
			current_max = Math.max(arr[i], arr[i]+current_max);
			
			
			if( current_max > global_max) {
				global_max = current_max;
			}
			
		}
		return global_max;		
	}
	
	
	public static void main(String args[]) {
		int arr[]  = {1,-3,2,1,-1};
		System.out.println(maxSum(arr));
	}
}
