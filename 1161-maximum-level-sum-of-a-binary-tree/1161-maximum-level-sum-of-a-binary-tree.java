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
    public int maxLevelSum(TreeNode root) {
        if(root == null) return 0;
        int currentLevelCount = 0;
        int levelCount = 1;
        
        int target = 0;
        int currentSum = 0;
        int level = 1;
        int max = root.val - 1;
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            currentLevelCount++;
            currentSum += node.val;
            
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
            
            if(currentLevelCount == levelCount) {
                levelCount = queue.size();
                currentLevelCount = 0;
                if(currentSum > max) {
                    max = currentSum;
                    target = level;
                }
                level++;
                currentSum = 0;
            }
        }
        return target;
        
    }
}