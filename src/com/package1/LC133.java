package com.package1;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC133 {
    public class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    };

    public Node cloneGraph(Node node) {

        if (node == null)
            return null;

        HashMap<Node, Node> map = new HashMap<>();

        copyNodes(node,map);

        for (Node origin:map.keySet()) {
            Node clone = map.get(origin);
            for (Node neighbor:origin.neighbors) {
                clone.neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);

    }

    private void copyNodes(Node node, HashMap<Node, Node> map){
        if (map.containsKey(node))
            return;
        map.put(node,new Node(node.val,new ArrayList<>()));
        for (Node neighbor: node.neighbors) {
            copyNodes(neighbor,map);
        }
    }



}
