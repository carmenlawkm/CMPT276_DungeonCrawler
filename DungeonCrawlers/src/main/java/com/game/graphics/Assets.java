package main.java.com.game.graphics;

import java.awt.image.BufferedImage;


public class Assets {

    public static BufferedImage player, enemy, barrier, exit, floor, specialReward, regularReward, trap;

    //load in everything(material) in our game
    public static void initAssets(){
        player = ImageLoader.loadImage("/main/resources/mainCharacter.png");
        enemy = ImageLoader.loadImage("/main/resources/enemy.png");
        barrier = ImageLoader.loadImage("/main/resources/barrier.png");
        exit = ImageLoader.loadImage("/main/resources/exit.png");
        floor = ImageLoader.loadImage("/main/resources/floor.png");
        specialReward = ImageLoader.loadImage("/main/resources/specialReward.png");
        regularReward = ImageLoader.loadImage("/main/resources/regularReward.png");
        trap = ImageLoader.loadImage("/main/resources/trap.png");

    }
}
