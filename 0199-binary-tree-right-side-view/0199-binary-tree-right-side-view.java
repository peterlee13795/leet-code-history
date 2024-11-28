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
    public List<Integer> rightSideView(TreeNode root) {
        // bfs
        // 층 별로 가장 오른쪽에 있는 걸 뽑기
        
        // bfs 연산방법
        // 큐: LinkedList()
        // levelCount로 조정
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        
        int levelCount = 1;
        int currentLevelCount = 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            currentLevelCount++;
            
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
            if(levelCount == currentLevelCount) {
                levelCount = queue.size();
                currentLevelCount = 0;
                list.add(node.val);
            }
        }
        
        return list;
    }
}