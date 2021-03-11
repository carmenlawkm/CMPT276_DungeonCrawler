package state;

public class Timer extends Thread{

    private boolean running;
    private Thread timerThread;

    private int fps = 60;
    private double timePerTick = 1000000000 / fps;
    private double delta = 0;
    private long now;
    private long lastTime = System.nanoTime();
    private long timer = 0;
    private int ticks = 0;

    public void run() {
        System.out.println("y11e");

        now = System.nanoTime();
        delta += (now - lastTime) / timePerTick;
        timer += now - lastTime;
        lastTime = now;

        while(running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 50) {
                ticks++;
                delta--;

                synchronized (this) {
                    notifyAll();
                    System.out.println("notifying");
                }
            }
        }
    }

    //starts the thread
    public synchronized void start() {
        if (running) return;

        running = true;
        timerThread = new Thread(this);
        timerThread.start();

    }

//    //stops the thread
//    public synchronized void stop() {
//        if (running) {
//            running = false;
//            try {
//                timerThread.join();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
}
