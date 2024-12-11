/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int max = 0;
    public int diameter(Node root) {
        // dfs call
        dfs(root);
        
        // return max
        return max;
    }
    
    int dfs(Node node) {
        if(node.children.size() == 0) return 0;
        
        // stack depth = 0
        int depth = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);
        
        // iterate child
        for(Node child: node.children) {
            int eachDepth = dfs(child) + 1;
            queue.add(eachDepth);
            if(queue.size() > 2) queue.poll();
        }
        
        // call dfs and + 1 (eachDepth)
        int longest = 0;
        
        // add to queue and max size is 2
        int sum = 0;
        while(!queue.isEmpty()) {            
            longest = queue.poll();
            sum += longest;
        }
        
        max = Math.max(max, sum);
        
        // return longest-depth
        return longest;
        
    }
}