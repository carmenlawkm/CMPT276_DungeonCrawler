package GameObjects;

import World.Tile;
import graphics.Assets;
import state.Game;


import java.awt.*;

public class Enemy extends Creatures{
    private int deductionValue;
    private Game game;
    private int texturesize= Tile.TEXTUREWIDTH;
    private MainCharacter player;

    public Enemy(Game game, Point location, int deductionValue, MainCharacter player) {
        super(location);
        this.deductionValue = deductionValue;
        this.image = Assets.enemy;
        this.game=game;
        this.player=player;
    }

    void setDeductionValue(int value) {
        deductionValue = value;
    }

    public void moveTowardsPlayer(Point playerLocation){
    }

    @Override
    public void update() {
        // enemy will prioritize moving in terms of left and right direction to
        // player then prioritizes moving up and down closer to player
        int xTowardsPlayer = 0;
        int yTowardsPlayer = 0;

        if (location.x == player.getX() && location.y == player.getY()) {
            player.score = player.score - deductionValue;
            System.out.printf("Enemy is in the same spot as player: (%2d,%2d)%n", location.x, location.y);
        } else if (location.x < player.getX()) {
            xTowardsPlayer = texturesize;
            System.out.printf("Enemy is to the left of player in position (%2d, %2d), Player: (%2d, %2d)%n", location.x, location.y, player.getX(), player.getY());
        } else if (location.x > player.getX()) {
            xTowardsPlayer = -texturesize;
            System.out.printf("Enemy is to the right of player in position (%2d, %2d), Player: (%2d, %2d)%n", location.x, location.y, player.getX(), player.getY());
        } else if (location.y < player.getY()) {
            yTowardsPlayer = texturesize;
            System.out.printf("Enemy is below player in position (%2d, %2d), Player: (%2d, %2d)%n", location.x, location.y, player.getX(), player.getY());
        } else if (location.y > player.getY()) {
            yTowardsPlayer = -texturesize;
            System.out.printf("Enemy is above player in position (%2d, %2d), Player: (%2d, %2d)%n", location.x, location.y, player.getX(), player.getY());
        }
        setLocation(location.x + xTowardsPlayer, location.y + yTowardsPlayer);
    }
}
