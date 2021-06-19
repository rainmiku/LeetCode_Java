package com.package1;

import java.util.Stack;

public class LC224 {
    public int calculate(String s) {
        int result = 0;

        s = s.replaceAll(" ","");
        System.out.print(s);
        int flag = 1;
        Stack<Integer> stack = new Stack<>();
        char[] c = s.toCharArray();
        for(int i =0;i<c.length;i++){
            if (isNumber(c[i])){
                int number = c[i] - '0';
                while (i+1 < c.length && isNumber(c[i+1])){
                    number = number*10 + (c[i+1]- '0');
                    i++;
                }
                result += number*flag;
            }
            else if (c[i] == '('){
                stack.push(result);
                stack.push(flag);
                result = 0;
                flag = 1;
            }
            else if (c[i] == ')'){
                result = stack.pop()*result + stack.pop();
            }
            else if (c[i] == '+' || c[i] == '-'){
                flag = c[i] == '+' ? 1 : -1;
            }
        }
        return result;
    }

    private boolean isNumber(char ch){
        return ch>='0' && ch <= '9';
    }
}
