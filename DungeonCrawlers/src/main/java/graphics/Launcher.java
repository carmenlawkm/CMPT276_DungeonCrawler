package graphics;

import state.Game;

//starts up our game.
public class Launcher {
    public static void main(String args[]){
        Game game = Game.getInstance();
        game.start();
    }
}
