class Solution {

        public static boolean isPalindrome(String s, int start, int end) {
        if (start >= end) {
            return true;
        }
        return s.charAt(start) == s.charAt(end) && isPalindrome(s, start + 1, end - 1);
    }
    
    public static void partitioning(int ind, String s, List<String> path, List<List<String>> result) {
        if (ind == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = ind; i < s.length(); i++) {
            if (isPalindrome(s, ind, i)) {
                path.add(s.substring(ind, i + 1));
                partitioning(i + 1, s, path, result);
                path.remove(path.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result =  new ArrayList<>();
        List<String> path = new ArrayList<>();
        partitioning(0 ,s ,path ,result);
        return result;
    }
}