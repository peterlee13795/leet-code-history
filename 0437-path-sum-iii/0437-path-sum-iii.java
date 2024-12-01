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
    
    private Map<Long, Integer> prefixSum = new HashMap<>();
    
    public int pathSum(TreeNode root, int targetSum) {
        prefixSum.put(0L, 1);
        return preorder(root, targetSum, 0L);
    }
    
    private int preorder(TreeNode node, int targetSum, long totalSum) {
        if(node == null) return 0;
        
        // 총합 누적
        totalSum += node.val;
        
        // 필요 누적 합산: 총합 누적 - target
        long leftoverSum = totalSum - targetSum;
        int leftoverSumCount = prefixSum.getOrDefault(leftoverSum, 0);
        
        // 누적합 추가
        prefixSum.put(totalSum, prefixSum.getOrDefault(totalSum, 0) + 1);
        
        // 전위호출
        int result = leftoverSumCount
            + preorder(node.left, targetSum, totalSum)
            + preorder(node.right, targetSum, totalSum)
        ;
    
        // 탐색 후 누적합 제거 (백트래킹)
        prefixSum.put(totalSum, prefixSum.getOrDefault(totalSum, 0) - 1);
        
        return result;
    }
}