package graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Assets class holds all images used in the game
 */
public class Assets {

    public static BufferedImage bg,logo, player, enemy, barrier, exit, floor, specialReward, regularReward, trap, trapgone, rewardgone;
    public static Font eightBit_click, eightBit_score, eightBit_over;
    /**
     * loads all assets from our resources folder
     */
    public static void initAssets(){
        bg = ImageLoader.loadImage("/dungeonBG_resized.png");
        logo = ImageLoader.loadImage("/logo.png");
        eightBit_click = FontLoader.loadFont("DungeonCrawlers/src/main/resources/Pixeboy-z8XGD.ttf", 70);
        eightBit_score = FontLoader.loadFont("DungeonCrawlers/src/main/resources/Pixeboy-z8XGD.ttf", 60);
        eightBit_over = FontLoader.loadFont("DungeonCrawlers/src/main/resources/Pixeboy-z8XGD.ttf", 120);
        player = ImageLoader.loadImage("/mainCharacter2.png");
        enemy = ImageLoader.loadImage("/enemy3.png");
        barrier = ImageLoader.loadImage("/barrierTexture.png");
        exit = ImageLoader.loadImage("/exitTexture2.png");
        floor = ImageLoader.loadImage("/floorTexture.png");
        specialReward = ImageLoader.loadImage("/specialReward2.png");
        regularReward = ImageLoader.loadImage("/regularReward3.png");
        trap = ImageLoader.loadImage("/trap3.png");
        trapgone = ImageLoader.loadImage("/Trapgone.png");
        rewardgone= ImageLoader.loadImage("/Rewardgone.png");
    }

}
