package state;


public abstract class State {
    //state manager
    private static State currentState = null;
    protected Game game;

    public State(){
        game = Game.getInstance();
    }
    public static void setState(State state){
        currentState = state;
    }
    public static State getState(){
        return currentState;
    }


}


