package state;

/**
 * Timer class (thread) manages ticks while game is running
 */
public class Timer implements Runnable{

    private boolean running;
    private Thread timerThread;
    private Game game;
    private int fps = 60;
    private double timePerTick = 1000000000 / fps;
    private double delta = 0;
    private long now;
    private long lastTime = System.nanoTime();
    private long timer = 0;
    private int ticks = 0;

    /**
     * Timer thread
     * Tracks ticks
     * When one tick is reached, notifies threads synchronized to this timer to continue the next loop
     */
    public void run() {

        game = Game.getInstance();

        now = System.nanoTime();
        delta += (now - lastTime) / timePerTick;
        timer += now - lastTime;
        lastTime = now;

        while(running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                ticks++;
                delta--;
            }

            //Timer time to be decided
            if (timer >= 100000*50000) {
                //System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;

                synchronized (this) {
                    //notify all game objects one tick has ended
                    notifyAll();
                    game.resetGraphics();
                }
            }
        }
    }

    /**
     * Starts the thread
     */
    public synchronized void start() {
        if (running) return;

        running = true;
        timerThread = new Thread(this);
        timerThread.start();

    }

    /**
     * Stops the thread
     */
    public synchronized void stop() {
        if (running) {
            running = false;
            try {
                timerThread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
