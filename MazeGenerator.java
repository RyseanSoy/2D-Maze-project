import java.util.ArrayList;

import Stack.StackReferenceBased;

public class MazeGenerator {
    public static void generateMazeRandomised(MazeModel model) {
        StackReferenceBased stack = new StackReferenceBased();
        // Starting from the top-left corner (0, 0)
        Cell startCell = model.getCell(0, 0);
        startCell.setVisited(true);
        // push the first cell into the stack
        stack.push(new int[] { 0, 0 });
        /**
         * while the stack is not empty
         * peek at the top of the stack for checking what our position is
         * get the row and column from the current cell
         * add list of valid unvisited cells
         */
        while (!stack.isEmpty()) {
            // peek at the top of the stack for checking what our position is
            int[] current = (int[]) stack.peek();
            // get the row and column from the current cell
            int r = current[0];
            int c = current[1];
            Cell currentCell = model.getCell(r, c);

            // add list of valid unvisited cells
            ArrayList<int[]> NotVisitedCell = new ArrayList<>();
            /**
             * check UP (r - 1, c)
             * check DOWN (r + 1, c)
             * check LEFT (r, c - 1)
             * check RIGHT (r, c + 1)
             * if the neighbor is in bounds and not visited, add it to the list
             */
            // Check UP (r - 1, c)
            if (model.inBounds(r - 1, c) && !model.getCell(r - 1, c).isVisited()) {
                NotVisitedCell.add(new int[] { r - 1, c });
            }
            // Check DOWN (r + 1, c)
            if (model.inBounds(r + 1, c) && !model.getCell(r + 1, c).isVisited()) {
                NotVisitedCell.add(new int[] { r + 1, c });
            }
            // Check LEFT (r, c - 1)
            if (model.inBounds(r, c - 1) && !model.getCell(r, c - 1).isVisited()) {
                NotVisitedCell.add(new int[] { r, c - 1 });
            }
            // Check RIGHT (r, c + 1)
            if (model.inBounds(r, c + 1) && !model.getCell(r, c + 1).isVisited()) {
                NotVisitedCell.add(new int[] { r, c + 1 });
            }
            /**
             * if the list is not empty, then there are unvisited neighbors
             * pick a random neighbor
             * remove the wall between the current cell and the chosen neighbor
             * push the chosen neighbor into the stack
             * set the chosen neighbor as visited
             */
            if (!NotVisitedCell.isEmpty()) {
                // Pick a random neighbor
                int randomIndex = (int) (Math.random() * NotVisitedCell.size());
                int[] next = NotVisitedCell.get(randomIndex);
                int nextR = next[0];
                int nextC = next[1];
                Cell nextCell = model.getCell(nextR, nextC);

                // Moving UP
                if (nextR == r - 1) {
                    currentCell.setTop(false);
                    nextCell.setBottom(false);
                }
                // Moving DOWN
                else if (nextR == r + 1) {
                    currentCell.setBottom(false);
                    nextCell.setTop(false);
                }
                // Moving LEFT
                else if (nextC == c - 1) {
                    currentCell.setLeft(false);
                    nextCell.setRight(false);
                }
                // Moving RIGHT
                else if (nextC == c + 1) {
                    currentCell.setRight(false);
                    nextCell.setLeft(false);
                }

                // Mark nextCell as visited
                nextCell.setVisited(true);

                // Push next position onto the stack
                stack.push(new int[] { nextR, nextC });

            } else {
                // No unvisited neighbors -> Dead end, backtrack
                stack.pop();
            } // end else
        } // end while loop
    } // end of generateMazeRandomised

} // end of class