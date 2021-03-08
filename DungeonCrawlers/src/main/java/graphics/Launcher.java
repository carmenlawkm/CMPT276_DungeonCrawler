package graphics;

import state.Game;

    //starts up our game.
public class Launcher {
    public static void main(String args[]){
            Game game = new Game(1200,800, "Dungeon Crawler");
            game.start();
    }
}
