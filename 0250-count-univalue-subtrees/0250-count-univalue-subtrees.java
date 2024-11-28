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
    
    int count;
    
    public int countUnivalSubtrees(TreeNode root) {
        dfs(root);
        return count;
    }
    
    /**
        @return: if both childs are null or has diff value
    **/
    public boolean dfs(TreeNode node) {
        if(node == null) return true;
        
        TreeNode leftNode = node.left;
        TreeNode rightNode = node.right;
        
        boolean left = dfs(leftNode);
        boolean right = dfs(rightNode);
        
        if(!left || !right) return false; // 왼쪽 & 오른쪽 중 하나라도 불일치할 경우 uni SubTree 아님
        
        // 현재값이 왼쪽/오른쪽 값과 불일치하면 uni-sub-tree 아님
        if(leftNode != null && leftNode.val != node.val) {
            return false;
        }
        if(rightNode != null && rightNode.val != node.val) {
            return false;
        }
        count++;
        
        return true;
    }

    
}