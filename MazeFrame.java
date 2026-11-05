import javax.swing.*;

public class MazeFrame extends JFrame {
    MazeModel model;

    public MazeFrame(MazeModel model) {
        this.model = model;
        setTitle("Maze Frame");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new MazeCanvas(model));
    }

}
