
public class Percolation {
    private final int size;
    private int openBlockCount;
    private boolean[][] grid;
    private int[][] unionFind;
    private int index;

    // creates n-by-n grid, with all sites initially blocked
    // 0 = blocked   1 = open   2 = full
    public Percolation(int n) {
        size = n;
        grid = new boolean[n + 1][n + 1];
        unionFind = new int[n + 1][n + 1];
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row > size || col > size || row <= 0 || col <= 0) {
            throw new java.lang.IllegalArgumentException();
        }

        if(isOpen(row,col)) {
            return;
        }

        if (!grid[row][col]) {
            grid[row][col] = true;
            openBlockCount++;
            index++;
            unionFind[row][col] = index;
            //connecting(row, col);
            if (row - 1 > 0) {
                if (grid[row - 1][col]) {
                    if (unionFind[row][col] < unionFind[row - 1][col]) {
                        int tem = unionFind[row - 1][col];
                        int changeNum = unionFind[row][col];
                        for (int i = 1; i <= size; i++) {
                            for (int j = 1; j <= size; j++) {
                                if (unionFind[i][j] == tem) {
                                    unionFind[i][j] = changeNum;
                                }
                            }
                        }
                    }
                    else {
                        int tem = unionFind[row][col];
                        int changeNum = unionFind[row - 1][col];
                        for (int i = 1; i <= size; i++) {
                            for (int j = 1; j <= size; j++) {
                                if (unionFind[i][j] == tem) {
                                    unionFind[i][j] = changeNum;
                                }
                            }
                        }
                    }
                }
            }
            if (row + 1 <= size) {
                if (grid[row + 1][col]) {
                    if (unionFind[row][col] < unionFind[row + 1][col]) {
                        int tem = unionFind[row + 1][col];
                        int changeNum = unionFind[row][col];
                        for (int i = 1; i <= size; i++) {
                            for (int j = 1; j <= size; j++) {
                                if (unionFind[i][j] == tem) {
                                    unionFind[i][j] = changeNum;
                                }
                            }
                        }
                    }
                    else {
                        int tem = unionFind[row][col];
                        int changeNum = unionFind[row + 1][col];
                        for (int i = 1; i <= size; i++) {
                            for (int j = 1; j <= size; j++) {
                                if (unionFind[i][j] == tem) {
                                    unionFind[i][j] = changeNum;
                                }
                            }
                        }
                    }
                }
            }
            if (col - 1 > 0) {
                if (grid[row][col - 1]) {
                    if (unionFind[row][col] < unionFind[row][col - 1]) {
                        int tem = unionFind[row][col - 1];
                        int changeNum = unionFind[row][col];
                        for (int i = 1; i <= size; i++) {
                            for (int j = 1; j <= size; j++) {
                                if (unionFind[i][j] == tem) {
                                    unionFind[i][j] = changeNum;
                                }
                            }
                        }
                    }
                    else {
                        int tem = unionFind[row][col];
                        int changeNum = unionFind[row][col - 1];
                        for (int i = 1; i <= size; i++) {
                            for (int j = 1; j <= size; j++) {
                                if (unionFind[i][j] == tem) {
                                    unionFind[i][j] = changeNum;
                                }
                            }
                        }
                    }
                }
            }
            if (col + 1 <= size) {
                if (grid[row][col + 1]) {
                    if (unionFind[row][col] < unionFind[row][col + 1]) {
                        int tem = unionFind[row][col + 1];
                        int changeNum =  unionFind[row][col];
                        for (int i = 1; i <= size; i++) {
                            for (int j = 1; j <= size; j++) {
                                if (unionFind[i][j] == tem) {
                                    unionFind[i][j] = changeNum;
                                }
                            }
                        }
                    }
                    else {
                        int tem = unionFind[row][col];
                        int changeNum = unionFind[row][col + 1];
                        for (int i = 1; i <= size; i++) {
                            for (int j = 1; j <= size; j++) {
                                if (unionFind[i][j] == tem) {
                                    unionFind[i][j] = changeNum;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /*
    public void connecting(int row, int col) {
        if (row > size || col > size || row <= 0 || col <= 0) {
            throw new java.lang.IndexOutOfBoundsException();
        }
     }
     */

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row > size || col > size || row <= 0 || col <= 0) {
            throw new java.lang.IllegalArgumentException();
        }
        if (grid[row][col]) {
            return true;
        }
        return false;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row > size || col > size || row <= 0 || col <= 0) {
            throw new java.lang.IllegalArgumentException();
        }
        if(isOpen(row,col)) {
            for (int i = 1; i <= size; i++) {
                if (unionFind[row][col] == unionFind[1][i]) {
                    return true;
                }
            }
        }
        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openBlockCount;
    }

    // does the system percolate?
    public boolean percolates() {

        for (int i = 1; i <= size; i++) {
            if (unionFind[1][i] != 0) {
                for (int j = 1; j <= size; j++) {
                    if (unionFind[size][j] == unionFind[1][i]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /*
    public void print() {
        StringBuilder builder = new StringBuilder();
        builder.append("   <Percolation>\n");
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                builder.append(unionFind[i][j] + " ");
            }
            builder.append('\n');
        }
        System.out.print(builder.toString());
    }
     */
}