package algorithm2;

import common.CustomBinaryTree;
import common.Node;

public class SubtreeOfAnotherTree {
	static boolean isSubtree(Node root, Node subRoot) {

		if (root == null) {
			return false;
		} else if (identical(root, subRoot)) {
			return true;
		} else {
			return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
		}
	}

	static boolean identical(Node root, Node subRoot) {

		if (root == null || subRoot == null)
			return root == null && subRoot == null;
		else if (root.val == subRoot.val) {
			return identical(root.left, subRoot.left) && identical(root.right, subRoot.right);
		}
		return false;
	}

	public static void main(String[] args) {
		CustomBinaryTree tree = new CustomBinaryTree();
		tree.root = new Node(3);
		tree.root.left = new Node(4);
		tree.root.right = new Node(5);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(2);

		CustomBinaryTree tree2 = new CustomBinaryTree();
		tree.root = new Node(4);
		tree.root.left = new Node(1);
		tree.root.right = new Node(2);

		System.out.println(isSubtree(tree.root, tree2.root));

	}
}
