
public class MazeSolver {
    public static void BFSMazeModel(MazeModel model, MazeCanvas canvas) {
        // reset visited cells
        for (int i = 0; i < model.getRows(); i++) {
            for (int j = 0; j < model.getCols(); j++) {
                model.getCell(i, j).setVisited(false);
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
                queue.enqueue(new int[] { r - 1, c });
                System.out.println("Current position: " + r + ", " + c);
            }

            // Check DOWN (r + 1, c)
            if (!currentCell.getBottom() && model.inBounds(r + 1, c) && !model.getCell(r + 1, c).isVisited()) {
                model.getCell(r + 1, c).setVisited(true);
                queue.enqueue(new int[] { r + 1, c });
                System.out.println("Current position: " + r + ", " + c);
            }

            // Check LEFT (r, c - 1)
            if (!currentCell.getLeft() && model.inBounds(r, c - 1) && !model.getCell(r, c - 1).isVisited()) {
                model.getCell(r, c - 1).setVisited(true);
                queue.enqueue(new int[] { r, c - 1 });
                System.out.println("Current position: " + r + ", " + c);
            }

            // Check RIGHT (r, c + 1)
            if (!currentCell.getRight() && model.inBounds(r, c + 1) && !model.getCell(r, c + 1).isVisited()) {
                model.getCell(r, c + 1).setVisited(true);
                queue.enqueue(new int[] { r, c + 1 });
                System.out.println("Current position: " + r + ", " + c);
            }

            if (r == model.getRows() - 1 && c == model.getCols() - 1) {
                System.out.println("Exit found at: " + r + ", " + c);
                break;
            }
            /**
             * repaint the canvas
             * delay in milliseconds
             */
            canvas.repaint();
            try {
                Thread.sleep(200); // delay in milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } // end while
    }// end BFSMazeModel
}// end class
