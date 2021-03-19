package GameObjects;

import World.World;
import com.sun.tools.javac.Main;
import graphics.Assets;
import state.Game;

import java.awt.*;

public class TrapCell extends GameObject{
    int deductionValue;
    int disappearTimer;
    MainCharacter player;

    public TrapCell(Game game, World world, Point location, int deductionValue, int disappearTimer, MainCharacter player) {
        super(game, world, location);
        this.deductionValue = deductionValue;
        this.disappearTimer = disappearTimer;
        this.image = Assets.trap;
        this.player=player;
    }

    public void update() {
        if(disappearTimer==2000){
            this.image = Assets.trapgone;
        }
        if(player.getX()==location.x && player.getY()==location.y){
            player.score=player.score-deductionValue;
            this.image=Assets.trap;
            disappearTimer=0;
        }
        disappearTimer++;
    }

    public void render(Graphics g){
        g.drawImage(image, location.x, location.y, tileSize, tileSize, null);

    }

}
