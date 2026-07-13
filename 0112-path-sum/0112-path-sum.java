class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return dfs(root, targetSum, 0);
    }

    private boolean dfs(TreeNode node, int targetSum, int sum) {

        if(node.left == null && node.right == null) {
            return sum + node.val == targetSum;
        }

        if(node.left != null &&
            dfs(node.left, targetSum, sum + node.val))
            return true;

        if(node.right != null &&
            dfs(node.right, targetSum, sum + node.val))
            return true;

        return false;
    }
}