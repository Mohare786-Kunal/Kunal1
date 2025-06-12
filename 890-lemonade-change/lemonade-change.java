class Solution {
    static {
        int[] bills = new int[] { 5, 5, 10 };

        for (int i = 0; i < 300; i++) {
            lemonadeChange(bills);
        }
    }

    public static boolean lemonadeChange(int[] bills) {

        int five = 0;
        int ten = 0;

        for (int x : bills) {
            if (x == 5)
                five++;
            else if (x == 10) {
                if (five < 1)
                    return false;
                five--;
                ten++;
            } else {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else
                    return false;
            }
        }
        return true;

    }
}