package LinkedList;

public class ReorderList {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		
		// construct the relationship
		n1.next = n2; 
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		
		reorderList(n1); 
		
		while(n1 != null){
			System.out.println(n1.value);
			n1 = n1.next;
		}
		
	}

	private static void reorderList(ListNode n1) {
		// discard null list scenario
		
		ListNode slow = n1; // head of list
		ListNode fast = n1; // head of list
		
		while(fast != null && fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode second = slow.next; // second part
		slow.next = null; // terminate first part
		
		second = reverseOrder(second); // return head of reversed list
		
		ListNode p1 = n1; // head of first part
		ListNode p2 = second; // head of second part
		
		// merge two parts
		// i.e. if the list is 1,2,3,4,5,6,7; then first part is 1,2,3,4, 
		// reversed second part is 7,6,5
		// if the list is 1,2,3,4,5,6; then first part is 1,2,3,
		// reversed second part is 6,5,4
		while(p2 != null){ 
			ListNode t1 = p1.next;
			ListNode t2 = p2.next;
			
			p1.next = p2;
			p2.next = t1;
			
			p1 = t1;
			p2 = t2;
		}
		
	}

	private static ListNode reverseOrder(ListNode head) {
		if(head == null || head.next == null)
			return head;
		
		ListNode pre = head;
		ListNode curr = head.next;
		
		while(curr != null){
			ListNode temp = curr.next;
			curr.next = pre; // reverse order
			pre = curr;
			curr = temp;
		}
		
		head.next = null; // terminate the last entry
		
		return pre;
	}

}
