import java.awt.*;

public abstract class State {

    private static State currentState = null;
    protected static int numberEnermy;

    public static void setState(State state){
        currentState = state;
    }
    public static State getState(){
        return currentState;
    }

    protected Game game;

    public State (Game game){
        this.game = game;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
}
