package LinkedListGFG;

import java.util.*;
public class IntersectionLinkedlist {
	
	class ListNode{
		int val; 
		ListNode next; 
		
	}
	
	public ListNode head; 
	private ListNode tail; 
	private int size; 
	
	/*This is simply substracting the difference of lengths from larger linkedlist and then traversing 
	 * both the linkedlist to find the repeating values.*/
	 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	     int lena =0;   
	     ListNode iterator = headA;
		 while(iterator != null) {
			 lena++;
			 iterator = iterator.next;
			 
		 }
		 
		 int lenb = 0;
		 iterator = headB;
		 while( iterator != null) {
			 lenb++;
			 iterator = iterator.next;
			 
		 }
		 int moveForward = Math.abs( lena-lenb);
		 
		 if(lena>lenb)
			 while(moveForward>0) {
				 headA=headA.next;
				 moveForward--;
			 }
		 else
			 while(moveForward>0) {
				 headB=headB.next;
				 moveForward--;
			 }
		 
		
		 while(headA!= null && headB != null) {
			 if(headA.val== headB.val) {
				 return headA;
			 }
		 }
		 return null;
		 
	 }

	 
	 /*This is a better approach by using hashmap 
	  * Traverse and store first linkedlist in hashmap and then traverse second linkedlist and if same element is repeated then
	  * return corresponding node*/
	 public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		 

		 HashSet<ListNode> mapuh = new HashSet<>();
		 
		 ListNode iterator = headA;
		 while(iterator != null) {
			 mapuh.add(iterator);
		 }
		 iterator = headB;
		 while(iterator != null) {
			 if(mapuh.contains(iterator))
				 return iterator;
		 }
		 return null;
	 }


	 public ListNode getIntersection(ListNode headA , ListNode headB) {
		 
		 ListNode iteratorA = headA;
		 ListNode iteratorB = headB;
		 
		 
		 return headA;
	 }
	 // has to be checked
	 public ListNode getIntersection3(ListNode headA, ListNode headB) {
		 ListNode Ta = headA;
		 ListNode Tb = headB;
		 while(Ta.next!= null && Tb.next!=null) {
			 Ta= Ta.next;
			 Tb= Tb.next;
		 }
		 if(Ta.next == null) {
			 Ta = headB;
		 }
		 if(Tb.next == null) {
			 Tb = headA;
		 }
		 while(Ta.next!= null && Tb.next!=null) {
			 Ta= Ta.next;
			 Tb= Tb.next;
		 }
		 if(Ta.next == null) {
			 Ta = headB;
		 }
		 if(Tb.next == null) {
			 Tb = headA;
		 }
		 
		 while(Ta != null && Tb != null) {
			 if(Ta == Tb )
				 return Ta;
			 Ta = Ta.next;
			 Tb = Tb.next;
		 }
		 return null;
	 }
}
