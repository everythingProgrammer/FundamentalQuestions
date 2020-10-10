package arrays_string;

public class MoveZeroes {
	
	public static void moveZeroes(int arr[]) {
		int j = 0; 
		
		for(int i = 0 ; i< arr.length ; i++) {
			
			if(arr[i] != 0 ) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j++;
			}
		}
	}
	
	
	public static void main(String args[]) {
		int arr[]= {1,3,0,2,4,0,5,0,6};
		moveZeroes(arr);
	}

}
