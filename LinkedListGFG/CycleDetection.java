package LinkedListGFG;

public class CycleDetection {
	
	public boolean hasCycle(ListNode head) {
		
		if(head == null )
			return false;
		
		ListNode sp = head;
		ListNode fp = head.next;
		
		while(  sp!=fp) {
			if(fp== null || fp.next == null) {
				return false;
			}
			
			sp = sp.next;
			fp = fp.next.next;
		}
		return sp==null?false:true;
		
	}
	
	
}
