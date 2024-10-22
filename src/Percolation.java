import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdOut;

public class Percolation {
    private int n;
    private boolean[][] matrix;
    private WeightedQuickUnionUF uf;
    private int topVirtualSite;
    private int bottomVirtualSite;
    private int openSitesCount;

    private void loadTopAndBottomVirtualSites(int n) {
        topVirtualSite = n * n;
        bottomVirtualSite = n * n + 1;

        for (int i = 0; i < n; i++) {
            uf.union(topVirtualSite, i);
        }

        int lastPosition = n * n - 1;

        for (int i = (n * n - 4); i <= lastPosition; i++) {
            uf.union(bottomVirtualSite, i);
        }
    }

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be greater than 0");
        }

        this.n = n;
        matrix = new boolean[n][n];

        uf = new WeightedQuickUnionUF(n * n + 2);

        loadTopAndBottomVirtualSites(n);

        openSitesCount = 0;
    }

    private int getMatrixIndex(int row, int col) {
        return (n * n + 1) - ((n * n + 1) - ((row - 1) * n)) + (col - 1);
    }

    public void open(int row, int col) {
        validateIndices(row, col);

        int rowIndex = getCorrectIndex(row);
        int colIndex = getCorrectIndex(col);

        if (matrix[rowIndex][colIndex]) {
            return;
        }

        if (rowIndex > 0 && matrix[rowIndex - 1][colIndex]) {
            openSitesCount++;
            uf.union(getMatrixIndex(row, col), getMatrixIndex(row - 1, col));
        }

        if ((rowIndex + 1) < n && matrix[rowIndex + 1][colIndex]) {
            openSitesCount++;
            uf.union(getMatrixIndex(row, col), getMatrixIndex(row + 1, col));
        }

        if (colIndex > 0 && matrix[rowIndex][colIndex - 1]) {
            openSitesCount++;
            uf.union(getMatrixIndex(row, col), getMatrixIndex(row, col - 1));
        }

        if ((colIndex + 1) < n && matrix[rowIndex][colIndex + 1]) {
            openSitesCount++;
            uf.union(getMatrixIndex(row, col), getMatrixIndex(row, col + 1));
        }

        openSitesCount++;
        matrix[rowIndex][colIndex] = true;
    }

    public boolean isOpen(int row, int col) {
        validateIndices(row, col);

        int rowIndex = getCorrectIndex(row);
        int colIndex = getCorrectIndex(col);

        if (matrix[rowIndex][colIndex]) {
            return true;
        }

        return false;
    }

    public int numberOfOpenSites() {
        return openSitesCount;
    }

    public boolean isFull(int row, int col) {
        validateIndices(row, col);

        int rowIndex = getCorrectIndex(row);
        int colIndex = getCorrectIndex(col);

        if (matrix[rowIndex][colIndex] &&
                (colIndex > 0 && matrix[rowIndex][colIndex - 1]) &&
                (colIndex < n && matrix[rowIndex][colIndex + 1]) &&
                (rowIndex < n && matrix[rowIndex + 1][colIndex]) &&
                (rowIndex > 0 && matrix[rowIndex - 1][colIndex])) {
            return true;
        }

        return false;
    }

    public boolean percolates() {
        return uf.find(topVirtualSite) == uf.find(bottomVirtualSite);
    }

    private void validateIndices(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n) {
            throw new IllegalArgumentException("row and col indices must be between 1 and " + n);
        }
    }

    private int getCorrectIndex(int index) {
        return index - 1;
    }

    public static void main(String[] args) {
        Percolation percolation = new Percolation(4);
        percolation.open(1, 1);
        StdOut.println("position 1 and 1 " + percolation.isOpen(1, 1));
        percolation.open(2, 1);
        StdOut.println("position 2 and 1 " + percolation.isOpen(2, 1));
        percolation.open(3, 1);
        StdOut.println("position 3 and 1 " + percolation.isOpen(3, 1));
        percolation.open(4, 1);
        StdOut.println("position 4 and 1 " + percolation.isOpen(4, 1));
        StdOut.println(percolation.percolates());
    }
}
