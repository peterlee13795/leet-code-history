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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> boundary = new ArrayList<>();
        if (root == null) return boundary;

        // Root 노드 추가
        if (!isLeaf(root)) boundary.add(root.val);

        // 왼쪽 경계 추가
        addLeftBoundary(root.left, boundary);

        // 리프 노드 추가
        addLeaves(root, boundary);

        // 오른쪽 경계 추가 (역순)
        addRightBoundary(root.right, boundary);

        return boundary;
    }

    private void addLeftBoundary(TreeNode node, List<Integer> boundary) {
        while (node != null) {
            if (!isLeaf(node)) boundary.add(node.val);
            node = (node.left != null) ? node.left : node.right;
        }
    }

    private void addLeaves(TreeNode node, List<Integer> boundary) {
        if (node == null) return;
        if (isLeaf(node)) {
            boundary.add(node.val);
        } else {
            addLeaves(node.left, boundary);
            addLeaves(node.right, boundary);
        }
    }

    private void addRightBoundary(TreeNode node, List<Integer> boundary) {
        List<Integer> temp = new ArrayList<>();
        while (node != null) {
            if (!isLeaf(node)) temp.add(node.val);
            node = (node.right != null) ? node.right : node.left;
        }
        // 역순으로 추가
        for (int i = temp.size() - 1; i >= 0; i--) {
            boundary.add(temp.get(i));
        }
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}