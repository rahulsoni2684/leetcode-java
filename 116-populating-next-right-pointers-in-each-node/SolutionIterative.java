class SolutionIterative {
    public Node connect(Node root)
    {
        //if tree is blank then do nothing
        if (root == null) return null;
        // Start with root's level and its next will be null
        Node cur = root;
        // traverse from tree second level to last level
        while(cur.left != null)
        {
            // hold root of the next level
            Node nextLevel = cur.left;
            // traverse to each node on this level and assign its next pointer value
            while(cur != null)
            {
                cur.left.next = cur.right;
                
                if(cur.next == null) {
                    cur.right.next = null;
                }
                else {
                    cur.right.next = cur.next.left;
                }
                // move by 1 position on the same level
                cur = cur.next;
            }
            // Move to next level by 1
            cur = nextLevel;
        }
        
        return root;
    }
}