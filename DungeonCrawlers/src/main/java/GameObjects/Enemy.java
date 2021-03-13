package GameObjects;

import graphics.Assets;

import java.awt.*;

public class Enemy extends GameObject {
    MainCharacter player = MainCharacter.getInstance();
    private int deductionValue;

    public Enemy(Point location, ID id, int deductionValue) {
        super(location);
        this.deductionValue = deductionValue;
        this.image = Assets.enemy;
    }

    void setDeductionValue(int value) {
        deductionValue = value;
    }

    @Override
    public void update() {
        // enemy will prioritize moving in terms of left and right direction to
        // player then prioritizes moving up and down closer to player
        int xTowardsPlayer = 0;
        int yTowardsPlayer = 0;

        if (location.x == player.getX() && location.y == player.getY()) {
            player.score = player.score - deductionValue;
            System.out.println("enemy is in same spot as player");
        } else if (location.x < player.getX()) {
            xTowardsPlayer = 40;
            System.out.println("enemy is to the left of player");
        } else if (location.x > player.getX()) {
            xTowardsPlayer = -40;
            System.out.println("enemy is to the right of player");
        } else if (location.y < player.getY()) {
            yTowardsPlayer = 40;
            System.out.println("enemy is below the player");
        } else if (location.y > player.getY()) {
            yTowardsPlayer = -40;
            System.out.println("enemy is above the player");
        }
        setLocation(location.x + xTowardsPlayer, location.y + yTowardsPlayer);
    }
}
