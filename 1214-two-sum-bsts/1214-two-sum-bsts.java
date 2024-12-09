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
    Set<Integer> set = new HashSet<>();
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        dfsSet(root1);
        
        return validate(root2, target);
    }
    
    boolean validate(TreeNode node, int target) {
        if(node == null) return false;
        
        
        if(set.contains(target - node.val)) return true;
        
        
        if(validate(node.left, target)) return true;
        if(validate(node.right, target)) return true;
        
        return false;
    }
    
    void dfsSet(TreeNode node) {
        if(node == null) return;
        
        set.add(node.val);
        dfsSet(node.left);
        dfsSet(node.right);
    }
}