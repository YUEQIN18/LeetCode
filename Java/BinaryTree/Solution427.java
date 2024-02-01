package BinaryTree;

/**
 * @author qinyue
 * @create 2024-02-02 00:43:00
 */
/**
 427. 建立四叉树
 给你一个 n * n 矩阵 grid ，矩阵由若干 0 和 1 组成。请你用四叉树表示该矩阵 grid 。
 你需要返回能表示矩阵 grid 的 四叉树 的根结点。
 四叉树数据结构中，每个内部节点只有四个子节点。此外，每个节点都有两个属性：
 val：储存叶子结点所代表的区域的值。1 对应 True，0 对应 False。注意，当 isLeaf 为 False 时，你可以把 True 或者 False 赋值给节点，两种值都会被判题机制 接受 。
 isLeaf: 当这个节点是一个叶子结点时为 True，如果它有 4 个子节点则为 False 。
 我们可以按以下步骤为二维区域构建四叉树：

 如果当前网格的值相同（即，全为 0 或者全为 1），将 isLeaf 设为 True ，将 val 设为网格相应的值，并将四个子节点都设为 Null 然后停止。
 如果当前网格的值不同，将 isLeaf 设为 False， 将 val 设为任意值，然后如下图所示，将当前网格划分为四个子网格。
 使用适当的子网格递归每个子节点。
 */
public class Solution427 {

    public Node construct(int[][] grid) {
        return traversal(grid, 0, grid.length, 0, grid[0].length);
    }

    private Node traversal(int[][] grid, int rowStart, int rowEnd, int colStart, int colEnd) {
        // 判断整个网格的值是否相同
        boolean isSame = true;
        for (int i = rowStart; i < rowEnd; i++) {
            for (int j = colStart; j < colEnd; j++) {
                if (grid[i][j] != grid[rowStart][colStart]) {
                    isSame = false;
                    break;
                }
            }
        }
        if (isSame) {
            return new Node(grid[rowStart][colStart] == 1, true);
        } else {
            // 分割成4个子网格
            Node node = new Node(grid[rowStart][colStart] == 1, false);
            node.topLeft = traversal(grid, rowStart, (rowStart+rowEnd) / 2, colStart, (colStart+colEnd) / 2);
            node.topRight = traversal(grid, rowStart, (rowStart+rowEnd) / 2, (colStart+colEnd) / 2, colEnd);
            node.bottomLeft = traversal(grid, (rowStart+rowEnd) / 2, rowEnd, colStart, (colStart+colEnd) / 2);
            node.bottomRight = traversal(grid, (rowStart+rowEnd) / 2, rowEnd, (colStart+colEnd) / 2, colEnd);
            return node;
        }
    }

    static class Node {
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
    };
}
