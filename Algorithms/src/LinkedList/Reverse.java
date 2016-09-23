package LinkedList;

public class Reverse {

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
		
		ListNode current = reverse(n1);
		while(current.next != null){
			System.out.println(current.value);
			current = current.next;
		}

	}

	private static ListNode reverse(ListNode n1) {
		ListNode tail = new ListNode(0); // fake tail in the reversed linked list
		ListNode n = n1;
		while(n.next != null){ // reverse the linked list, until the last second node
			ListNode temp = n.next;
			n.next = tail;
			tail = n;
			n = temp;
		}
		
		n.next = tail; // link last node in the original linked list
		
		return n;
		
	}

}
