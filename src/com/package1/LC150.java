package com.package1;

import java.util.Stack;

public class LC150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens) {
            switch (str){
                case "+":
                    stack.push(stack.pop()+stack.pop());
                    break;

                case  "-":
                    stack.push(-stack.pop()+stack.pop());
                    break;

                case "*":
                    stack.push(stack.pop()*stack.pop());
                    break;

                case "/":
                    int second = stack.pop();
                    int first = stack.pop();
                    stack.push(first / second);
                    break;

                default:
                    stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}
