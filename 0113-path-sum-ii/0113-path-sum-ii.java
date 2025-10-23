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
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        if(root == null) return answer;

        // dfs
        dfs(root, new Stack<>(), 0, targetSum);

        return answer;
    }

    void dfs(TreeNode node, Stack<Integer> stack, int currentSum, int targetSum) {
        // currentSum += node.val;
        currentSum += node.val;

        // stack.add(node.val);
        stack.add(node.val);

        // if(targetSum == currentSum)  
        if (currentSum == targetSum) {
            boolean isLeaf = node.left == null && node.right == null;
            if(isLeaf) answer.add(new ArrayList<>(stack));
        }
        
        if(node.left != null) dfs(node.left, stack, currentSum, targetSum);
        if(node.right != null) dfs(node.right, stack, currentSum, targetSum);

        stack.pop();
    }
}