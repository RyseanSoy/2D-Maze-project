public class Main {
    /**
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {

        // create maze model with 30 rows and 30 column
        MazeModel maze = new MazeModel(30, 30);
        // create maze with random path
        MazeGenerator.generateMazeRandomised(maze);
        // create maze window to display maze
        MazeFrame frame = new MazeFrame(maze);
        frame.setVisible(true);
        /*
         * create background thread
         * Solving maze using BFS algorithm
         */
        new Thread(() -> {
            MazeSolver.BFSMazeModel(maze, frame.getCanvas());
        }).start();
    }
}
