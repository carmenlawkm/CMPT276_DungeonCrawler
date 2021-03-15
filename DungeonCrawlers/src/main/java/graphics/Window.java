package graphics;

import javax.swing.*;
import java.awt.*;

/**
 * Window class creates the window of the game
 */
public class Window {
    private JFrame frame;
    private Canvas canvas;

    private String title;
    private int width, height;

    /**
     * Window constructor
     * Defines and creates the window
     * @param width defines the width of the window
     * @param height defines the height of the window
     * @param title defines the title of the window
     */
    public Window(int width, int height, String title) {
        this.title = title;
        this.width = width;
        this.height = height;

        createWindow();
    }

    /**
     * Creates the window
     */
    private void createWindow() {
        frame = new JFrame(title);
        //setting size for window
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //let game exit
        frame.setResizable(false);//cannot resize game
        frame.setLocationRelativeTo(null);//let window start in the middle
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();
    }

    /**
     * Canvas getter
     * @return Window canvas
     */
    public Canvas getCanvas() {
        return canvas;
    }

    /**
     * JFrame getter
     * @return frame of the window
     */
    public JFrame getFrame() {
        return frame;
    }
}
