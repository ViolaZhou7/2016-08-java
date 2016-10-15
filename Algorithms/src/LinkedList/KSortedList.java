package LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KSortedList {

	public static void main(String[] args) {
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(3);
		ListNode a3 = new ListNode(5);
		ListNode a4 = new ListNode(7);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		
		ListNode b1 = new ListNode(2);
		ListNode b2 = new ListNode(4);
		ListNode b3 = new ListNode(6);
		ListNode b4 = new ListNode(8);
		b1.next = b2;
		b2.next = b3;
		b3.next = b4;
		
		ListNode c1 = new ListNode(0);
		ListNode c2 = new ListNode(9);
		ListNode c3 = new ListNode(10);
		ListNode c4 = new ListNode(11);
		c1.next = c2;
		c2.next = c3;
		c3.next = c4;
		
		ListNode[] lists = {a1,b1,c1};
		ListNode head = mergeKSortedList(lists);
		
		while (head.next != null){
			System.out.println(head.value);
			head = head.next;
		}
		
	}

	public static ListNode mergeKSortedList(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;
		
		ListNode head = new ListNode(0); // fake head of result
		ListNode p = head; // proceed on p;
		
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
			public int compare(ListNode n1, ListNode n2){
				return n1.value - n2.value;
			}
		});
		
		// put lists in the queue
		for(ListNode list : lists){
			if(list != null)
				queue.offer(list);
		}
		
		while(!queue.isEmpty()){
			ListNode n = queue.poll();
			p.next = n;
			p = p.next;
			
			if (n.next != null)
				queue.offer(n.next);
		}
		
		return head.next;
	}

}
