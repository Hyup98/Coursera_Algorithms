/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;

public class PercolationStats extends IllegalArgumentException {
    private double[] numberOfTrials;
    private int trials;
    private int gridSize;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            IllegalArgumentException e = new IllegalArgumentException("Invalid input");
            throw e;
        }
        numberOfTrials = new double[trials];
        this.trials = trials;
        this.gridSize = n * n;
        Percolation[] percolation = new Percolation[trials];
        for (int i = 0; i < trials; i++) {
            int count = 0;
            percolation[i] = new Percolation(n);
            while (true) {
                if (percolation[i].percolates()) {
                    break;
                }

                int left = StdRandom.uniform(1, n + 1);
                int right = StdRandom.uniform(1, n + 1);

                if (!percolation[i].isOpen(left, right)) {
                    percolation[i].open(left, right);
                    count++;
                }
            }
            numberOfTrials[i] = count;
            numberOfTrials[i] /= gridSize;
        }
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - (1.96 * stddev() / Math.sqrt(trials));
    }

    // sample mean of percolation threshold
    public double mean() {
        double tem = 0;
        for (int i = 0; i < trials; i++) {
            tem += numberOfTrials[i];
        }
        tem /= trials;
        return tem;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        double tem = 0;
        for (int i = 0; i < trials; i++) {
            tem += (mean() - numberOfTrials[i]) * (mean() - numberOfTrials[i]);
        }
        tem /= trials;
        return Math.sqrt(tem);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + (1.96 * stddev() / Math.sqrt(trials));
    }

}
