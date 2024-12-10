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
    
    
    
    public int largestBSTSubtree(TreeNode root) {
        return postorder(root).size;
    }
    
    
    SubTree postorder(TreeNode node) {
        // if node is null then..
        if(node == null) {
            return new SubTree(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        // left, right
        SubTree leftTree = postorder(node.left);
        SubTree rightTree = postorder(node.right);
        boolean isSubTree = leftTree.isSubTree && rightTree.isSubTree && leftTree.max < node.val && rightTree.min > node.val;
        if(isSubTree) return new SubTree(
            true
            , leftTree.size + rightTree.size + 1
            , Math.max(node.val, rightTree.max)
            , Math.min(node.val, leftTree.min)
        );
        
        return new SubTree(false, Math.max(leftTree.size, rightTree.size), 0, 0);
    }
    
    
    static class SubTree {
        boolean isSubTree;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int size;
        SubTree(boolean isSubTree, int size, int max, int min) {
            this.isSubTree = isSubTree;
            this.size = size;
            this.max = max;
            this.min = min;
        }
        
    }
}