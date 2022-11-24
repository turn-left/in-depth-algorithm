package com.ethen.leetcode;

class NumMatrix {
    // 矩阵
    private int[][] matrix;

    // 前缀和数组
    private int[][] preSum;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;

        // 构造前缀和数组
        int row = matrix.length + 1;
        int col = matrix[0].length + 1;
        preSum = new int[row][col];
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                preSum[i][j] = preSum[i - 1][j - 1] ;
            }
        }


    }


    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;

        for (int r = row1; r <= row2; r++) {
            for (int c = col1; c <= col2; c++) {
                res += matrix[r][c];
            }
        }
        return res;
    }

}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */