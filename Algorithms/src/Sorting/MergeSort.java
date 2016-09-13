package Sorting;

public class MergeSort {
	// time complexity: O(nlogn)
	// space complexity: depends
	// key idea:
	// Break the sorted list to two in the middle
	// Recursively sort the two sub lists
	// Merge the two sub lists
	public static void main(String[] args) {
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);
 
		ListNode n4 = new ListNode(1);
		ListNode n5 = new ListNode(2);
		ListNode n6 = new ListNode(3);
 
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		
		ListNode p = breakList(n1); // pass the head, return the head of merged list
		
		while(p != null){
			System.out.println(p.value);
			p = p.next;
		}
	}

	private static ListNode breakList(ListNode n1) {
		if(n1 == null || n1.next == null)
			return n1;
		
		int count=0;
		ListNode p1 = n1;
		while(p1 != null){ // count # of elements in the list
			count++;
			p1=p1.next;
		}
		
		int half = count / 2; 
		int countHalf = 0;
		
		ListNode l=n1,r=null;
		ListNode p2=n1; // proceed on p2
		while(p2 != null){ // break the list into 2 equal-size parts
			countHalf++;
			ListNode next = p2.next;
			if(countHalf == half){ 
				r=next; // head of second half list
				p2.next = null;
			}
			p2=p2.next;
		}
		
		// now we have l & r, recursively break them
		ListNode h1 = breakList(l);
		ListNode h2 = breakList(r);
		
		ListNode merged = merge(h1,h2); // pass two heads, return the head of the merged list
		return merged;
	}

	private static ListNode merge(ListNode h1, ListNode h2) {
		ListNode p1 = h1;
		ListNode p2 = h2;
		
		ListNode head = new ListNode(0); // initialize a fake head
		ListNode p = head;
		while(p1 != null || p2 != null){
			if(p1 == null){ // no element in p1, proceed p2
				p.next = new ListNode(p2.value);
				p2 = p2.next;
				p = p.next;
			}else if(p2 == null){ // no element in p2, proceed p1
				p.next = new ListNode(p1.value);
				p1 = p1.next;
				p = p.next;
				
			}else{ // elements in both p1 and p2, proceed based on values
				if(p1.value < p2.value){
					p.next = new ListNode(p1.value);
					p1 = p1.next;
					p = p.next;
				}else{
					p.next = new ListNode(p2.value);
					p2 = p2.next;
					p = p.next;
				}
			}
		}
		
		return head.next; // first element is fake
	}
}
