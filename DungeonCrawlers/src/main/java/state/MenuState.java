package state;

import graphics.Assets;

import java.awt.*;

/**
 * State to indicate the player is in the start menu
 */
public class MenuState extends State{

    private Game game;
    private Image logo;
    private Image bg;

    /**
     * Constructor
     */
    public MenuState(){
        this.game = Game.getInstance();
        this.logo = Assets.logo;
        this.bg = Assets.bg;
    }

    /**
     * renders the special graphics of game menu
     * @param g Graphic to render on
     */
    public void render(Graphics g) {
        g.drawImage(bg,0,0, null);
        g.drawImage(logo,230,100, null);
        g.setColor(Color.white);
        g.setFont(Assets.eightBit_click);
        g.drawString("CLICK TO START!", 375, 600);
    }

    /**
     * if the player clicks on the menu:
     * Start up the first level
     */
    public void update() {
        if(game.getMouseInput().isLeftPressed()){
            System.out.println("Starting Level1.");
            State.setState(game.gameState);
            game.gameState.startThreads();
        }
    }
}
