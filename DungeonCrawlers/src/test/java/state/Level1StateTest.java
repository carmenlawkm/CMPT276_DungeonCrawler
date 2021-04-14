package state;

import GameObjects.*;
import World.World;
import com.sun.tools.javac.Main;
import graphics.Assets;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;


public class Level1StateTest {
    public Level1State level1state;
    private Game game;
    public static Point exitLocation = new Point (1120,560);
    @Before
    public void setup(){
        level1state = new Level1State();
        game = Game.getInstance();

    }
    @Test
    public void threadShouldStart(){
        MainCharacter player = level1state.getMainCharacter();
        Enemy enemy = level1state.getEnemy();
        BonusReward bonus1 = level1state.getBonusReward("bonus1");
        BonusReward bonus2 = level1state.getBonusReward("bonus2");
        level1state.startThreads();
        assertTrue(player.getPlayerThread().isAlive());
        assertTrue(enemy.getEnemyThread().isAlive());
        assertTrue(bonus1.getBonusrewardthread().isAlive());
        assertTrue(bonus2.getBonusrewardthread().isAlive());

    }
    @Test
    public void playerShouldDieLevel1(){
        ArrayList <GameObject> arrayList = level1state.getArrayList();
        BonusReward bonus1 = level1state.getBonusReward("bonus1");
        BonusReward bonus2 = level1state.getBonusReward("bonus2");
        GameObject trap1 = arrayList.get(5);
        MainCharacter player = level1state.getMainCharacter();
        Enemy enemy = level1state.getEnemy();
        level1state.startThreads();
        player.setLocation(80,80);
        player.update();
        trap1.setLocation(80,80);
        level1state.update();
        assertFalse(player.getPlayerThread().isAlive());
        assertFalse(enemy.getEnemyThread().isAlive());
        assertFalse(bonus1.getBonusrewardthread().isAlive());
        assertFalse(bonus2.getBonusrewardthread().isAlive());
        GameOverState gameOverState = new GameOverState();
        assertEquals(game.gameOverState, State.getState());


    }
    @Test
    public void playerShouldWinLevel1(){
        ArrayList <GameObject> arrayList = level1state.getArrayList();
        BonusReward bonus1 = level1state.getBonusReward("bonus1");
        BonusReward bonus2 = level1state.getBonusReward("bonus2");
        MainCharacter player = level1state.getMainCharacter();
        Enemy enemy = level1state.getEnemy();
        level1state.startThreads();
        player.setLocation(80,80);
        for(int i=0;i<5;i++){
            player.addRewardCount();
            player.update();
        }
        player.setLocation(1120,560);
        level1state.update();

        assertFalse(player.getPlayerThread().isAlive());
        assertFalse(enemy.getEnemyThread().isAlive());
        assertFalse(bonus1.getBonusrewardthread().isAlive());
        assertFalse(bonus2.getBonusrewardthread().isAlive());
        assertEquals(game.winState, State.getState());

    }

    @Test
    public void checkConstructorValues(){
        Point playerSpawn = new Point(0,80);

        Point enemySpawn = new Point(1040,80);

        Point reward1Spawn = new Point (160,640);
        Point reward2Spawn = new Point (960,160);
        Point reward3Spawn = new Point (800,640);
        Point reward4Spawn = new Point (80,320);
        Point reward5Spawn = new Point (560,240);

        Point bonusReward1Spawn= new Point(80,640);
        Point bonusReward2Spawn= new Point(720,400);

        Point trap1Spawn = new Point(320, 80);
        Point trap2Spawn = new Point(480, 160);
        Point trap3Spawn = new Point(400, 400);
        Point trap4Spawn = new Point(480, 560);
        Point trap5Spawn = new Point(1040, 160);
        Point trap6Spawn = new Point(880, 80);

        Point exitLocation = new Point (1120,560);
        ArrayList <GameObject> arrayList = level1state.getArrayList();
        MainCharacter player = level1state.getMainCharacter();
        Enemy enemy = level1state.getEnemy();
        BonusReward bonus1 = level1state.getBonusReward("bonus1");
        BonusReward bonus2 = level1state.getBonusReward("bonus2");
        GameObject reward1 =  arrayList.get(0);
        GameObject reward2 = arrayList.get(1);
        GameObject reward3 = arrayList.get(2);
        GameObject reward4 = arrayList.get(3);
        GameObject reward5 = arrayList.get(4);
        GameObject trap1 = arrayList.get(5);
        GameObject trap2 = arrayList.get(6);
        GameObject trap3 = arrayList.get(7);
        GameObject trap4 = arrayList.get(8);
        GameObject trap5 = arrayList.get(9);
        GameObject trap6 = arrayList.get(10);
        assertEquals(reward1.getLocation(),reward1Spawn);
        assertEquals(reward2.getLocation(),reward2Spawn);
        assertEquals(reward3.getLocation(),reward3Spawn);
        assertEquals(reward4.getLocation(),reward4Spawn);
        assertEquals(reward5.getLocation(),reward5Spawn);
        assertEquals(trap1.getLocation(),trap1Spawn);
        assertEquals(trap2.getLocation(),trap2Spawn);
        assertEquals(trap3.getLocation(),trap3Spawn);
        assertEquals(trap4.getLocation(),trap4Spawn);
        assertEquals(trap5.getLocation(),trap5Spawn);
        assertEquals(trap6.getLocation(),trap6Spawn);
        assertEquals(player.getLocation(),playerSpawn);
        assertEquals(enemy.getLocation(),enemySpawn);
        assertEquals(bonus1.getLocation(),bonusReward1Spawn);
        assertEquals(bonus2.getLocation(),bonusReward2Spawn);

    }



}