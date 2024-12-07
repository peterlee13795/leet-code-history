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
    List<List<Integer>> list = new ArrayList<>();
    TreeNode root;
    public List<List<Integer>> findLeaves(TreeNode root) {
        this.root = root;
        dfs(root);
        List<Integer> last = new ArrayList<>();
        last.add(root.val);
        list.add(last);
        return list;
    }
    
    private int dfs(TreeNode node) {
        // stack count
        int count = 0;
        
        // stack count return increment
        if(node.left != null) count = Math.max(count, dfs(node.left) + 1);
        if(node.right != null) count = Math.max(count, dfs(node.right) + 1);
        
        // count get list item or add if null
        List<Integer> items = null;
        if(node != this.root) {
            if(count == list.size()) {
                items = new ArrayList<>();
                list.add(items);
            } else {
                items = list.get(count);
            }
            items.add(node.val);
        }
        
        
        // return count
        return count;
    }
}