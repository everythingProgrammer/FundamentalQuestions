package arrays_string;

public class FindMissingPositive {
	
	 public static  int firstMissingPositive(int[] nums) {

		 int n = nums.length;
		 /*Converting -ve numbers into N+2*/
		 for(int i =0 ; i< n ; i++) {
			 if(nums[i] <=0 || nums[i] > n+1)
				 nums[i] = n+2;
		 }
		 /*Converting all the appearing Indexes to -ve*/
		 for(int v:nums) {
			 int i = v>0? v-1: -v-1;
			 if(i >= 0 && i<n)
				 nums[i] = -Math.abs(nums[i]);
		 }
		 
		 for(int i = 0 ; i<n; i++) {
			 if(nums[i] > 0) {
				 return i+1;
			 }
		 }
		 return n+1;
	 }
	 public static void main(String args[]) {
		 int nums [] = {1,2,0};
		System.out.println( firstMissingPositive(nums));
	 }
}
