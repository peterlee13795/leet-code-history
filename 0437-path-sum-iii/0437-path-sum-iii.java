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
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        // 초기값 추가: 누적합이 0인 경로는 하나 존재한다고 가정
        prefixSumCount.put(0L, 1);
        return dfs(root, 0L, targetSum, prefixSumCount);
    }

    private int dfs(TreeNode node, long currSum, int target, Map<Long, Integer> prefixSumCount) {
        if (node == null) {
            return 0;
        }

        // 현재 노드까지의 누적합
        currSum += node.val;

        // 현재 누적합에서 타겟합을 뺀 값이 prefixSumCount에 몇 번 등장했는지 확인
        int numPathsToCurr = prefixSumCount.getOrDefault(currSum - target, 0);

        // 현재 경로의 누적합 추가
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);

        // 좌우 서브트리 탐색
        int result = numPathsToCurr
                + dfs(node.left, currSum, target, prefixSumCount)
                + dfs(node.right, currSum, target, prefixSumCount);

        // 탐색 후 현재 노드의 누적합 제거 (백트래킹)
        prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);

        return result;
    }
}