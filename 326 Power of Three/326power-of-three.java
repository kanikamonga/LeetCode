class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 1) return true;

        long tmp = 1;
        while (tmp < n) {
            tmp *= 3;
            if (n == tmp) return true;
        }

        return false;
    }
}