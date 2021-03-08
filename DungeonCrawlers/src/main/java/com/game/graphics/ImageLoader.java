package main.java.com.game;

import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoader {

    private static int imageX = 50;
    private static int imageY = 50;

    public static BufferedImage loadImage(String path, Boolean resize){
        try {
            BufferedImage bImage;
            bImage = ImageIO.read(ImageLoader.class.getResource(path));

            if (resize == true){
                return Thumbnails.of(bImage).size(imageX, imageY).asBufferedImage();
            }

            return bImage;

        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
