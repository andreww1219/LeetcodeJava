package StackAndQueue;


import org.junit.Test;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

// 逆波兰表达式求值
public class Solution150 {
    @Test
    public void test(){
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }
    private static Map<String, BiFunction<Long, Long, Long>> functionMap;

    static {
        functionMap = new HashMap<>();
        functionMap.put("+", Math::addExact);
        functionMap.put("-", Math::subtractExact);
        functionMap.put("*", Math::multiplyExact);
        functionMap.put("/", Solution150::myDiv);
    }
    private static Long myDiv (Long num1, Long num2) {
        long res = Math.floorDiv(Math.abs(num1), Math.abs(num2));
        return num1 * num2 < 0? -res: res;
    }
    private boolean isOperator(String str){
        return str.equals("+") || str.equals("-")
        || str.equals("*") || str.equals("/");
    }
    public int evalRPN(String[] tokens) {
        int len = tokens.length;
        Stack<Long> stack = new Stack<>();
        for (int i = 0; i < len; ++i){
            if (isOperator(tokens[i])){
                Long num2 = stack.pop();
                Long num1 = stack.pop();
                stack.push(functionMap.get(tokens[i]).apply(num1, num2));
            }
            else
                stack.push(Long.parseLong(tokens[i]));
        }
        return stack.pop().intValue();
    }
}
