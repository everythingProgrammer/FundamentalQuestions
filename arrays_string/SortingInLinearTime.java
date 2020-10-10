package arrays_string;

public class SortingInLinearTime {
	
	public static void swap(int arr[], int a , int b) {
		int temp = arr[a];
		  arr[a] = arr[b];
		  arr[b] = temp;
	}
	
	
	public static void threePointerApproach(int arr[]) {
		int left = 0 , right = arr.length -1 , c = 0;
		
		
		while(c<= right) {
			if( arr[c] == 0 ) {
				swap(arr,c,left);
				left++;
				c++;
			}
			else if( arr[c] == 2) {
				swap(arr, c , right);
				right--;
			}
			else {
				c++;
			}
		}
		
		for(int a = 0; a< arr.length ; a++) {
			System.out.print(arr[a]+" ");
		}
		
	}
	
	
	public static void main(String args[]) {
		int arr[] = {1,1,0,0,2,2,0,1};
		threePointerApproach(arr);
	}
}
