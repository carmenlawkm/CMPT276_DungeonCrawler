package state;

import java.awt.*;

public abstract class State {
    //state manager
    private static State currentState = null;

    public static void setState(State state){
        currentState = state;
    }

    public static State getState(){
        return currentState;
    }

    protected Game game;

    public State(Game game){
        this.game = game;
    }

    //class
    public abstract void update();
    public abstract void render();

    public abstract void initiateState();

}


