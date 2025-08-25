class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int rowSize = mat.length;
        int colSize = mat[0].length;
        int diagonalOrderSize = rowSize * colSize;
        int[] diagonalOrder = new int[diagonalOrderSize];
        int[][] direction = {{-1, 1}, {1, -1}}; //0-> up & right, 1-> down, left
        int directionIndex = 0; //0-> up & right, 1-> down, left
        for (int row =0, col = 0, diagonalIndex = 0; diagonalIndex < diagonalOrderSize; diagonalIndex++) {
            diagonalOrder[diagonalIndex] = mat[row][col];
            row = row + direction[directionIndex][0];
            col = col + direction[directionIndex][1];
            if(row < 0 || col < 0 || row >= rowSize || col >= colSize) {
                directionIndex = directionIndex^1;
            }
            if(row < 0 && col >= colSize) {
                row += 2;
                col = colSize - 1;
            }
            if(col < 0 && row >= rowSize) {
                row = rowSize - 1;
                col += 2;
            }
            if (row < 0) {
                row = 0;
            }
            if(col < 0) {
                col = 0;
            }
            if(row >= rowSize) {
                row = rowSize - 1;
                col += 2;
            }
            if(col >= colSize) {
                row += 2;
                col = colSize - 1;
            }
        }
        return diagonalOrder;
    }
}