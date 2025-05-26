class Solution {
        public int tribonacci(int n) {
            if (n == 0) return 0; // Handle base case for n = 0
            if (n == 1 || n == 2) return 1; // Handle base cases for n = 1 and n = 2
            
            int prev1 = 1, prev2 = 1, prev3 = 0, curi = 0;

            for (int i = 3; i <= n; i++) {
                curi = prev1 + prev2 + prev3; // Calculate the current tribonacci number
                prev3 = prev2; // Update prev3 to the previous value of prev2
                prev2 = prev1; // Update prev2 to the previous value of prev1
                prev1 = curi;  // Update prev1 to the current tribonacci number
            }
            return curi;
        }
} 