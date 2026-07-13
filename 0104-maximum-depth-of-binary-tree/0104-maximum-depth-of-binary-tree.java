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
    public int maxDepth(TreeNode root) {
        // in-order maxDepth
        
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode node, int depth) {
        // if node not exists, return depth
        if(node == null) return depth;
        
        // ldepth, rdepth
        int ldepth = dfs(node.left, depth + 1);
        int rdepth = dfs(node.right, depth + 1);
        
        // return max
        return Math.max(ldepth, rdepth);
    }
}