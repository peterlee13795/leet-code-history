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
    public List<Integer> inorderTraversal(TreeNode root) {
        // return
        return inorder(new ArrayList<>(), root);
    }

    List<Integer> inorder(List<Integer> answer, TreeNode node) {
        if(node == null) return answer;
        
        // left
        if(node.left != null) inorder(answer, node.left);
        // self
        answer.add(node.val);
        // right
        if(node.right != null) inorder(answer, node.right);

        return answer;
    }
}