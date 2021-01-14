package heap;
import java.util.*;
public class KthLargest {
	
	
	public int findKthLargest(int [] nums, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		/*remove n-k elements from our min heap and we will be left with kth largest element on top.*/
//		for(int i = 0 ; i<nums.length ; i++) {
//			minHeap.add(nums[i]);
//			
//			
//			if(minHeap.size()> k) {
//				minHeap.poll();
//			}
//		}
//		return minHeap.poll();
		
		
		/*add only k elements in min heap */
		int i  = 0 ;
		for( ; i< k ; i++) {
			minHeap.add(nums[i]);
		}
		for(;i<nums.length; i++) {
			if(nums[i] > minHeap.peek()) {
				minHeap.poll();
				minHeap.add(nums[i]);
			}
		}
		return minHeap.poll();
	}
}
