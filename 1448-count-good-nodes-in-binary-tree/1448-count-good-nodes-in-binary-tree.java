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
    
    int count = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return count;
    }
    
    public void dfs(TreeNode node, int maxInPath) {
        if(node.val >= maxInPath) {
            count++;    
        }
        maxInPath = Math.max(maxInPath, node.val);
        if(node.left != null) dfs(node.left, maxInPath);
        if(node.right != null) dfs(node.right, maxInPath);
    }
    
}