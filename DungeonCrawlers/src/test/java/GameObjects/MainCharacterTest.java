package GameObjects;

import World.World;
import com.sun.tools.javac.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import state.Game;
import state.Level1State;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class MainCharacterTest {

    private World world;
    private Point playerSpawn;
    private MainCharacter player;

    @BeforeEach
    void setup(){
        world = new World("src/main/resources/Level1.txt");
        playerSpawn = new Point(0,80);
        player = new MainCharacter(world, playerSpawn);
    }

    @Test
    void update() {

    }

    @Test
    void run() {

    }

    @Test
    void getRewardCount() {
        assertTrue(player.getRewardCount() == 0);
    }

    @Test
    void addRewardCount() {
        int firstRewardCount = player.getRewardCount();
        player.addRewardCount();
        int newRewardCount = player.getRewardCount();
        assertTrue(firstRewardCount == newRewardCount - 1);
    }

    @Test
    void getLevel1Win() {
        //case 1: not 5 rewards and not on location
        assertEquals(false, player.getLevel1Win());

        //case 2: not 5 rewards but on location
        player.setLocation(Level1State.exitLocation.x, Level1State.exitLocation.y);
        assertEquals(false, player.getLevel1Win());

        //case 3: 5 rewards but not on location
        for (int i = 0; i < 5; i++){
            player.addRewardCount();
        }
        player.setLocation(Level1State.exitLocation.x - 40, Level1State.exitLocation.y - 40);
        assertEquals(false, player.getLevel1Win());

        //case 4: 5 rewards and on location
        player.setLocation(Level1State.exitLocation.x, Level1State.exitLocation.y);
        assertEquals(true, player.getLevel1Win());
    }

    @Test
    void getScore(){
        assertEquals(100, player.getScore());
    }

    @Test
    void getTime() {
        System.out.println(player.getTime());
        assertEquals(0, player.getTime());
    }

    @Test
    void start() {
    }

    @Test
    void stop() {
    }

}