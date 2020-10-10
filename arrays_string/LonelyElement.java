package arrays_string;

public class LonelyElement {
	
	
	public static boolean single(int arr[], int m ) {
		
		if(m == 0 && arr[0] != arr[1]) {
			return true;
		}
		if(m == arr.length -1 && arr[m] != arr[m-1]) {
			return true;
		}
		
		
		if(arr[m] != arr[m-1] && arr[m] != arr[m+1]) {
			return true;
		}
		return false;
	}
	
	
	public static int findElement( int arr[]) {
	
		
		int l = 0 ; 
		int h = arr.length -1;
		
		while( l<= h) {
			int mid = (l+h)/2;
			if(single(arr, mid) )
				return arr[mid]; 
			
			if(mid+1 < arr.length && arr[mid] == arr[mid+1]) {
				if(mid%2 == 0) {
					l = mid+1;
				}else {
					h = mid -1;
				}
			}
			if( mid >=1 && arr[mid] == arr[mid-1]) {
				if( ((mid) %2) ==1) {
					l = mid+1;
				}
				else 
					h = mid-1;
			}
				
			
		}
		
		return arr[1];
	}
	
	public static void main(String args[]) {
		int arr[] = {1,1,2,2,3,3,4,4,5,6,6,7,7};
		System.out.println(findElement(arr));
	}

}
