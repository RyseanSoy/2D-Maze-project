public class Main {
    public static void main(String[] args) {
        /*
         * create maze model with 10 rows and 10 columns
         */
        MazeModel maze = new MazeModel(10, 10);
        /*
         * create maze with random path
         */
        MazeGenerator.generateMazeRandomised(maze);
        /*
         * create maze window to display maze
         */
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
