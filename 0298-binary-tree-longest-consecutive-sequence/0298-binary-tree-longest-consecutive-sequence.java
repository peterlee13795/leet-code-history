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
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        dfs(root, 1, root.val);
        return max;
    }
    
    public void dfs(TreeNode node, int count, int previousValue) {
        
        int nextVal = previousValue + 1;
        max = Math.max(max, count);
        // recursive & expected value to match
        if(node.left != null) {
            if(node.left.val == nextVal) {
                dfs(node.left, count + 1, nextVal);
            } else {
                dfs(node.left, 1, node.left.val);
            }
        }
        if(node.right != null) {
            if(node.right.val == nextVal) {
                dfs(node.right, count + 1, nextVal);
            } else {
                dfs(node.right, 1, node.right.val);
            }
        }
        
    }
    
}