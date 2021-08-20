/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Percolation {
    private int size;
    private int openBlockCount;
    private boolean[][] grid;
    private int[][] unionFind;
    private int index;

    // creates n-by-n grid, with all sites initially blocked
    // 0 = blocked   1 = open   2 = full
    public Percolation(int n) {
        size = n;
        grid = new boolean[n+1][n+1];
        unionFind = new int[n+1][n+1];
        openBlockCount = 0;
    }

    public void connecting(int row, int col) {
        if(row-1 > 0) {
            if (grid[row - 1][col] == true) {
                if (unionFind[row][col] < unionFind[row - 1][col]) {
                    int tem = unionFind[row - 1][col];
                    for (int i = 1; i <= size; i++) {
                        for (int j = 1; j <= size; j++) {
                            if (unionFind[i][j] == tem) {
                                unionFind[i][j] = unionFind[row][col];
                            }
                        }
                    }
                }
                else {
                    int tem = unionFind[row][col];
                    for (int i = 1; i <= size; i++) {
                        for (int j = 1; j <= size; j++) {
                            if (unionFind[i][j] == tem) {
                                unionFind[i][j] = unionFind[row - 1][col];
                            }
                        }
                    }
                }
            }
        }
        if(row+1 <= size) {
         if (grid[row + 1][col] == true) {
                if (unionFind[row][col] < unionFind[row + 1][col]) {
                    int tem = unionFind[row + 1][col];
                    for (int i = 1; i <= size; i++) {
                        for (int j = 1; j <= size; j++) {
                            if (unionFind[i][j] == tem) {
                                unionFind[i][j] = unionFind[row][col];
                            }
                        }
                    }
                }
                else {
                    int tem =  unionFind[row][col];
                    for (int i = 1; i <= size; i++) {
                        for (int j = 1; j <= size; j++) {
                            if (unionFind[i][j] == unionFind[row][col]) {
                                unionFind[i][j] = unionFind[row + 1][col];
                            }
                        }
                    }
                }
            }
        }
        if(col - 1 > 0) {
            if(grid[row][col-1] == true) {
                if (unionFind[row][col] < unionFind[row][col - 1]) {
                    int tem = unionFind[row][col - 1];
                    for (int i = 1; i <= size; i++) {
                        for (int j = 1; j <= size; j++) {
                            if (unionFind[i][j] == tem) {
                                unionFind[i][j] = unionFind[row][col];
                            }
                        }
                    }
                }
                else {
                    int tem = unionFind[row][col];
                    for (int i = 1; i <= size; i++) {
                        for (int j = 1; j <= size; j++) {
                            if (unionFind[i][j] == tem) {
                                unionFind[i][j] = unionFind[row][col - 1];
                            }
                        }
                    }
                }
            }
        }
        if(col + 1 <= size) {
            if (grid[row][col + 1] == true) {
                if (unionFind[row][col] < unionFind[row][col + 1]) {
                    int tem = unionFind[row][col + 1];
                    for (int i = 1; i <= size; i++) {
                        for (int j = 1; j <= size; j++) {
                            if (unionFind[i][j] == tem) {
                                unionFind[i][j] = unionFind[row][col];
                            }
                        }
                    }
                }
                else {
                    int tem = unionFind[row][col];
                    for (int i = 1; i <= size; i++) {
                        for (int j = 1; j <= size; j++) {
                            if (unionFind[i][j] == tem) {
                                unionFind[i][j] = unionFind[row][col + 1];
                            }
                        }
                    }
                }
            }
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if(row > size || col > size || row <= 0 || col <= 0) {
            return;
        }

        if(grid[row][col] == false){
            grid[row][col] = true;
            openBlockCount++;
            index++;
            unionFind[row][col] = index;
            connecting(row, col);
        }
        return;

    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if(grid[row][col] == true) {
            return true;
        }
        return false;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if(unionFind[row][col] != 0) {
            return true;
        }
        return false;
    }
    // returns the number of open sites
    public int numberOfOpenSites() {
        return openBlockCount;
    }

    // does the system percolate?
    public boolean percolates() {
        for(int i = 1; i <= size; i++) {
            if(unionFind[1][i] != 0) {
                for(int j = 1; j<=size; j++) {
                    if(unionFind[size][j] == unionFind[1][i]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

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

    // test client (optional)
    public static void main(String[] args) {
        Percolation a = new Percolation(100);

    }
}
