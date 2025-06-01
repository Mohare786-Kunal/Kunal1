class Solution {
    public long distributeCandies(int n, int limit) {
        long result = 0;
        for (int i = 0; i <= Math.min(n, limit); i++) {
            int remaining = n - i;
            if (remaining > 2 * limit) continue;
            int minSecond = Math.max(0, remaining - limit);
            int maxSecond = Math.min(limit, remaining);
            result += (long)(maxSecond - minSecond + 1);
        }
        return result;
    }
}