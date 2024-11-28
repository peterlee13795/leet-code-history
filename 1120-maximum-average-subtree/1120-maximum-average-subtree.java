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
    double max = 0;
    
    // 필요한거 
    // 1. sub tree 노드 개수
    // 2. sub tree 개수 합산
    // 연산방법
    // dfs로 호출
    // dfs로 왼쪽/오른쪽 순회와 현재까지 쌓인 값 차감 후 계산
    public double maximumAverageSubtree(TreeNode root) {
        dfs(root, new AtomicInteger(), new AtomicInteger());
        return max;
    }
    
    public void dfs(TreeNode node, AtomicInteger previousSum, AtomicInteger previousCount) {
        int previousSum0 = previousSum.get();
        int previousCount0 = previousCount.get();
        
        if(node.left != null) {
            dfs(node.left, previousSum, previousCount);
        }
        if(node.right != null) {
            dfs(node.right, previousSum, previousCount);
        }
        int nowSum = previousSum.get() + node.val;
        int nowCount = previousCount.get() + 1;
        
        double currentAverage = (nowSum - previousSum0) / (double)(nowCount - previousCount0);
        max = Math.max(max, currentAverage);
        
        previousSum.set(nowSum);
        previousCount.set(nowCount);
        
        
    }
}