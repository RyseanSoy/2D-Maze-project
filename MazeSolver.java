
public class MazeSolver {
    /**
     * Solves the maze using the Breadth-First Search algorithm.
     * if it is in bounds and not visited and not a wall, add it to the queue
     * repaint the canvas after adding the cell to the queue
     * delay in milliseconds
     * 
     * @param model  The maze model to solve.
     * @param canvas The canvas to draw the solution on.
     */
    public static void BFSMazeModel(MazeModel model, MazeCanvas canvas) {
        // reset visited cells
        for (int i = 0; i < model.getRows(); i++) {
            for (int j = 0; j < model.getCols(); j++) {
                model.getCell(i, j).setVisited(false);
                model.getCell(i, j).setParent(null);
                model.getCell(i, j).setOnPath(false);
            }
        }
        // create a queue
        // add start cell to queue
        // while queue is not empty
        QueueArrayBased queue = new QueueArrayBased();
        model.getCell(0, 0).setVisited(true);
        queue.enqueue(new int[] { 0, 0 });
        // while loop
        while (!queue.isEmpty()) {
            int[] current = (int[]) queue.dequeue();
            int r = current[0];
            int c = current[1];
            Cell currentCell = model.getCell(r, c);
            // if exit is found, reconstruct path and return
            if (r == model.getRows() - 1 && c == model.getCols() - 1) {
                reconstructPath(model, currentCell, canvas);
                return;
            }

            /**
             * check UP (r - 1, c)
             * check DOWN (r + 1, c)
             * check LEFT (r, c - 1)
             * check RIGHT (r, c + 1)
             * if cell is not visited and within bounds and not wall, add it to the queue
             */
            // Check UP (r - 1, c)
            if (!currentCell.getTop() && model.inBounds(r - 1, c) && !model.getCell(r - 1, c).isVisited()) {
                model.getCell(r - 1, c).setVisited(true);
                model.getCell(r - 1, c).setParent(currentCell);
                queue.enqueue(new int[] { r - 1, c });

            }

            // Check DOWN (r + 1, c)
            if (!currentCell.getBottom() && model.inBounds(r + 1, c) && !model.getCell(r + 1, c).isVisited()) {
                model.getCell(r + 1, c).setVisited(true);
                model.getCell(r + 1, c).setParent(currentCell);
                queue.enqueue(new int[] { r + 1, c });

            }

            // Check LEFT (r, c - 1)
            if (!currentCell.getLeft() && model.inBounds(r, c - 1) && !model.getCell(r, c - 1).isVisited()) {
                model.getCell(r, c - 1).setVisited(true);
                model.getCell(r, c - 1).setParent(currentCell);
                queue.enqueue(new int[] { r, c - 1 });

            }

            // Check RIGHT (r, c + 1)
            if (!currentCell.getRight() && model.inBounds(r, c + 1) && !model.getCell(r, c + 1).isVisited()) {
                model.getCell(r, c + 1).setVisited(true);
                model.getCell(r, c + 1).setParent(currentCell);
                queue.enqueue(new int[] { r, c + 1 });

            }

            /**
             * repaint the canvas
             * delay in milliseconds
             * thread.sleep is used to slow down the visualizer
             */
            canvas.repaint();
            try {
                Thread.sleep(100); // delay in milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } // end while
    }// end BFSMazeModel

    /**
     * it reconstructs the path from exit to start by backtracking
     * 
     * @param model  the model of the maze
     * @param exit   the exit cell
     * @param canvas the canvas to draw on
     */
    public static void reconstructPath(MazeModel model, Cell exit, MazeCanvas canvas) {
        Cell step = exit;
        int length = 0;
        // while loop to reconstruct the path
        while (step != null) {
            step.setOnPath(true);// mark the cell as on the path
            step = step.getParent();// set the step to the parent of the current cell
            length++;
        }
        System.out.println("Path length: " + length + " cells");
        canvas.repaint();
    }// end reconstructPath
}// end class
