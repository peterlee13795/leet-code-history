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
    List<List<Integer>> answer;
    public List<List<Integer>> levelOrder(TreeNode root) {
        // init (answer, queue)
        List<List<Integer>> answer = new ArrayList<>();
        if(root == null) return answer;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        

        // iterate queue
        while(!queue.isEmpty()) {
            // poll
            

            // init levelList, size
            List<Integer> values = new ArrayList<>();
            int size = queue.size();

            // iterate size
            for(int i =0 ; i < size; i ++) {
                TreeNode node = queue.poll();
                values.add(node.val);
                
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }

            // if(levelList.isNotEmpty) => add to answer
            answer.add(values);

        }
        return answer;
        
    }
}