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
    // node1 set
    Set<Integer> set = new HashSet<>();
    
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        
        dfsSet(root1); // node1 dfs pre-set
        
        
        
        return validate(root2, target); // validate if target found
    }
    
    boolean validate(TreeNode node, int target) {
        if(node == null) return false;
        
        
        int diff = target - node.val;
        if(set.contains(diff)) return true; // 합산값 found
        
        // TreeNode next = diff > node.val ? node.right : node.left;
        // return validate(next, target);
        
        // 양쪽 노드 이동
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