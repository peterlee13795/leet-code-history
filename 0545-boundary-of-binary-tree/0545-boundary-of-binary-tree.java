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
    // boundary list
    List<Integer> boundary = new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        
        if(!isLeaf(root)) boundary.add(root.val);
        
        addLeftBoundary(root.left);
        
        addBottomBoundary(root);
        
        addRightBoundary(root.right);
        
        return boundary;
    }
    
    private void addLeftBoundary(TreeNode node) {
        while(node != null) {
            if(!isLeaf(node)) boundary.add(node.val);
            node = node.left != null ? node.left : node.right;
        }
        
    }
    
    private void addBottomBoundary(TreeNode node) {
        if(node == null) return;
        if(isLeaf(node)) boundary.add(node.val);
        else {
            addBottomBoundary(node.left);
            addBottomBoundary(node.right);
        }
    }
    
    private void addRightBoundary(TreeNode node) {
        List<TreeNode> rights = new ArrayList<>();
        TreeNode rightNode = node;
        while(node != null) {
            if(!isLeaf(node)) rights.add(node);
            node = node.right != null ? node.right : node.left;
        }
        for(int i = rights.size() - 1; i >= 0; i--) {
            boundary.add(rights.get(i).val);
        }
    }
    
    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

}