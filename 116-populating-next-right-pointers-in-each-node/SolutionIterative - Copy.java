// This is based of recursive approch
class SolutionRecursive {
	
   public Node connect(Node root) {
       
       //If tree of height 0 then do nothing
       if(root == null) {
           return null;            
       }
       
       // Traverse till the end of tree
       if(root.left != null) {
           // fill the next pointer of this node by its parents right node
           root.left.next = root.right;
           // If next pointer of root itself is not empty then it means its right sibling is present
           if(root.next != null) {
               //assign the left children of root's sibling into next pointer of root's right children
               root.right.next = root.next.left;
           }
    }
    // recursive method calls based on new roots
    connect(root.left);
    connect(root.right);
       
    return root;
    }
}