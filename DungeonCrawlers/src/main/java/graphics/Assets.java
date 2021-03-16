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

    public static BufferedImage player, enemy, barrier, exit, floor, specialReward, regularReward, trap, trapgone, rewardgone;

    /**
     * loads all assets from our resources folder
     */
    public static void initAssets(){
        player = ImageLoader.loadImage("/mainCharacter.png");
        enemy = ImageLoader.loadImage("/enemy2.png");
        barrier = ImageLoader.loadImage("/barrierTexture.png");
        exit = ImageLoader.loadImage("/exitTexture.png");
        floor = ImageLoader.loadImage("/floorTexture.png");
        specialReward = ImageLoader.loadImage("/specialReward.png");
        regularReward = ImageLoader.loadImage("/regularReward.png");
        trap = ImageLoader.loadImage("/trap.png");
        trapgone = ImageLoader.loadImage("/Trapgone.png");
        rewardgone= ImageLoader.loadImage("/Rewardgone.png");
    }

}
