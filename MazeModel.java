public class MazeModel {
    private Cell[][] cells;
    private int rows, cols;

    /**
     * Constructor for MazeModel
     * 
     * @param rows number of rows in the maze
     * @param cols number of columns in the maze
     */
    public MazeModel(int rows, int cols) {
        if (rows < 1 || cols < 1) {
            throw new IllegalArgumentException(
                    "Maze dimensions must be at least 1. Got rows=" + rows + ", cols=" + cols);
        } // end if
        this.rows = rows;
        this.cols = cols;
        cells = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
    }// end constructor

    /**
     * Checks if a cell is within the bounds of the maze
     * 
     * @param r row index
     * @param c column index
     * @return true if the cell is within bounds, false otherwise
     */
    public boolean inBounds(int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }// end inBounds

    // Getters
    public int getRows() {
        return rows;
    }// end getRows

    public int getCols() {
        return cols;
    }// end getCols

    /**
     * Returns the cell at the given row and column
     * 
     * @param r row index
     * @param c column index
     * @return the Cell at position (r, c)
     * @throws IllegalArgumentException if (r, c) is out of bounds
     */
    public Cell getCell(int r, int c) {
        if (!inBounds(r, c)) {
            throw new IllegalArgumentException("Cell position out of bounds: row=" + r + ", col=" + c);
        } // end if
        return cells[r][c];
    }// end getCell
}
