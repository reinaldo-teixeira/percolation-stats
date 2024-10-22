import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.Stopwatch;

public class PercolationStats {
      int[] attempts;
      int trials;

      public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
          throw new IllegalArgumentException("n and trials must be greater than 0");
        }

        this.trials = trials;
        
        attempts = new int[trials];

        for (int i = 0; i < trials; i++) {
          Percolation percolation = new Percolation(n);

          while(percolation.percolates() == false) {
            int row = StdRandom.uniformInt(1, n + 1);
            int col = StdRandom.uniformInt(1, n + 1);

            percolation.open(row, col);

            if (percolation.percolates()) {
              int openSites = percolation.numberOfOpenSites();
              attempts[i] = openSites / (n * n);
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
        return mean() - 1.96 * stddev() / Math.sqrt(trials);
      }
  
      public double confidenceHi() {
        return  mean() + 1.96 * stddev() / Math.sqrt(trials);
      }
  
     public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();

        PercolationStats p = new PercolationStats(200, 100);

        StdOut.println("mean                    = " + p.mean());
        StdOut.println("stddev                  = " + p.stddev());
        StdOut.println("95% confidence interval = [" + p.confidenceLo() + ", " + p.confidenceHi() + "]");

        double time = stopwatch.elapsedTime();

        StdOut.println("Time elapsed: " + time);
     }
}
