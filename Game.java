import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

public class Game implements Runnable{
    private Display display;
    private int width, height;
    private String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs, bg;
    private Graphics g,g1;
    private List<Graphics> g2;

    //State
    private State gameState;

    //Score
    protected int Score;

    public Game(String title, int width, int height){
        g2 = new ArrayList<>();
        this.title = title;
        this.width = width;
        this.height = height;

        Score = 6;

    }

    private void init(){

        display = new Display(title, width, height);
        Assets.init();

        gameState = new gameState(this);

        gameState.setState(gameState);
    }

    private void tick(){

        if(gameState.getState() != null)
            gameState.getState().tick();
    }

    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();
        //CLear Screen

        g.clearRect(0,0,width,height);
        g1 = bs.getDrawGraphics();

        for(int i = 0; i< State.numberEnermy; ++i){
            g2.add(bs.getDrawGraphics());
        }

        //DRAW HERE

        g.drawImage(Assets.bg,0,0,null);

        for(int i=0; i<State.numberEnermy;++i){
            if(gameState.getState() != null){
                gameState.getState().render(g);
            }
        }

        if(gameState.getState() != null)
            gameState.getState().render(g);

        //END DRAWING
        bs.show();
        g.dispose();

    }

    public void run(){

        init();
        int fps = 60;
        double timePerTick = 100000000/fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();

        while(running){

            now = System.nanoTime();
            delta+= (now - lastTime)/timePerTick;
            lastTime = now;

            if(delta >=16) {

                tick();
                render();
                delta -=16;
            }
        }

        stop();

    }


    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this::run);
        thread.start();
    }

    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //Score
    public void setScore(int Score){
        this.Score = Score;
    }
    public int getScore(){
        return Score;
    }
}
