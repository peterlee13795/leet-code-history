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
    public Node cloneTree(Node root) {
        if(root == null) return null;
        
        // generate copy of node
        Node copy = new Node(root.val);
        
        // dfs
        dfs(root, copy);
        
        return copy;
    }
    
    
    void dfs(Node origin, Node copy) {
        // create list of target node
        copy.children = new ArrayList<>();
        
        // iterate children of origin
        for(Node originChild: origin.children) {
            Node copyChild = new Node(originChild.val);
            copy.children.add(copyChild);
            dfs(originChild, copyChild); // dfs call
        }
        
    }
}