/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null; // if not found 
        
        
        // if smaller then key, then to left
        if(root.val < key) root.right = deleteNode(root.right, key);
        else if (root.val > key) root.left = deleteNode(root.left, key);
        else {
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            TreeNode smallest = findSmallest(root.right);
            root.val = smallest.val;
            root.right = deleteNode(root.right, smallest.val);    
        }
        
        
        return root;
    }
    
    TreeNode findSmallest(TreeNode node) {
        while(node.left != null) node = node.left;
        return node;
    }
}