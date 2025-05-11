package Classic150.DivideAndConquer;


// 建立四叉树
public class Solution427 {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
    // 初见，超过42.42%
    public Node construct1(int[][] grid) {
        if (grid.length != grid[0].length)
            return null;
        int n = grid.length;
        return construct1(grid, 0, n - 1, 0, n - 1);
    }
    private Node construct1(int[][] grid, int minRow, int maxRow, int minCol, int maxCol) {
        if (minRow == maxRow)
            return new Node(grid[minRow][minCol] == 1, true);
        Node root = new Node();
        int midRow = (minRow + maxRow) >> 1;
        int midCol = (minCol + maxCol) >> 1;
        root.topLeft = construct1(grid, minRow, midRow, minCol, midCol);
        root.topRight = construct1(grid, minRow, midRow, midCol + 1, maxCol);
        root.bottomLeft = construct1(grid, midRow + 1, maxRow, minCol, midCol);
        root.bottomRight = construct1(grid, midRow + 1, maxRow, midCol + 1, maxCol);
        if ((root.topLeft.isLeaf && root.topRight.isLeaf && root.bottomLeft.isLeaf && root.bottomRight.isLeaf)
            && ((root.topLeft.val && root.topRight.val && root.bottomLeft.val && root.bottomRight.val)
            || (!root.topLeft.val && !root.topRight.val && !root.bottomLeft.val && !root.bottomRight.val)))
            root = new Node(root.topLeft.val, true);
        return root;
    }
    // 使用二维前缀和，超过17.49%
    int[][] pre;
    public Node construct2(int[][] grid) {
        if (grid.length != grid[0].length)
            return null;
        int n = grid.length;
        pre = new int[n + 1][n + 1];
        for (int i = 1; i <= n; ++i)
            for (int j = 1; j <= n; ++j)
                pre[i][j] = pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1] + grid[i - 1][j - 1];
        return construct2(grid, 0, n - 1, 0, n - 1);
    }
    private int getSum(int minRow, int maxRow, int minCol, int maxCol) {
        return pre[maxRow + 1][maxCol + 1]
                - pre[maxRow + 1][minCol]
                - pre[minRow][maxCol + 1]
                + pre[minRow][minCol];
    }
    private Node construct2(int[][] grid, int minRow, int maxRow, int minCol, int maxCol) {
        int total = getSum(minRow, maxRow, minCol, maxCol);
        if (total == 0)
            return new Node(false, true);
        else if (total == (maxRow - minRow + 1) * (maxCol - minCol + 1))
            return new Node(true, true);
        int midRow = (minRow + maxRow) >> 1;
        int midCol = (minCol + maxCol) >> 1;
        return new Node(
                false,
                false,
                construct2(grid, minRow, midRow, minCol, midCol),
                construct2(grid, minRow, midRow, midCol + 1, maxCol),
                construct2(grid, midRow + 1, maxRow, minCol, midCol),
                construct2(grid, midRow + 1, maxRow, midCol + 1, maxCol)
        );
    }
}
