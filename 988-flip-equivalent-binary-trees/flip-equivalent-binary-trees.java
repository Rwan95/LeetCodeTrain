class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

public class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // Base case: both nodes are null, so they are equivalent
        if (root1 == null && root2 == null) {
            return true;
        }
        
        // If one of them is null but the other isn't, they are not equivalent
        if (root1 == null || root2 == null) {
            return false;
        }
        
        // If the values of the two nodes don't match, they are not equivalent
        if (root1.val != root2.val) {
            return false;
        }
        
        // Check both possible cases of flip equivalency:
        // Case 1: No flip is required
        // Case 2: A flip is required
        boolean noFlip = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        boolean flip = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
        
        // Return true if either of the two cases hold
        return noFlip || flip;
    }
}
