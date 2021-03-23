package state;

import graphics.Assets;

import java.awt.*;

/**
 * State to indicate the player has won
 */
public class WinState extends State{
    private Game game;

    /**
     * Constructor
     * @param game the game the state is running on
     */
    public WinState(Game game){
        this.game = game;
    }

    /**
     * renders the special graphics of game won status
     * @param g Graphic to render on
     */
    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0,0,1200,800);
        g.setColor(Color.white);
        g.setFont(Assets.eightBit_over);
        g.drawString("You Win!", 380, 400);

    }

    /**
     * sets the game to not running
     */
    public void update() {
        game.setRunning(false);
    }
}
