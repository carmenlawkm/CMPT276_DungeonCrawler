package state;

public class Timer extends Thread{

    int fps = 60;
    double timePerTick = 1000000000 / fps;
    double delta = 0;
    long now;
    long lastTime = System.nanoTime();
    long timer = 0;
    int ticks = 0;

    public void run() {
        now = System.nanoTime();
        delta += (now - lastTime) / timePerTick;
        timer += now - lastTime;
        lastTime = now;

        if (delta >= 1) {
            ticks++;
            delta--;

            synchronized(this){
                notifyAll();
            }
        }

        if (timer >= 10000000) {
            //System.out.println("Ticks and Frames: " + ticks);
            ticks = 0;
            timer = 0;
        }
    }
}
