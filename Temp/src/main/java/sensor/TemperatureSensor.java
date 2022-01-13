package sensor;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TemperatureSensor implements Runnable {
    private Object value = 0.0D;
    private final Object lock = new Object();
    ExecutorService executor = Executors.newFixedThreadPool(1);

    public TemperatureSensor() {
    }

    public void start() {
        this.executor.submit(this);
    }

    public void stop() {
        this.executor.shutdownNow();
    }

    public void run() {
        new Random();

        while(true) {
            Double t = Math.random() * 40.0D;
            synchronized(this.lock) {
                this.value = Math.random() > 0.5D ? t * -1.0D : t;
            }

            try {
                Thread.sleep(1000L);
            } catch (InterruptedException var5) {
                return;
            }
        }
    }

    public Object value() {
        synchronized(this.lock) {
            double d = (Double)this.value;
            return d;
        }
    }
}
