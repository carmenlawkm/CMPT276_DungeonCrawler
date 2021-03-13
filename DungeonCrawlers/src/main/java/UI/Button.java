package main.java.UI;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Button extends ObjectUI{
    private BufferedImage[] images;
    private Click clicker;

    public void tick() {}


    public void render(Graphics g) {
        if(hovering)
            g.drawImage(images[1], (int) x, (int) y, width, height, null);
        else
            g.drawImage(images[0], (int) x, (int) y, width, height, null);
    }
    public void onClick() {
        clicker.onClick();
    }

    public Button(float x, float y, int width, int height, BufferedImage[] images, Click clicker) {
        super(x, y, width, height);
        this.images = images;
        this.clicker = clicker;
    }
}
