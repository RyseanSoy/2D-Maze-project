import java.awt.Canvas;
import java.awt.Graphics;

public class MazeCanvas extends Canvas {
    MazeModel model;

    public MazeCanvas(MazeModel model) {
        this.model = model;
    }

    private void drawCell(Graphics g, Cell c, int top, int left, int cell_dim) {
        top = top + 1;
        if (c.getTop() == true)
            g.drawLine(left, top, left + cell_dim, top);
        if (c.getLeft() == true)
            g.drawLine(left, top, left, top + cell_dim);
        if (c.getBottom() == true)
            g.drawLine(left, top + cell_dim, left + cell_dim, top + cell_dim);
        if (c.getRight() == true)
            g.drawLine(left + cell_dim, top, left + cell_dim, top + cell_dim);
    }

    @Override
    public void paint(Graphics g) {

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
