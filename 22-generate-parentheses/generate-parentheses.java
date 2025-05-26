import java.util.*;

public class Solution {

    public static void main(String[] args) {
        List<String> result = generateParenthesis(3);
        System.out.println(result);
    }

   public static List<String> generateParenthesis(int n) {
        List<String> ll = new ArrayList<>();
        ans(n, 0, 0, "", ll);
        return ll;
    }

    private static void ans(int n, int close, int open, String ans, List<String> ll) {
        if (ans.length() == 2 * n) {
            ll.add(ans);
            return;
        }

        if (open < n) {
            ans(n, close, open + 1, ans + "(", ll);
        }
        if (close < open) {
            ans(n, close + 1, open, ans + ")", ll);
        }
    
    }
}
