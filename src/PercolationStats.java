import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.Stopwatch;

public class PercolationStats {
    private double[] attempts;
    private int trials;
    private double CONFIDENCE_95 = 1.96;

    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("n and trials must be greater than 0");
        }

        this.trials = trials;

        attempts = new double[trials];

        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);

            while (!percolation.percolates()) {
                int row = StdRandom.uniformInt(1, n + 1);
                int col = StdRandom.uniformInt(1, n + 1);

                percolation.open(row, col);

                if (percolation.percolates()) {
                    int openSites = percolation.numberOfOpenSites();
                    attempts[i] = (double) openSites / (n * n);
                }
            }
        }
    }

    public double mean() {
        return StdStats.mean(attempts);
    }

    public double stddev() {
        return StdStats.stddev(attempts);

    }

    public double confidenceLo() {
        return mean() - CONFIDENCE_95 * stddev() / Math.sqrt(trials);
    }

    public double confidenceHi() {
        return mean() + CONFIDENCE_95 * stddev() / Math.sqrt(trials);
    }

    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            int n = StdIn.readInt();
            int trials = StdIn.readInt();

            Stopwatch stopwatch = new Stopwatch();

            PercolationStats percolationStats = new PercolationStats(n, trials);

            StdOut.println("mean                    = " + percolationStats.mean());
            StdOut.println("stddev                  = " + percolationStats.stddev());
            StdOut.println("95% confidence interval = [" + percolationStats.confidenceLo() + ", "
                    + percolationStats.confidenceHi() + "]");

            double time = stopwatch.elapsedTime();

            StdOut.println("Time elapsed: " + time);
        }
    }
}
