package Hot100.Backtrace;


import java.util.ArrayList;
import java.util.List;

// 括号生成
public class Solution22 {
    List<String> result = new ArrayList<>();
    private void backtrace(StringBuilder sb, int notUsed, int remain) {
        // notUsed表示没有使用的左括号，remain表示使用了但是还没消除的左括号
        if (notUsed == 0 && remain == 0) {
            result.add(sb.toString());
            return;
        }
        if (notUsed > 0) {
            sb.append("(");
            backtrace(sb, notUsed - 1, remain + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (remain > 0) {
            sb.append(")");
            backtrace(sb, notUsed, remain - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        backtrace(new StringBuilder(), n, 0);
        return result;
    }
}
