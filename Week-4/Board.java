import edu.princeton.cs.algs4.In;

public class Board {
    private final int n;
    private final int[][] board;

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
        n = tiles.length;
        board = tiles.clone();
    }
                                           
    // string representation of this board
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append(n + "\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                s.append(" " + board[i][j]);

            s.append("\n");
        }
        return s.toString();
    }

    // board dimension n
    public int dimension() {
        return n;
    }

    // number of tiles out of place
    public int hamming() {
        int distance = 0;

        for (int row = 0; row < n; row++)
            for (int col = 0; col < n; col++)
                if (solution(row, col) != 0 && solution(row, col) != board[row][col])
                    distance++;

        return distance;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        int distance = 0;

        for (int row = 0; row < n; row++)
            for (int col = 0; col < n; col++)
                distance += distanceToCorrectPosition(board[row][col], row, col);
        
        return distance;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return false;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        return false;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        return null;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        return null;
    }

    // unit testing (not graded)
    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tiles[i][j] = in.readInt();
        Board initial = new Board(tiles);

        System.out.print(initial.toString());

        System.out.println("HAMMING: " + initial.hamming());
        System.out.println("MANHATTAN: " + initial.manhattan()); 
    }

    private int distanceToCorrectPosition(int value, int currentRow, int currentCol) {
        if (value == 0) return 0;

        int correctRow = (value - 1) / n;
        int correctCol = (value - 1) % n;

        int dist = Math.abs(currentRow - correctRow) + Math.abs(currentCol - correctCol);
        return dist;
    }

    private int solution(int row, int col) {
        if (row == (n - 1) && col == (n - 1)) return 0;
        return row * n + col + 1;
    }

    private void printSolution() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(solution(i, j));
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
}