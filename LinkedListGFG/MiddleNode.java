package LinkedListGFG;

public class MiddleNode {
	public ListNode middleNode(ListNode head) {
        if(head == null) {
        	return null;
        }
        if(head.next == null)
        {
        	return head;
        }
        
        
        ListNode sp = head;
        ListNode fp = head;
        
        while(fp!= null && fp.next!=null)
        {
        	sp = sp.next;
        	fp = fp.next.next;
        }
        return sp;
        
        
    }
}
