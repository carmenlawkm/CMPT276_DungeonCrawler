package GameObjects;

import World.World;
import graphics.Assets;
import state.Game;

import java.awt.*;
import java.util.Random;

/**
 * BonusReward class defines cells where bonus rewards appear
 * bonus rewards disappear after a set time and reward the player extra points upon collection
 */
public class BonusReward extends RewardCell implements Runnable{
    int disappearTimer;
    MainCharacter player;
    private Thread bonusrewardthread;

    /**
     * BonusReward constructor
     * @param location defines the Point the bonus reward resides on the map
     * @param value defines the amount of points the player earns when collecting this reward
     * @param disappearTimer defines the amount of ticks the player has to collect the reward before it disappears
     */
    public BonusReward(World world, Point location, int value, int disappearTimer, MainCharacter player) {
        super(world, location, value);
        this.disappearTimer = disappearTimer;
        this.image = Assets.specialReward;
        this.player=player;
    }

    @Override
    public void run() {
        disappearTimer=0;
        int randomtimer=0;
        int actualvalue=value;
        int flag=0;
        randomtimer=getRandomtime();
        while(running){
            if(player.getTime()<=randomtimer){
                this.image=Assets.rewardgone;
                value=0;
            }
            if(player.getTime()>=randomtimer&&disappearTimer<5&&flag==0){
                this.image=Assets.specialReward;
                value=actualvalue;
                disappearTimer++;
                System.out.printf("disappear timer is %d\n",disappearTimer);
                if(player.getX()==location.x&&player.getY()==location.y){
                    player.score=player.score+value;
                    this.image=Assets.rewardgone;
                    value=0;
                    flag=1;
                }
            }
            else if(player.getTime()>=randomtimer&&disappearTimer>=5){
                this.image=Assets.rewardgone;
                value=0;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
    public synchronized void start(){
        if(running)
            return;
        running=true;
        bonusrewardthread=new Thread(this);
        bonusrewardthread.start();

    }
    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            bonusrewardthread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public int getRandomtime(){
        int randomtime=0;
        Random random=new Random();
        randomtime=random.nextInt(25-5)+5;
        return randomtime;
    }

    @Override
    public void update() {


    }
}
