package graphics;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Designed to load fonts into the game
 */
public class FontLoader {

    /**
     * @param path File of the font
     * @param size Size of the output font
     */
    public static Font loadFont(String path, float size){
        try {
            return Font.createFont(Font.TRUETYPE_FONT, new File(path)).deriveFont(Font.PLAIN, size);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
