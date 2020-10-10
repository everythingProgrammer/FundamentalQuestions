package arrays_string;
import java.util.*;
public class Balanced01Array {
	
	 public static int findMaxLength(int[] nums) {
	        int count = 0;
	        int ans = 0;
	        /*Count , Index */
	        /*The Idea here is that wherever the values of count is same */
	        HashMap<Integer, Integer> uCount = new HashMap<>();
	        uCount.put(0,-1);
	        count =0;
	         
	        for(int i =0  ; i< nums.length ; i++) {
	        	if(nums[i] == 0)
	        		count -=1;
	        	else
	        		count +=1;
	        	
	        	 if(uCount.containsKey(count)) {
//	        		 System.out.println(uCount.get(count) + " " +i);
	        		 ans = Math.max(ans, i-uCount.get(count) );
	        	 }
	        	 else
	        		 uCount.put(count, i );
	        }
	        System.out.println(uCount);
	        return ans;
	    }
	 
	 
	 public static void main(String args[]) {
		 int arr[] = {1,0,0,0,0,1,1,1};
		 System.out.println(findMaxLength(arr));
	 }
	 
}
