import javax.swing.*;

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
        this.canvas = new MazeCanvas(model);
        setTitle("Maze Frame");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(this.canvas);
    }

    // getter
    public MazeCanvas getCanvas() {
        return canvas;
    }

}
