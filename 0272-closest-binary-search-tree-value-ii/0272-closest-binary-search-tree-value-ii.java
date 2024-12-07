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
    
    Queue<Integer> queue;

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        queue = new PriorityQueue<>((a, b) -> Math.abs(a - target) - Math.abs(b - target) > 0 ? -1 : 1);
        dfs(root, k);
        return new ArrayList<>(queue);
    }
    
    void dfs(TreeNode node, int k) {
        if(node == null) return;
        dfs(node.left, k);
        dfs(node.right, k);
        
        queue.add(node.val);
        if(queue.size() > k) queue.remove();
        
    }
}