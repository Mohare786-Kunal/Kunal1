class Solution {

       public static boolean isPalindrome(int start, int end, String s) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
    public static void partitioning(int ind, String s, List<String> path, List<List<String>> result) {
        if(ind ==s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = ind; i < s.length(); i++) {
            if(isPalindrome(ind, i, s)){
                path.add(s.substring(ind, i+1));
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