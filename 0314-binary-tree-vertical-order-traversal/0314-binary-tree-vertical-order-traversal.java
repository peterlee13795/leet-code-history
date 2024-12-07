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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // 결과를 저장할 리스트
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        // 열 번호와 노드를 매핑하기 위한 맵
        Map<Integer, List<Integer>> columnTable = new HashMap<>();
        // BFS를 위한 큐
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));

        // 열 번호의 범위를 추적
        int minColumn = 0, maxColumn = 0;

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int column = pair.getValue();

            if (node != null) {
                // 현재 노드의 값을 열 번호에 따라 추가
                columnTable.computeIfAbsent(column, k -> new ArrayList<>()).add(node.val);
                // 최소, 최대 열 번호 갱신
                minColumn = Math.min(minColumn, column);
                maxColumn = Math.max(maxColumn, column);

                // 왼쪽과 오른쪽 자식을 큐에 추가
                queue.offer(new Pair<>(node.left, column - 1));
                queue.offer(new Pair<>(node.right, column + 1));
            }
        }

        // 열 번호 범위에 따라 결과 생성
        for (int i = minColumn; i <= maxColumn; i++) {
            result.add(columnTable.get(i));
        }

        return result;
    }

}