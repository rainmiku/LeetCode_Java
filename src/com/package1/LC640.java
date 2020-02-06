package com.package1;

public class LC640 {
    public String solveEquation(String equation) {

        int equlPos = equation.indexOf('=');
        String left = equation.substring(0,equlPos);
        String right = equation.substring(equlPos+1);

        int[] leftCoe = getCoefficients(left);
        int[] rightCoe = getCoefficients(right);

        int coeX = leftCoe[0]-rightCoe[0];
        int coeNum = leftCoe[1] - rightCoe[1];

        if (coeX == 0){
            if (coeNum != 0)
                return "No solution";
            else
                return "Infinite solutions";
        }

        int ans = -coeNum / coeX;

        return "x="+ String.valueOf(ans);
    }

    private int[] getCoefficients(String s){

        int[] coe = new int[2];

        if (s.charAt(0) != '-')
            s = "+" + s;
        char[] c = s.toCharArray();
        String num = "";
        for (int i = c.length-1; i >=0; i--) {
            if (c[i] != '+' && c[i] != '-'){
                num = c[i] + num;
                continue;
            }

            if (num.charAt(num.length()-1) == 'x'){
                String coeX = (num.length()==1) ? "1" : num.substring(0,num.length()-1);
                if (c[i] == '+')
                    coe[0] += Integer.parseInt(coeX);
                else
                    coe[0] -= Integer.parseInt(coeX);
            }
            else{
                if (c[i] == '+')
                    coe[1] += Integer.parseInt(num);
                else
                    coe[1] -= Integer.parseInt(num);
            }
            num = "";
        }
        return coe;
    }
}
