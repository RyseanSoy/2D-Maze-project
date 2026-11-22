/**
 * The Cell class represents a single cell in the maze.
 * Each cell has four walls: top, bottom, left, and right.
 * Each cell also has a visited status: true if visited, false otherwise.
 * 
 */

public class Cell {
    public boolean top, bottom, left, right;
    public boolean visited;
    public int row, col;
    private Cell parent;
    private boolean onPath;

    /**
     * Constructor for Cell
     * Initializes a cell with all walls intact and visited status set to false
     * 
     * @param r row of the cell
     * @param c column of the cell
     */
    public Cell(int r, int c) {
        row = r;
        col = c;
        this.top = true;
        this.bottom = true;
        this.left = true;
        this.right = true;
        this.visited = false;
    }// end

    /**
     * 
     * 
     * @return true if top, bottom, left or right wall exists, false otherwise
     * @return row of the cell
     * @return col of the cell
     */
    //
    public int getRow() {
        return row;
    }

    /**
     * 
     * 
     * @return column of the cell
     */
    public int getCol() {
        return col;
    }

    /**
     * 
     * 
     * @return true if top wall exists, false otherwise
     */
    public boolean getTop() {
        return top;
    }// end getTop

    /**
     * 
     * @return true if bottom wall exists, false otherwise
     */
    public boolean getBottom() {
        return bottom;
    }// end getBottom

    /**
     * 
     * @return true if left wall exists, false otherwise
     */
    public boolean getLeft() {
        return left;
    }// end getLeft

    /**
     * 
     * @return true if right wall exists, false otherwise
     */
    public boolean getRight() {
        return right;
    }// end getRight

    /**
     * 
     * @return true if the cell is visited, false otherwise
     */
    public boolean isVisited() {
        return visited;
    }// end isVisited

    /**
     * sets the visited status of the cell
     * 
     * @param visited true if visited, false otherwise
     */
    // setter
    public void setVisited(boolean visited) {
        this.visited = visited;
    }// end setVisited

    // parent setter and getter
    /**
     * 
     * @return parent of the cell
     */
    public Cell getParent() {
        return parent;
    }

    /**
     * 
     * @param parent parent of the cell
     */
    public void setParent(Cell parent) {
        this.parent = parent;
    }

    /**
     * 
     * @return true if the cell is on the path, false otherwise
     */
    public boolean isOnPath() {
        return onPath;
    }

    /**
     * 
     * @param onPath true if the cell is on the path, false otherwise
     */
    public void setOnPath(boolean onPath) {
        this.onPath = onPath;
    }

    /**
     * sets the top wall of the cell
     * 
     * @param top    bottom true if top wall exists, false otherwise
     * @param bottom bottom true if bottom wall exists, false otherwise
     * @param left   left true if left wall exists, false otherwise
     * @param right  right true if right wall exists, false otherwise
     */

    public void setTop(boolean top) {
        this.top = top;
    }// end setTop

    public void setBottom(boolean bottom) {
        this.bottom = bottom;
    }// end setBottom

    public void setLeft(boolean left) {
        this.left = left;
    }// end setLeft

    public void setRight(boolean right) {
        this.right = right;
    }// end setRight

}// end Cell
