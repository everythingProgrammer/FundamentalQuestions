package LinkedListGFG;

public class LinkedListCycle2 {
	public ListNode detectCycle(ListNode head) {
		if(head == null )
			return null;
		
		ListNode sp = head;
		ListNode fp = head.next;
		
		while(  sp!=fp) {
			if(fp== null || fp.next == null) {
				return null;
			}
			
			sp = sp.next;
			fp = fp.next.next;
		}
		return sp==null?null:sp.next;
    }
}
