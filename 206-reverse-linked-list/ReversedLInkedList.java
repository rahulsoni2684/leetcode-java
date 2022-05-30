/**
 * 206. Reverse Linked List
 */

public class ReversedLInkedList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode reverseList(ListNode head) {

		ListNode prev = null;
		ListNode nextNode;

		while (head != null) {
			nextNode = head.next;
			head.next = prev;
			prev = head;
			head = nextNode;
		}

		return prev;
	}

	public static void main(String[] args) {
		ReversedLInkedList obj = new ReversedLInkedList();
		// input keys
		int[] keys = { 1, 2, 3, 4, 5, 6, 7 };

		ListNode a = null;
		for (int i = keys.length - 1; i >= 0; i = i - 2) {
			a = obj.new ListNode(keys[i], a);
		}
		// print both lists
		printList("Original List: ", a);

		ListNode head = obj.reverseList(a);
		printList("Reversed List: ", head);
	}

	// Helper function to print a given linked list
	public static void printList(String msg, ListNode head) {
		System.out.print(msg);

		ListNode ptr = head;
		while (ptr != null) {
			System.out.print(ptr.val + " —> ");
			ptr = ptr.next;
		}

		System.out.println("null");
	}
}
