package state;


import java.awt.*;

public abstract class State {
    //state manager
    private static State currentState = null;
    protected Game game;

    public static void setState(State state){
        currentState = state;
    }
    public static State getState(){
        return currentState;
    }
    public abstract void render(Graphics g);


    public abstract void update();
}


