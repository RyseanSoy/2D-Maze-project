import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Color;

/**
 * Canvas for drawing the maze model
 * 
 */
public class MazeCanvas extends JPanel {
    // Maze model to draw
    MazeModel model;

    /**
     * Constructor for MazeCanvas
     * 
     * @param model Maze model to draw
     */
    public MazeCanvas(MazeModel model) {
        this.model = model;
    }

    /**
     * Draw a cell in the maze
     * 
     * @param g        Graphics context
     * @param c        Cell to draw
     * @param top      Top coordinate
     * @param left     Left coordinate
     * @param cell_dim Cell dimension
     */
    private void drawCell(Graphics g, Cell c, int top, int left, int cell_dim) {
        top = top + 1;
        // If visited, fill the inside with color light blue
        if (c.isVisited()) {
            g.setColor(new Color(173, 216, 230)); // light blue
            g.fillRect(left, top, cell_dim, cell_dim);
        }
        // If on path, fill the inside with color orange
        if (c.isOnPath()) {
            g.setColor(new Color(255, 165, 0)); // orange
            g.fillRect(left, top, cell_dim, cell_dim);
        }
        g.setColor(Color.BLACK);
        if (c.getTop() == true)
            g.drawLine(left, top, left + cell_dim, top);
        if (c.getLeft() == true)
            g.drawLine(left, top, left, top + cell_dim);
        if (c.getBottom() == true)
            g.drawLine(left, top + cell_dim, left + cell_dim, top + cell_dim);
        if (c.getRight() == true)
            g.drawLine(left + cell_dim, top, left + cell_dim, top + cell_dim);
    }

    /**
     * Paint the maze
     * 
     * @param g Graphics context
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // clears the panel before redrawing
        int w = getWidth();
        int h = getHeight();
        int cell_dim;

        if (w < h)
            cell_dim = w / model.getRows();
        else
            cell_dim = h / model.getRows();
        for (int i = 0; i < model.getRows(); i++) {
            for (int j = 0; j < model.getCols(); j++) {
                drawCell(g, model.getCell(i, j), i * cell_dim, j * cell_dim, cell_dim);
            }
        }
    }
}
