package arrays_string;
/*Nick white's approach*/
public class SearchinRotated2 {
	
	
	public static int find(int nums[] , int search) {
		/*So first find the smallest element*/
		int n = nums.length ;
		int left = 0;
		int right = n-1;
		int midpoint = 0;
		while(left<right) {
			midpoint = (left+ (right )) / 2;
			if(nums[midpoint] > nums[right]) {
				left = midpoint+1;
			}else
				right = midpoint;	
		}
		int start = left;
		left = 0;
		right = n-1;
		 /*Now check on which side of the array does the searching element lies.*/
		if( search >= nums[start] && search <= nums[right])
			left = start;
		else
			right = start;
		
		/*Now simple binary search will do*/
		while(left <= right) {
			midpoint = (left+ (right )) / 2;
			
			if( nums[midpoint] == search)
				return midpoint;
			else if (nums[midpoint] > search)
				right = midpoint-1;
			else if(nums[midpoint] < search) {
				left = midpoint+1;
			}

		}
		return -1;
	}
	
	
	public static void main(String args[]) {
		int arr[] = {3,4,5,6,7,0,1,2};
		System.out.println(find(arr, 0));
	}
	
	
}
