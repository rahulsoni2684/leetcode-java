
/**
 * 21. Merge Two Sorted Lists
 */
public class MergeTwoSortedLists {

// Definition for singly-linked list.
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

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode temp = new ListNode();
		ListNode cur = temp;

		while (list1 != null && list2 != null) {

			if (list1.val < list2.val) {
				cur.next = list1;
				list1 = list1.next;
			} else {
				cur.next = list2;
				list2 = list2.next;
			}

			cur = cur.next;
		}

		if (list1 != null) {
			cur.next = list1;
			list1 = list1.next;
		}
		if (list2 != null) {
			cur.next = list2;
			list2 = list2.next;
		}

		return temp.next;
	}
	
	// Helper function to print a given linked list
    public static void printList(String msg, ListNode head)
    {
        System.out.print(msg);
 
        ListNode ptr = head;
        while (ptr != null)
        {
            System.out.print(ptr.val + " —> ");
            ptr = ptr.next;
        }
 
        System.out.println("null");
    }
    
	public static void main(String[] args)
    {
		 MergeTwoSortedLists obj =  new MergeTwoSortedLists();
        // input keys
        int[] keys = { 1, 2, 3, 4, 5, 6, 7 };
 
        ListNode a = null;
        ListNode b = null;
        
        for (int i = keys.length - 1; i >= 0; i = i - 2) {
             a = obj.new ListNode(keys[i], a);
        }
 
        for (int i = keys.length - 2; i >= 0; i = i - 2) {
            b = obj.new ListNode(keys[i], b);
        }
 
        // print both lists
        printList("First List: ", a);
        printList("Second List: ", b);
       
        ListNode head = obj.mergeTwoLists(a, b);
        printList("After Merge: ", head);
    }
}