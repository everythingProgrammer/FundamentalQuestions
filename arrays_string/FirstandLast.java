package arrays_string;
/*First and last index of an element using binary search .*/
public class FirstandLast {
	
	public  int[] searchRange(int[] nums, int target) {
        int arr[] = new int[2];
        arr[0] = -1;
        arr[1] = -1;
        
        arr[0] = getFirst(nums, target );
        arr[1] = getLast(nums , target);
        
        return arr;
    }

	public int getFirst(int nums[] , int target  ) {
		 int n = nums.length;
		 int l = 0 , r = n-1;
		 int ans = Integer.MIN_VALUE;
		 
		 while(l<= r ) {
			 int mid = (l+r)/ 2;
			 if(nums[mid]  == target ) {
				 ans = Math.min(ans, mid);
				 r = mid-1;
			 }
			 else if(nums[mid] > target){
				 r = mid -1;
			 }
			 else 
				 l = mid+1;
		 }
		return ans== Integer.MIN_VALUE ? -1: ans;
	}
	
	public int getLast(int nums[] , int target) {
		int n = nums.length;
		int l = 0 ,r = n-1;
		int ans = Integer.MIN_VALUE;
		while(l<= r) {
			int mid = (l+r)/2;
			if(nums[mid] == target) {
				ans = Math.max(ans, mid);
				l = mid +1;
			}
			else if(nums[mid]>target) {
				r = mid -1;
			}
			else {
				l = mid+1;
			}
		}
		return ans == Integer.MIN_VALUE ? -1: ans;
	}
	

}
