/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;

public class PercolationStats {
    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        Percolation percolation = new Percolation(n);
        for(int i = 0; i < trials; i++) {
            while (true) {
                if (percolation.percolates()) {
                    break;
                }
                percolation.open(StdRandom.uniform(1, n),StdRandom.uniform(1, n));
            }
        }

    }

    // sample mean of percolation threshold
    public double mean()

    // sample standard deviation of percolation threshold
    public double stddev()

    // low endpoint of 95% confidence interval
    public double confidenceLo()

    // high endpoint of 95% confidence interval
    public double confidenceHi()

}
