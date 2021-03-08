package main.java.com.game.graphics;

import java.awt.image.BufferedImage;


public class Assets {
    //private static final int width = 32, height = 32;
    public static BufferedImage player;

    //load in everything(material) in our game
    public static void initAssets(){
        player = ImageLoader.loadImage("/main/resources/mainCharacter.png");

    }
}
