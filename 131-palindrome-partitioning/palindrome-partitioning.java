class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        PalindromePartitioning(s, new ArrayList<>(), result);
        System.out.println(result);
        return result;
    }

     public static boolean isPalindrome(String s1) {
        StringBuilder sb = new StringBuilder(s1);
        String s2 = sb.reverse().toString();
        return s1.equals(s2);
    }
    
    public static void PalindromePartitioning(String ques, List<String> ll, List<List<String>> result) {
        if (ques.length() == 0) {
            result.add(new ArrayList<>(ll));  
            return;
        }

        for (int i = 1; i <= ques.length(); i++) {
            String s = ques.substring(0, i);
            if (isPalindrome(s)) {
                ll.add(s);  
                PalindromePartitioning(ques.substring(i), ll, result); 
                ll.remove(ll.size() - 1);  
            }
        }
    }
}