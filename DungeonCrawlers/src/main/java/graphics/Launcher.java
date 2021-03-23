package graphics;

import state.Game;

/**
 * Holds the main method
 * Initiates our game!
 */

public class Launcher {
    /**
     * Main method
     * runs our game
     */
    public static void main(String args[]){

        Game game;
        game = Game.getInstance();
        game.initialize();
    }
}
