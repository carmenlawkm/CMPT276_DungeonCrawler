package GameObjects;

import World.World;
import graphics.Assets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class RegularRewardTest{
        private int value;
        private MainCharacter player;
        protected boolean isTaken;
        private World world;
        private Point playerSpawn;
        private Point location;
        private RegularReward reward;

        @BeforeEach
        void setup(){
            value=50;
            isTaken=false;
            playerSpawn=new Point(240,80);
            location=new Point(120,240);
            world = new World("src/main/resources/Level1.txt");
            player=new MainCharacter(world,playerSpawn);
            reward= new RegularReward(world,location,value,player);
        }

        @Test
        void playeronReward(){
            //scenario one, player is on the reward
            player.setLocation(120,80);
            player.score=50;
            reward.setLocation(120,80);
            reward.update();
            assertTrue(reward.notTaken==false);

        }

        @Test
        void playerisNotonReward(){
            //scenario two, player is NOT on the reward
            reward.notTaken=true;
            player.setLocation(120,80);
            player.score=50;
            reward.setLocation(80,80);
            reward.update();
            assertTrue(reward.notTaken==true);

        }

}