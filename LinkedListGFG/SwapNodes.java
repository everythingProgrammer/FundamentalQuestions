package LinkedListGFG;

public class SwapNodes {
	
	
	public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode newNode = swapPairs(head.next.next);
		ListNode temp = head.next;
		temp.next = head;
		head.next = newNode;
		return temp;
		
		
	}
	
}
