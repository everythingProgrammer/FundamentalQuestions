package LinkedListGFG;

 

public class LinkedListDriver {
	public static ListNode head = null;
	public static ListNode current = null;
	public void addLast(int a) {
		ListNode temp = head; 
		ListNode nn = new ListNode(a,null);
		
		if(current == null) {
			head = nn;
			current = nn;
		}else {
			current.next = nn;
			current = nn;
		}
	}
	
	public void display() {
		ListNode temp = head;
//		System.out.println("Entering loop");
		while(temp!=null) {
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
	}
	
	public static ListNode reverse(ListNode head) {
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
	public static void main(String args[]) {
		LinkedListDriver ll = new LinkedListDriver();
		ll.addLast(1);
		ll.addLast(2);
//		ll.addLast(1);
//		ll.addLast(4);
		ll.display();
		PallindromeLinkedlist p = new PallindromeLinkedlist();
		System.out.println( isPalindrome(ll.head));
	}
}
