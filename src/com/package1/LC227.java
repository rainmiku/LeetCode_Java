package com.package1;

import java.util.Stack;

public class LC227 {
    public int calculate(String s) {
        int[] numbers = new int[1000];

        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        s = s.replace(" ","");
        s = s+'+';

        int number = 0;
        char sign = '+';

        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            char ch = chs[i];
            if (ch>='0' && ch<='9'){
                number = number*10+(chs[i]-'0');
            }
            else{
                switch (sign){
                    case '+': {
                        stack.push(number);
                        break;
                    }
                    case '-': {
                        stack.push(-number);
                        break;
                    }
                    case '*':{
                        stack.push(stack.pop()*number);
                        break;
                    }
                    case '/':{
                        stack.push(stack.pop()/number);
                    }
                }
                sign = chs[i];
                number = 0;
            }
        }

        while (!stack.empty())
            ans+=stack.pop();
        return ans;
    }
}
