package GameObjects;

import World.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {

    private World world;
    private Point playerSpawn;
    private Point enemySpawn;
    private int deductionValue;
    private MainCharacter player;
    private Enemy enemy;

    @BeforeEach
    void setup(){
        world = new World("src/main/resources/Level1.txt");
        playerSpawn = new Point(0,80);
        player = new MainCharacter(world, playerSpawn);

        deductionValue = 100;
        enemySpawn = new Point(1040,80);
        enemy = new Enemy(world, enemySpawn, deductionValue, player);
    }

    @Test
    void run() {
    }

    @Test
    void isOnPlayer() {
        //initial spawn points are not the same
        assertFalse(enemy.isOnPlayer());
        //move enemy to player, then check if true
        enemy.setLocation(0, 80);
        assertTrue(enemy.isOnPlayer());
    }

    @Test
    void start() {
    }

    @Test
    void stop() {
    }

    @Test
    void update() {
        //scenario 1: player is left, enemy moves left
        player.setLocation(80, 80);
        enemy.setLocation(400, 80);
        enemy.update();
        assertTrue(enemy.getLocation() == new Point(400 - 40, 80));

        //scenario 2: player is right, enemy moves right
        player.setLocation(400, 80);
        enemy.setLocation(80, 80);
        enemy.update();
        assertTrue(enemy.getLocation() == new Point(80 + 40, 80));

        //scenario 3: player is above, x is un-walkable, enemy moves up
        player.setLocation(40, 40);
        enemy.setLocation(160, 240);
        enemy.update();
        assertTrue(enemy.getLocation() == new Point(160, 240 - 40));

        //scenario 4: player is below, x is un-walkable, enemy moves down
        player.setLocation(400, 280);
        enemy.setLocation(160, 240);
        enemy.update();
        assertTrue(enemy.getLocation() == new Point(160, 240 + 40));

        //scenario 5: both x and y directions are un-walkable; enemy stays in place
        player.setLocation(400, 80);
        enemy.setLocation(80, 560);
        enemy.update();
        assertTrue(enemy.getLocation() == new Point(80, 560));
    }
}