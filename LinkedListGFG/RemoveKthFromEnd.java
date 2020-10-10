package LinkedListGFG;

public class RemoveKthFromEnd {
	/*Slow pointer fast pointer approach*/
	public ListNode removeNthFromEnd(ListNode head, int n) {
		
		if(head.next == null) {
			return null;
		}
		
		
		ListNode slp = head;
		ListNode fp = head;
		while(n>0 && fp!= null) {
			fp = fp.next;
			n--;
		}
		/*Corner case 
		 * [1,2]  2
		 * Here we have 2 nodes and we have to delete 2nd from end i.e 1
		 * so incase fp becomes null then delete the very first node*/
		
		while(fp.next != null) {
			fp = fp.next;
			slp = slp.next;
		}
		/*here fp.next = null i.e. fp is at the last node
		 *here remove next of slp*/
		slp.next = slp.next.next;
		return head;
	}
}
