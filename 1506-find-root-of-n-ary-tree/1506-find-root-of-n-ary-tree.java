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
    // map cache gen, key: node, val: count
    Map<Node, Integer> cache = new HashMap<>();
    public Node findRoot(List<Node> tree) {
        // iterate array
        for(Node node: tree) {
            // call dfs
            dfs(node);
        }
        
        return cache.entrySet().stream().min((e0, e1) -> e1.getValue() - e0.getValue()).orElse(null).getKey();
    }
    
    int dfs(Node node) {
        // find node.val from cache
        // if exist return
        if(cache.containsKey(node)) return cache.get(node);
        
        
        // create child count int
        int count = node.children.size();
        
        // iterate
        for(Node child: node.children) {
            // call dfs and increase count
            count += dfs(child);
        }
        
        cache.put(node, count);
        
        return count;
        
    }
}