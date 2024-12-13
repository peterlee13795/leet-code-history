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
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null; // 트리가 비어 있는 경우

        if (key < root.val) { // 삭제할 키가 현재 노드의 값보다 작으면 왼쪽 서브트리에서 삭제
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            // 삭제할 키가 현재 노드의 값보다 크면 오른쪽 서브트리에서 삭제
            root.right = deleteNode(root.right, key);
        } else {
            // 삭제할 노드를 찾은 경우
            if (root.left == null) {
                // 왼쪽 자식이 없는 경우 오른쪽 자식 반환
                return root.right;
            } else if (root.right == null) {
                // 오른쪽 자식이 없는 경우 왼쪽 자식 반환
                return root.left;
            }

            // 삭제할 노드가 두 개의 자식을 가진 경우
            // 오른쪽 서브트리의 최소값 노드를 가져와 현재 노드에 복사
            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            // 최소값 노드를 삭제
            root.right = deleteNode(root.right, minNode.val);
        }

        return root;
    }

    // 오른쪽 서브트리에서 최소값을 찾는 헬퍼 메서드
    private TreeNode getMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}