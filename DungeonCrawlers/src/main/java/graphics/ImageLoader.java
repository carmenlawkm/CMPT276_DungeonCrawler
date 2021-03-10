package main.java.com.game.graphics;

//import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoader {

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
