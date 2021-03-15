package graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * ImageLoader class assists rendering of images of the game
 */
public class ImageLoader {

    /**
     * loadImage takes image path and converts it to a BufferedImage
     * @param path defines the path of the image
     */
    public static BufferedImage loadImage(String path)  {
       try {
           return ImageIO.read(ImageLoader.class.getResource(path));
       }catch (IOException e){
           e.printStackTrace();
           System.exit(1);
       }
       return null;
    }
}
