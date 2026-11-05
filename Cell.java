/**
 * The Cell class represents a single cell in the maze.
 * Each cell has four walls: top, bottom, left, and right.
 * Each cell also has a visited status: true if visited, false otherwise.
 * 
 */

public class Cell {
    private boolean top = true, bottom = true, left = true, right = true; // true = wall exists
    private boolean visited = false;

    /**
     * Constructor for Cell
     * Initializes a cell with all walls intact and visited status set to false
     */
    public Cell() {
        this.top = true;
        this.bottom = true;
        this.left = true;
        this.right = true;
        this.visited = false;
    }// end constructor

        public boolean getTop() {
            return top;
        }// end getTop

        public boolean getBottom() {
            return bottom;
        }// end getBottom

        public boolean getLeft() {
            return left;
        }// end getLeft

        public boolean getRight() {
            return right;
        }// end getRight

        public boolean isVisited() {
            return visited;
        }// end isVisited

        public void setVisited(boolean visited) {
            this.visited = visited;
        }// end setVisited
}// end Cell
