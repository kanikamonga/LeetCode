class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int maxOnes = -1;
        int rowIndex = -1;

        for (int i = 0; i < m; ++i) {
            int onesCount = 0;
            for (int j = 0; j < n; ++j) {
                if (mat[i][j] == 1) onesCount++;
            }
            if (onesCount > maxOnes) {
                maxOnes = onesCount;
                rowIndex = i;
            }
        }

        int result [] = new int[2];
        result[0] = rowIndex;
        result[1] = maxOnes;
        return result;
    }
}