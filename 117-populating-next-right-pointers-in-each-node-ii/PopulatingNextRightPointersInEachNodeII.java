package algorithm2;

import common.CustomBinaryTree;
import common.Node;

public class PopulatingNextRightPointersInEachNodeII {

	static Node connect(Node root) {
		if (root == null) {
			return null;
		}

		Node cur = root;

		while (cur != null) {
			Node dummy = new Node(0);
			Node prev = dummy;

			while (cur != null) {
				if (cur.left != null) {
					prev.next = cur.left;
					prev = prev.next;
				}

				if (cur.right != null) {
					prev.next = cur.right;
					prev = prev.next;
				}
				cur = cur.next;
			}
			cur = dummy.next;
		}
		return root;
	}
	
    public static void main(String args[])
    {
         /* Constructed binary tree is
                1
              /   \
             2      3 
           /  \      \
          4    5      7
        */
        CustomBinaryTree tree = new CustomBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(7);
  
        // Populates nextRight pointer in all nodes
        connect(tree.root);
          
		// Let us check the values of nextRight pointers
		int a = tree.root.next != null ? tree.root.next.val : -1;
		int b = tree.root.left.next != null ? tree.root.left.next.val : -1;
		int c = tree.root.right.next != null ? tree.root.right.next.val : -1;
		int d = tree.root.left.left.next != null ? tree.root.left.left.next.val : -1;
		int e = tree.root.right.right.next != null ? tree.root.right.right.next.val : -1;

		// Now lets print the values
		System.out.println(
				"Following are populated next pointers in " + " the tree(-1 is printed if there is no next)");
		System.out.println("next of " + tree.root.val + " is " + a);
		System.out.println("next of " + tree.root.left.val + " is " + b);
		System.out.println("next of " + tree.root.right.val + " is " + c);
		System.out.println("next of " + tree.root.left.left.val + " is " + d);
		System.out.println("next of " + tree.root.right.right.val + " is " + e);
	}

}
