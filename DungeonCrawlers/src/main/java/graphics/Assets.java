package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class Assets {

    public static BufferedImage player, enemy, barrier, exit, floor, specialReward, regularReward, trap;

    //load in everything(material) in our game
    public static void initAssets(){
        player = ImageLoader.loadImage("/mainCharacter.png");
        enemy = ImageLoader.loadImage("/enemy2.png");
        barrier = ImageLoader.loadImage("/barrierTexture.png");
        exit = ImageLoader.loadImage("/exitTexture.png");
        floor = ImageLoader.loadImage("/floorTexture.png");
        specialReward = ImageLoader.loadImage("/specialReward.png");
        regularReward = ImageLoader.loadImage("/regularReward.png");
        trap = ImageLoader.loadImage("/trap.png");
    }

}
