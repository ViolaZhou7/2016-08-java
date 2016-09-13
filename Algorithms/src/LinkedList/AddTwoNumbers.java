package LinkedList;

public class AddTwoNumbers {
	//You are given two linked lists representing two non-negative numbers. 
	//The digits are stored in reverse order and each of their nodes contain a 
	//single digit. Add the two numbers and return it as a linked list.
	public static void main(String[] args) {
		//Input: (9 -> 9 -> 9) + (1 -> 1 -> 1)
		//Output: 7 -> 0 -> 8
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		//ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(9);
		ListNode n5 = new ListNode(9);
		ListNode n6 = new ListNode(9);
		
		n1.next = n2;
		//n2.next = n3;
		
		n4.next = n5;
		n5.next = n6;
		
		addTwoNumbers(n1, n4);
	}

	private static void addTwoNumbers(ListNode n1, ListNode n4) {
		int carry = 0;
		// initialize first digit as 0, not counted in the final result
		ListNode t1 = new ListNode(0);
		// p3 = t1, two pointers point to one reference, proceeds p3 but remains t1 at the original position
		ListNode p1 = n1, p2 = n4, p3 = t1;
		while (p1 != null || p2 != null){
			if(p1 != null){
				carry += p1.value;
				p1 = p1.next;
			}
			if(p2 != null){
				carry += p2.value;
				p2 = p2.next;
			}
			
			p3.next = new ListNode(carry % 10);
			p3 = p3.next;
			carry = carry / 10;
		}
		if(carry == 1){
			p3.next = new ListNode(1);
		}
		
		t1 = t1.next; // first digit is 0, not counted in the final result
		while (t1 != null){
			System.out.println(t1.value);
			t1 = t1.next;
		}
	}

}
