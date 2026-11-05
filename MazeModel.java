public class MazeModel {
    private Cell[][] cells;
    private int rows, cols;

    /**
     * Constructor for MazeModel
     * @param rows number of rows in the maze
     * @param cols number of columns in the maze
     */
    public MazeModel(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        cells = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new Cell();
            }
        }
    }// end constructor
    /**
     * Checks if a cell is within the bounds of the maze
     * @param r row index
     * @param c column index
     * @return true if the cell is within bounds, false otherwise
     */
    public boolean inBounds(int r, int c){
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }// end inBounds

    // Getters
    public int getRows() {
        return rows;
    }// end getRows
    public int getCols() {
        return cols;
    }// end getCols
    
    public Cell getCell(int r, int c) {
        return cells[r][c];
    }   
}
