package com.package1;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC331 {

    //this is for "9,9,#,#,9,#,#"
    private class Node{
        String val;
        public Node(String val){
            this.val = val;
        }
    }

    public boolean isValidSerialization(String preorder) {
        if (preorder.equals("#")) return true;

        String[] strings = preorder.split(",");
        Node[] nodes = new Node[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nodes[i] = new Node(strings[i]);
        }

        Stack<Node> stack = new Stack<>();
        Map<Node,Integer> childs = new HashMap<>();

        for (int i = 0; i < nodes.length ; i++) {
            Node node = nodes[i];
            if (!node.val.equals("#")){
                stack.add(node);
                if (childs.containsKey(node))
                    return false;
                childs.put(node,2);
            }
            else {
                if (stack.isEmpty())
                    return false;
                Node top = stack.peek();
                childs.replace(top,childs.get(top)-1);
                while (childs.get(top) == 0){
                    stack.pop();
                    childs.remove(top);
                    if (stack.isEmpty())
                        return (i == nodes.length-1);
                    top = stack.peek();
                    childs.replace(top,childs.get(top)-1);
                }
            }
        }
        return stack.isEmpty();
    }
}
