package arrays_string;
/*does not works*/
import java.util.*;
public class ClosestSum3 {
	public static int threeSumClosest(int[] nums, int target) {
        int closest_sum =0, closest_difference = Integer.MAX_VALUE;
        int i = 0, j = 0 , k = 0;
        Arrays.sort(nums);
        for(  i = 0 ; i<= nums.length-3 ; i++) {
        	int sum = 0;
        	j = i+1; 
        	k = nums.length -1; 
        	sum+= nums[i]+nums[j]+nums[k];
        	
        	while(j<k) {
        		if(Math.abs(sum - target) < closest_difference ) {
        			closest_difference = Math.abs(sum - target) ;
        			closest_sum =sum;
        		}
        		if( sum > target) {
        			sum-= nums[k];
        			k--;
        			sum+= nums[k];
        		}
        		else if( sum < target) {
        			sum-= nums[j];
        			j++;
        			sum+= nums[j];
        		}
        		else
        			return sum;
        		/*Third else is in case our value of num[i]+nums[j]+ nums[k] == the target value then we have to return this
        		 *sum directly.*/
        	}
        	
        	
        }
        return closest_sum;   
    }
	
	public static void main(String args[]) {
		int arr[] = {-1, 2,1,-4};
		System.out.println(threeSumClosest(arr , 1));
	}
}
