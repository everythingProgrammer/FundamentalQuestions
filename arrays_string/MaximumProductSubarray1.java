package arrays_string;

public class MaximumProductSubarray1 {
	
	public int maxProduct(int nums[]) {
		if(nums.length == 0) {
			return -1;
		}
		
		int current_max = nums[0];
		int current_min = nums[0];
		int global_max = 0;
		
		for(int i = 1 ; i< nums.length ; i++) {
			int temp = current_max; 
			current_max = Math.max(Math.max(current_max * nums[i],  current_min * nums[i]), nums[i]);
			current_min = Math.min(Math.min(temp * nums[i], current_min * nums[i]),nums[i]);
			
			if(current_max > global_max)
				global_max = current_max;
			
		}
		
		return global_max;
		
	}

}
