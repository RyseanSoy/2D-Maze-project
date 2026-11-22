import javax.swing.*;

/**
 * Class that extends JFrame to create a window with the title "Maze Frame"
 */
public class MazeFrame extends JFrame {
    MazeModel model;
    MazeCanvas canvas;

    /**
     * create a window with the title "Maze Frame"
     * set the size of the window
     * set the default close operation
     * add the maze canvas to the window
     */
    public MazeFrame(MazeModel model) {
        this.model = model;
        this.canvas = new MazeCanvas(model);// create canvas
        setTitle("Maze Frame");// set title
        setSize(400, 400);// set size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// set default close operation
        add(this.canvas);// add canvas
    }

    // getter
    public MazeCanvas getCanvas() {
        return canvas;
    }

}
