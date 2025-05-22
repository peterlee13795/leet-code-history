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
    List<Integer> answer;
    public List<Integer> preorderTraversal(TreeNode root) {
        answer = new ArrayList<>();
        preorder(root);
        return answer;
    }

    void preorder(TreeNode node) {
        if(node == null) return;
        answer.add(node.val);
        preorder(node.left);
        preorder(node.right);

    }
}