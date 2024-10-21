import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int n;
    private boolean[][] grid;
    private WeightedQuickUnionUF uf;
    private int topVirtualSite;
    private int bottomVirtualSite;
    private int openSitesCount;

    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException("n must be greater than 0");
        this.n = n;
        grid = new boolean[n][n];
        uf = new WeightedQuickUnionUF(n * n);
        topVirtualSite = n * n;
        bottomVirtualSite = n * n;
        openSitesCount = 0;
    }
}