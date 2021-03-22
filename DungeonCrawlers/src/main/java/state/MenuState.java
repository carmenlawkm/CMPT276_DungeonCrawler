package state;

import graphics.Assets;

import java.awt.*;

public class MenuState extends State{

    private Game game;
    private Image logo;
    private Image bg;

    public MenuState(Game game){
        this.game = game;
        this.logo = Assets.logo;
        this.bg = Assets.bg;
    }

    public void render(Graphics g) {
        g.drawImage(bg,0,0, null);
        g.drawImage(logo,230,100, null);
        g.setColor(Color.white);
        g.setFont(Assets.eightBit_click);
        g.drawString("CLICK TO START!", 375, 600);
    }


    public void update() {
        if(game.getMouseInput().isLeftPressed()){
            System.out.println("Starting Level1.");
            State.setState(game.gameState);
            game.gameState.startThreads();
        }
    }
}
