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
        dfs(root);
        return max;
    }
    
    private int[] dfs(TreeNode node) {
        int increment = 1, decrement = 1;
        
        TreeNode left = node.left, right = node.right;
        
        if(left != null) {
            int[] leftValue = dfs(left);
            if(node.val == left.val + 1) {
                decrement = leftValue[0] + 1;
            } else if (node.val == left.val - 1) {
                increment = leftValue[1] + 1;
            }
        }
        if(right != null) {
            int[] rightValue = dfs(right);
            if(node.val == right.val + 1) {
                decrement = Math.max(decrement, rightValue[0] + 1);
            } else if(node.val == right.val - 1) {
                increment = Math.max(increment, rightValue[1] + 1);
            }
        }
        
        max = Math.max(max, increment + decrement - 1);
        return new int[] {decrement, increment};
    }
    
}