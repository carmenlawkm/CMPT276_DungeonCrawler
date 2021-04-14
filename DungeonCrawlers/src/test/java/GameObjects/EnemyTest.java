package GameObjects;

import World.Tile;
import World.World;
import World.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
    void isNotOnPlayer(){
        //initial spawn points are not the same
        assertFalse(enemy.isOnPlayer());
    }

    @Test
    void isOnPlayer() {
        //move enemy to player, then check if true
        enemy.setLocation(0, 80);
        assertTrue(enemy.isOnPlayer());
    }


    @Test
    void updatesLocationTowardsPlayer() {
        //scenario 1: player is left, enemy moves left
        player.setLocation(80, 80);
        enemy.setLocation(400, 80);
        enemy.update();
        assertEquals(new Point(400 - Tile.TEXTUREWIDTH, 80), enemy.getLocation());

        //scenario 2: player is right, enemy moves right
        player.setLocation(400, 80);
        enemy.setLocation(80, 80);
        enemy.update();
        assertEquals(new Point(80 + Tile.TEXTUREWIDTH, 80), enemy.getLocation());

        //scenario 3: player is above, x is un-walkable, enemy moves up
        player.setLocation(40, 40);
        enemy.setLocation(160, 240);
        enemy.update();
        assertEquals(new Point(160, 240 - Tile.TEXTUREWIDTH), enemy.getLocation());

        //scenario 4: player is below, x is un-walkable, enemy moves down
        player.setLocation(400, 280);
        enemy.setLocation(160, 240);
        enemy.update();
        assertEquals(new Point(160, 240 + Tile.TEXTUREWIDTH), enemy.getLocation());
    }

    @Test
    void doesNotUpdateLocationTowardsPlayer(){
        //only scenario: both x and y directions are un-walkable; enemy stays in place
        player.setLocation(400, 80);
        enemy.setLocation(160, 560);
        enemy.update();
        assertEquals(new Point(160, 560), enemy.getLocation());
    }

    @Test
    void startAndStoppingThread() {
        enemy.start();
        assertTrue(enemy.getEnemyThread().isAlive());
        enemy.stop();
        assertFalse(enemy.getEnemyThread().isAlive());
    }
}