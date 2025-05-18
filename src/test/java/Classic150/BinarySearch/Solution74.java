package Classic150.BinarySearch;


// 搜索二维矩阵
public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 找到所在行
        int rows = matrix.length, cols = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[rows - 1][cols - 1])
            return false;
        int lRow = 0, rRow = rows - 1, row = -1;
        while (lRow <= rRow) {
            int midRow = (rRow - lRow) / 2 + lRow;
            if (target >= matrix[midRow][0]) {
                row = midRow;
                lRow = midRow + 1;
            } else {
                rRow = midRow - 1;
            }
        }
        // 找到所在列
        int lCol = 0, rCol = cols - 1;
        while (lCol <= rCol) {
            int midCol = (rCol - lCol) / 2 + lCol;
            if (matrix[row][midCol] == target)
                return true;
            if (matrix[row][midCol] > target)
                rCol = midCol - 1;
            else
                lCol = midCol + 1;
        }
        return false;
    }
}
