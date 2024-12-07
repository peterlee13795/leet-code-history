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
    double min = Double.MAX_VALUE;
    int minVal = 0;
    public int closestValue(TreeNode root, double target) {
        dfs(root, target);
        return minVal;
    }
    
    void dfs(TreeNode node, double target) {
        if(node == null) return;
        
        dfs(node.left, target);
        dfs(node.right, target);
        double diff = Math.abs(node.val - target);
        if(diff < min) {
            min = diff;
            minVal = node.val;
        } else if (diff == min && minVal > node.val) {
            minVal = node.val;
        }
    }
}