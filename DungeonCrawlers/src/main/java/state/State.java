package state;


import java.awt.*;

/**
 * Abstract blueprint for game states
 */
public abstract class State {
    private static State currentState = null;
    protected Game game;

    /**
     * determines the state
     * @param state the state the game is to be in
     */
    public static void setState(State state){
        currentState = state;
    }

    /**
     * @return current running state of the game
     */
    public static State getState(){
        return currentState;
    }

    /**
     * Renders the graphics of the state
     * @param g the Graphic to be rendered on
     */
    public abstract void render(Graphics g);

    /**
     * Updates the status of the state
     */
    public abstract void update();
}


