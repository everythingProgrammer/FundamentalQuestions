package hashing;
import java.util.*;
public class MaximumSumOfSubarrayWithTargetSum {
	
	
	
	/*In this method we don't update hashmap with value with has been inserted once because we need the longest 
	 * subarray , for example we got a 10 at index 2 and another at index 5 and we need 10 to make
	 * k , then 10 at smaller index i.e. 2 will be required first ...*/
	public static int geeksforgeeks(int arr[] , int k) {
		
		int sum = 0; 
		int maxLength = 0;
		
		HashMap <Integer, Integer> map = new HashMap<>();
		
		for(int i = 0 ; i< arr.length ; i++) {
			sum = sum+arr[i];
			if(sum == k ) {
				maxLength = i+1;
			}
			if(!map.containsKey(sum)) {
				map.put(sum, i);
			}
			if(map.containsKey(sum - k)) {
				if(maxLength < i - map.get(sum - k)) {
					maxLength = i - map.get(sum - k);
				}
			}
		}
		
		return maxLength;
	}
	
	
}
