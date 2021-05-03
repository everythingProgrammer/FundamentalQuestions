package LinkedListGFG;
import java.util.*;

//https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/593/week-1-april-1st-april-7th/3693/

 

public class PallindromeLinkedlist {
	
	/*Oneway is using stacks*/
	public static boolean isPallindromeStacks(ListNode head) {
		Stack<Integer> stack  = new Stack<>();
		ListNode ptr = head;
		while(ptr!=null) {
			stack.push(ptr.val);
			ptr = ptr.next;
		}
		ptr= head;
		while(ptr!=null) {
			if(ptr.val != stack.pop()) {
				return false;
			}
		}
		return true;
	}
	/*but this method takes O(n) extra space ,
	 * we need O(1) space */
	public ListNode reverse(ListNode head) {
		ListNode current = head;
		ListNode prevNode = null, nextNode = null;
		while(current!=null) {
			nextNode = current.next;
			current.next = prevNode;
			prevNode = current;
			current = nextNode;
		}
		return prevNode;
	}
	
	public static boolean isPalindrome(ListNode head) {
		ListNode slowptr = head;
		int size = 0 ;
		while(slowptr != null) {
			size ++;
			slowptr = slowptr.next;
		}
		slowptr = head;
		int mid = size%2 == 0?size/2:(size+1)/2;
		for(int i = 0 ; i<  mid; i++) {
			slowptr = slowptr.next;
		}
		ListNode midNode = reverse(slowptr) ;
		while(midNode!= null && head!=null ) {
			if(midNode.val != head.val) {
				return false;
			}
			
			
			midNode= midNode.next;
			head = head.next ;
		}
		return true;
	}
	
}
