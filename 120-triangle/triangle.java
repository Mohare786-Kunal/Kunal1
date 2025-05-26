class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();

        // Fill the last row of dp with the last row of the triangle

        int[] front = new int[m];

        for (int j = 0; j < m; j++) {
            front[j] = triangle.get(m-1).get(j);
        }

        // Build the dp array from the bottom up
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                front[j] = Math.min(front[j], front[j + 1]) + triangle.get(i).get(j);
            }
        }

        return front[0]; // The top element will have the minimum path sum
    }
}