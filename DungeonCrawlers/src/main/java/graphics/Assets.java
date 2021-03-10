package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class Assets {

    public static BufferedImage player, enemy, barrier, exit, floor, specialReward, regularReward, trap;

    //load in everything(material) in our game
    public static void initAssets(){
        player = ImageLoader.loadImage("/mainCharacter.png");
        enemy = ImageLoader.loadImage("/enemy.png");
        barrier = ImageLoader.loadImage("/barrier.png");
        exit = ImageLoader.loadImage("/exit.png");
        floor = ImageLoader.loadImage("/floor.png");
        specialReward = ImageLoader.loadImage("/specialReward.png");
        regularReward = ImageLoader.loadImage("/regularReward.png");
        trap = ImageLoader.loadImage("/trap.png");

    }

}
