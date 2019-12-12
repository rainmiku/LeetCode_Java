package com.package1;

import java.util.Arrays;
import java.util.Stack;


public class LC071 {
    public String simplifyPath(String path) {
        String[] tempDic = path.split("/");
        Stack<String> stack = new Stack<>();
        Stack<String> resulyStack = new Stack<>();

        for (String dic: tempDic) {
            if (dic.equals("") || dic.equals("."))
                continue;
            if (dic.equals(".."))
            {
                if (stack.isEmpty())
                    continue;
                stack.pop();
                continue;
            }
            stack.push(dic);
        }

        if (stack.empty())
            return "/";

        while (!stack.empty()){
            resulyStack.add(stack.pop());
        }

        String result = "";
        while (!resulyStack.empty()){
            result += "/";
            result += resulyStack.pop();
        }

        return result;
    }
}
