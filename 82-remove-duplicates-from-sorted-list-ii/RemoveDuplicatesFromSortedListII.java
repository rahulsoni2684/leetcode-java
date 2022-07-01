package algorithm2;

import common.CustomLinkedList;
import common.ListNode;

public class RemoveDuplicatesFromSortedListII {
	
	static ListNode deleteDuplicates(ListNode head) {
		
		if (head == null) {
			return head;
		}

		ListNode beforeHead = new ListNode(-1, head);
		beforeHead.next = head;
		ListNode prev = beforeHead;
		ListNode cur = head;

		while (cur != null) {
			if (cur.next != null && cur.val == cur.next.val) {
				// this loop is for continuous duplicate elements
				while (cur.next != null && cur.val == cur.next.val) {
					cur = cur.next;
				}
				// skip all the elements lies between prev and cur because they all are
				// duplicate
				prev.next = cur.next;
			} else {
				prev = prev.next;
			}
			cur = cur.next;
		}
		return beforeHead.next;
	}


	public static void main(String[] args) {
		ListNode head = CustomLinkedList.makeList(new int[] { 1, 1, 1, 2, 3 });

		System.out.println("Linked list with duplicate");
		CustomLinkedList.printList(head);

		ListNode curHead = RemoveDuplicatesFromSortedListII.deleteDuplicates(head);

		System.out.println("\nLinked list without duplicate");
		CustomLinkedList.printList(curHead);
	}

}
