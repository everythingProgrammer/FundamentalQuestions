package arrays_string;

public class SearchInRotated {
	
	
	public static int search(int arr[] , int search) {
		if(arr  == null || arr.length == 0) {
			return -1;
		}
		
		int start = 0;
		int end = arr.length -1;
		int mid = 0;
		
		while(start <= end) {
			mid = (start + end)/2;
			
//			System.out.println("start  "+start+" end "+end);
			
			if( arr[mid] == search)
				return mid;
			
			
			/*Now either the pointer is in right part or in left part */
			/*Starting with left part. */
			if(arr[mid] > arr[arr.length -1]) {
			
				if(search > arr[mid] || search < arr[start]) {
					start = mid+1;
				}
				else 
					end = mid-1;
			}
			
				
			else if( arr[mid] < arr[0]) {
				if(search < arr[mid] || search > arr[arr.length -1 ])
					end = mid -1;
				else
					start = mid+1;
			}	
		}
		return -1;
	}
	
	
	public static void main(String args[]){
		int arr[] = {5,6,7,8,9,0,1,2,3,4};
		System.out.println(search(arr, 9));
	}

}
