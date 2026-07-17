class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (row == 1 && col == 1) {
            return 1;
        }

        int max = 1;

        List<int[]> numList = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                numList.add(new int[]{matrix[i][j], i, j});
            }
        }

        Collections.sort(numList, (o1, o2) -> o2[0] - o1[0]);

        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(dp[i], 1);
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] item : numList) {
            int x = item[1];
            int y = item[2];
            System.out.println (item [0]+ " "+x+" "+y);

            for (int[] dir : dirs) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];

                if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col || matrix[nextX][nextY] <= matrix[x][y]) {
                    continue;
                }

                dp[x][y] = Math.max(dp[x][y], dp[nextX][nextY] + 1);
            }

            max = Math.max(max, dp[x][y]);
        }

        return max;
    }
}