package state;

import GameObjects.*;
import World.World;
import graphics.Assets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Level1StateTest {
    private MainCharacter player;
    private Enemy enemy;
    private World world;
    private Game game;
    public Level1State level1state;
    private ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

    private BonusReward bonus1, bonus2;

    private static Point playerSpawn = new Point(0,80);

    private static Point enemySpawn = new Point(1040,80);

    private static Point reward1Spawn = new Point (160,640);
    private static Point reward2Spawn = new Point (960,160);
    private static Point reward3Spawn = new Point (800,640);
    private static Point reward4Spawn = new Point (80,320);
    private static Point reward5Spawn = new Point (560,240);

    private static Point bonusReward1Spawn= new Point(80,640);
    private static Point bonusReward2Spawn= new Point(720,400);

    private static Point trap1Spawn = new Point(320, 80);
    private static Point trap2Spawn = new Point(480, 160);
    private static Point trap3Spawn = new Point(400, 400);
    private static Point trap4Spawn = new Point(480, 560);
    private static Point trap6Spawn = new Point(1040, 160);
    private static Point trap7Spawn = new Point(880, 80);

    public static Point exitLocation = new Point (1120,560);
    @BeforeEach
    void setup(){
        level1state = new Level1State();
    }
    @Test
    void checkifThreadsStarted(){
        assertTrue(enemy.getEnemyThread().isAlive());
        assertTrue(player.getPlayerThread().isAlive());
        assertTrue(bonus1.getBonusrewardthread().isAlive());
        assertTrue(bonus2.getBonusrewardthread().isAlive());


    }
    @Test
    void checkConstructorValues(){

    }



}