package Hot100.Stack;


import java.util.Stack;

// 字符串解码
public class Solution394 {
    public String decodeString(String s) {
        char[] arr = s.toCharArray();
        StringBuilder res = new StringBuilder();
        Stack<Integer> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();
        int iter = 0;
        int num = 0;
        while (iter < arr.length) {
            if (arr[iter] == '[') {
                s1.push(num);
                s2.push(res.toString());
                num = 0;
                res = new StringBuilder();
            } else if (arr[iter] == ']') {
                int cnt = s1.pop();
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < cnt; i++) temp.append(res);
                res = new StringBuilder(s2.pop() + temp);
            } else if (arr[iter] >= '0' && arr[iter] <= '9') {
                num = num * 10 + (arr[iter] - '0');
            } else {
                res.append(arr[iter]);
            }
            iter++;
        }
        return res.toString();
    }
}
