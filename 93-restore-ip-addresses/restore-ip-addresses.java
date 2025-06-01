class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(String s, int start, List<String> current, List<String> result) {
        if (current.size() == 4 && start == s.length()) {
            result.add(String.join(".", current));
            return;
        }
        if (current.size() > 4) return;
        for (int i = start; i < s.length() && i < start + 3; i++) {
            String part = s.substring(start, i + 1);
            if (part.length() > 1 && part.charAt(0) == '0') continue;
            int num = Integer.parseInt(part);
            if (num > 255) continue;
            current.add(part);
            backtrack(s, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}