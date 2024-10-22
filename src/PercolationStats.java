import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdIn;

public class PercolationStats {
      int tries;

      // perform independent trials on an n-by-n grid
      public PercolationStats(int n, int trials) {

      }

      // sample mean of percolation threshold
      public double mean() {
        return 0;

      }
  
      // sample standard deviation of percolation threshold
      public double stddev() {
        return 0;

      }
  
      // low endpoint of 95% confidence interval
      public double confidenceLo() {
        return 0;

      }
  
      // high endpoint of 95% confidence interval
      public double confidenceHi() {
        return 0;
      }
  
     // test client (see below)
     public static void main(String[] args) {
      int n = 4;

      Percolation p = new Percolation(n);

      while(p.percolates() == false) {
        p.open(StdRandom.uniformInt(0, n - 1), StdRandom.uniformInt(n, n - 1));
        p.numberOfOpenSites();
      }
     }
}
